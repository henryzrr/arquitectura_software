import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
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
    List<String> getFiles() throws  Exception{
        List<String> files;
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {

            files = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());


        } catch (Exception e) {
            throw new Exception("dir error, Direccion ingresada en bob.conf para "+name+" no válida");
        }
        return files;
    }
     List<String> getDirectories() throws Exception{
         List<String> directories;
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {

            directories = walk.filter(Files::isDirectory)
                    .map(Path::toString).collect(Collectors.toList());

        } catch (Exception e) {
            throw new Exception("dir error, Direccion ingresada en bob.conf para "+name+" no válida");
        }
        return directories;
    }

    String getPath() {
        return path;
    }

    List<String> getOneFileType(String fileType) throws Exception {
        List<String> result;
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {

            result = walk.map(Path::toString)
                    .filter(f -> f.endsWith("."+fileType)).collect(Collectors.toList());

        } catch (Exception e) {
            throw new Exception("dir error, Direccion ingresada en bob.conf para "+name+" no válida");
        }
        return result;
    }
    List<String> getOneFileTypeRelativePath(String fileType) throws Exception {
        List<String> files = getOneFileType(fileType);
        List<String> trimmedFiles =  new LinkedList<>();
        String relativeFile;
        for (String file: files
             ) {
            int sizePath = path.length();
            relativeFile = file.substring(sizePath+1);
            trimmedFiles.add(relativeFile);
        }
        return trimmedFiles;
    }
}
