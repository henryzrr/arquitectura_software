package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class CommandParser {
    private Map<String, IPlugin> availableCommandInterfaces;

    CommandParser(Map<String, IPlugin> availableCommandInterfaces) {
        this.availableCommandInterfaces = availableCommandInterfaces;

    }

    Command getCommand(String nextCommandLine) throws Exception{
        List<String> tokensFromLine = getTokensFromLine(nextCommandLine);
        String commandName = tokensFromLine.get(0);
        if(!availableCommandInterfaces.containsKey(commandName))
            throw new Exception("Bob conf Error, command "+commandName+" unsupported");
        IPlugin commandPlugin = availableCommandInterfaces.get(commandName);
        return commandPlugin.newCommand(tokensFromLine);
    }

    private List<String> getTokensFromLine(String commandLine) {
        StringTokenizer tokenizer = new StringTokenizer(commandLine," ");
        List<String> tokenList = new ArrayList<>();

        while(tokenizer.hasMoreTokens()){
            tokenList.add(tokenizer.nextToken());
        }
        return tokenList;
    }
}
