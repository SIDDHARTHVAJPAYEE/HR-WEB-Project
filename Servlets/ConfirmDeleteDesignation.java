package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class ConfirmDeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
int code=0;
try
{
code=Integer.parseInt(request.getParameter("code"));
}catch(NumberFormatException numberFormatException)
{
sendBackView(response);
return;
}
DesignationDAO designationDAO=new DesignationDAO();
try
{
DesignationDTO designation=designationDAO.getByCode(code);
PrintWriter pw=response.getWriter();
response.setContentType("text/html");

pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<center>");
pw.println("<title>");
pw.println("HR-Application");
pw.println("</title>");
pw.println("</center>");
pw.println("<script>");
pw.println("function cancelDeletion()");
pw.println("{");
pw.println("document.getElementById('cancelDeletion').submit();");
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
pw.println("<h3>Designation (Delete-module)</h3>");
pw.println("<form method='post' action='/styleone/deleteDesignation'>");
pw.println("Designation : ");
pw.println("<b>"+designation.getTitle()+"</b><br><br>");
pw.println("Are You sure you want to delete this designation ?<br><br>");
pw.println("<input type='hidden' id='code' name='code' value='"+code+"'>");
pw.println("<button type='submit'>Yes</button>");
pw.println("<button type='Button' onclick='cancelDeletion()'>No</button>");
pw.println("</form>");
pw.println("</div>");
pw.println("<!--right pane ends-->");
pw.println("</div><!--Main content ends here--->");
pw.println("<!--footer start-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;text-align:center;border:2px solid black'>&copy SIDDHARTH VAJPAYEE</div>");
pw.println("<!--footer start-->");
pw.println("</div><!--Main container ends here-->");
pw.println("<form id='cancelDeletion' action='/styleone/designationsView'></form>");
pw.println("</body>");
pw.println("</html>");
}catch(DAOException daoException)
{
sendBackView(response);
return;
}
}catch(Exception exception)
{
System.out.println(exception.getMessage());
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}

private void sendBackView(HttpServletResponse response)
{
try
{
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
List<DesignationDTO> designations;
designations=designationDAO.getAll();
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<title>HR-Application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!--Main container start here-->");
pw.println("<div style='width:90hw;height:80vh;border:2px solid black'>");
pw.println("<!--Header start here-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:2px solid black'>");
pw.println("<a href='/styleone/index.html'><img src='/styleone/images/logo.png'</a> style='float:left'><div style='margin-top:10px;margin-bottom:10px;font-size:15pt'>SIDDHARTH VAJPAYEE</div>");
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
pw.println("<div style='height:50vh;margin-left:110px;margin-right:5px;margin-top:5px;margin-bottom:5px;padding:5px;border:1px solid black;overflow:scroll'>");
pw.println("<h2>Designations</h2>");
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th colspan='4' style='text-align:right;padding:5px'>");
pw.println("<a href='/styleone/AddDesignation.html'>Add new Designation</a>");
pw.println("</th>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<th style='width:30px'>S.No.</th>");
pw.println("<th style='width:200px'>Designation</th>");
pw.println("<th style='width:100px'>Edit</th>");
pw.println("<th style='width:100px'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");
int x;
DesignationDTO designationDTO;
int sno=0;
int code;
String title;
for(x=0;x<designations.size();x++)
{
sno++;
designationDTO=designations.get(x);
code=designationDTO.getCode();
title=designationDTO.getTitle();
pw.println("<tr>");
pw.println("<td style='text-align:right'>"+sno+".</td>");
pw.println("<td style='text-align:center'>"+title+"</td>");
pw.println("<td style='text-align:center'><a href='/styleone/editDesignation?code="+code+"'>Edit</a></td>");
pw.println("<td style='text-align:center'><a href='/styleone/confirmDeleteDesignation?code="+code+"'>Delete</a></td>");
pw.println("</tr>");
}
pw.println("</tbody>");
pw.println("</table>");
pw.println("<!--right pane ends-->");
pw.println("</div><!--Main content ends here--->");
pw.println("<!--footer start-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;text-align:center;border:2px solid black'>&copy SIDDHARTH VAJPAYEE</div>");
pw.println("<!--footer start-->");
pw.println("</div><!--Main container ends here-->");
pw.println("</body>");
pw.println("</html>");
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
catch(Exception exception)
{
System.out.println(exception.getMessage());
}
}
}