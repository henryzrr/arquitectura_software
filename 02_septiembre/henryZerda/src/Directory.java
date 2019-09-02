import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Directory {
    private String name;
    private String path;
    Directory(String path,String name){
        this.path=path;
        this.name=name;
    }
    Directory(String path){
        this.path=path;
        name="";
    }
    List<String> getFiles() throws  Exception{
        List<String> result;
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {

            result = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());


        } catch (Exception e) {
            throw new Exception("Direccion ingresada en bob.conf para "+name+" no válida");
        }
        return result;
    }
     List<String> getDirectories() throws Exception{
         List<String> result;
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {

            result = walk.filter(Files::isDirectory)
                    .map(Path::toString).collect(Collectors.toList());

        } catch (Exception e) {
            throw new Exception("Direccion ingresada en bob.conf para "+name+" no válida");
        }
        return result;
    }

    String getPath() {
        return path;
    }

    public List<String> getOneFileType(String fileType) {

    }
}
