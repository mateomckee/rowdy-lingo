package edu.utsa.cs3443.rowdylingo;

import java.util.Scanner;

public class MainMenuScreen extends Screen{
    private int userID;

    public MainMenuScreen(Scanner scanner, int userID){
        super(scanner, "Main Menu");
        this.userID = userID;

    }

    @Override
    public Screen show() {
        printHeader();
        System.out.println("1. Add session");
        System.out.println("2. Delete session");
        System.out.println("3. Quiz");
        System.out.println("4. Logout");
        System.out.print("Choice: ");
        String choice = scanner.nextLine();

        switch(choice) {
            case "1":
                return new AddSessionScreen(scanner, userID);
            case "2":
                return new DeleteSessionScreen(scanner, userID);
            case "3":
                return new QuizScreen(scanner, userID);
            case "4":
                return new LandingPageScreen(scanner);
            default:
                System.out.println("Invalid choice, try again.");
                return this;
        }

        }
    }
