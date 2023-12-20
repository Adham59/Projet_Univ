
import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;



@WebServlet("/NouvelleAn")
public class NouvelAn  extends HttpServlet{
    


    public void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println( "<head><title>Ascii</title>" );
        out.println( "<META content=\"charset=UTF-8\"></head><body><center>" );
        out.println( "<h1>Ascii</h1>" );


        LocalDateTime today = LocalDateTime.now();
        LocalDateTime JANUARYFirst = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        Duration delay = Duration.between( today , JANUARYFirst);
        long seconds = delay.get( ChronoUnit.SECONDS );

        out.println( "<h2> " +  seconds +"</h2>" );




        out.println("<meta http-equiv=refresh content=2; >");

        out.println( "</center> </body>" );
    }
}
