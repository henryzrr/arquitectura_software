
import java.util.LinkedList;
import java.util.List;

public class VolumeCommandParser implements ICommandParser {
    private List<String> commandParams;

    public VolumeCommandParser(List<String> commandParams) {
        this.commandParams = commandParams;
    }

    @Override
    public List<String> getValidTokens() throws Exception {
        if(!hasAllParams())
            throw new Exception("volume Error, bad params on bob.conf");

        String volume = commandParams.get(1);
        List<String> newParams = new LinkedList<>();
        newParams.add(volume);
        return newParams;
    }

    private boolean hasAllParams() {
        return commandParams.size()==2;
    }
}
