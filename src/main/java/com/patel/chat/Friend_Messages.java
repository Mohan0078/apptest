package com.patel.chat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Friend_Messages
 */
public class Friend_Messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Friend_Messages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String friend_Name = request.getParameter("username");
		
		out.print("<!DOCTYPE html><html>");
		out.print("<head><title>Messages..</title><script type='text/javascript' src='js/script.js'></script></head>");
		out.print("<body>");
		
		
		// setting the friend name at the top 
		out.print("<h3>"+friend_Name+"</h3>");
		
		out.print("<input type='hidden' value='"+friend_Name+"' id='to'>");
		
        out.print("<table><tr><td colspan='2'>");
//        out.print("<input type='text' id='username' placeholder='Username'/>");
  //      out.print("<button type='button' onclick='connect();' >Connect</button>");
        out.print("</td>");
        out.print("</tr><tr><td>");
        out.print("<textarea readonly='readonly' rows='10' cols='80' id='log'></textarea>");
        out.print("</td></tr><tr><td>");
       // out.print("<input type='text' size='15' id='to' placeholder='To'/>");
        out.print("<input type='text' size='51' id='msg' placeholder='Message'/>");
        out.print("<button type='button' onclick='send();'>Send</button>");
        out.print("</td></tr></table>");
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
