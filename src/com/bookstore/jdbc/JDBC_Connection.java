package com.bookstore.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connection {
	static String drivername="oracle.jdbc.OracleDriver";
	static String url="jdbc:oracle:thin:@localhost:1521:orcl";
	static String username="C##BOOKSTORE";
	static String password="123";
	static{
		try{
			Class.forName(drivername);
			System.out.println("���������ɹ���");
		}catch(ClassNotFoundException e){
			System.out.println("��������ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection conn=null;
		try{
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("�������ݿ�ɹ���");
		}catch(SQLException e){
			System.out.println("�������ݿ�ʧ�ܣ�");
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args){
		JDBC_Connection.getConnection();
	}
}
