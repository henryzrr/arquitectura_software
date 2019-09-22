
import java.time.LocalDate;
public class Main {
    public static void main(String [] args){
        LocalDate date = LocalDate.now();
        String executionPath = System.getProperty("user.dir");
        String pcName = System.getProperty("user.name");
	    System.out.println("Hola "+ pcName+ " ejecuto el programa desde:\n"+executionPath+"\nEn fecha de "+date);
    }
}
