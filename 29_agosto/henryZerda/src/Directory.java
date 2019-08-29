import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Directory {
    private String name;
    private String path;
    Directory(){
        name=null;
        path=null;
    }


    void getPath() {
        System.out.println("El path de "+name+" es en:");
        System.out.println(path+"\n");
    }

    void setName(String name) {
        this.name = name;
    }

    void setPath(String path) {
        this.path = path;
    }
    void getFiles() throws  Exception{
        System.out.println("Lost archivos de "+name+" son: ");
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());

            result.forEach(System.out::println);

        } catch (Exception e) {
            throw new Exception("Direccion ingresada en bob.conf para "+name+" no válida");
        }
        System.out.println();
    }
     void getDirectories() throws Exception{
        System.out.println("Lost directorios de "+name+" son: ");
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {

            List<String> result = walk.filter(Files::isDirectory)
                    .map(Path::toString).collect(Collectors.toList());

            result.forEach(System.out::println);

        } catch (Exception e) {
            throw new Exception("Direccion ingresada en bob.conf para "+name+" no válida");
        }
        System.out.println();
    }

}
