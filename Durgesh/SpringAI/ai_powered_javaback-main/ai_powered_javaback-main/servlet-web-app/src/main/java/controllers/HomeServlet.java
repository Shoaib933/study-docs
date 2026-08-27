package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.Filter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeServlet", value = "/home-servlet")
public class HomeServlet extends HttpServlet {
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("home servlet executed...");
		// what type of content we are going to send
		resp.setContentType("text/html");

		// we will send the content :[we will write the content with PrintWriter]
		PrintWriter writer = resp.getWriter();
		writer.println("hey this is home servlet");

		for (int i = 1; i <= 5; i++) {
			writer.println("<h1>Welcome to home servlet</h1> " + new Date().toLocaleString());
		}
		// database connectivity
		// email code
		// sms code
		// pdf bhej

	}

}
