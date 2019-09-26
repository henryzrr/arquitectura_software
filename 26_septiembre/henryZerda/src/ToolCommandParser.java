

import java.util.LinkedList;
import java.util.List;

public class ToolCommandParser implements ICommandParser {
    private List<String> commandParams;

    public ToolCommandParser(List<String> commandParams) {
        this.commandParams = commandParams;
    }

    @Override
    public List<String> getValidTokens() throws Exception {
        if(!hasAllParams())
            throw new Exception("tool Error, bad params on bob.conf");
        String toolName = commandParams.get(1);
        String toolInstruction = commandParams.get(2);
        String fileType1 = commandParams.get(3);
        String fileType2 = commandParams.get(4);
        List<String> newParams = new LinkedList<>();
        newParams.add(toolName);
        newParams.add(toolInstruction);
        newParams.add(fileType1);
        newParams.add(fileType2);
        return  newParams;
    }

    private boolean hasAllParams() {
        return commandParams.size()==5;
    }
}
