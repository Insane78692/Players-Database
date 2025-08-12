package com.jsp.httpServletProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findbyid")
public class FindPlayerById extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ipl_playerdb?user=root&password=root");
			PreparedStatement pst = conn.prepareStatement("select * from ipl_playerdb.players_db where id=?");
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			//Transferring the ResultSet to the Display page
			
			req.setAttribute("player", rs);//What 
			req.getRequestDispatcher("UpdatePlayerById.jsp").forward(req, resp);//where
			
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
