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

@WebServlet("/ListeRencontres")
public class ListeRencontresEvol extends HttpServlet{

    public String order = "ASC";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        String tri = req.getParameter("tri");
        order = req.getParameter("order");


        out.println("<!doctype html>");
        out.println("<html><head><title>servlet Test</title><style>");
        out.println("th{ color: white; background-color: grey;}table, th, td{border: solid;border-color: black;}tr:nth-child(2n){background-color: lightgray;}tr:hover{background-color: lightgreen;}table, form{margin: 1%;}form{text-align: center;}");
        out.println("</style></head><body>");

        try(Connection c = DS.getConnection()){
            Statement stmt = c.createStatement();
            ResultSet rs;
            /*cpt++;
            if((cpt%2) == 0){
                order = "ASC";
            }else{
                order = "DESC";
            }*/

            if(tri == null){
            rs = stmt.executeQuery("select * from rencontres ");
            }else{
                String r = "select * from rencontres ORDER BY " + tri + " " +  order;
                System.out.println(r);
                rs = stmt.executeQuery(r);
            }

            out.println("<table>");

            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i = 1; i <= rsmd.getColumnCount(); i++){
                out.println("<td> <a href=./ListeRencontres?tri=" + rsmd.getColumnName(i) + "&order=" + order  + ">" +  rsmd.getColumnName(i) +  "</a></td>");
            }
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