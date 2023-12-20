
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Menu")
public class Menu extends HttpServlet{


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String login = (String) session.getAttribute("login");
        Boolean presence = (Boolean) session.getAttribute("session");
        
        if(presence){
        session.setAttribute("presence", true);
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<!doctype html>");
        out.println("<html><head><title>servlet Test</title><style>");
        out.println("th{ color: white; background-color: grey;}table, th, td{border: solid;border-color: black;}tr:nth-child(2n){background-color: lightgray;}tr:hover{background-color: lightgreen;}table, form{margin: 1%;}form{text-align: center;}");
        out.println("</style></head><body>");



        out.println("<a href=Lecture>Lecture</a>");
        out.println("<a href=Modif>Modification</a>");
        out.println("        <form action=\"Deconnecter\" method=\"post\">\n" + //
                "            <button type=\"submit\">Cliquez sur moi</button>\n" + //
                "          </form>\n" + //
                "        </form>");

                
        out.println("</body></html>");
        }else{
            session.invalidate();
            res.sendRedirect("./login.html");
        }
    }

}