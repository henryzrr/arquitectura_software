import java.util.Properties;
import java.io.FileInputStream;

public class Main {
    public static void main(String [] args){
        FileInputStream archivo;
        Properties valores;
        try {
            archivo = new FileInputStream("configure/bob.conf");
            valores = new Properties();
            valores.load(archivo);
            archivo.close();
            System.out.println("Mi 'home_dir' es:");
            System.out.println(valores.getProperty("home_dir"));
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
