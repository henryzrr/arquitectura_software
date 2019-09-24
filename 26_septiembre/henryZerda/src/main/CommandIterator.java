package main;

import java.util.Iterator;

class CommandIterator implements Iterator<ICommand>, Iterable<ICommand> {

    private CommandLexer commandLexer;
    private BobConfReader bobConfReader;

    CommandIterator(CommandLexer commandLexer, BobConfReader bobConfReader) {
        this.commandLexer = commandLexer;
        this.bobConfReader = bobConfReader;
    }


    @Override
    public boolean hasNext() {
        return bobConfReader.hasMoreLines();
    }

    @Override
    public ICommand next() {
        try {
            String nextLine = bobConfReader.nextLine();
            return commandLexer.getCommand(nextLine);
        } catch (Exception e) {
            System.err.println("Iterator Error, command declared on bob.conf unsupported");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Iterator<ICommand> iterator() {
        return this;
    }
}
