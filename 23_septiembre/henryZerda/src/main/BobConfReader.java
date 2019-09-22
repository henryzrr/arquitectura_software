package main;

import java.io.*;
import java.util.Scanner;

class BobConfReader {
    private Scanner scanner;

    BobConfReader(String fileName) throws FileNotFoundException {
        scanner = new Scanner(new File(fileName));
    }

    String nextLine() {
        return scanner.nextLine();
    }

    boolean hasMoreLines() {
        return scanner.hasNext();
    }
}
