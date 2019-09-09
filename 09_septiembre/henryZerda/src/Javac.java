import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Javac implements Tool{
    private String compilerName;
    private String fileType1;

    Javac(String compilerName, String fileType1) {
        this.compilerName = compilerName;
        this.fileType1 = fileType1;
    }



    private void compile(List<String>files) throws Exception {
        for (String path:files
        ) {
            String command = compilerName+" "+path;
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        }
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
            throw  new Exception("apply error, instruccion mal declarada en "+compilerName);
        }
        return files;
    }


    @Override
    public void applyTool(List<String> commandAndParamList, Map<String, String> systemValues) throws Exception {
        int paramNumber = commandAndParamList.size();
        if(paramNumber!=3)
            throw new Exception("apply error, instruccion mal declarada en apply "+compilerName);
        String directoryFiles=commandAndParamList.get(2);
        List<String> files = getAllFiles(directoryFiles,systemValues);
        compile(files);
    }
}
