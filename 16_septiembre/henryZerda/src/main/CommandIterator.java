package main;

class CommandIterator {

    private CommandParser commandParser;
    private BobConfCommandReader commandReader;
    private String nextCommandLine;
    CommandIterator(CommandParser commandParser, BobConfCommandReader commandReader) {
        this.commandParser = commandParser;
        this.commandReader = commandReader;
    }

    boolean hasNextCommand() throws Exception {
        nextCommandLine = commandReader.readNextLine();
        return nextCommandLine!=null;
    }

    Command nextCommand() throws Exception{
        if (nextCommandLine ==null) {
            if((nextCommandLine = commandReader.readNextLine())==null)
                throw new Exception("Read next Command Error, there is no more command lines in bob.conf");
        }
        Command command =  commandParser.nextCommand(nextCommandLine);
        nextCommandLine = null;
        return command;
    }
}
