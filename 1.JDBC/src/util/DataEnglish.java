package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import model.Library;

public class DataEnglish  {
	
	
	public static void read() throws ClassNotFoundException, SQLException  {
		

		Connection connection1 = ConnectUtil.getConnection2();
		
		String readQuery="select * from listEnglish";
		PreparedStatement prepare=connection1.prepareStatement(readQuery);
		
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

		Connection connection1 = ConnectUtil.getConnection2();
		
		String query = "insert into listEnglish (bookId,bookName)values(?, ?)";
		
		PreparedStatement prepare = connection1.prepareStatement(query);
		prepare.setInt(1, lib.bkId);
		prepare.setString(2, lib.bookName);
		
		
		
		int rows = prepare.executeUpdate();
		
		System.out.println("Rows inserted : " + rows);
	}
	
	
	public static void update(Library lib) throws ClassNotFoundException, SQLException {
		
		Connection connection1 = ConnectUtil.getConnection2();
		
		String updateQuery="update listEnglish set bookName=? where bookId=?";
		
		PreparedStatement pr=connection1.prepareStatement(updateQuery);
		pr.setString(1, lib.bookName);
		pr.setInt(2, lib.bkId);
		
		
		int rows =pr.executeUpdate();
		
		System.out.println("Rows updated:"+rows);
		
		
	}
	public static void delete(Library lib) throws ClassNotFoundException, SQLException {

		Connection connection1 = ConnectUtil.getConnection2();
		String deleteQuery="delete from listEnglish where bookID=?";
		
		PreparedStatement pr=connection1.prepareStatement(deleteQuery);
		pr.setInt(1,lib.bkId);
		
         int rows =pr.executeUpdate();
		
		System.out.println("Rows deleted:"+rows);
		
		
		
	}
	
	
	
	
	

}

