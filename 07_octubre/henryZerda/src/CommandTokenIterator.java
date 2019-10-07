import java.util.Iterator;

class CommandTokenIterator implements Iterator<String []>, Iterable<String []> {

    private BobConfReader bobConfReader;

    CommandTokenIterator(BobConfReader bobConfReader) {
        this.bobConfReader = bobConfReader;
    }

    @Override
    public boolean hasNext() {
        return bobConfReader.hasMoreLines();
    }

    @Override
    public String [] next() {
        try {
            String nextLine = bobConfReader.nextLine();
            String [] tokens = getTokensFromLine(nextLine);
            return tokens;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    private String [] getTokensFromLine(String commandLine) throws Exception{
        String []tokens = commandLine.split(" ",2);
        if(tokens.length<2){
            throw  new Exception("Bad instruction line on bob.conf");
        }
        return  tokens;
    }
    @Override
    public Iterator<String []> iterator() {
        return this;
    }
}
