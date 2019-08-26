import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public abstract class CommandParser {
    public static ArrayList<String[]> getCommands(ArrayList<String> lines, TreeSet<String> available_commands) throws Exception{
        ArrayList<String[]> command_list = new ArrayList<>();
        int lines_number = lines.size();
        String command,param;
        for (int i=0;i<lines_number;i++){
            StringTokenizer st = new StringTokenizer(lines.get(i)," ");
            command = st.nextToken();
            param = st.nextToken();
            if(available_commands.contains(command)&&!st.hasMoreElements()){
                String [] command_param= {command,param};
                command_list.add(command_param);
            }else{
                throw new Exception("Error en los comandos en bob.conf");
            }

        }
        return command_list;
    }
}
