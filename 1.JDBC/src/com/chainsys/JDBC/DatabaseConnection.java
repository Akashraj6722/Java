package com.chainsys.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class DatabaseConnection {
	
	public static void read() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		System.out.println(connection);
		
		String readQuery = "select * from list";
		
		PreparedStatement prepareStatement = connection.prepareStatement(readQuery);
		
		ResultSet rs = prepareStatement.executeQuery();
		
		ResultSetMetaData metaData = rs.getMetaData();
		
		int columnCount = metaData.getColumnCount();
		
		for(int i=1; i<=columnCount; i+=1)
		{
			System.out.print(metaData.getColumnName(i) + "\t");
		}
		System.out.println();
		
		while(rs.next())
		{
			for(int i=1; i<=columnCount; i+=1)
			{
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println();
		}
	}
	
	public static void insert(Library lib) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();

		
		String insertQuery = "insert into listsT (bookId,bookName)values(?, ?)";
		
		PreparedStatement prepare = connection.prepareStatement(insertQuery);
		prepare.setInt(1, lib.bkId);
		prepare.setString(2, lib.bookName);
		
		
		
		int rows = prepare.executeUpdate();
		
		System.out.println("Rows Affected : " + rows);
	}
	
	public static void update() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String UpdateQuery = "update list set bookName='chorlette witch' where bookId='2'";
		
		PreparedStatement prepare = connection.prepareStatement(UpdateQuery);
		
		int rows = prepare.executeUpdate();
		
		System.out.println("Rows updated : " + rows);
	}
	
	public static void delete() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String deleteQuery = "delete from list where bookId='10'";
		
		PreparedStatement prepare = connection.prepareStatement(deleteQuery);
		
		int rows = prepare.executeUpdate();
		
		System.out.println("Rows deleted : " + rows);
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Library lib=new Library();
		
		
//		update();
//		delete();
		read();
		
	}
	
	
	

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	      
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/libraryT", "root", "root");

        return connection;
    }

}
