package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AboutServlet", value = "/about-servlet")
public class AboutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("About servlet is processing your request...");
		resp.setContentType("text/html");
		PrintWriter writer= resp.getWriter();
		writer.print("Welcome to about page....");
	}

}
