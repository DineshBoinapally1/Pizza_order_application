package com.gvs.pizza;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RetrievingAllParams extends HttpServlet {

	 public void doPost(HttpServletRequest request,
	            HttpServletResponse response)
	            throws ServletException, IOException
	{
	        Enumeration paramNames = request.getParameterNames();
	        PrintWriter out = response.getWriter();
	        response.setContentType("text/html");
	 
	        out.print("<html><body>");
	        out.print("<h1> Your Order...</h1>");
	        out.println("<table border=\"1\" cellpadding = \"5\" +cellspacing = \"5\">");
	        out.println("<tr> <th>Parameter Name</th>" +"<th>Parameter Value</th></tr>");
	        while(paramNames.hasMoreElements())
	        {
	            String paramName = (String)paramNames.nextElement();
	            out.print("<tr><td>" + paramName + "\n<td>");
	            String[] paramValues = request.getParameterValues(paramName);
	            if (paramValues.length == 1)
	            {
	                String paramValue = paramValues[0];
	                if (paramValue.length() == 0)
	                    out.println("No Value");
	                else
	                    out.println(paramValue);
	            }
	            else
	            {
	                out.println("<ul>");
	                for(int i=0; i<paramValues.length; i++)
	                {
	                    out.println("<li>" + paramValues[i] + "</li>");
	                }
	                out.println("</ul>");
	            }
	        }
	    out.println("</table></body></html>");}
	}