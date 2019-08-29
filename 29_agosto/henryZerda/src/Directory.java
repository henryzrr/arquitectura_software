import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Directory {
    String name;
    String path;
    public Directory(){
        name=null;
        path=null;
    }


    public void getPath() {
        System.out.println("El path de "+name+" es en:");
        System.out.println(path+"\n");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public void getFiles() throws  Exception{
        System.out.println("Lost archivos de "+name+" son: ");
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());

            result.forEach(System.out::println);

        } catch (Exception e) {
            throw new Exception("Direccion ingresada en bob.conf para "+name+" no válida");
        }
        System.out.println("");
    }
    public void getDirectories() throws Exception{
        System.out.println("Lost directorios de "+name+" son: ");
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {

            List<String> result = walk.filter(Files::isDirectory)
                    .map(x -> x.toString()).collect(Collectors.toList());

            result.forEach(System.out::println);

        } catch (Exception e) {
            throw new Exception("Direccion ingresada en bob.conf para "+name+" no válida");
        }
        System.out.println("");
    }

}
