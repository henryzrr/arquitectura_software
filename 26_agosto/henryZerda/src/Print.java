import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.StringTokenizer;
public  class Print implements Command{
    private HashMap<String,String> directory_path;
    public Print(HashMap<String,String> directory_list){
        directory_path=directory_list;
    }

    @Override
    public void execute(String param) throws Exception {
        StringTokenizer st = new StringTokenizer(param,".");
        String dir = st.nextToken();
        String dir_param;
        if(st.hasMoreTokens()){
            dir_param = st.nextToken();
            if(!dir_param.equals("file")){
                throw new Exception("parameto en print no valido");
            }
        }
        if(param==null){
            getPath(directory_path.get(dir));
        }else{
            getAllDirectories(directory_path.get(dir));
        }

    }
    private void getAllDirectories(String full_path) throws Exception{
        try {
            Path source = Paths.get(full_path);
            Files.walk(source).filter(Files::isRegularFile).forEach(System.out::println);
        }catch (Exception e){
            throw new Exception("Ruta en comando print no valida");
        }
    }
    private void getPath(String full_path){
        System.out.println(directory_path.get(full_path));
    }
}
