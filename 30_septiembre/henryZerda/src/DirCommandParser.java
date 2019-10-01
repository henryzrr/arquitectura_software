
import java.util.LinkedList;
import java.util.List;

class DirCommandParser implements ICommandParser {
    private List<String> commandParams;

    DirCommandParser(List<String> commandParams) {
        this.commandParams = commandParams;
    }

    @Override
    public List<String> getValidTokens() throws Exception {
        int sizeParamsList = commandParams.size();
        if(!hasAllParams(sizeParamsList))
            throw new BadParamsDirException("Bad params for dir on bob.conf");

        List<String> newParams = new LinkedList<>();
        String dirName=commandParams.get(1);
        String dirPath=null;
        if(sizeParamsList==3)
            dirPath = commandParams.get(2);
        newParams.add(dirName);
        newParams.add(dirPath);

        return newParams;
    }

    private boolean hasAllParams(int sizeParamsList) {
        return sizeParamsList>=2 && sizeParamsList<=3;
    }
}
