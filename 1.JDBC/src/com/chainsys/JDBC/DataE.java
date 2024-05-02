package com.chainsys.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class DataE {
	
	
	
	
	public static void read() throws SQLException, ClassNotFoundException {
		
		Connection connection=getConnection();
		
		String readQuery="select * from listsE";
		PreparedStatement prepare=connection.prepareStatement(readQuery);
		
		ResultSet rs=prepare.executeQuery();
		
		ResultSetMetaData metaData=rs.getMetaData();
		
		int columnCount=metaData.getColumnCount();
		
		for(int i=1;i<=columnCount;i++) {
			
			System.out.println(metaData.getColumnName(i));
		}
		System.out.println();
		
		
		while(rs.next()) {
			
			for(int i=0;i<=columnCount;i++) {
				
				System.out.println(rs.getString(i));
			}
			System.out.println();
		}
		
	}
	
	
	
	
	public static void insert(Library lib) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "insert into listsE (bookId,bookName)values(?, ?)";
		
		PreparedStatement prepare = connection.prepareStatement(query);
		prepare.setInt(1, lib.bkId);
		prepare.setString(2, lib.bookName);
		
		
		
		int rows = prepare.executeUpdate();
		
		System.out.println("Rows Affected : " + rows);
	}
	
	
	public static void update() throws ClassNotFoundException, SQLException {
		
		Connection connect =getConnection();
		
		String updateQuery="update listsE set bookName=? where bookId=?";
		
		PreparedStatement pr=connect.prepareStatement(updateQuery);
		
		int rows =pr.executeUpdate();
		
		System.out.println("Rows affected"+rows);
		
		
	}
	
	
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	      
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/libraryE", "root", "root");

        return connection;
    }

}
