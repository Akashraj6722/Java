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
		
		String readQuery="select bookID,bookName from bookList where lang='English'";
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
		
		String query = "insert into bookList (bookID,bookName,lang)values(?,?,?)";
		
		PreparedStatement prepare = connection.prepareStatement(query);
		prepare.setInt(1, lib.bookId);
		prepare.setString(2, lib.bookName);
		prepare.setString(3, lib.language);
		
		
		
		int rows = prepare.executeUpdate();
		
		System.out.println("Rows inserted : " + rows);
	}
	
	
	public static void update(Library lib) throws ClassNotFoundException, SQLException {
		
		Connection connection = ConnectUtil.getConnection();
		
		String updateQuery="update bookList set bookName=? where bookId=?";
		
		PreparedStatement pr=connection.prepareStatement(updateQuery);
		pr.setString(1, lib.bookName);
		pr.setInt(2, lib.bookId);
		
		
		int rows =pr.executeUpdate();
		
		System.out.println("Rows updated:"+rows);
		
		
	}
	public static void delete(Library lib) throws ClassNotFoundException, SQLException {

		Connection connection = ConnectUtil.getConnection();
		String deleteQuery="delete from bookList where bookID=?";
		
		PreparedStatement pr=connection.prepareStatement(deleteQuery);
		pr.setInt(1,lib.bookId);
		
         int rows =pr.executeUpdate();
		
		System.out.println("Rows deleted:"+rows);
		
	}
	
	public static void readSelect(Library lib) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectUtil.getConnection();
		
		String readQuery = "select bookName from bookList where bookID=?";
		
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

