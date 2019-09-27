

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class PrintCommandParser implements ICommandParser {

    private List<String>commandAndParams;

    public PrintCommandParser(List<String> commandAndParams) {
        this.commandAndParams = commandAndParams;
    }

    @Override
    public List<String> getValidTokens() throws Exception {

        if(!hasAllParams())
            throw new BadParamsPrintException("bad params on bob.conf");
        String dirAndCallFunction = commandAndParams.get(1);
        StringTokenizer tokenizer = new StringTokenizer(dirAndCallFunction,".");
        String dirName = tokenizer.nextToken();
        String functionCall;
        if(tokenizer.hasMoreTokens())
            functionCall = tokenizer.nextToken();
        else
            functionCall="path";
        List<String> newParams = new LinkedList<>();
        newParams.add(dirName);
        newParams.add(functionCall);
        return newParams;
    }

    private boolean hasAllParams() {
        return commandAndParams.size()==2;
    }
}
