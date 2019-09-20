package main;

import java.util.Map;

public interface Command {
    void execute( Map<String,String> programValues) throws Exception;
}
