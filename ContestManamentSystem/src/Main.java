//  Add comments cho ngau
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Coach duong = new Coach();
        duong.setName("Duong");
        QuestionBank qb = new QuestionBank();
//        Problem newProb= new Problem("MAE","12","cau1","cau 1 shordesc","cau 1 full desc",15,"Duong");
//        qb.addProblem(newProb);
        qb.addProblem(new Problem("MAE","12","cau1","cau 1 shordesc","cau 1 full desc",15,"Duong"));
       
<<<<<<< HEAD
        qb.updateProblem("0042");
=======
        qb.updateProblem("000012045845");
>>>>>>> 123ac256c63ee48da9ad098b6ab6a3f758ea7df0
        qb.save();
//        qb.export("test.txt");
    }
    
}
