package edu.utsa.cs3443.rowdylingo;

import java.util.Scanner;

/**
 * Starting screen of application, allows the users to login, create an account, or exit.
 */
public class LandingPageScreen extends Screen {

    public LandingPageScreen(Scanner scanner){
        super(scanner, "Get Started!");
    }

    @Override
    public Screen show() {
        printHeader();
        System.out.println("1. Login");
        System.out.println("2. Create account");
        System.out.println("3. Exit");
        System.out.println("Choice: ");
        String choice = scanner.nextLine();

        switch(choice) {
            case "1":
                //LoginScreen
                return new LoginScreen(scanner);

            case "2":
                //AddUserScreen
                return new AddUserScreen(scanner);
            case "3":
                return this;
            default:
                System.out.println("Invalid choice, try again.");
                return this;
        }

    }
}
