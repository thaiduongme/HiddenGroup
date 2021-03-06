
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


/*
 * @author Hidden Group
 */
public class Problem {

    private String ID, createdDate, probName, shortDesc, fullDescLink, category, author;
    private double weight;

    public Problem() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.createdDate = dtf.format(now);
    }

    public Problem(String category, String probName, String shortDesc, String fullDescLink, double weight, Coach coach) {
        this.ID = IDGenerator();
        this.probName = probName;
        this.shortDesc = shortDesc;
        this.fullDescLink = fullDescLink;
        this.weight = weight;
        this.category = category;
        this.author = coach.getName();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.createdDate = dtf.format(now);
    }
    
    public Problem(String category, String ID, String probName, String shortDesc, String fullDescLink, double weight, String author, String createdDate) {
        this.ID = IDGenerator(ID);
        this.probName = probName;
        this.shortDesc = shortDesc;
        this.fullDescLink = fullDescLink;
        this.weight = weight;
        this.category = category;
        this.author = author;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return category + "|" + ID + "|" + probName + "|" + shortDesc + "|" + fullDescLink + "|" + weight + "|" + author + "|" + createdDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = IDGenerator(ID);
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getProbName() {
        return probName;
    }

    public void setProbName(String probName) {
        this.probName = probName;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getFullDescLink() {
        return fullDescLink;
    }

    public void setFullDescLink(String fullDescLink) {
        this.fullDescLink = fullDescLink;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String IDGenerator(String ID) {
        ID = String.format("%06d", Integer.parseInt(ID.replaceAll("[^0-9]", "")));
        return ID;
    }
    //generate ID from 0 -> 99
    public String IDGenerator() {
        Random rand = new Random();
        ID = String.format("%06d", rand.nextInt(100));
        return ID;
    }

    protected void changeInfo() {
        try {
            String temp = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Change problem name:");
            if ((temp = in.readLine()).equals("")); else {
                setProbName(temp);
            }
             System.out.println("Change short description:");
            if ((temp = in.readLine()).equals("")); else {
                setShortDesc(temp);
            }
            System.out.println("Change full description link");
            if ((temp = in.readLine()).equals("")); else {
                setFullDescLink(temp);
            }
            System.out.println("Change category:");
            if ((temp = in.readLine()).equals("")); else {
                setCategory(temp);
            }
            System.out.println("Change weight:");
            //tránh trường hợp nhập chữ làm hỏng chương trình
            if ((temp = in.readLine()).equals("")); else {
                try {
                    setWeight(Double.parseDouble(temp));
                } catch (Exception e) {
                    System.err.println("invalid value");
                }
            }
            System.out.println("Change author:");
            if ((temp = in.readLine()).equals("")); else {
                setAuthor(temp);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }



}
