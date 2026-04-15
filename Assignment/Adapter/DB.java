// Target Interface
 interface SQLDatabase {
    void connectToSQL();
}

// Adaptee Interface
 interface NoSQLDatabase {
    void connectToNoSQL();
}

// Adaptee Implementation
class MongoDB implements NoSQLDatabase {
    @Override
    public void connectToNoSQL() {
        System.out.println("Connected to MongoDB (NoSQL) database.");
    }
}

// Adapter Class
 class SQLDatabaseAdapter implements SQLDatabase {
    private NoSQLDatabase noSQLDatabase;

    // Constructor to initialize the NoSQLDatabase instance
    public SQLDatabaseAdapter(NoSQLDatabase noSQLDatabase) {
        this.noSQLDatabase = noSQLDatabase;
    }

    // Overriding the connectToSQL method to bridge the gap
    @Override
    public void connectToSQL() {
        noSQLDatabase.connectToNoSQL();
    }
}


public class DB {
    public static void main(String[] args) {
           // Create an instance of MongoDB
        NoSQLDatabase mongoDB = new MongoDB();
        
        // Use the adapter to wrap the NoSQL instance into an SQL compatible interface
        SQLDatabase adapter = new SQLDatabaseAdapter(mongoDB);
        
        // Connect treating it as an SQL database
        adapter.connectToSQL();
    }
}
