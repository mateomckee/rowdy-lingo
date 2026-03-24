package edu.utsa.cs3443.rowdylingo;
import java.util.*;
import java.io.*;


public class QuizScreen extends Screen{
    private int userID;
    private static final String QUESTIONS = "src/main/resources/edu/utsa/cs3443/rowdylingo/data/quizQuestions.csv";

    public QuizScreen(Scanner scanner, int userID){
        super(scanner, "Quiz");
        this.userID = userID;
    }

    @Override
    public Screen show(){
        printHeader();
        List<String []> questions = loadQuestions();

        if(questions.isEmpty()){
            System.out.println("No questions found");
            return new MainMenuScreen(scanner, userID);
        }
        int score = 0;

        for(String[] q: questions){
            System.out.println("\n("+q[1]+") " + q[2]);
            System.out.println("A. " + q[3]);
            System.out.println("B. " + q[4]);
            System.out.println("C. " + q[5]);
            System.out.println("D. " + q[6]);
            System.out.print("Your answer: ");

            String answer = scanner.nextLine().trim().toUpperCase();

            if (answer.equals(q[7])) {
                System.out.println("Correct.");
                score++;
            }
            else{
                System.out.println(("Wrong. The answer was " + q[7]));
            }
        }

        System.out.println("You got " + score+ " out of " + questions.size() + " correct");
        return new MainMenuScreen(scanner, userID);

    }

    private List<String[]> loadQuestions() {
        List<String[]> questions = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(QUESTIONS));
            String line;
            br.readLine();

            while((line = br.readLine()) != null){
                questions.add(line.split(","));
        }

        br.close();
    } catch(IOException e){
            System.out.println("Question error.");
        }
        return questions;
    }
}
