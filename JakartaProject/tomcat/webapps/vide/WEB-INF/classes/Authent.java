import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Une servlet Authent.java qui vérifie dans la base de données si cette personne existe ou non et range
un token dans la session de l’utilisateur quand il est connu.
 */
@WebServlet("/Authent")
public class Authent extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        HttpSession session = req.getSession(true);
        String login = req.getParameter("login");
        String password = req.getParameter("password");


        session.setMaxInactiveInterval(30000);
        session.setAttribute("login", login);
        session.setAttribute("password", password);

        if (isInDataBase(login, password)){
            session.setAttribute( "presence", true );
            res.sendRedirect("./menu.html");
        }else{
            session.setAttribute( "presence", false);
            res.sendRedirect("./login.html");
        }
        if(isAnAdmin(login, password)){
            session.setAttribute("admin", true);
        }else{
            session.setAttribute("amdin", false);
        }
    }

    private boolean isInDataBase(String login, String password) {
        try (Connection con = DS.getConnection()) {
            PreparedStatement psLog = con.prepareStatement("Select * from personne where login = ? AND mdp = ?");
            psLog.setString(1, login);
            psLog.setString(2, password);
            return psLog.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isAnAdmin(String login , String password){
        try (Connection con = DS.getConnection()) {
            PreparedStatement psLog = con.prepareStatement("Select * from personne where login = ? AND mdp = ? AND role = ?");
            psLog.setString(1, login);
            psLog.setString(2, password);
            psLog.setString(3, "admin");
            return psLog.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}