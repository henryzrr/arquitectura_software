import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AvailableToolPluginIterator implements Iterable<String>,Iterator<String> {
    private List<String> availablePlugins;
    private Iterator<String>it;
    public AvailableToolPluginIterator(){
        availablePlugins  = new LinkedList<>();
        addPlugins();
        it = availablePlugins.iterator();
    }

    private void addPlugins() {

        availablePlugins.add("CompilerToolCreator");
        availablePlugins.add("PackerToolCreator");
    }

    @Override
    public Iterator<String> iterator() {
        return this;
    }


    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public String next() {
        return it.next();
    }
}
