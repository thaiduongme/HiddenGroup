
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
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

    protected void generateNewContest() {

        Random rd = new Random();
        ID = String.format("%06d", rd.nextInt(10000));
        QuestionBank qtBank = new QuestionBank();

        rplst = qtBank.getLstProblems();

        getRandProb("MAE");
        getRandProb("PRF");
        getRandProb("SQL");
        getRandProb("CSI");
        getRandProb("CEA");
    }

    public void getRandProb(String category) {
        
        Random rand = new Random();
        boolean check = false;
        switch (category) {
            case "MAE":
                while (!check) {
                    for (Problem p : rplst) {
                        if (p.getCategory() == "MAE" && rand.nextInt(6) == 1) {
                            contestTemp.add(p);
                            rplst.remove(p);
                            check = true;
                        }
                    }
                }
                break;
            case "SQL":
                while (!check) {
                    for (Problem p : rplst) {
                        if (p.getCategory() == "SQL" && rand.nextInt(6) == 1) {                           
                            contestTemp.add(p);
                            rplst.remove(p);
                            check = true;
                        }

                    }
                }
                break;
            case "PRF":
                while (!check) {
                    for (Problem p : rplst) {
                        if (p.getCategory() == "PRF" && rand.nextInt(6) == 1) {                          
                            contestTemp.add(p);
                            rplst.remove(p);
                            check = true;
                        }
                    }
                }
                break;
            case "CEA":
                while (!check) {
                    for (Problem p : rplst) {
                        if (p.getCategory() == "CEA" && rand.nextInt(6) == 1) {                          
                            contestTemp.add(p);
                            rplst.remove(p);
                            check = true;
                        }
                    }
                }
                break;
            case "CSI":
                while (!check) {
                    for (Problem p : rplst) {
                        if (p.getCategory() == "CSI" && rand.nextInt(6) == 1) {                           
                            contestTemp.add(p);
                            rplst.remove(p);
                            check = true;
                        }
                    }
                }
                break;
        }      
    }

    protected void printContest() {
        System.out.println(rplst);
    }

    public void save() {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(ID + ".txt"));
            String output = "";
            for (Problem p : rplst) {
                output += p.getCategory() + "|" + p.getID() + "|" + p.getProbName() + "|" + p.getShortDesc() + "|" + p.getFullDescLink()
                        + "|" + p.getWeight() + "|" + p.getAuthor() + "|" + p.getCreatedDate() + "\n";
            }
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
