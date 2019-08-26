import java.util.ArrayList;
import java.util.HashMap;

public class CommandInvoker {
    private Dir dir_command;
    private Print print_command;

    private HashMap<String,String> directory_path;
    public CommandInvoker(){
        directory_path = new HashMap<>();
        dir_command = new Dir(directory_path);
        print_command = new Print(directory_path);
    }
    public void invokeCommands(ArrayList<String[]>command_list) throws Exception {
        for (String[] list: command_list
             ) {
            switch (list[0]){
                case "dir":
                    dir_command.execute(list[1]);
                    break;
                case "print":
                    print_command.execute(list[1]);
            }
        }
    }
}
