//TESTER FILE FOR addSession/deleteSession FILES!!!
//MAYBE DELETE AFTER TESTING??

package edu.utsa.cs3443.rowdylingo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Screen screen = new LandingPageScreen(scanner);

        while(true) {
            screen = screen.show();
        }
    }
}
