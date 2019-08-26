import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

abstract class CommandParser {
    static ArrayList<String[]> getCommands(ArrayList<String> lines, TreeSet<String> available_commands) throws Exception{
        ArrayList<String[]> command_list = new ArrayList<>();
        String command,param;
        for (String line : lines) {
            StringTokenizer st = new StringTokenizer(line, " ");
            command = st.nextToken();
            param = st.nextToken();
            if (available_commands.contains(command) && !st.hasMoreElements()) {
                String[] command_param = {command, param};
                command_list.add(command_param);
            } else {
                throw new Exception("Error en los comandos en bob.conf");
            }

        }
        return command_list;
    }
}
