import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.Serializable;


public class Coach implements Serializable {
    private String id;
    private String name;
    private String email;
    private String mobilePhone;
    private String userName;
    private String password;
    ArrayList<Coach> lstCoaches = new ArrayList<>();
    

    public Coach() {
    }

    public Coach(String name, String email, String mobilePhone, String userName, String password) {
        this.id = IDGenerator();
        this.name = name;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.userName = userName;
        this.password = password;
    }

    
    public Coach(String id, String name, String email, String mobilePhone, String userName, String password) {
        this.id = IDGenerator();
        this.name = name;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.userName = userName;
        this.password = password;
    }

    public void changeInfo() throws FileNotFoundException {
        readFromFile();
        DataInput validator = new DataInput();
        if(!validator.checkEnter("Do you want to change name? [" + name + "]")) {
            this.name = validator.getStringInput("New name: ", "[a-zA-Z ]+");
        }
        if(!validator.checkEnter("Do you want to change password? ")) {
            while(true) {
                String currentPassword = validator.passwordValidator("Current password: ", "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
                String newPassword = validator.passwordValidator("New password: ", "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
                String confirmNewPassword = validator.passwordValidator("Confirm new password: ", "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
                if(currentPassword.equals(this.password)) {
                    if (newPassword.equals(confirmNewPassword)) {
                        this.password = newPassword;
                        break;
                    } else {
                        System.out.println("Do not match! Try again");
                    }
                } else {
                    System.out.println("Incorrect password");
                }
            }
        }
        if(!validator.checkEnter("Do you want to change email? [" + email + "]")) {
            this.email = validator.emailValidator("New email: ", "^[a-zA-Z]\\w+@\\w+(\\.\\w+){1,2}$"); // regex nhập email
        }
        if(!validator.checkEnter("Do you want to change mobile phone? [" + mobilePhone + "]")) {
            this.mobilePhone = validator.mobilePhoneValidator("New mobile phone: ", "0[0-9]{9, 10}"); // regex sđt 
        }
        for (int i = 0; i < lstCoaches.size(); i++) {
            if(lstCoaches.get(i).getUserName().equals(userName)) {
                lstCoaches.set(i, this);
            }
        }
        
        try {
            // Sắp xếp trước khi lưu
            
            BufferedWriter writer = new BufferedWriter(new FileWriter("Coaches.dat"));

            String output = "";
            for (Coach p : lstCoaches) {
                output += p.getId() + "|" + p.getName() + "|" + p.getEmail() + "|" + p.getMobilePhone() + "|" + p.getUserName()
                        + "|" + p.getPassword() + "\n";
            }
            writer.write(output.trim());
            writer.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String IDGenerator(String ID) {
        ID = String.format("%06d", Integer.parseInt(ID.replaceAll("[^0-9]", "")));
        return ID;
    }

    public String IDGenerator() {
        Random rand = new Random();
        id = String.format("%06d", rand.nextInt(100));
        return id;
    }

    public void readFromFile() throws FileNotFoundException {
        try {
            File fileDir = new File("Coaches.dat");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));

            // Đọc từng dòng một trong file Coaches & add vào lstCoaches
            // Format từng dòng:  ID|name|email|mobilePhone|username|password

            String str;
            while ((str = in.readLine()) != null) {
                lstCoaches.add(new Coach(str.split("\\|")[0], str.split("\\|")[1], str.split("\\|")[2], str.split("\\|")[3],
                        str.split("\\|")[4],str.split("\\|")[5]));
            }

            in.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
        
    @Override
    public String toString() {
        return this.id + "|" + this.name + "|" + this.email + "|" + this.mobilePhone + "|" + this.userName + "|" + this.password;
    }
}
