
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.io.ObjectStreamConstants.STREAM_MAGIC;
import static java.io.ObjectStreamConstants.STREAM_VERSION;
import java.io.OutputStream;
import java.util.ArrayList;


public class Authenticator {
    private ArrayList<Coach> lstCoaches = new ArrayList<>();
    private String path;
    // Nếu isLoggedin = false => Yêu cầu người dùng nhập tài khoản, mật khẩu. (username / password)
        // Nếu có username|password ở trong coaches.data
        // Tạo obj currentCoach với các thông tin  =>>> chua hieuuuu
        // Mỗi dòng có dạng:
        // username|password|name|email|mobilePhone
        // Login thành công => set isLoggedin = true
        // In ra “Welcome back, {name}”
        // Else
	// Thông báo “You’re already logged in!”

    public Authenticator() {
        this.path = "Coaches.dat";
    }
    
    public boolean isLoggedin(){
        return false;
    }
    
    public void login() throws IOException {
        BufferedReader nhap = new BufferedReader(new InputStreamReader(System.in));
        lstCoaches.clear();
        try {
            File fileDir = new File(path);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));

            // Đọc từng dòng một trong file QuestionBank & add vào lstCoaches
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
        
        String userName = nhap.readLine();
        String passWord = nhap.readLine();
        boolean isExisted = false;
        for (Coach p : lstCoaches) {
            if (p.getUserName() == userName && p.getPassword() == passWord) {
                System.out.println("Welcome back: " + userName);
                isExisted = true;
                break;
            }
        }
        if (!isExisted) {
            System.out.println("Failed to login");
        }
    }

    public void loadLstCoach()
    {
        
        lstCoaches.clear();
        try {
            File fileDir = new File(path);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));

            // Đọc từng dòng một trong file QuestionBank & add vào lstCoaches
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
    
    public void logout() {
        if(this.isLoggedin() == false){
            System.out.println("You're logged out, thanks for using our software");
        }
    }

    public void register() throws IOException {

        /* String ID, name, email, mobilePhone, username, password;
        Coaches.dat format: ID|name|email|mobilePhone|username|password */

        // Yêu cầu người dùng nhập các thông tin cần thiết, lưu vào các biến
        // Append vào cuối file coaches.dat
        // Thông báo đăng ký thành công!
        // In ra: “Do you want to login? “
        // gọi method login()
        loadLstCoach();
        Authenticator lg = new Authenticator();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList <Coach> lstCoach = new ArrayList<>();
        System.out.print("Enter ID: ");
        String ID = in.readLine();
        System.out.print("Enter name: ");
        String name = in.readLine();
        System.out.print("Enter email: ");
        String email = in.readLine();
        System.out.print("Enter mobile phone: ");
        String phone = in.readLine();
        System.out.print("Enter username: ");
        String userName = in.readLine();
        System.out.print("Enter password: ");
        String pass = in.readLine();
        Coach c1 = new Coach(ID, name, email, phone, userName, pass);
        lstCoach.add(c1);
        
        String filename = "Coaches.txt";
        File f = new File(filename);
        boolean append = f.exists(); // if file exists then append, otherwise create new
        try {
            // Sắp xếp trước khi lưu
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));

            String output = "";
            for (Coach p : lstCoach) {
                output += p.getId() + "|" + p.getName() + "|" + p.getEmail() + "|" + p.getMobilePhone() + "|" + p.getUserName()
                        + "|" + p.getPassword() + "\n";
            }
            writer.write(output.trim());
            writer.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        System.out.println("Please login");
        lg.login();

}
    // append new object 
    public class AppendableObjectOutputStream extends ObjectOutputStream {
        private boolean append;
        private boolean initialized;
        private DataOutputStream dout;
        
        protected AppendableObjectOutputStream(boolean append) throws IOException, SecurityException {
            super();
            this.append = append;
            this.initialized = true;
        }

        public AppendableObjectOutputStream(OutputStream out, boolean append) throws IOException {
            super(out);
            this.append = append;
            this.initialized = true;
            this.dout = new DataOutputStream(out);
            this.writeStreamHeader();
        }

    @Override
    protected void writeStreamHeader() throws IOException {
        if (!this.initialized || this.append) return;
        if (dout != null) {
            dout.writeShort(STREAM_MAGIC);
            dout.writeShort(STREAM_VERSION);
        }
    }
    }   


}


