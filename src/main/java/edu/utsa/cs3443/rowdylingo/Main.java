//TESTER FILE FOR addSession/deleteSession FILES!!!
//MAYBE DELETE AFTER TESTING??

package edu.utsa.cs3443.rowdylingo;

import java.util.Scanner;

/**
 * Entry point of application, simply displays the screen and updates to a new screen every call to show() using
 * polymorphism.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Screen screen = new LandingPageScreen(scanner);

        while(true) {
            screen = screen.show();
        }
    }
}
