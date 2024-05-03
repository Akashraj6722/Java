package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import model.Library;
import dao.Librarian;

public class DataTamil {
	
	public static void read() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectUtil.getConnection();
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
		Connection connection = ConnectUtil.getConnection();
		
		String insertQuery = "insert into listTamil (bookId,bookName)values(?, ?)";
		
		PreparedStatement prepare = connection.prepareStatement(insertQuery);
		prepare.setInt(1, lib.bkId);
		prepare.setString(2, lib.bookName);
		
		
		
		int rows = prepare.executeUpdate();
		
		System.out.println("Rows inserted : " + rows);
	}
	
	public static void update(Library lib) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectUtil.getConnection();		
		String UpdateQuery = "update listTamil  set bookName=? where bookId=?";
		
		PreparedStatement prepare = connection.prepareStatement(UpdateQuery);
		prepare.setString(1, lib.bookName);
		prepare.setInt(2, lib.bkId);
		
		int rows = prepare.executeUpdate();
		
		System.out.println("Rows updated : " + rows);
	}
	
	public static void delete(Library lib) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectUtil.getConnection();		
		String deleteQuery = "delete from listTamil where bookId=?";
		
		PreparedStatement prepare = connection.prepareStatement(deleteQuery);
		prepare.setInt(1, lib.bkId);
		
		int rows = prepare.executeUpdate();
		
		System.out.println("Rows deleted : " + rows);
	}
	
	
	
	
	

	
}

