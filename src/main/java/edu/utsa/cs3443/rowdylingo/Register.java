package edu.utsa.cs3443.rowdylingo;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/**
 * Class for account creation logic. AttemptRegister() creates an account,getNextUserID() gets the next highest userID possible from users.csv
 */
public class Register {
    public static int AttemptRegister(String username, String email, String password, String usersFile) {
        int id = 0;

        try {
            FileWriter fw = new FileWriter("src/main/resources/edu/utsa/cs3443/rowdylingo/data/users.csv", true);

            id = getNextUserId();

            fw.write(id + "," + username + "," + email + "," + password + "," +
                    0 + "," + 0 + "," + 0 + "\n");

            fw.close();

            System.out.println("User registered successfully!!");
        }
        catch (Exception e) {
            System.out.println("ERROR: File was not Found");
        }
        return id;
    }

    private static int getNextUserId() {
        int lastId = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/edu/utsa/cs3443/rowdylingo/data/users.csv"))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.startsWith("user_id")) {
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