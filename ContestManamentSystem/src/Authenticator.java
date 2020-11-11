
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.io.ObjectStreamConstants.STREAM_MAGIC;
import static java.io.ObjectStreamConstants.STREAM_VERSION;
import java.io.OutputStream;
import java.util.ArrayList;



public class Authenticator {
    Boolean isLoggedin = false;
    
    // Nếu isLoggedin = false => Yêu cầu người dùng nhập tài khoản, mật khẩu. (username / password)
        // Nếu có username|password ở trong coaches.data
        // Tạo obj currentCoach với các thông tin  =>>> chua hieuuuu
        // Mỗi dòng có dạng:
        // username|password|name|email|mobilePhone
        // Login thành công => set isLoggedin = true
        // In ra “Welcome back, {name}”
        // Else
	// Thông báo “You’re already logged in!”
    
    public void login() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
//        if(isLoggedin == false){
//        }
        
        String filename = "Coaches.dat";
        try {
            File f = new File(filename);
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            int k=1;
            while(true) {
                try {
                    System.out.print("Username: ");
                    String userName = in.readLine();
                    System.out.print("Password: ");
                    String passWord = in.readLine();
                    
                    Coach cX = (Coach) ois.readObject();
                    if (cX.getUserName() == userName && cX.getPassword() == passWord){ // co the sai
                        System.out.println("Welcome back " +userName);
                    }
                    else{
                        System.out.println("Wrong username or password. Try again");
                    }
                } 
                catch (EOFException e) {
                    break; //thoát khỏi vòng lặp while true
                }
            }
            ois.close();
            fis.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("You're already logged in!");
    }

    public void logout() {
// set isLoggedin = false
        isLoggedin = false;
        if(isLoggedin == false){
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
        
        String filename = "Coaches.dat";
        File f = new File(filename);
        boolean append = f.exists(); // if file exists then append, otherwise create new
        try {
            FileOutputStream fos = new FileOutputStream(f);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
            AppendableObjectOutputStream oout = new AppendableObjectOutputStream(fos, append);        
            oout.writeObject(c1);
            oout.flush();
            oout.close();
            fos.close();
            System.out.println("Register succesfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.print("Do you want to login? \n Yes: Enter 1 \n No: Enter 2 ");
        int tc = Integer.parseInt(in.readLine());
        if(tc == 1){
            lg.login();
        }

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
