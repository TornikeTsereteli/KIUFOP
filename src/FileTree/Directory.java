package FileTree;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Directory extends File {

    private final List<File> files;

    public Directory(Path path, List<File> files) {
        super(path);
        this.files = files;
    }

    @Override
    public Iterator<File> iterator() {
        // TODO
        return toList(this).iterator();
    }


    private static List<File> toList(File file){
        LinkedList<File> list  = new LinkedList<>();
        switch (file){
            case RegularFile regularFile ->{
                list.add(regularFile);
                return list;
            }
            case Directory dir -> {
                list.add(dir);
                for(File childFile : dir.files){
                    list.addAll(toList(childFile));
                }
                return list;
            }
            default -> throw new IllegalStateException("Unexpected value: " + file);
        }
    }

    @Override
    public int getHeight() {
//        int max = Integer.MIN_VALUE;
//        for(File file: files){
//            max = Math.max(max, file.getHeight());
//        }
//        return max + 1;

        // with streams
        return files.stream().max((x,y)->Integer.compare(x.getHeight(),y.getHeight())).get().getHeight() + 1;
    }

    @Override
    public boolean isRegularFile() {
        return false;
    }

    public List<File> getFiles() {
        return files;
    }

}
