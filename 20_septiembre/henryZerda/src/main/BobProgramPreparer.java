package main;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

class BobProgramPreparer {

    private static  Map<String, IPlugin> availableCommandInterfaces;
    private Map<String,String> programDefaultValues;
    BobProgramPreparer() {
        availableCommandInterfaces = loadCommandPlugins();
        programDefaultValues = loadDefaultProgramValues();
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

    static Map<String,IPlugin> getAvailableCommands(){
        return availableCommandInterfaces;
    }
    void startProgram() throws Exception{
        CommandInterpreter bobCommandInterpreter = new CommandInterpreter( programDefaultValues);
        bobCommandInterpreter.executeCommand();
    }
}
