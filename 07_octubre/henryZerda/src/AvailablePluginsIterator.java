import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AvailablePluginsIterator implements Iterable<String>,Iterator<String> {
    private List<String> availablePlugins;
    private Iterator<String>it;
    public AvailablePluginsIterator(){
        availablePlugins  = new LinkedList<>();
        addPlugins();
        it = availablePlugins.iterator();
    }

    private void addPlugins() {

        availablePlugins.add("Tool");
        availablePlugins.add("Dir");
        availablePlugins.add("Volume");
        availablePlugins.add("Apply");
        availablePlugins.add("Print");
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
