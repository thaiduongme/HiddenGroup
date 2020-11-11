
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public void register() {
        
        /* String ID, name, email, mobilePhone, username, password;
        Coaches.dat format: ID|name|email|mobilePhone|username|password */

// Yêu cầu người dùng nhập các thông tin cần thiết, lưu vào các biến
// Append vào cuối file coaches.dat
// Thông báo đăng ký thành công!
// In ra: “Do you want to login? “
// gọi method login()
        ArrayList <Coach> lstCoach = new ArrayList<>();
//        HashMap
        
       
}

}
