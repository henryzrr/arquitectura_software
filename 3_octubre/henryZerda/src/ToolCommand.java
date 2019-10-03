
public class ToolCommand implements Command {
    private ToolContainer toolContainer;
    public ToolCommand(){
        toolContainer = ToolContainerImplementation.getInstance();
    }
    @Override
    public void execute(String args) {
        try{
            String [] toolParams = makeParsing(args);
            ToolTool tool = new ToolTool(toolParams[0],toolParams[1],toolParams[2],toolParams[3]);
            toolContainer.setTool(toolParams[0],tool);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    private String[] makeParsing(String args) throws Exception{

        String [] tokens = getTokensFromLine(args);
        if(tokens.length<4)
            throw  new Exception("Error on execute method in ToolC, bad params on bob.conf for tool");
        return tokens;
    }
    private String [] getTokensFromLine(String commandLine) {
        String []tokenList = new String[4];
        int j=0;
        int stringSize = commandLine.length();
        String token="";
        boolean insideQuote = false;
        for(int i=0;i<stringSize;i++){
            char c = commandLine.charAt(i);
            if((c =='=' || c==' ' && !insideQuote)){
                if(token.length()>0) {
                    tokenList[j++]=token;
                    token = "";
                }
            }else if(c=='\"' && !insideQuote){
                insideQuote=true;
            }else if(c == '\"'){
                insideQuote=false;
                tokenList[j++]=token;
                token="";
            }else{
                token = token+c;
            }
        }
        if(token.length()>0)
            tokenList[j++]=token;

        return tokenList;
    }
}
