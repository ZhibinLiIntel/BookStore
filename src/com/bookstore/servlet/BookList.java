package com.bookstore.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class BookList extends HttpServlet{
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
			rs=stmt.executeQuery("select * from 图书");
			out.println("<html>"+"<head><title>图书信息</title></head>"+"<body>");
			out.println("<h3>图书信息</h3>");
			out.print("<table border=1>");
			out.print("<tr><th>图书编号</th><th>图书名称</th><th>作者</th><th>价格</th><th>库存</th></tr>");
			while(rs.next()){
				out.println("<tr><td>"+rs.getString(1)+"</td>"+"<td>"+rs.getString(3)+"</td>"+"<td>"+rs.getString(4)+"</td>"+"<td>"+rs.getString(5)+"</td>"+"<td>"+rs.getString(6)+"</td>"+"</tr>");				
			}
			out.print("</table");
			out.print("</body></html>");
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
