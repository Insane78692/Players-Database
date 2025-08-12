package com.jsp.httpServletProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update-player")
public class SaveUpdatedPlayer extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String title =req.getParameter("title");
		int age = Integer.parseInt(req.getParameter("age"));
		String team =req.getParameter("team");
		String nationality =req.getParameter("nationality");
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ipl_playerdb?user=root&password=root");
			
			PreparedStatement pst = conn.prepareStatement("update ipl_playerdb.players_db set title=?, age=?, team=?, nationality=? where id=?");
			pst.setString(1, title);
			pst.setInt(2, age);
			pst.setString(3, team);
			pst.setString(4, nationality);
			pst.setInt(5, id);
			
			pst.executeUpdate();
			
			resp.sendRedirect("display-all");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (conn!=null) {
				try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		}
		
		
	}

}
