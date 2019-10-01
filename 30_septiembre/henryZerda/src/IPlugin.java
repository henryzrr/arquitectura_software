import java.util.List;

public interface IPlugin {
    String getPluginName();
    ICommand newCommand(List<String> commandLineTokens) throws Exception;
}
