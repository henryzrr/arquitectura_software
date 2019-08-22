import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args){
        File ARCHIVO_CONFIGURACION;
        FileReader lector;
        BufferedReader br;
        HashMap<String,String>valores_configuracion;
        StringTokenizer token;
        try {
            ARCHIVO_CONFIGURACION = new File("configure/bob.conf");
            lector = new FileReader(ARCHIVO_CONFIGURACION);
            br = new BufferedReader(lector);
            String s;
            valores_configuracion = new HashMap<String,String>();
            while((s = br.readLine())!=null){
                token = new StringTokenizer(s,"=");
                valores_configuracion.put(token.nextToken(),token.nextToken());
            }
            System.out.println("Mi 'home_dir' es: ");
            System.out.println(valores_configuracion.get("home_dir"));
            lector.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
