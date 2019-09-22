package main;

public class Main {
    public static void main(String [] args) {
        try {
            CommandPluginLoader commandPluginLoader = new CommandPluginLoader();
            CommandInterpreter commandInterpreter = new CommandInterpreter(commandPluginLoader);
            commandInterpreter.executeCommand();

        }catch (Exception e){
            System.err.println("Fatal Error, el programa bob dejo de funcionar");
            e.printStackTrace();
        }

    }
}
