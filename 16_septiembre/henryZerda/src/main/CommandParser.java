package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class CommandParser {
    private Map<String, IPlugin> availableCommandInterfaces;
    private Map<String, String> programValues;

    CommandParser(Map<String, IPlugin> availableCommandInterfaces, Map<String, String> programValues) {
        this.availableCommandInterfaces = availableCommandInterfaces;
        this.programValues = programValues;
    }

    Command nextCommand(String nextCommandLine) throws Exception{
        List<String> commandLineTokens = getLineTokens(nextCommandLine);
        String commandName = commandLineTokens.get(0);
        if(!availableCommandInterfaces.containsKey(commandName))
            throw new Exception("Bob conf Error, command "+commandName+" unsupported");
        IPlugin commandPlugin = availableCommandInterfaces.get(commandName);
        return commandPlugin.newCommand(commandLineTokens);
    }

    private List<String> getLineTokens(String commandLine) {
        StringTokenizer tokenizer = new StringTokenizer(commandLine," ");
        List<String> tokenList = new ArrayList<>();

        while(tokenizer.hasMoreTokens()){
            tokenList.add(tokenizer.nextToken());
        }
        return tokenList;
    }
}