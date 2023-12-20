import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@WebServlet("/ListeJoueurs")
public class ListeJoueurs extends HttpServlet {


    public void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println( "<head><title>Liste Joueurs</title>" );
        out.println( "<META content=\"charset=UTF-8\"></head><body><center>" );
        out.println("<table>");
        
        Connection c = DS.getConnection();
        try {
            Statement stmt = c.createStatement();
            String query = "Select * from JOUEURS";
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsMD = rs.getMetaData();

            while (rs.next()) {
                out.println("<tr style=\" border: 1px solid; \">");
                for (int cpt = 0 ; cpt<rsMD.getColumnCount() ; cpt++) {
                    try {
                    out.println("<td style=\" border: 1px solid; \">" + rs.getString(cpt) + "</td>");
                    out.println("<td style=\" border: 1px solid; \">" + rs.getString(cpt)  + "</td>");
                    out.println("<td style=\" border: 1px solid; \">" + rs.getString(cpt)  + "</td>");
                    out.println("<td style=\" border: 1px solid; \">" + rs.getString(cpt)  + "</td>");
                    out.println("<td style=\" border: 1px solid; \">" + rs.getString(cpt)  + "</td>");
                    out.println("<td style=\" border: 1px solid; \">" + rs.getString(cpt)  + "</td>");
                    out.println("<td style=\" border: 1px solid; \">" + rs.getString(cpt)  + "</td>");
                    out.println("<td style=\" border: 1px solid; \">" + rs.getString(cpt)  + "</td>");
                    } catch (Exception e) {
                        
                    }

                }
                out.println("</tr>");
            }
            out.println("</table>");
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}