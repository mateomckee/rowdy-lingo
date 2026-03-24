package edu.utsa.cs3443.rowdylingo;
import java.util.Scanner;

public class LoginScreen extends Screen{

    public LoginScreen(Scanner scanner) {
        super(scanner, "Login");
    }

    @Override
    public Screen show() {
        printHeader();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        int userID = Login.AttemptLogin(username, password, "src/main/resources/edu/utsa/cs3443/rowdylingo/data/users.csv");

        if (userID <= 0){
            System.out.println("Invalid, try again.");
            return this;
        }

        return new MainMenuScreen(scanner, userID);
    }
}
