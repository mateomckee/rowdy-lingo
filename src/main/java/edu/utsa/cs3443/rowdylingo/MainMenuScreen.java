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
        System.out.println("Choice: ");
        String choice = scanner.nextLine();

        switch(choice) {
            case "1":
                AddSessionClass.addSession(userID);
                return this;
            case "2":
                DeleteSessionClass.deleteSession(userID);
                return this;
            case "3":
                return new QuizScreen(scanner, userID);
            case "4":
                return new LoginScreen(scanner);
            default:
                System.out.println("Invalid choice, try again.");
                return this;
        }

        }
    }
