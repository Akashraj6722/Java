package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import model.Library;


public class bookRecords {
	
	
	public static void update(Library lib) throws ClassNotFoundException, SQLException {
		
		Connection connection=ConnectUtil.getConnection();
		
		String insertQuery="update register set bookName=?,bookID=?,registeredDate=?,dueDate=? where userName=?";
		PreparedStatement prepare=connection.prepareStatement(insertQuery);
		
		prepare.setString(1, lib.bookName);
		prepare.setInt(2, lib.bookId);
		prepare.setString(3, lib.date);
		prepare.setString(4, lib.dueDate);
		prepare.setString(5, lib.userName);

		
       int rows=prepare.executeUpdate();
       
       System.out.println("Book registered :"+rows);
		
		
	}
	
	public static void read() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectUtil.getConnection();
		
		String readQuery = "select userName,bookID,registeredDate,dueDate from register where User_or_Admin=User";
		
		PreparedStatement prepareStatement = connection.prepareStatement(readQuery);
		
		ResultSet rs = prepareStatement.executeQuery(); 
		
		ResultSetMetaData metaData = rs.getMetaData();
		
		int columnCount = metaData.getColumnCount();
		
		for(int i=1; i<=columnCount; i+=1)
		{
			System.out.print(metaData.getColumnName(i) + "\t\t");
		}
		System.out.println();
		
		while(rs.next())
		{
			for(int i=1; i<=2; i+=1)
			{
				System.out.print(rs.getString(i) + "\t\t\t");
			}
			
			for(int i=3; i<=columnCount; i+=1)
			{
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println();
		}
	}

}
