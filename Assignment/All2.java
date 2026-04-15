
import java.util.ArrayList;
import java.util.List;

// 1. ADAPTER PATTERN
interface SQLDatabase {

    void connectToSQL();
}

interface NoSQLDatabase {

    void connectToNoSQL();
}

class MongoDB implements NoSQLDatabase {

    @Override
    public void connectToNoSQL() {
        System.out.println("Connected to MongoDB (NoSQL Database)");
    }
}

class SQLDatabaseAdapter implements SQLDatabase {

    private NoSQLDatabase noSQLDatabase;

    public SQLDatabaseAdapter(NoSQLDatabase noSQLDatabase) {
        this.noSQLDatabase = noSQLDatabase;
    }

    @Override
    public void connectToSQL() {
        System.out.println("Logging: Connecting to SQL Database using NoSQL Adapter");
        noSQLDatabase.connectToNoSQL();
    }
}

// 2. COMPOSITE PATTERN
interface FileSystem {

    void showDetails();
}

class File implements FileSystem {

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

class Directory implements FileSystem {

    private List<FileSystem> contents = new ArrayList<>();

    public void add(FileSystem fileSystem) {
        contents.add(fileSystem);
    }

    public void remove(FileSystem fileSystem) {
        contents.remove(fileSystem);
    }

    public int getTotalItems() {
        int count = 0;
        for (FileSystem fs : contents) {
            count++;
            if (fs instanceof Directory) {
                count += ((Directory) fs).getTotalItems();
            }
        }
        return count;
    }

    @Override
    public void showDetails() {
        for (FileSystem fs : contents) {
            fs.showDetails();
        }
    }
}

// 3. DECORATOR PATTERN
interface WebPage {

    String render();
}

class BasicWebPage implements WebPage {

    @Override
    public String render() {
        return "Basic Web Page";
    }
}

abstract class WebPageDecorator implements WebPage {

    protected WebPage page;

    public WebPageDecorator(WebPage page) {
        this.page = page;
    }

    @Override
    public String render() {
        return page.render();
    }
}

class AuthenticatedWebPage extends WebPageDecorator {

    public AuthenticatedWebPage(WebPage page) {
        super(page);
    }

    @Override
    public String render() {
        return super.render() + " with Authentication";
    }
}

class AuthorizedWebPage extends WebPageDecorator {

    private String role;

    public AuthorizedWebPage(WebPage page, String role) {
        super(page);
        this.role = role;
    }

    @Override
    public String render() {
        if ("admin".equalsIgnoreCase(role) || "editor".equalsIgnoreCase(role)) {
            return super.render() + " with Authorization for role: " + role;
        } else {
            return "Access Denied";
        }
    }
}

public class All2 {

    public static void main(String[] args) {
        // --- Adapter Pattern Usage ---
        System.out.println("--- Adapter Pattern ---");
        NoSQLDatabase mongoDB = new MongoDB();
        SQLDatabase adapter = new SQLDatabaseAdapter(mongoDB);
        adapter.connectToSQL();

        // --- Composite Pattern Usage ---
        System.out.println("\n--- Composite Pattern ---");
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        Directory directory = new Directory();
        directory.add(file1);
        directory.add(file2);
        System.out.println("Total items in directory: " + directory.getTotalItems());
        directory.showDetails();

        // --- Decorator Pattern Usage ---
        System.out.println("\n--- Decorator Pattern ---");
        WebPage myPage = new BasicWebPage();
        myPage = new AuthenticatedWebPage(myPage);
        myPage = new AuthorizedWebPage(myPage, "admin");
        System.out.println(myPage.render());
    }
}
