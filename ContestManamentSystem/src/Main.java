import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        while (true) {
            System.out.println("===========CONTEST MANAGEMENT SYSTEM===========");
            System.out.println(".....::::::Created by Hidden Group::::::.....");
            if (Authenticator.isLoggedin) {
                int func_answer;
                QuestionBank qb = new QuestionBank();
                System.out.println("Welcome back, " + Authenticator.getCurrentCoach().getName());
                System.out.println("1. Change profile information");
                System.out.println("2. Add new question to QuestionBank");
                System.out.println("3. Change Problem Info by ID");
                System.out.println("4. Generate a new contest");
                System.out.println("5. Print information of a test by ID");
                System.out.println("6. Sort all problems by Category (Ascending)");
                System.out.println("7. Save Question Bank");
                System.out.println("8. Load Question Bank");
                System.out.println("9. Export Question Bank");
                System.out.println("10. Exit");
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Please select one option: ");
                    if (scanner.hasNextInt()) {
                        func_answer = scanner.nextInt();
                        if (func_answer > 0 && func_answer < 11) {
                            break;
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
                switch (func_answer) {
                    case 1:
                        Authenticator.getCurrentCoach().changeInfo();
                        System.out.println("Changed Successfully!");
                        break;
                    case 2:
                        Problem newProb = new Problem();
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Enter problem name: ");
                        newProb.setProbName(scanner.nextLine());
                        System.out.print("Enter short description: ");
                        newProb.setShortDesc(scanner.nextLine());
                        System.out.print("Enter full description link: ");
                        newProb.setFullDescLink(scanner.nextLine());
                        System.out.print("Enter category: ");
                        newProb.setCategory(scanner.nextLine());
                        System.out.print("Enter weight: ");
                        newProb.setWeight(scanner.nextDouble());
                        newProb.setID("blabla");
                        newProb.setCoach(Authenticator.getCurrentCoach());  
                        qb.addProblem(newProb);
                        System.out.println("Added Question to Question Bank!");
                        
                        break;
                    case 3:
                        scanner = new Scanner(System.in);
                        System.out.print("Enter Problem ID: ");
                        qb.updateProblem(scanner.nextLine());
                        
                        break;
                    case 4:
                        Contest.generateNewContest();
                        System.out.println("Created contest successfully!");
                        break;
                    case 5:
                        scanner = new Scanner(System.in);
                        System.out.print("Enter Contest ID: ");
                        Contest.printContest(scanner.nextLine());
                        break;
                    case 6:
                        qb.sortProblems();
                        System.out.println("Sorted question bank Successfully!");
                        break;
                    case 7:
                        qb.save();
                        System.out.println("Saved question bank Successfully!");
                        break;
                    case 8:
                        scanner = new Scanner(System.in);
                        System.out.print("Path to QB file: ");
                        qb.loadProblems(scanner.nextLine());
                        break;
                    case 9:
                        scanner = new Scanner(System.in);
                        System.out.print("Export to path: ");
                        qb.exportTo(scanner.nextLine());
                        break;
                    case 10:
                        Authenticator.logout();
                        break;
                }
                clearScreen();
                
            } else {
                int func_answer;
                System.out.println("1. Login");
                System.out.println("2. Register");
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter a number: ");
                    if (scanner.hasNextInt()) {
                        func_answer = scanner.nextInt();
                        if (func_answer == 1 || func_answer == 2) {
                            break;
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
                switch (func_answer) {
                    case 1:
                        Authenticator.login();
                        break;
                    case 2:
                        Authenticator.register();
                        break;
                }
            }
        }
//        Coach duong = new Coach();
//        duong.setName("Duong");
//        QuestionBank qb = new QuestionBank();
////        Problem newProb= new Problem("MAE","12","cau1","cau 1 shordesc","cau 1 full desc",15,"Duong");
////        qb.addProblem(newProb);
//        qb.addProblem(new Problem("MAE","12","cau1","cau 1 shordesc","cau 1 full desc",15,"Duong"));
//       
//        qb.updateProblem("000012045845");
//        qb.save();

    }
    
    public static void clearScreen() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }
    
}
