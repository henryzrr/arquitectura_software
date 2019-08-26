import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.StringTokenizer;
public  class Print implements Command{
    private HashMap<String,String> directory_path;
    Print(HashMap<String, String> directory_list){
        directory_path=directory_list;
    }

    @Override
    public void execute(String param) throws Exception {
        StringTokenizer st = new StringTokenizer(param,".");
        String dir = st.nextToken();
        if(!directory_path.containsKey(dir)){
            throw new Exception("Error en bob.conf no se ingreso un valor para "+dir);
        }
        String dir_param="";
        if(st.hasMoreTokens()){
            dir_param = st.nextToken();
            if(!dir_param.equals("file")){
                throw new Exception("parametro en print no valido");
            }
        }
        if(dir_param.equals("")){
            getPath(directory_path.get(dir),dir);
        }else{
            getFiles(directory_path.get(dir),dir);
        }

    }
    private void getFiles(String full_path,String dir_name) throws Exception{
        try {
            Path source = Paths.get(full_path);
            System.out.println("Los archivos que contiene la caperta "+dir_name +" son:");
            Files.walk(source).filter(Files::isRegularFile).forEach(System.out::println);
        }catch (Exception e){
            throw new Exception("Ruta ingresada para "+ dir_name +" no valida");
        }
    }
    private void getPath(String full_path,String dir_name){
        System.out.println("EL path de "+dir_name+" es:");
        System.out.println(full_path);
    }
}
