import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Lecture")
public class Lecture extends HttpServlet{
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String login = (String) session.getAttribute("login");
        Boolean presence = (Boolean) session.getAttribute("presence");
        Boolean admin = (Boolean) session.getAttribute("admin");
        ResultSet rs;
    

        if(presence){
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<!doctype html>");
        out.println("<html><head><title>servlet Test</title><style>");
        out.println("th{ color: white; background-color: grey;}table, th, td{border: solid;border-color: black;}tr:nth-child(2n){background-color: lightgray;}tr:hover{background-color: lightgreen;}table, form{margin: 1%;}form{text-align: center;}");
        out.println("</style></head><body>");


        try (Connection con = DS.getConnection()) {
            Statement stmt = con.createStatement();  
            if(admin){
            rs = stmt.executeQuery("select * from personne");
            }else{
            rs = stmt.executeQuery("select * from personne where login='"+ login +"' ");
            }


            out.println("<table>");
            while (rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                for(int i = 1; i <= rsmd.getColumnCount(); i++){
                    out.println("<th>" + rsmd.getColumnName(i) + "</th>");
                }
                while(rs.next()){
                    out.println("<tr>");
                    out.println("<td>" + rs.getString(1) + "</td>");
                    out.println("<td>" + rs.getString(2) + "</td>");
                    out.println("<td>" + rs.getString(3) + "</td>");
                    out.println("<td>" + rs.getString(4) + "</td>");
                    out.println("<td>" + rs.getString(5) + "</td>");
                    out.println("<td>" + rs.getString(6) + "</td>");
                    out.println("<td>" + rs.getString(7) + "</td>");
                    out.println("<td>" + rs.getString(8) + "</td>");
                    out.println("<td>" + rs.getString(9) + "</td>");

                    out.println("</tr>");
                }
                out.println("</table");
            }
            
        } catch (SQLException e) {
            out.println("</table>");
            out.println("<p>" + e.getMessage() + "</p>");
        }


        out.println("</body></html>");

        }else{
            session.invalidate();
            res.sendRedirect("./login.html");
        }

    }
}
