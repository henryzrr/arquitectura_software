import java.util.ArrayList;
import java.util.HashMap;

class CommandInvoker {
    private Dir dir_command;
    private Print print_command;

    CommandInvoker(){
        HashMap<String, String> directory_path = new HashMap<>();
        dir_command = new Dir(directory_path);
        print_command = new Print(directory_path);
    }
    void invokeCommands(ArrayList<String[]> command_list) throws Exception {
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
