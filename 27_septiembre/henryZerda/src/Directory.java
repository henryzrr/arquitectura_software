import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Directory {
    private String dirPath;
    private String dirName;

    public Directory(String dirPath, String dirName) {
        this.dirPath = dirPath;
        this.dirName = dirName;
    }
    public String pathToString(){
        return dirPath;
    }
    public Iterator<String> getDirPath(){
        List<String> auxList = new LinkedList<>();
        auxList.add(dirPath);
        return  auxList.iterator();
    }
    public Iterator<String> getAllFiles()throws Exception{
        try {
            Stream<Path> streamPath = Files.walk(Paths.get(dirPath));
            return  streamPath.filter(Files::isRegularFile).map(Path::toString).collect(Collectors.toList()).iterator();
        }catch (Exception e){
            throw  new Exception("path Error, path assigned to "+dirName+" is invalid");
        }
    }
    public Iterator<String> getEspeciFicfileType(String fileType) throws Exception{
         return getFiles(fileType).iterator();
    }
    public Iterator<String>getEspecificFileTypeWithRelativePah(String fileType) throws Exception {
        List<String> files = getFiles(fileType);
        files = formatToRelativePath(files);
        return files.iterator();
    }

    private List<String> formatToRelativePath(List<String>files) {
        int dirPathSize = dirPath.length();
        List<String> filesList = new LinkedList<>();
        for (String path: files
             ) {
            filesList.add(path.substring(dirPathSize+1));
        }
        return filesList;
    }

    private List<String> getFiles(String fileType) throws Exception {
        try {
            Stream<Path> streamPath = Files.walk(Paths.get(dirPath));
            return  streamPath.map(Path::toString).filter(x-> x.endsWith(fileType)).collect(Collectors.toList());
        }catch (Exception e){
            throw  new Exception("path Error, path assigned to "+dirName+" is invalid");
        }

    }
    public Iterator<String> getDirs()throws Exception{
        try{
            Stream<Path> streamPath = Files.walk(Paths.get(dirPath));
            List<String> dirs = streamPath.filter(Files::isDirectory).map(Path::toString).collect(Collectors.toList());
            return dirs.iterator();
        }catch (Exception e){
            throw  new Exception("path Error, path assigned to "+dirName+" is invalid");
        }

    }
}
