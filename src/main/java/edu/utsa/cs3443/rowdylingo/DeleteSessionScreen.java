package edu.utsa.cs3443.rowdylingo;

import java.io.*;
import java.util.*;

public class DeleteSessionScreen extends Screen {
    private int userID;

    public DeleteSessionScreen(Scanner scanner, int userID) {
        super(scanner, "Delete session");
        this.userID = userID;
    }

    @Override
    public Screen show() {
        printHeader();

        List<String> updatedLines = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/edu/utsa/cs3443/rowdylingo/data/sessions.csv"));
            String line;

            // Show sessions
            while ((line = br.readLine()) != null) {
                if (line.startsWith("session_id")) {
                    updatedLines.add(line);
                    continue;
                }

                String[] parts = line.split(",");

                int sessionUserId = Integer.parseInt(parts[1]);

                if (sessionUserId == userID) {
                    System.out.println("ID: " + parts[0] +
                            " | Name: " + parts[2] +
                            " | Words: " + parts[3] +
                            " | Time: " + parts[4] +
                            " | Confidence: " + parts[5] + "%");
                }

                updatedLines.add(line);
            }

            br.close();

            // Ask for ID to delete
            System.out.print("\nEnter session ID to delete: ");
            int deleteID = Integer.parseInt(scanner.nextLine());

            System.out.print("Are you sure? (y/n): ");
            String confirm = scanner.nextLine();

            if (!confirm.equalsIgnoreCase("y")) {
                System.out.println("Deletion cancelled!!");
                return new MainMenuScreen(scanner, userID);
            }

            UserManager.deleteSession(deleteID, updatedLines);

        } catch (IOException e) {
            System.out.println("Error handling file.");
        }

        return new MainMenuScreen(scanner, userID);
    }
}
