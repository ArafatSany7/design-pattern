class DatabaseConnection {

    // Private constructor to prevent instantiation
    private DatabaseConnection() {
    }

    // Static inner helper class to hold the Singleton instance
    private static class ConnectionHolder {
        private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    }

    // Public method to provide access to the Singleton instance
    public static DatabaseConnection getInstance() {
        return ConnectionHolder.INSTANCE;
    }

    public void connect() {
        System.out.println("Database connected.");
    }
}

public class Database {
    public static void main(String[] args) {
        // Create the first instance of DatabaseConnection
        DatabaseConnection instance1 = DatabaseConnection.getInstance();

        // Create the second instance of DatabaseConnection
        DatabaseConnection instance2 = DatabaseConnection.getInstance();

        // Verify if both instances are the same
        System.out.println(instance1 == instance2);

        // Test the connect method
        instance1.connect();
    }
}
