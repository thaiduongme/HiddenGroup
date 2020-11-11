//  Add comments cho ngau
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Coach duong= new Coach();
        duong.setName("Duong");
        QuestionBank qb = new QuestionBank();
        Problem newProb= new Problem("MAE","12","cau1","cau 1 shordesc","cau 1 full desc",15,"Duong");
        qb.addProblem(newProb);
       
       
//        qb.updateProblem("0017");
        qb.save();
        qb.exportTo("test.txt");
    }
    
}
