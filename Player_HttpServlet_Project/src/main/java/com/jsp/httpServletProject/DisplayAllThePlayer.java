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

@WebServlet("/display-all")
public class DisplayAllThePlayer extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//JDBC Logic
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ipl_playerdb?user=root&password=root");
			PreparedStatement pst = conn.prepareStatement("select * from players_db");
			
			ResultSet rs = pst.executeQuery();
			
			//Transferring the Result set to Display page
			req.setAttribute("players", rs);// What to display
			req.getRequestDispatcher("DisplayAllPlayers.jsp").forward(req, resp);//Where to Display
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
