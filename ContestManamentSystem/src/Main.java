//  Add comments cho ngau
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Coach duong= new Coach();
        duong.setName("Duong");
        QuestionBank qb = new QuestionBank();
        Problem newProb= new Problem("MAE","P10001","cau1","cau 1 shordesc","cau 1 full desc",15,duong);
        qb.addProblem(newProb);
       
       
        qb.updateProblem("P10001");
         qb.save();
        qb.exportTo("test.txt");
    }
    
}
