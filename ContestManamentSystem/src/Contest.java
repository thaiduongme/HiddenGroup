import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;

public class Contest {

    ArrayList<Problem> rplst = new ArrayList<>();
    ArrayList<Problem> contestTemp = new ArrayList<>();
    public String ID;

    public Contest() {
    }

    public Contest(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    protected void generateNewContest(Coach currentCoach) {
        
        Random rd = new Random();
        ID = String.format("%06d", rd.nextInt(10000));
        QuestionBank qtBank = new QuestionBank();
        rplst = qtBank.getLstProblems();
        ArrayList<String> categories = qtBank.getCategories();
        for (String cat : categories) {
            getRandProb(cat);
        }
        save(currentCoach);
    }

    public void getRandProb(String category) {
        Random rand = new Random();
        for (Problem p : rplst) {
            System.out.println(p);
            if (p.getCategory().equals(category)) {
                contestTemp.add(p);
                rplst.remove(p);
                break;
            }
        }     
    }

    protected void printContest(String ID) {
        try {
            File myObj = new File(ID + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
        }
        myReader.close();
      } catch (FileNotFoundException e) {
            System.out.println("ID not found.");
      }
    }

    public void save(Coach currentCoach) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String createdDate = dtf.format(now);
        try {
            double total = 0;
            BufferedWriter writer = new BufferedWriter(new FileWriter(ID + ".txt"));
            String output = "Contest Code: " + ID + "\n" + "Author: " + currentCoach.getUserName() + "\n" + "Created date: " + createdDate + "\n" + "Problems:\n";
            for (Problem p : contestTemp) {
                total += p.getWeight();
                output += p.getCategory() + "|" + p.getID() + "|" + p.getProbName() + "|" + p.getShortDesc() + "|" + p.getFullDescLink()
                        + "|Weight: " + p.getWeight() + "|" + p.getAuthor() + "|" + p.getCreatedDate() + "\n";
            }
            output += "Total Mark: " + total;
            writer.write(output.trim());
            writer.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        loadContest(ID+".txt");
    }
    protected void loadContest(String path)
    {
        contestTemp.clear();
        try {
            File fileDir = new File(path);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));

            // Đọc từng dòng một trong file QuestionBank & add vào lstProblems
            // Format từng dòng: category|ID|probName|shortDesc|fullDescLink|weight|author|createdDate
            String str;
            while ((str = in.readLine()) != null) {
                contestTemp.add(new Problem(str.split("\\|")[0], str.split("\\|")[1], str.split("\\|")[2], str.split("\\|")[3],
                        str.split("\\|")[4], Double.parseDouble(str.split("\\|")[5]), str.split("\\|")[6], str.split("\\|")[7]));
            }

            in.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
