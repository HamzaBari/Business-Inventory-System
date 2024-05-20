package SQLConnection;

import java.sql.*;

/* This is a connection class which is going to be used for connecting to the SQL Database, This will open up a connection and then,
 you can save Data in the database.
 */
public class ConnectionClass {

    public Connection myConnection;

    //Method to connect to the Database
    public Connection connectDB() {

        String errorMsg = "The database has failed to connect";

        try {

            //JDBC Class
            Class.forName("com.mysql.jdbc.Driver");

            //Database Link
            myConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/businessinventorysystem", "root", "");

        } catch (Exception exp) {
            exp.printStackTrace();
            System.out.println(exp.getMessage() + " " + errorMsg);
        }

        return myConnection;

    }

}
