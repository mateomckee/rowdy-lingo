package edu.utsa.cs3443.rowdylingo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class AddSessionClass {

    public static void addSession(int userId) {
        Scanner scanner = new Scanner(System.in);

        try {
            int newId = getNextSessionId();

            System.out.println("\n--- Add Session ---");

            System.out.print("Enter session name: ");
            String name = scanner.nextLine();

            System.out.print("Enter words studied: ");
            int words = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter time spent (hours): ");
            double time = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter confidence level (%): ");
            int confidence = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter mastered words: ");
            int mastered = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter good words: ");
            int good = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter bad words: ");
            int bad = Integer.parseInt(scanner.nextLine());

            FileWriter fw = new FileWriter("src/main/resources/edu/utsa/cs3443/rowdylingo/data/sessions.csv", true);

            fw.write("\n" + newId + "," + userId + "," + name + "," + words + "," +
                    time + "," + confidence + "," + mastered + "," + good + "," + bad);

            fw.close();

            System.out.println("Session added successfully!!");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    private static int getNextSessionId() {
        int lastId = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/edu/utsa/cs3443/rowdylingo/data/sessions.csv"))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.startsWith("session_id")) {
                    String[] parts = line.split(",");
                    lastId = Integer.parseInt(parts[0]);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        return lastId + 1;
    }
}