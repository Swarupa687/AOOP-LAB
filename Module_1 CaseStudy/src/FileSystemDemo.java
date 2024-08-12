import java.util.ArrayList;
import java.util.List;

class FileSystemNode {
    protected String name;

    public FileSystemNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class File extends FileSystemNode {
    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

class Directory extends FileSystemNode {
    private List<FileSystemNode> children;

    public Directory(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    public void addChild(FileSystemNode node) {
        children.add(node);
    }

    public void listChildren() {
        for (FileSystemNode child : children) {
            System.out.println(child.getName() + " - " + (child instanceof Directory ? "Directory" : "File"));
        }
    }
}

// Example usage
public class FileSystemDemo {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory dir1 = new Directory("dir1");
        File file1 = new File("file1", 100);
        File file2 = new File("file2", 200);

        root.addChild(dir1);
        root.addChild(file1);
        dir1.addChild(file2);

        // Listing the contents of the root directory
        System.out.println("Contents of root:");
        root.listChildren();
        // Output:
        // dir1 - Directory
        // file1 - File

        // Listing the contents of dir1
        System.out.println("Contents of dir1:");
        dir1.listChildren();
        // Output:
        // file2 - File
    }
}
