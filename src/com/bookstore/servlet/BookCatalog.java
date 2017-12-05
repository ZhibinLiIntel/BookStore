package com.bookstore.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class BookCatalog extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("gb2312");
		PrintWriter out=response.getWriter();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","C##BOOKSTORE","123");
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from 图书目录");
			out.println("<html>"+"<head><title>图书目录</title></head>"+"<body>");
			out.println("<h3>图书目录</h3>");
			out.print("<table border=1>");
			out.print("<tr><th>书目编号</th><th>书目类别</th></tr>");
			while(rs.next()){
				out.println("<tr><td>"+rs.getString(1)+"</td>"+"<td>"+rs.getString(2)+"</td>"+"</tr>");				
			}
			out.print("</table");
			out.print("</body></html>");
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
