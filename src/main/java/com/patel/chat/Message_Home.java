package com.patel.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Message_Home
 */
public class Message_Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Message_Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		ArrayList <String> names = new ArrayList<String>();
		names.add("Ram");
		names.add("Rahul");
		names.add("Jack");
		names.add("John");
		names.add("Rock");
		
		
		out.print("<!DOCTYPE html><html>");
		out.print("<head><title>Messages..</title><script type='text/javascript' src='js/script.js'></script>");
		
		//out.print("<script>");
	//	for(String str : names)
		//{
		//out.print("<input type='hidden' id='username' value='"+str+"' >");
	   // String str="Ram";
	//	out.print("connect();");
		
		//}
		//out.print("</script></head>");

		
		out.print("</head><body>");
		
		out.print("<form action='friend_messages'>");
		out.print("<input type='submit' value='Ram' id='username' name='username' >");out.print("<br>");
		out.print("<input type='submit' value='Rahul' id='username' name='username'  >");out.print("<br>");
		out.print("<input type='submit' value='Jack' id='username' name='username'  >");out.print("<br>");
		out.print("<input type='submit' value='John' id='username' name='username'  >");out.print("<br>");
		out.print("<input type='submit' value='Rock' id='username' name='username'  >");out.print("<br>");
		
		
		
		out.print("</body>");
//        out.print("<table><tr><td colspan='2'>");
//        out.print("<input type='text' id='username' placeholder='Username'/>");
//        out.print("<button type='button' onclick='connect();' >Connect</button>");
//        out.print("</td>");
//        out.print("</tr><tr><td>");
//        out.print("<textarea readonly='readonly' rows='10' cols='80' id='log'></textarea>");
//        out.print("</td></tr><tr><td>");
//        out.print("<input type='text' size='15' id='to' placeholder='To'/>");
//        out.print("<input type='text' size='51' id='msg' placeholder='Message'/>");
//        out.print("<button type='button' onclick='send();'>Send</button>");
//        out.print("</td></tr></table>");
        
        HttpSession session = request.getSession(false);
        
        
        
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
