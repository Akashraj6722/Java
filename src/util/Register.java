package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import model.Library;

public class Register {
	
	
	public static void register(Library lib) throws ClassNotFoundException, SQLException {
		Scanner input=new Scanner(System.in);
		String regex3="[6789]{1}[0-9]{9}";

		Connection connection = ConnectUtil.getConnection();
		while(true) {
			try {
				String regQuery="insert into register(userName,pass,phone,User_or_Admin) values(?,?,?,?)";
				
				PreparedStatement prepare=connection.prepareStatement(regQuery);
				
				prepare.setString(1,lib.userName);
				prepare.setString(2, lib.pass);
				prepare.setString(3, lib.phone);
				prepare.setString(4, lib.Type);
				int rows =prepare.executeUpdate();
				
				System.out.println("Registered user:"+rows);
				break;
				}catch(SQLIntegrityConstraintViolationException e) {
					System.out.println(e);
					System.out.println("Enter correct phone number");
					String phone=input.next();
					while(!phone.matches(regex3)) {
						System.err.println("Enter the  VALID MOBILE number:");
						phone=input.next();
					}
					lib.setPhone(phone);
				
					input.nextLine();
				}
			
		}
		
		
	}
	
	public static  boolean login(Library lib) throws ClassNotFoundException, SQLException {
		
		Connection connection= ConnectUtil.getConnection();
		
		String checkQuery="Select userName,pass,User_or_Admin from register where userName=? and pass=? and User_or_Admin=?";
		
		
		PreparedStatement prepare=connection.prepareStatement(checkQuery);
		prepare.setString(1,lib.getUserName());
		prepare.setString(2,lib.getPassW());
		prepare.setString(3, lib.getType());
	
		ResultSet rs= prepare.executeQuery();
			
		if(rs.next()) {
			

			return true;
	
		}
		
			
		return false;
	}
	


}
