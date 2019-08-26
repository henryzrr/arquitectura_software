
import java.util.ArrayList;
import java.util.TreeSet;

public class App {
    public static void main(String [] args) {
        String CONFIG_FILE_PATH = "configure/bob.conf";
        TreeSet<String>available_commands = new TreeSet<String>();
        available_commands.add("dir");
        available_commands.add("print");

        try {
            ArrayList<String> fileConfig_lines=Reader.read_lines(CONFIG_FILE_PATH);
            ArrayList<String[]> command_list =  CommandParser.getCommands(fileConfig_lines,available_commands);
            CommandInvoker invoker = new CommandInvoker();
            invoker.invokeCommands(command_list);
            /*for (String [] command: command_list
                 ) {
               // System.out.println(command[0]+" "+command[1]);
            }*/
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
