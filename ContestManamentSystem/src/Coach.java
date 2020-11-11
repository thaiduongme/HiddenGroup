public class Coach {

    private String id;
    private String name;
    private String email;
    private String mobilePhone;
    private String userName;
    private String password;

    public Coach() {
    }

    public Coach(String id, String name, String email, String mobilePhone, String userName, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.userName = userName;
        this.password = password;
    }

    public void changeInfo() {
        DataInput validator = new DataInput();
        if(validator.checkEnter("Do you want to change name ?")) {
            this.name = validator.getStringInput("New name: ", "[a-zA-Z ]+");
        }
        if(validator.checkEnter("Do you want to change password ? ")) {
            while(true) {
                String currentPassword = validator.getStringInput("Current password: ", "\\w+");
                String newPassowrd = validator.getStringInput("New password: ", "\\w+");
                String confirmNewPassowrd = validator.getStringInput("Confirm new password: ", "\\w+");
                if(currentPassword==newPassowrd) {
                    if (newPassowrd.equals(confirmNewPassowrd)) {
                        this.password = newPassowrd;
                        break;
                    } else {
                        System.out.println("Incorrect password");
                    }
                } else {
                    System.out.println("Incorrect password");
                }
            }
        }
        if(validator.checkEnter("Do you want to change email ? ")) {
            this.email = validator.getStringInput("New email", "^[a-zA-Z]\\w+@\\w+(\\.\\w+){1,2}$"); // regex nhap email
        }
        if(validator.checkEnter("Do you want to change mobile phone ?")) {
            this.mobilePhone = validator.getStringInput("New mobile phone: ", "[0-9]{10}"); // regex nhap sdt gom 10
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

    @Override
    public String toString() {
        return this.id + "|" + this.name + "|" + this.email + "|" + this.mobilePhone + "|" + this.userName + "|" + this.password;
    }
}
