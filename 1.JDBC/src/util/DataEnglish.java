package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import model.Library;

public class DataEnglish  {
	
	
	public static void read() throws ClassNotFoundException, SQLException  {
		

		Connection connection = ConnectUtil.getConnection();
		
		String readQuery="select * from listEnglish";
		PreparedStatement prepare=connection.prepareStatement(readQuery);
		
		ResultSet rs=prepare.executeQuery();
	    ResultSetMetaData metaData=rs.getMetaData();
		
		int columnCount=metaData.getColumnCount();
		
		for(int i=1;i<=columnCount;i++) {
			
			System.out.print(metaData.getColumnName(i)+"\t");
		}
		System.out.println();
		
		
		while(rs.next()) {
			
			for(int i=1;i<=columnCount;i++) {
				
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
		
	}
	
	
	
	
	public static void insert(Library lib) throws ClassNotFoundException, SQLException {

		Connection connection = ConnectUtil.getConnection();
		
		String query = "insert into listEnglish (bookId,bookName)values(?, ?)";
		
		PreparedStatement prepare = connection.prepareStatement(query);
		prepare.setInt(1, lib.bookId);
		prepare.setString(2, lib.bookName);
		
		
		
		int rows = prepare.executeUpdate();
		
		System.out.println("Rows inserted : " + rows);
	}
	
	
	public static void update(Library lib) throws ClassNotFoundException, SQLException {
		
		Connection connection = ConnectUtil.getConnection();
		
		String updateQuery="update listEnglish set bookName=? where bookId=?";
		
		PreparedStatement pr=connection.prepareStatement(updateQuery);
		pr.setString(1, lib.bookName);
		pr.setInt(2, lib.bookId);
		
		
		int rows =pr.executeUpdate();
		
		System.out.println("Rows updated:"+rows);
		
		
	}
	public static void delete(Library lib) throws ClassNotFoundException, SQLException {

		Connection connection = ConnectUtil.getConnection();
		String deleteQuery="delete from listEnglish where bookID=?";
		
		PreparedStatement pr=connection.prepareStatement(deleteQuery);
		pr.setInt(1,lib.bookId);
		
         int rows =pr.executeUpdate();
		
		System.out.println("Rows deleted:"+rows);
		
	}
	
	public static void readSelect(Library lib) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectUtil.getConnection();
		
		String readQuery = "select bookname from listEnglish where bookID=?";
		
		PreparedStatement prepareStatement = connection.prepareStatement(readQuery);
		
		prepareStatement.setInt(1, lib.getBookId());
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
	
	
	
	
	

}

