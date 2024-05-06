package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import model.Library;

public class Register {
	
	
	public static void register(Library lib) throws ClassNotFoundException, SQLException {
		
		Connection connection3 = ConnectUtil.getConnection3();
		
		String regQuery="insert into register values(?,?,?)";
		
		PreparedStatement prepare=connection3.prepareStatement(regQuery);
		
		prepare.setString(1,lib.userName);
		prepare.setString(2, lib.pass);
		prepare.setString(3, lib.phone);
		int rows =prepare.executeUpdate();
		
		System.out.println("Registered user:"+rows);
		
		
	}
	
	public static  boolean login(Library lib) throws ClassNotFoundException, SQLException {
		
		Connection connection4= ConnectUtil.getConnection3();
		
		String checkQuery="Select userName,pass from register where userName=? and pass=?";
		
		
		PreparedStatement prepare=connection4.prepareStatement(checkQuery);
		prepare.setString(1,lib.getUserName());
		prepare.setString(2,lib.getPassW());
	
		ResultSet rs= prepare.executeQuery();
			
		if(rs.next()) {
			
//			System.out.println("login");

			
			return true;
	
		}
		
			
		return false;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		register();
		
	}

}
