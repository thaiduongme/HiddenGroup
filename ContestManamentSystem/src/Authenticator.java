
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Authenticator {
    Boolean isLoggedin = false;
    public void login() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // Nếu isLoggedin = false => Yêu cầu người dùng nhập tài khoản, mật khẩu. (username / password)
        // Nếu có username|password ở trong coaches.data
        // Tạo obj currentCoach với các thông tin  =>>> chua hieuuuu
        // Mỗi dòng có dạng:
        // username|password|name|email|mobilePhone
        // Login thành công => set isLoggedin = true
        // In ra “Welcome back, {name}”
        // Else
	// Thông báo “You’re already logged in!”
        if(isLoggedin == false){
            System.out.print("Username: ");
            String username = in.readLine();
            System.out.print("Password: ");
            String password = in.readLine();
        }

        System.out.println("You're already logged in!");
    }

    public void logout() {
// set isLoggedin = false
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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename = "Coach.dat";
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
        Coach c1 = new Coach("1234", "Trung Duc", "duc@gmail.com", "0916", "ducndt", "123454");
        lstCoach.add(c1);
        try {
            File f = new File(filename);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(c1);
            oos.flush();
            oos.close();
            fos.close();
            System.out.println("Write objects to file ");
        } catch (Exception e) {
        }

}

}
