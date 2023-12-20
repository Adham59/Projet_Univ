import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Compteur")
public class Compteur extends HttpServlet {


    int compteur = 1;



    public void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException  {
        HttpSession session = req.getSession(true);
        Integer cpt = (Integer)session.getAttribute( "compteur" );
        cpt = Integer.valueOf( cpt == null ? 1 : cpt.intValue() + 1 );
        session.setAttribute( "compteur", cpt );

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println( "<head><title>Liste Joueurs</title>" );
        out.println( "<META content=\"charset=UTF-8\"></head><body><center>" );
        out.println("<table>");
        out.println("<tr><td>Compteur : </td><td> Votre session : " +  compteur + " Totale de sessions :  " + cpt + "</td></tr>");
        out.println("</table>");

        compteur++;

    }

}