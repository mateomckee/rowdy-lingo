package edu.utsa.cs3443.rowdylingo;

import java.util.Scanner;

public abstract class Screen {
    protected Scanner scanner;
    protected String subheader;

    public Screen(Scanner scanner, String subheader) {
        this.scanner = scanner;
        this.subheader = subheader;
    }

    protected void printHeader() {
        System.out.println("======= Rowdy Lingo ======");
        System.out.println("~~~~ " + subheader + " ~~~~");

    }

    public abstract Screen show();

}
