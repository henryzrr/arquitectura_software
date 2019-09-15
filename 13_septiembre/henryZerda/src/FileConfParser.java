import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class FileConfParser {
    private Set<String> commandList;
    FileConfParser(Set<String>commandList) {
        this.commandList=commandList;
    }
    List<String> getCommandAndParams(String line)throws Exception{
        List<String> tokens= new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(line," ");
        String command = tokenizer.nextToken();
        if(!commandList.contains(command)){
            throw new Exception("bob.conf error, Comando no existente "+command);
        }else if(!tokenizer.hasMoreTokens()) {
            throw new Exception("bob.conf error, Faltan valores para " + command);
        }
        tokens.add(command);
        while (tokenizer.hasMoreTokens()){
            tokens.add(tokenizer.nextToken());
        }
        return  tokens;
    }
}
