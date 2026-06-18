package db;

import java.sql.Connection;
import java.sql.DriverManager;

/* This class
DBConnection.getConnection()
↓
Creates connection with MySQL
↓
Returns Connection object
*/

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://127.0.0.1:3306/inventory_db";

    private static final String USER = "root";

    private static final String PASSWORD = "Shobha";

    //Hide JDBC setup code from the rest of the application.
    //It's just a helper method created.
    public static Connection getConnection() throws Exception {

        //Class.forName() is used in Java to load classes from referenced libraries
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Loads the MySQL JDBC driver class into memory, which is in lib\.jar file
        //JDBC Driver is a translator between Java and Database, it can understand both java lang and MySQL protocol

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
        /*Actually contacts MySQL and creates the Connection object.
        DriverManger.getConnection()
        1. Finds the MySQL JDBC driver
        2. Contacts MySQL server at localhost:3306
        3. Checks username and password
        4. Creates a Connection object
        5. Returns that Connection object */
    }
}