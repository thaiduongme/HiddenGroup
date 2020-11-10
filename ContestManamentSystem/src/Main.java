//  Add comments cho ngau
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        QuestionBank qb = new QuestionBank();
        qb.printProblems();
        qb.exportTo("test.txt");
    }
    
}
