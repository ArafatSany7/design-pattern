
import java.util.ArrayList;
import java.util.List;

// Component Interface
interface FileSystem {

    void showDetails();
}

// Leaf Class
class File implements FileSystem {

    private String name;

    public File(String name) {
        this.name = name;
    }

    // Overriding showDetails to print the file name
    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

// Composite Class
class Directory implements FileSystem {

    private List<FileSystem> contents = new ArrayList<>();

    // Add a FileSystem object (File or Directory) to the contents list
    public void add(FileSystem component) {
        contents.add(component);
    }

    // Remove a FileSystem object from the contents list
    public void remove(FileSystem component) {
        contents.remove(component);
    }

    // Iterate through the contents list and call showDetails on each
    @Override
    public void showDetails() {
        for (FileSystem component : contents) {
            component.showDetails();
        }
    }
}

// Main execution
public class Files {

    public static void main(String[] args) {
        // Create instances of File
        File file1 = new File("File1.txt");
        File file2 = new File("File2.txt");

        // Create instances of Directory
        Directory directory1 = new Directory();
        Directory directory2 = new Directory();

        // Add files to the first directory
        directory1.add(file1);
        directory1.add(file2);

        // Add the first directory to the second directory
        directory2.add(directory1);

        // Display details of the first directory
        System.out.println("--- Directory 1 Contents ---");
        directory1.showDetails();
        // Output expected: Details of File1.txt and File2.txt

        // Display details of the second directory
        System.out.println("\n--- Directory 2 Contents ---");
        directory2.showDetails();
        // Output expected: Details of Directory 1's contents (File1.txt and File2.txt)
    }
}
