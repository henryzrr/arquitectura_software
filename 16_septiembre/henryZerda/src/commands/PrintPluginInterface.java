package commands;

import main.Command;
import main.IPlugin;

import java.util.List;

public class PrintPluginInterface implements IPlugin {
    @Override
    public String getPluginName() {
        return "print";
    }

    @Override
    public Command newCommand(List<String> commandLineTokens) throws Exception {
        return new PrintCommand(commandLineTokens);
    }

}
