package edu.utsa.cs3443.rowdylingo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {


    public static void addSession(int newID, int userID, String name, int words, double time, int confidence, int mastered, int good, int bad) throws IOException {
        FileWriter fw = new FileWriter("src/main/resources/edu/utsa/cs3443/rowdylingo/data/sessions.csv", true);

        fw.write(newID + "," + userID + "," + name + "," + words + "," +
                time + "," + confidence + "," + mastered + "," + good + "," + bad + "\n");

        fw.close();

        System.out.println("Session added successfully!!");
    }

    public static void deleteSession(int deleteID, List<String> updatedLines) throws IOException {
        // Rewrite file without selected session
        FileWriter fw = new FileWriter("src/main/resources/edu/utsa/cs3443/rowdylingo/data/sessions.csv");

        for (String l : updatedLines) {
            if (!l.startsWith(deleteID + ",")) {
                fw.write(l + "\n");
            }
        }

        fw.close();

        System.out.println("Session deleted!!");
    }
}
