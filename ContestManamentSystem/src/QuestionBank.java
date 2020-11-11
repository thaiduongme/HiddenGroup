
/**
 *
 * @author Thai Duong
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuestionBank {

    /**
     * * CÁC BIẾN BAN ĐẦU **
     */
    private ArrayList<Problem> lstProblems = new ArrayList<>();
    private String path;
    private ArrayList<String> categories = new ArrayList<>();

    /**
     * * GETTERS VÀ SETTERS **
     */
    public ArrayList<Problem> getLstProblems() {
        return lstProblems;
    }

    public void setLstProblems(ArrayList<Problem> lstProblems) {
        this.lstProblems = lstProblems;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * * CONSTRUCTORS **
     */
    // Mặc định file là "QBs.dat"
    public QuestionBank() {
        this.path = System.getProperty("user.dir") + "\\QBs.dat";
        loadProblems(path);
        for (Problem p : lstProblems) {
            if (categories.contains(p.getCategory())) {
                continue;
            } else {
                categories.add(p.getCategory());
            }
        }
    }

    // Truyền vào argument là path của file
    public QuestionBank(String path) {
        this.path = System.getProperty("user.dir") + "\\" + path;
        loadProblems(this.path);
        for (Problem p : lstProblems) {
            if (categories.contains(p.getCategory())) {
                continue;
            } else {
                categories.add(p.getCategory());
            }
        }

    }

    /**
     * * CÁC METHODS **
     */
    // Load Problems từ path vào lstProblems
    public void loadProblems(String path) {
        // Xóa toàn bộ phần tử trong lstProblems
        lstProblems.clear();
        try {
            File fileDir = new File(path);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));

            // Đọc từng dòng một trong file QuestionBank & add vào lstProblems
            // Format từng dòng: category|ID|probName|shortDesc|fullDescLink|weight|author|createdDate
            String str;
            while ((str = in.readLine()) != null) {
                lstProblems.add(new Problem(str.split("\\|")[0], str.split("\\|")[1], str.split("\\|")[2], str.split("\\|")[3],
                        str.split("\\|")[4], Double.parseDouble(str.split("\\|")[5]), str.split("\\|")[6], str.split("\\|")[7]));
            }

            in.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Sắp xếp các Problems trong lstProblems theo Category (Ascending)
    // Nếu chung Category, thì sắp xếp theo ID
    public void sortProblems() {
        Collections.sort(lstProblems, new Comparator<Problem>() {
            @Override
            public int compare(Problem t1, Problem t2) {
                if (t1.getCategory() != t2.getCategory()) {
                    return t1.getCategory().compareToIgnoreCase(t2.getCategory());
                } else {
                    return t1.getID().compareToIgnoreCase(t2.getID());
                }
            }
        });
    }

    // In ra các Problems trong lstProblems
    public void printProblems() {
        sortProblems();
        for (Problem p : lstProblems) {
            System.out.println(p);
        }
    }

    // Cập nhật Problems theo ID
    public void updateProblem(String ID) {
        for (Problem p : lstProblems) {
            if (p.getID() == ID || Integer.parseInt(p.getID()) == Integer.parseInt(ID)) {
                p.changeInfo();
                for (Problem p1 : lstProblems) {
                    while (p1.getID().contains(p.getID()) && p1 != p) {
                        System.out.println("ID existed, please update the ID");
                        p.changeID();
                    }
                }
                break;
            }
        }
    }

    // Xuất QuestionBank vào 1 file nào đó
    public void exportTo(String path) {
        try {
            // Sắp xếp trước khi xuất
            sortProblems();
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            String output = "";
            for (Problem p : lstProblems) {
                output += p.getCategory() + "|" + p.getID() + "|" + p.getProbName() + "|" + p.getShortDesc() + "|" + p.getFullDescLink() + "|"
                        + p.getWeight() + "|" + p.getAuthor() + "|" + p.getCreatedDate() + "\n";
            }
            writer.write(output.trim());
            writer.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Lưu QuestionBank
    public void save() {
        try {
            // Sắp xếp trước khi lưu
            sortProblems();
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));

            String output = "";
            for (Problem p : lstProblems) {
                output += p.getCategory() + "|" + p.getID() + "|" + p.getProbName() + "|" + p.getShortDesc() + "|" + p.getFullDescLink()
                        + "|" + p.getWeight() + "|" + p.getAuthor() + "|" + p.getCreatedDate() + "\n";
            }
            writer.write(output.trim());
            writer.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //thêm câu hỏi
    public void addProblem(Problem newProb) {

        boolean isUnique = true;

        try {
            for (Problem p : lstProblems) {
                if (p.getID() == newProb.getID() || Integer.parseInt(p.getID()) == Integer.parseInt(newProb.getID())) {
                    isUnique = false;
                }
            }
            if (isUnique == false) {
                    System.out.println("Problem ID existed");
                } else {
                    lstProblems.add(newProb);
                }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
