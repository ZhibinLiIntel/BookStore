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
			ResultSet rs=stmt.executeQuery("select * from ͼ��");
			while(rs.next()){
				System.out.println(rs.getString("ͼ������"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
