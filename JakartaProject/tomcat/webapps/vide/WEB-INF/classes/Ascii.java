import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Ascii")
public class Ascii extends HttpServlet {

    public void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println( "<head><title>servlet first</title>" );
        out.println( "<META content=\"charset=UTF-8\"></head><body><center>" );
        out.println("<table style=\" border: 1px solid; \">");


        int nbCol;

        try {
            nbCol = Integer.parseInt(req.getParameter("nbCol"));
            if (nbCol > 14 || nbCol < 1) nbCol = 1;
        } catch (Exception e) {
            nbCol = 1;
        }


        out.println("<tr>");
        for (int x = 0 ; x < nbCol ; x++) {
            out.println("<th style=\" border: 1px solid; \">code</th>");
            out.println("<th style=\" border: 1px solid; \">valeur</th>");
        }
        out.println("</tr>");

        for (int i = 32 ; i < 256 ; i++) {
            if (i % nbCol == 0) {
                out.println("<tr>");
            }
            out.println("<td style=\" border: 1px solid; \">" + i + "</td>");
            out.println("<td style=\" border: 1px solid; \">" + (char)i + "</td>");
            if (i % nbCol == nbCol - 1) {
                out.println("</tr>");
            }
        }
        
        out.println("</table>");
        out.println("</p>");
        out.println( "</center> </body>" ); 
    }
}