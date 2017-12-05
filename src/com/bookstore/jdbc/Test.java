package com.bookstore.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args){
		try{
			Connection conn=JDBC_Connection.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Õº È");
			while(rs.next()){
				System.out.println(rs.getString("Õº È√˚≥∆"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
