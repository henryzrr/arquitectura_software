
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ApplyCommandParser implements ICommandParser {

    private List<String>commandParams;

    public ApplyCommandParser(List<String> commandParams) {
        this.commandParams = commandParams;
    }

    @Override
    public List<String> getValidTokens() throws Exception {

        if(!hasAllParams())
            throw new BadParamsApplyException("bad params on bob.conf");

        String toolName = commandParams.get(1);
        String dirCallFunction = commandParams.get(2);
        StringTokenizer st = new StringTokenizer(dirCallFunction,".");
        String dirName = st.nextToken();
        String dirFunction=null;
        if(st.hasMoreTokens())
            dirFunction = st.nextToken();
        if(st.hasMoreTokens())
            throw new BadParamsApplyException("Bad params on bob.conf");

        List<String> newParams = new LinkedList<>();
        newParams.add(toolName);
        newParams.add(dirName);
        newParams.add(dirFunction);
        return  newParams;
    }

    private boolean hasAllParams() {
        return commandParams.size()==3;
    }
}
