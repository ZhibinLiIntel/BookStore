package com.bookstore.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Register extends HttpServlet{
	/*public void init() throws ServletException{
		
	}*/
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out=response.getWriter();
		this.doPost(request, response);
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("gb2312");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","C##BOOKSTORE","123");
			String sql="insert into 消费者(账号,用户名,密码) values(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			int result=pstmt.executeUpdate();
			if(result==1)
				out.println("successful");
			else
				out.println("failed");
		}catch(Exception e){
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}
	public void destroy(){
		super.destroy();
	}
}
