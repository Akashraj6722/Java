package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtil {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	      
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/libraryList", "root", "root");

        return connection;
    }
	public static Connection getConnection2() throws ClassNotFoundException, SQLException {
	      
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/libraryList", "root", "root");

        return connection;
    }
	

	public static Connection getConnection3() throws ClassNotFoundException, SQLException {
	      
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/register", "root", "root");

       return connection;
   }
}
