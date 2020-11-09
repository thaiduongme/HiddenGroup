
public class Authenticator {
    Boolean isLoggedin = false;
    public void login() {
// Nếu isLoggedin = false => Yêu cầu người dùng nhập tài khoản, mật khẩu.
// Nếu có username|password ở trong coaches.data
// Tạo obj currentCoach với các thông tin
// Mỗi dòng có dạng:
// username|password|name|email|mobilePhone
// Login thành công => set isLoggedin = true
// In ra “Welcome back, {name}”
// Else
	// Thông báo “You’re already logged in!”
        System.out.println("You're already logged in!");
    }

    public void logout() {
// set isLoggedin = false
// In ra: “You’re logged out, thanks for using our software.”
 
}

    public void register() {
// Yêu cầu người dùng nhập các thông tin cần thiết, lưu vào các biến
// Append vào cuối file coaches.dat
// Thông báo đăng ký thành công!
// In ra: “Do you want to login? “
// gọi method login()
}

}
