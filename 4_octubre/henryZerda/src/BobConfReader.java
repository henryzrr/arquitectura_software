import java.io.*;
import java.util.Scanner;

class BobConfReader {
    private Scanner scanner;

    BobConfReader(String fileName) throws IOException {
        try {
            scanner = new Scanner(new File(fileName));
        }catch (Exception e){
            throw new IOException("Bob.conf is not found");
        }
    }

    String nextLine() {
        return scanner.nextLine();
    }

    boolean hasMoreLines() {
        return scanner.hasNext();
    }
}
