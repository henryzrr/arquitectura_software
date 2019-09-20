package main;


import java.util.Map;

class CommandInterpreter {

    private Map<String,String> programValues;
    CommandInterpreter( Map<String, String> programValues) {
        this.programValues = programValues;
    }


     void executeCommand() throws Exception {
         Map<String,IPlugin> availableCommandInterfaces = BobProgramPreparer.getAvailableCommands();
         BobConfReader reader = new BobConfReader("src/configure/bob.conf");
         CommandParser parser = new CommandParser(availableCommandInterfaces);
         CommandIterator commandIterator = new CommandIterator(parser,reader);
         for (Command command: commandIterator
              ) {
             command.execute(programValues);
         }

    }
}
