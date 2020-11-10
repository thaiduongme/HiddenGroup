import java.util.Scanner;

public class DataInput {

    public String getStringInput(String msg, String format) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        String strInput = "";
        while (flag) {
            System.out.print(msg);
            strInput = sc.nextLine().trim();
            if (strInput.isEmpty()) {
                System.out.println("Not empty");
                continue;
            }
            if (!strInput.matches(format)) {
                System.out.println("Content invalid");
                continue;
                
            }
            flag = false;
        }
        return strInput;
    }

    public boolean checkEnter(String msg) {
        Scanner sc = new Scanner(System.in);
        String strInput;
        while (true) {
            System.out.print(msg);
            strInput = sc.nextLine().trim();
            return strInput.equals("");
        }
    }

}
