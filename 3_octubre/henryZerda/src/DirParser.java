import java.util.StringTokenizer;

public class DirParser {

    public String[] makeParsing(String args) {
        StringTokenizer tokenizer = new StringTokenizer(args,"=");
        String dirName = tokenizer.nextToken();
        String dirPath = "";
        if(tokenizer.hasMoreTokens()){
            dirPath = tokenizer.nextToken().replaceAll("\"","");
        }
        return  new String[]{dirName,dirPath};
    }
}
