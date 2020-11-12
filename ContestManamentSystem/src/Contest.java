
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

    void generateNewContest() {
        QuestionBank qtBank = new QuestionBank();
        ArrayList<Problem> rplst = new ArrayList<>();
        rplst = qtBank.getLstProblems();
        ArrayList<Problem> contestTemp = new ArrayList<>();
        contestTemp.add

        }

    }
    public Problem getRandProb  (String category,int numb)
    {   int temp=0;
        Problem tempProb=new Problem();
        Random rand = new Random();
        QuestionBank qtBank = new QuestionBank();
        ArrayList<Problem> rplst = qtBank.getLstProblems();
        switch(category)
        {
            case"MAE":
                numb=0;
                for(Problem p : rplst)
                {
                    if (p.getCategory()=="MAE"&& rand.nextInt(2)==1)
                    {
                        tempProb=p;
                        temp++;
                        rplst.remove(p);
                        if(temp>=numb)
                        {
                            break;
                        }
                    }
                        
                }break;
            case"SQL":break;
            case"PRF":
            case"CEA":
            case"CSI":
        }
    }

}
