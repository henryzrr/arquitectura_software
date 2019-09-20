package main;

import java.util.Iterator;

class CommandIterator implements Iterator<Command>, Iterable<Command> {

    private CommandParser commandParser;
    private BobConfReader bobConfReader;

    CommandIterator(CommandParser commandParser, BobConfReader bobConfReader) {
        this.commandParser = commandParser;
        this.bobConfReader = bobConfReader;
    }


    @Override
    public boolean hasNext() {
        return bobConfReader.hasMoreLines();
    }

    @Override
    public Command next() {
        try {
            String nextLine = bobConfReader.nextLine();
            return commandParser.getCommand(nextLine);
        } catch (Exception e) {
            System.err.println("Iterator Error, command declared on bob.conf unsupported");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Iterator<Command> iterator() {
        return this;
    }
}
