import java.io.*;
import java.util.Scanner;

class BobConfReader {
    private Scanner scanner;

    BobConfReader(String fileName) throws BobFileNotFoundException {
        try {
            scanner = new Scanner(new File(fileName));
        }catch (Exception e){
            throw new BobFileNotFoundException("Bob.conf is not found",e);
        }
    }

    String nextLine() {
        return scanner.nextLine();
    }

    boolean hasMoreLines() {
        return scanner.hasNext();
    }
}
