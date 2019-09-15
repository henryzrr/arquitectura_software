package main;

import java.util.List;

public interface IPlugin {
    String getPluginName();
    Command newCommand(List<String> commandLineTokens) throws Exception;
}
