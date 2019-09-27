import java.util.List;


public class DirPluginInterface implements IPlugin {
    @Override
    public String getPluginName() {
        return "dir";
    }

    @Override
    public ICommand newCommand(List<String> commandLineTokens) throws Exception{
        return new DirCommand(commandLineTokens);
    }
}
