import java.util.ArrayList;
import java.util.List;


class CommandLexer {
    private CommandPluginLoader commandPluginLoader;

    CommandLexer(CommandPluginLoader commandPluginLoader) {
        this.commandPluginLoader = commandPluginLoader;

    }

    ICommand getCommand(String nextCommandLine) throws Exception{
        List<String> tokensFromLine = getTokensFromLine(nextCommandLine);
        String commandName = tokensFromLine.get(0);
        if(!commandPluginLoader.pluginInterfaceIsLoaded(commandName))
            throw new CommandUnsupportedException("Command '"+commandName+"' on bob.conf is unsupported");
        IPlugin commandPlugin = commandPluginLoader.getPluginInterface(commandName);
        return commandPlugin.newCommand(tokensFromLine);
    }

    private List<String> getTokensFromLine(String commandLine) {


        List<String> tokenList = new ArrayList<>();
        int stringSize = commandLine.length();
        String token="";
        boolean insideQuote = false;
        for(int i=0;i<stringSize;i++){
            char c = commandLine.charAt(i);
            if((c =='=' || c==' ' && !insideQuote)){
                if(token.length()>0) {
                    tokenList.add(token);
                    token = "";
                }
            }else if(c=='\"' && !insideQuote){
                insideQuote=true;
            }else if(c == '\"'){
                insideQuote=false;
                tokenList.add(token);
                token="";
            }else{
                token = token+c;
            }
        }
        if(token.length()>0)
            tokenList.add(token);

        return tokenList;
    }
}
