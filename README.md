# JDBC Setup Guide

## Getting Started with JDBC

Follow these steps to set up JDBC for MySQL database connectivity in your Java project.

### Step 1: Add Maven Dependencies

Add the MySQL JDBC driver dependency to your `pom.xml` file:

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

### Step 2: Load the JDBC Driver

Create a class and load the MySQL JDBC driver using `Class.forName()`: 

```java
public class DatabaseConnection {
    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        }
    }
}
```

### Step 3: Establish a Database Connection

Use `DriverManager.getConnection()` to establish a connection:

```java
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Get database connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected to database successfully!");
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
```

### Step 4: Execute SQL Queries

Use the `Statement` interface to execute SQL queries:

```java
import java.sql.*;

public class DatabaseConnection {
    static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            // Create a statement
            statement = connection.createStatement();
            
            // Execute SELECT query
            String query = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }
            
            // Execute INSERT, UPDATE, or DELETE query
            String updateQuery = "INSERT INTO users (name, email) VALUES ('John', 'john@example.com')";
            int rowsAffected = statement.executeUpdate(updateQuery);
            System.out.println("Rows affected: " + rowsAffected);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
```

## Key Methods

- **Class.forName()** - Loads the JDBC driver
- **DriverManager.getConnection()** - Establishes a database connection
- **Connection.createStatement()** - Creates a Statement object
- **Statement.executeQuery()** - Executes SELECT queries, returns ResultSet
- **Statement.executeUpdate()** - Executes INSERT, UPDATE, DELETE queries
- **ResultSet** - Stores query results for iteration

## Best Practices

1. Always use try-catch blocks for error handling
2. Close resources in a `finally` block or use try-with-resources
3. Use `PreparedStatement` for dynamic queries to prevent SQL injection
4. Replace database credentials with environment variables in production
