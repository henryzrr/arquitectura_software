import java.util.HashMap;
import java.util.StringTokenizer;
public  class Dir  implements Command{
    private HashMap<String,String> directory_path;
    Dir(HashMap<String, String> directory_list){
        directory_path=directory_list;
    }
    @Override
    public void execute(String param) throws Exception{
        String[] path = get_path(param);
        directory_path.put(path[0],path[1]);
    }
    private  String[] get_path(String aux_path) throws Exception{
        StringTokenizer st = new StringTokenizer(aux_path,"=");
        String path_name = st.nextToken();
        String path;
        if(st.hasMoreTokens()){
            path = st.nextToken();
            path = path.replaceAll("\"","");

        }else if(path_name.equals("home")){
            path = System.getProperty("user.dir");
        }else{
            throw new Exception("Error en en parametro de "+ path_name+" del comando dir en el archivo bob.conf");
        }
        return new String[]{path_name,path};
    }

}
