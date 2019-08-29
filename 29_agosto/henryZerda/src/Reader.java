import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class Reader {
    static List<String> readFile(String Path) throws Exception{
        FileReader file_reader = new FileReader(Path);
        BufferedReader br = new BufferedReader(file_reader);
        String line;
        List<String> file_lines = new ArrayList<>();
        while ((line=br.readLine())!=null){
            file_lines.add(line);
        }
        br.close();
        return file_lines;
    }
}
