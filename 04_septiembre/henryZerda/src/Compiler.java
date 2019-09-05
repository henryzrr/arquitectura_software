import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Compiler{
    private String compilerName;
    private String fileType1;
    private String fileType2;

    Compiler(String compilerName, String fileType1, String fileType2) {
        this.compilerName = compilerName;
        this.fileType1 = fileType1;
        this.fileType2 = fileType2;
    }



    private void compile(List<String>files) throws Exception {
        for (String path:files
        ) {
            String command = compilerName+" "+path;
            Runtime.getRuntime().exec(command);
        }
    }
    void execCompilation(String path, Map<String,String> systemValues)throws Exception{
        List<String> files = getAllFiles(path,systemValues);
        compile(files);

    }

    private List<String> getAllFiles(String path, Map<String, String> systemValues) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(path,".");
        String dirName = tokenizer.nextToken();
        List<String>files;
        if(tokenizer.hasMoreTokens()){
            if(!systemValues.containsKey(dirName))
                throw new Exception("apply error: no existe el directorio "+dirName);
            String dirFunction = tokenizer.nextToken();
            if(!dirFunction.equals("files") || tokenizer.hasMoreTokens()){
                throw new Exception("apply error, Parametros inválidos");
            }
            Directory dir = new Directory(systemValues.get(dirName),dirName);
            files = dir.getOneFileType(fileType1);
        }else{
            files = new ArrayList<>();
            files.add(dirName);
        }
        return files;
    }

}
