import java.util.List;


public class DirPluginInterface implements IPlugin {
    private BobProgramValues bobProgramValues;
    public DirPluginInterface(){
        bobProgramValues = BobProgramValues.getBobProgramValues();
    }
    @Override
    public String getPluginName() {
        return "dir";
    }

    @Override
    public ICommand newCommand(List<String> commandLineTokens) throws Exception{
        return new DirCommand(commandLineTokens,bobProgramValues);
    }
}
