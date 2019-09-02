import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class FileConfParser {
    Set<String> commandList;
    public FileConfParser(Set<String>commandList) {
        this.commandList=commandList;
    }
    List<String> getCommandAndParams(String line)throws Exception{
        List<String> tokens= new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(line," ");
        String command = tokenizer.nextToken();
        if(!commandList.contains(command)){
            throw new Exception("Comando no existente "+command);
        }else if(!tokenizer.hasMoreTokens()) {
            throw new Exception("Error! Faltan valores para " + command);
        }
        tokens.add(command);
        while (tokenizer.hasMoreTokens()){
            tokens.add(tokenizer.nextToken());
        }
        return  tokens;
    }
}
