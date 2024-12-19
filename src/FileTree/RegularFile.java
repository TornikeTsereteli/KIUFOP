package FileTree;



import java.nio.file.Path;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RegularFile extends File {

    public RegularFile(Path path) {
        super(path);
    }

    @Override
    public Iterator<File> iterator() {
        return new RegularFileIterator(this);
    }

    static class RegularFileIterator implements Iterator<File>{
        private File file;
        public boolean hasCalled = false;

        public RegularFileIterator(File file){
            this.file = file;
        }
        @Override
        public boolean hasNext() {
            return !hasCalled;
        }

        @Override
        public File next() {
            if(hasNext()){
                hasCalled = true;
                return file;
            }
            throw new NoSuchElementException("no next element exists");
        }
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public boolean isRegularFile() {
        return true;
    }

}
