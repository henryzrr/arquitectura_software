public class Main {
    public static void main(String [] args) {
        try {
            CommandPluginLoader commandPluginLoader = new CommandPluginLoader();
            CommandInterpreter commandInterpreter = new CommandInterpreter(commandPluginLoader);
            commandInterpreter.executeCommand();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
