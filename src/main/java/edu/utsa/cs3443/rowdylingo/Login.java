package edu.utsa.cs3443.rowdylingo;
import java.io.*;
import java.util.*;

public class Login {
    public static int AttemptLogin(String username, String userPassword, String usersFile) {

        int id = 0;

        try {
            BufferedReader bReader = new BufferedReader(new FileReader(usersFile));
            String line = "";

            while ((line = bReader.readLine()) != null) {
                String[] date = line.split(",");
                String usernameAttempt = data[1].trim();
                String userPasswordAttempt = data[3].trim();

                    id = Integer.parseInt(data[0].trim());
                }
            }
            bReader.close();
        }
        catch (Exception e) {
            System.out.println("ERROR: File was not Found");
        }

    }
}
