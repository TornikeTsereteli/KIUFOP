package FileTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileUtil {

    public static File toFileRepresentation(Path path){
        if (Files.isRegularFile(path)){
            return new RegularFile(path);
        }
        try {
            List<File> childs = Files.list(path).map(x -> toFileRepresentation(x)).toList();
            return new Directory(path,childs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
