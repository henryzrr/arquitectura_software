package main;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

class BobProgramPreparer {

    private Map<String, IPlugin> availableCommandInterfaces;
    private Map<String,String> programDefaultValues;
    private String bobConfPath;
    BobProgramPreparer(String bob_conf_path) {
        availableCommandInterfaces = loadCommandPlugins();
        programDefaultValues = loadDefaultProgramValues();
        bobConfPath = bob_conf_path;
    }

    private Map<String, String> loadDefaultProgramValues() {
        Map<String,String>programDefaultValues = new HashMap<>();
        String defaultWindowsVolume = "C";
        String homeDefaultPath = getBobExecutionPath();
        String isWindows = isWindows();
        programDefaultValues.put("volume",defaultWindowsVolume);
        programDefaultValues.put("isWindows",isWindows);
        programDefaultValues.put("home",homeDefaultPath);
        return programDefaultValues;
    }

    private String isWindows() {
        String OSname = System.getProperty("os.name");
        String isWindows;
        if(OSname.contains("Windows"))
            isWindows = "True";
        else
            isWindows = "False";
        return isWindows;
    }

    private String getBobExecutionPath() {
        return System.getProperty("user.dir");
    }

    private Map<String, IPlugin> loadCommandPlugins() {
        Map<String, IPlugin> availableCommandInterfaces = new HashMap<>();
        ServiceLoader <IPlugin> commandPluginInterfaceLoader = ServiceLoader.load(IPlugin.class);
        for (IPlugin commandPluginInterface : commandPluginInterfaceLoader) {
            String pluginName = commandPluginInterface.getPluginName();
            availableCommandInterfaces.put(pluginName, commandPluginInterface);

        }
        return availableCommandInterfaces;
    }


    void startProgram() throws Exception{

        BobConfCommandReader commandReader = new BobConfCommandReader(bobConfPath);
        CommandParser commandParser = new CommandParser(availableCommandInterfaces);
        CommandIterator commandIterator = new CommandIterator(commandParser,commandReader);
        CommandInterpreter bobCommandInterpreter = new CommandInterpreter(commandIterator, programDefaultValues);
        bobCommandInterpreter.executeCommand();
    }
}
