package edu.utsa.cs3443.rowdylingo;
import java.util.Scanner;

public class AddUserScreen extends Screen{

    public AddUserScreen(Scanner scanner) {
        super(scanner, "Create account");
    }

    @Override
    public Screen show() {
        printHeader();

        System.out.print("New account username: ");
        String username = scanner.nextLine();

        System.out.print("New account email: ");
        String email = scanner.nextLine();

        System.out.print("New account password: ");
        String password = scanner.nextLine();

        int userID = Register.AttemptRegister(username, email, password, "src/main/resources/edu/utsa/cs3443/rowdylingo/data/users.csv");

        if (userID <= 0){
            System.out.println("Invalid, try again.");
            return this;
        }

        return new MainMenuScreen(scanner, userID);
    }
}
