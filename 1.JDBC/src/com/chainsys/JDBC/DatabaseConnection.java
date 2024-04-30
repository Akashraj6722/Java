package com.chainsys.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class DatabaseConnection {
	
	public static void read() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		System.out.println(connection);
		
		String query = "select * from list";
		
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		
		ResultSet rows = prepareStatement.executeQuery();
		
		ResultSetMetaData metaData = rows.getMetaData();
		
		int columnCount = metaData.getColumnCount();
		
		for(int i=1; i<=columnCount; i+=1)
		{
			System.out.print(metaData.getColumnName(i) + "\t");
		}
		System.out.println();
		
		while(rows.next())
		{
			for(int i=1; i<=columnCount; i+=1)
			{
				System.out.print(rows.getString(i) + "\t");
			}
			System.out.println();
		}
	}
	
	public static void insert() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "insert into list values(11, 'GOT')";
		
		PreparedStatement prepare = connection.prepareStatement(query);
		
		int rows = prepare.executeUpdate();
		
		System.out.println("Rows Affected : " + rows);
	}
	
	public static void update() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "update list set bookName='chorlette witch' where bookId='2'";
		
		PreparedStatement prepare = connection.prepareStatement(query);
		
		int rows = prepare.executeUpdate();
		
		System.out.println("Rows updated : " + rows);
	}
	
	public static void delete() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "delete from list where bookId='10'";
		
		PreparedStatement prepare = connection.prepareStatement(query);
		
		int rows = prepare.executeUpdate();
		
		System.out.println("Rows deleted : " + rows);
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		insert();
		update();
		delete();
		
	}
	
	
	

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	      
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/library", "root", "root");

        return connection;
    }
}
