import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args){
        File ARCHIVE_PATH;
        FileReader reader;
        BufferedReader br;
        StringTokenizer token;

        HashMap<String,String>system_values = new HashMap<String,String>();

        try {
            ARCHIVE_PATH = new File("configure/bob.conf");
            reader = new FileReader(ARCHIVE_PATH);
            br = new BufferedReader(reader);
            String s;
            while((s = br.readLine())!=null){
                token = new StringTokenizer(s,"=");
                system_values.put(token.nextToken(),token.nextToken());
            }

            reader.close();
        }catch(Exception e){
            String directory = System.getProperty("user.dir");
            ARCHIVE_PATH = new File(directory);
            system_values.put("home_dir",ARCHIVE_PATH.getAbsolutePath());
        }
        System.out.println("Mi 'home_dir' es: ");
        System.out.println(system_values.get("home_dir"));
    }
}
