package edu.utsa.cs3443.rowdylingo;
import java.util.Scanner;


public class QuizScreen extends Screen{
    private int userID;

    public QuizScreen(Scanner scanner, int userID){
        super(scanner, "Quiz");
        this.userID = userID;
    }

    @Override
    public Screen show(){
        printHeader();
        // Quiz later
        return new MainMenuScreen(scanner, userID);
    }
}
