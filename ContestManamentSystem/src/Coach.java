
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

    public Coach() {
    }

    public Coach(String id, String name, String email, String mobilePhone, String userName, String password) {
        this.id = IDGenerator();
        this.name = name;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.userName = userName;
        this.password = password;
    }

    public void changeInfo() {
        DataInput validator = new DataInput();
        if(!validator.checkEnter("Do you want to change name ?")) {
            this.name = validator.getStringInput("New name: ", "[a-zA-Z ]+");
        }
        if(!validator.checkEnter("Do you want to change password ? ")) {
            while(true) {
                String currentPassword = validator.getStringInput("Current password: ", "\\w+");
                String newPassword = validator.getStringInput("New password: ", "\\w+");
                String confirmNewPassword = validator.getStringInput("Confirm new password: ", "\\w+");
                if(currentPassword.equals(newPassword)) {
                    if (newPassword.equals(confirmNewPassword)) {
                        this.password = newPassword;
                        break;
                    } else {
                        System.out.println("Incorrect password");
                    }
                } else {
                    System.out.println("Incorrect password");
                }
            }
        }
        if(!validator.checkEnter("Do you want to change email ? ")) {
            this.email = validator.getStringInput("New email", "^[a-zA-Z]\\w+@\\w+(\\.\\w+){1,2}$"); // regex nhập email
        }
        if(!validator.checkEnter("Do you want to change mobile phone ?")) {
            this.mobilePhone = validator.getStringInput("New mobile phone: ", "[0-9]{10}"); // regex sđt 
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

    public void updateInfo() {
        Coach c = new Coach();
        try {
            FileReader fr = new FileReader("Coaches.dat");      //ghi toString mới cho currentCoach
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while(true) {
                line = br.readLine();
                if(line.contains(c.getUserName())) {
                    line = line.replace(c.toString(), " ");
                }
            }
        } catch (Exception e) {
        }
        try {
            FileWriter fw = new FileWriter("Coaches.dat", true);    //thay thế toString cũ của currentCoach bằng " "
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(c.toString());
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
        
    @Override
    public String toString() {
        return this.id + "|" + this.name + "|" + this.email + "|" + this.mobilePhone + "|" + this.userName + "|" + this.password;
    }
}
