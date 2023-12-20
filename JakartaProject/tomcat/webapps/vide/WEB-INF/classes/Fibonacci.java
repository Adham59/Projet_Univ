import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;




@WebServlet("/Fibannaci")
public class Fibonacci  extends HttpServlet{
    

    public void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{
    
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println( "<head><title>Suite Finbonacci</title>" );
        out.println( "<META content=\"charset=UTF-8\"></head><body><center>" );
        out.println( "<h1>Suite Finbonacci</h1>" );
        int count1 = 1;
        int count2 = 1;
        int count3;
        for (int i = 0; i < 30; i++) {
            out.println( "<h2>"+ count2 + "</h2>" );
            count3 = count2;
            count2 = count1 + count2;
            count1 = count3 ;

        }
        out.println( "<h2></h2>" );

        out.println( "</center> </body>" );
    
        }
}
