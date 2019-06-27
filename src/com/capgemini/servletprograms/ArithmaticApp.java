package com.capgemini.servletprograms;
import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ArithmaticApp extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1=Integer.parseInt((req.getParameter("num1")));
		int num2=Integer.parseInt(req.getParameter("num2"));
		char symbol=req.getParameter("symbol").charAt(0);
		double answer=0;
				switch (symbol) {
				case '+':
					answer=num1+num2;
					break;
				case '-':
					answer=num1-num2;
					break;
				case '*':
					answer=num1*num2;
					break;
				case '/':
					answer=num1/num2;
					break;
				default:
					break;
				}
		PrintWriter out = resp.getWriter(); 
		out.write("<b> Welcome <b>");
		HttpSession session=req.getSession();
		session.setAttribute("answer",answer);
		RequestDispatcher rd1 = req.getRequestDispatcher("output.jsp");
		//req.setAttribute("name", userinfo);
		rd1.forward(req, resp);  
	}

}
