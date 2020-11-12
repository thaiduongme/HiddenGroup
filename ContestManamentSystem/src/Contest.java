import java.util.*;
public class Contest {
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
    QuestionBank qtBank = new QuestionBank();
    ArrayList<Problem> rplst = qtBank.getLstProblems();
   
    
    
    
}
