import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListeRencontre")
public class ListeRencontre extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<!doctype html>");
        out.println("<html><head><title>servlet Test</title><style>");
        out.println("th{ color: white; background-color: grey;}table, th, td{border: solid;border-color: black;}tr:nth-child(2n){background-color: lightgray;}tr:hover{background-color: lightgreen;}table, form{margin: 1%;}form{text-align: center;}");
        out.println("</style></head><body><table>");
        out.println("<tr><th>colonne</th><th>type</th><th>description</th></tr>");
        try(Connection c = DS.getConnection()){
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from rencontres");
            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i = 1; i <= rsmd.getColumnCount(); i++){
                out.println("<tr>");
                out.println("<td>" + rsmd.getColumnName(i) + "</td>");
                out.println("<td>" + rsmd.getColumnType(i) + "</td>");
                out.println("<td>" + rsmd.getColumnLabel(i) + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<table>");
            while(rs.next()){
                out.println("<tr>");
                out.println("<td>" + rs.getString(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");
                out.println("<td>" + rs.getString(4) + "</td>");
                out.println("<td>" + rs.getString(5) + "</td>");
                out.println("<td>" + rs.getString(6) + "</td>");
                out.println("</tr>");
            }
            out.println("</table");
        }catch(Exception e){
            out.println("</table>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
        out.println("</body></html>");
    }

    

    
    
}