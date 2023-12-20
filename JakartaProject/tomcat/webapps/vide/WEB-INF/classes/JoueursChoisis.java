import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/JoueursChoisis")
public class JoueursChoisis extends HttpServlet{
    
    public static ArrayList<String> dream = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    HttpSession session = req.getSession(true);


    String personne = req.getParameter("personne");

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("<!doctype html>");
    out.println("<html><head><title>servlet Test</title><style>");
    out.println("th{ color: white; background-color: grey;}table, th, td{border: solid;border-color: black;}tr:nth-child(2n){background-color: lightgray;}tr:hover{background-color: lightgreen;}table, form{margin: 1%;}form{text-align: center;}");
    out.println("</style></head><body>");
    dream.add(personne);


    out.println("<p> Vos membres :  </p>");
    out.println("<table>");
    for (String s : dream) {
        out.println("<td>" + s +  " </td>");
    }

    out.println("</table");



    out.println("<a href=JoueurDisponibles Retour>"+ "Retour" +  "</a>");    
    out.println("</body></html>");

    }

}
