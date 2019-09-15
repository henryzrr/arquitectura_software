package main;


import java.util.Map;

class CommandInterpreter {

    private CommandIterator commandIterator;
    private Map<String,String> programValues;
    CommandInterpreter(CommandIterator commandIterator, Map<String, String> programValues) {
        this.commandIterator = commandIterator;
        this.programValues = programValues;
    }


     void executeCommand() throws Exception {
        while(commandIterator.hasNextCommand()){
            Command command = commandIterator.nextCommand();
            command.execute(programValues);
        }
    }
}
