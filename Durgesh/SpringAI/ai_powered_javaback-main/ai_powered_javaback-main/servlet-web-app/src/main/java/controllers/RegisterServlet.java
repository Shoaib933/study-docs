package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="RegisterServlet", value="/register-servlet")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// form pura yaha aa raha hoga...
		
		String name = req.getParameter("username");
		System.out.println("submitted name is "+name);
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("form submitted");
		writer.println("you have submitted your name "+name +", thankyou for showing interest in our website...");
		
	}

}
