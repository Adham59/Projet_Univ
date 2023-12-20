import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Modif")
public class Modif extends HttpServlet{


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String login = (String) session.getAttribute("login");
        Boolean presence = (Boolean) session.getAttribute("presence");
        Boolean admin = (Boolean) session.getAttribute("admin");
    
        if(presence){
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<!doctype html>");
        out.println("<html><head><title>servlet Test</title><style>");
        out.println("th{ color: white; background-color: grey;}table, th, td{border: solid;border-color: black;}tr:nth-child(2n){background-color: lightgray;}tr:hover{background-color: lightgreen;}table, form{margin: 1%;}form{text-align: center;}");
        out.println("</style></head><body>");

        if(admin){
            out.println("<a>Modif d'admin</a>"); 
        }else{
        out.println("<a>Modif</a>");
        }

        out.println("</body></html>");
        }else{
            session.invalidate();
            res.sendRedirect("./login.html");
        }


    }
}
