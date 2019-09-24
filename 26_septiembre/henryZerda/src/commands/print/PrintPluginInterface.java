package commands.print;

import main.BobProgramValues;
import main.ICommand;
import main.IPlugin;

import java.util.List;

public class PrintPluginInterface implements IPlugin {
    private BobProgramValues bobProgramValues;
    public PrintPluginInterface(){
        bobProgramValues = BobProgramValues.getBobProgramValues();
    }
    @Override
    public String getPluginName() {
        return "print";
    }

    @Override
    public ICommand newCommand(List<String> commandLineTokens) throws Exception {
        return new PrintCommand(commandLineTokens,bobProgramValues);
    }

}
