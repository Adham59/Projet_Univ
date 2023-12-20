import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/JoueurDisponibles")
public class JoueurDisponibles extends HttpServlet {

 
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String postes = req.getParameter("postes");
    HttpSession session = req.getSession(true);
    session;

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("<!doctype html>");
    out.println("<html><head><title>servlet Test</title><style>");
    out.println("th{ color: white; background-color: grey;}table, th, td{border: solid;border-color: black;}tr:nth-child(2n){background-color: lightgray;}tr:hover{background-color: lightgreen;}table, form{margin: 1%;}form{text-align: center;}");
    out.println("</style></head><body>");

            try(Connection c = DS.getConnection()){
                Statement stmt = c.createStatement();
                ResultSet rs;

            if(postes == null){
                rs = stmt.executeQuery("select * from joueurs where poste='ATT' ");
                }else{
                    String r = "select * from joueurs where poste='" + postes + "'";
                    System.out.println(r);
                    rs = stmt.executeQuery(r);
                }
                out.println("<table>");

            while (rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                for(int i = 1; i <= rsmd.getColumnCount(); i++){
                    out.println("<td>" + rsmd.getColumnName(i) + "</td>");
                }
                while(rs.next()){
                    out.println("<tr>");
                    out.println("<td>" + rs.getString(1) + "</td>");
                    out.println("<td> <a href=\"JoueursChoisis?personne=" +  rs.getString(2) + "\">" + rs.getString(2) + "</a></td>");                    
                    out.println("<td>" + rs.getString(3) + "</td>");
                    out.println("<td>" + rs.getString(4) + "</td>");
                    out.println("<td>" + rs.getString(5) + "</td>");
                    out.println("<td>" + rs.getString(6) + "</td>");
                    out.println("<td>" + rs.getString(7) + "</td>");
                    out.println("<td>" + rs.getString(8) + "</td>");
                    out.println("</tr>");
                }
                out.println("</table");
            }
            out.println("</body></html>");
        }catch(Exception e){
        out.println("</table>");
        out.println("<p>" + e.getMessage() + "</p>");
    }
    }

}
