package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class AddDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
PrintWriter pw=null;
String title="";
try
{
pw=response.getWriter();
title=request.getParameter("title");
DesignationDTO designation=new DesignationDTO();
designation.setTitle(title);
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
designationDAO.add(designation);
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<center>");
pw.println("<title>");
pw.println("HR-Application");
pw.println("</title>");
pw.println("</center>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!--Main container start here-->");
pw.println("<div style='width:90hw;height:80vh;border:2px solid black'>");
pw.println("<!--Header start here-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:2px solid black'>");
pw.println("<img src='/styleone/images/logo.png' style='float:left'><div style='margin-top:10px;margin-bottom:10px;font-size:15pt'>SIDDHARTH VAJPAYEE</div>");
pw.println("</div><!--Header ends here-->");
pw.println("<!--Main content start here--->");
pw.println("<div style='margin:5px;width:90hw;height:60vh;border:2px solid black'>");
pw.println("<!--left pane starts-->");
pw.println("<div style='height:50vh;margin:5px;float:left;padding:5px;border:solid black'>");
pw.println("<a href='/styleone/designationsView'>Designations</a><br>");
pw.println("<a href='/styleone/employeesView'>Employees</a>");
pw.println("</div>");
pw.println("<!--left pane ends-->");
pw.println("<!--right pane starts-->");
pw.println("<div style='height:50vh;margin-left:110px;margin-right:5px;margin-top:5px;margin-bottom:5px;padding:5px;border:1px solid black;'>");
pw.println("<h3>Notification</h3>");
pw.println("Designation Added<br>Add more designations ?<br>");
pw.println("<table>");
pw.println("<tr>");
pw.println("<td>");
pw.println("<form action='/styleone/AddDesignation.html'>");
pw.println("<button type='submit'>Yes</button>");
pw.println("</form>");
pw.println("</td>");
pw.println("<td>");
pw.println("<form action='/styleone/designationsView'>");
pw.println("<button type='submit'>No</button>");
pw.println("</form>");
pw.println("</td>");
pw.println("</tr>");
pw.println("</table>");
pw.println("</div>");
pw.println("<!--right pane ends-->");
pw.println("</div><!--Main content ends here--->");
pw.println("<!--footer starts-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;text-align:center;border:2px solid black'>&copy SIDDHARTH VAJPAYEE</div>");
pw.println("<!--footer ends-->");
pw.println("</div><!--Main container ends here-->");
pw.println("</body>");
pw.println("</html>");
}catch(DAOException daoException)
{
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<center>");
pw.println("<title>");
pw.println("HR-Application");
pw.println("</title>");
pw.println("</center>");
pw.println("<script>");
pw.println("function validateForm(frm)");
pw.println("{");
pw.println("var title=frm.title.value.trim();");
pw.println("var titleErrorSection=document.getElementById('titleErrorSection');");
pw.println("titleErrorSection.innerHTML='';");
pw.println("if(title.length==0)");
pw.println("{");
pw.println("titleErrorSection.innerHTML='required';");
pw.println("frm.title.focus();");
pw.println("return false;");
pw.println("}");
pw.println("return true;");
pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!--Main container start here-->");
pw.println("<div style='width:90hw;height:80vh;border:2px solid black'>");
pw.println("<!--Header start here-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:2px solid black'>");
pw.println("<img src='/styleone/images/logo.png' style='float:left'><div style='margin-top:10px;margin-bottom:10px;font-size:15pt'>SIDDHARTH VAJPAYEE</div>");
pw.println("</div><!--Header ends here-->");
pw.println("<!--Main content start here--->");
pw.println("<div style='margin:5px;width:90hw;height:60vh;border:2px solid black'>");
pw.println("<!--left pane starts-->");
pw.println("<div style='height:50vh;margin:5px;float:left;padding:5px;border:solid black'>");
pw.println("<b>Designations</b><br>");
pw.println("<a href='/styleone/employeesView'>Employees</a><br><br>");
pw.println("<a href='/styleone/index.html'>Home</a>");
pw.println("</div>");
pw.println("<!--left pane ends-->");
pw.println("<!--right pane starts-->");
pw.println("<div style='height:50vh;margin-left:110px;margin-right:5px;margin-top:5px;margin-bottom:5px;padding:5px;border:1px solid black;'>");
pw.println("<div style='color:red'>"+daoException.getMessage()+"</div>");
pw.println("<h3>Designation (Add-module)</h3>");
pw.println("<form action='/styleone/addDesignation' onsubmit='return validateForm(this)'>Designation<input type='text' id='title' name='title' maxlength='35' size='36' value='"+title+"'>");
pw.println("<span id='titleErrorSection' style='color:red'></span><br>");
pw.println("<button type='submit'>Add</button>");
pw.println("</form>");
pw.println("</div>");
pw.println("<!--right pane ends-->");
pw.println("</div><!--Main content ends here--->");
pw.println("<!--footer start-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;text-align:center;border:2px solid black'>&copy SIDDHARTH VAJPAYEE</div>");
pw.println("<!--footer start-->");
pw.println("</div><!--Main container ends here-->");
pw.println("</body>");
pw.println("</html>");
}
catch(Exception exception)
{
System.out.println(exception);
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}
