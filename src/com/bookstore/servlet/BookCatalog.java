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
			rs=stmt.executeQuery("select * from ͼ��Ŀ¼");
			out.println("<html>"+"<head><title>ͼ��Ŀ¼</title></head>"+"<body>");
			out.println("<h3>ͼ��Ŀ¼</h3>");
			out.print("<table border=1>");
			out.print("<tr><th>��Ŀ���</th><th>��Ŀ���</th></tr>");
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
