import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Reader {
    private  BufferedReader br;
    Reader(String filePath) throws FileNotFoundException {
        FileReader file_reader = new FileReader(filePath);
        br = new BufferedReader(file_reader);
    }

    String nextLine() throws  IOException{
        return br.readLine();
    }
    void close() throws IOException {
        br.close();
    }
}
