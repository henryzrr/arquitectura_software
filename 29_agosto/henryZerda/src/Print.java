import java.util.Map;

public class Print implements DirectoryInstruction {
    private String dirName;
    private String dirFunction;
    Print(){
        dirName=null;
        dirFunction = null;
    }

    @Override
    public void setDirName(String name) {
        dirName=name;
    }

    @Override
    public void setDirInstruction(String instruction) {
        dirFunction = instruction;
    }

    @Override
    public void executeInstruction(Map<String, Directory> directories) throws Exception{
        if(directories.containsKey(dirName)){
           Directory dir = directories.get(dirName);
           if(dirFunction.equals("")){
              dir.getPath();
           }else{
               switch (dirFunction){
                   case "files":
                       dir.getFiles();
                       break;
                   case "directories":
                       dir.getDirectories();
               }
           }

        }else{
            throw new Exception("Error en bob.conf en la sentencia print, no existe el directorio!!");
        }
    }
}
