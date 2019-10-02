import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoryManager {
    private static DirectoryManager directoryManager = new DirectoryManager();

    public Iterator<String> getAllFiles(String dirPath)throws InvalidPathException{
        try {
            Stream<Path> streamPath = Files.walk(Paths.get(dirPath));
            return  streamPath.filter(Files::isRegularFile).map(Path::toString).collect(Collectors.toList()).iterator();
        }catch (Exception e){
            throw  new InvalidPathException("The path does not exist","bad path param for getAllFiles method on DirectoryManger");
        }
    }

    public Iterator<String> getDirs(String dirPath)throws InvalidPathException{
        try{
            Stream<Path> streamPath = Files.walk(Paths.get(dirPath));
            List<String> dirs = streamPath.filter(Files::isDirectory).map(Path::toString).collect(Collectors.toList());
            return dirs.iterator();
        }catch (Exception e){
            throw  new InvalidPathException("The path does not exist","bad path param for getDirs method on DirectoryManger");
        }
    }

    public Iterator<String> getSpecificFileTypeWithAbsolutePath(String fileType, String dirPath) throws InvalidPathException{
        try {
            return getFiles(fileType, dirPath).iterator();
        }catch (Exception e){
            throw  new InvalidPathException("The path does not exist","bad path param for getSpecificFileTypeWithAbsolutePath method on DirectoryManger");
        }
    }
    private List<String> getFiles(String fileType,String dirPath) throws Exception {
        Stream<Path> streamPath = Files.walk(Paths.get(dirPath));
        return  streamPath.map(Path::toString).filter(x-> x.endsWith(fileType)).collect(Collectors.toList());
    }

    public Iterator<String>getSpecificFileTypeWithRelativePah(String fileType,String dirPath) throws InvalidPathException {
        try {
            List<String> files = getFiles(fileType,dirPath);
            files = formatToRelativePath(files,dirPath);
            return files.iterator();
        }catch (Exception e){
            throw  new InvalidPathException("The path does not exist","bad path param for getSpecificFileTypeWithRelativePath method on DirectoryManger");
        }

    }
    private List<String> formatToRelativePath(List<String>files,String dirPath) {
        int dirPathSize = dirPath.length();
        List<String> filesList = new LinkedList<>();
        for (String path: files
        ) {
            filesList.add(path.substring(dirPathSize+1));
        }
        return filesList;
    }
    
    public static DirectoryManager getInstance(){
        return directoryManager;
    }
}
