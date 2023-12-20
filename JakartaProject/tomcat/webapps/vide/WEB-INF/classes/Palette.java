
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/Palette")
public class Palette extends HttpServlet {
    

    public void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        String r = req.getParameter("r");
        int rn = Integer.parseInt(r);
        out.println( "<head><title>Palette</title>" );
        out.println( "<META content=\"charset=UTF-8\"></head><body><center>" );
        out.println( "<h1>Palette de couleur</h1>" );

        String v = "0123456789ABCDEF";
        out.println( "<table>" );


        for(int j = 0 ; j<16 ; j++){
        out.println(" <td> <a href=./Palette?r=" + j + ">r=" + j + "</a></td> ") ;
        }

        out.println( "</table>" );

        out.println( "<table>" );
        for (int i = 0; i < 16 ; i++) {
            out.println( "<tr>" );
            for (int j = 0; j < 16; j++) {
                if(!(rn >16)){

                out.println( "<td style=\"background-color:#" + v.charAt(rn) + v.charAt(i) + v.charAt(j) +  "; width:40px; height: 40px;\"></td>" );
                }else{
                rn = 16;
                out.println( "<td style=\"background-color:#" + v.charAt(rn) + v.charAt(i) + v.charAt(j) +  "; width:40px; height: 40px;\"></td>" );
   
                }
            }
            out.println( "</tr>" );
        }

        out.println( "<h1>Palette de couleur r=" + rn +  "</h1>" ); 
        out.println( "</table>" );
        out.println( "</center> </body>" );
    }


}
