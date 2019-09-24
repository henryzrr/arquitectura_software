package main;


class CommandInterpreter {

    private CommandPluginLoader commandPluginLoader;

    CommandInterpreter(CommandPluginLoader commandPluginLoader) {
        this.commandPluginLoader = commandPluginLoader;
    }


     void executeCommand() throws Exception {
         BobConfReader reader = new BobConfReader("./bob.conf");
         CommandLexer parser = new CommandLexer(commandPluginLoader);
         CommandIterator commandIterator = new CommandIterator(parser,reader);
         for (ICommand command : commandIterator
              ) {
             command.execute();
         }

    }
}
