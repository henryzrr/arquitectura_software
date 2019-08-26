import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
abstract class Reader {
    static ArrayList<String> read_lines(String path) throws Exception{
        ArrayList<String>lines=new ArrayList<>();
        FileReader file_reader = new FileReader(path);
        BufferedReader reader = new BufferedReader(file_reader);
        String line;
        while((line = reader.readLine())!=null){
            lines.add(line);
        }
        return lines;
    }
}
