package edu.utsa.cs3443.rowdylingo;

import java.io.*;
import java.util.*;

public class DeleteSessionClass {

    public static void deleteSession(int userId) {
        Scanner scanner = new Scanner(System.in);
        List<String> updatedLines = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/edu/utsa/cs3443/rowdylingo/data/sessions.csv"));
            String line;

            System.out.println("\n--- Your Sessions ---");

            // Show sessions
            while ((line = br.readLine()) != null) {
                if (line.startsWith("session_id")) {
                    updatedLines.add(line);
                    continue;
                }

                String[] parts = line.split(",");

                int sessionUserId = Integer.parseInt(parts[1]);

                if (sessionUserId == userId) {
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
            int deleteId = Integer.parseInt(scanner.nextLine());

            System.out.print("Are you sure? (y/n): ");
            String confirm = scanner.nextLine();

            if (!confirm.equalsIgnoreCase("y")) {
                System.out.println("Deletion cancelled!!");
                return;
            }

            // Rewrite file without selected session
            FileWriter fw = new FileWriter("src/main/resources/edu/utsa/cs3443/rowdylingo/data/sessions.csv");

            for (String l : updatedLines) {
                if (!l.startsWith(deleteId + ",")) {
                    fw.write(l + "\n");
                }
            }

            fw.close();

            System.out.println("Session deleted!!");

        } catch (IOException e) {
            System.out.println("Error handling file.");
        }
    }
}
