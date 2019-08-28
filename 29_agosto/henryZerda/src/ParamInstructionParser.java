import java.util.Set;
import java.util.StringTokenizer;

public class ParamInstructionParser {

    public String [] getDirParams(String param) throws Exception{

        StringTokenizer tokenizer = new StringTokenizer(param,"=");
        String dirname = tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()){
            return new String [] {dirname,tokenizer.nextToken()};
        }else{
            return new String[]{dirname,null};
        }
    }
    public String [] getPrintParams(String param, Set<String>directoryMethods) throws Exception{
        StringTokenizer tokenizer = new StringTokenizer(param,".");
        String dir_name = tokenizer.nextToken();
        if(!tokenizer.hasMoreTokens()){
            return new String[]{dir_name,null};
        }else{
            String method = tokenizer.nextToken();
            if(directoryMethods.contains(method)){
                return new String[]{dir_name,method};
            }else{
                throw new Exception("Error en bob.conf print con metodo inexistente");
            }
        }

    }
}