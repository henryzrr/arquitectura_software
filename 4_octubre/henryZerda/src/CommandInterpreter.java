class CommandInterpreter {

    private CommandPluginLoader commandPluginLoader;

    CommandInterpreter(CommandPluginLoader commandPluginLoader) {
        this.commandPluginLoader = commandPluginLoader;
    }


     void executeCommand() throws Exception {
         BobConfReader reader = new BobConfReader("bob.conf");
         CommandTokenIterator commandTokenIterator = new CommandTokenIterator(reader);
         for (String [] commandTokens : commandTokenIterator
              ) {
             String commandName = commandTokens[0];
             String args = commandTokens[1];
             if(!commandPluginLoader.commandIsLoaded(commandName))
                throw  new Exception("Command declared on bob.conf "+commandName+" unsupported!");
             else
                commandPluginLoader.getCommand(commandName).execute(args);
         }

    }
}
