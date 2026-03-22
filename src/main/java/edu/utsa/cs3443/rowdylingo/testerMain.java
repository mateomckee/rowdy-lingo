//TESTER FILE FOR addSession/deleteSession FILES!!!
//MAYBE DELETE AFTER TESTING??

package edu.utsa.cs3443.rowdylingo;

import java.util.Scanner;

public class testerMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentUserId = 1; // hardcoded for testing add/delete session files

        while (true) {
            System.out.println("\n=== Session Manager ===");
            System.out.println("1. Add Session");
            System.out.println("2. Delete Session");
            System.out.println("3. Exit");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    AddSessionClass.addSession(currentUserId);
                    break;

                case "2":
                    DeleteSessionClass.deleteSession(currentUserId);
                    break;

                case "3":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
