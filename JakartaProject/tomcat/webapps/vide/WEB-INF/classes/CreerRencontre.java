import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



@WebServlet("/CreerRencontre")
public class CreerRencontre extends HttpServlet {



    public void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException  {
        res.setContentType("text/html;charset=UTF-8");

        PrintWriter out = res.getWriter();
        out.println( "<head><title>Liste Joueurs</title>" );
        out.println( "<META content=\"charset=UTF-8\"></head><body><center>" );
        out.println("<table>");


        try(Connection c = DS.getConnection();) {
        } catch (Exception e) {
            e.printStackTrace();
        }

        finally{
        }




    }
    



}
