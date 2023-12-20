
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DS {

    private String url;
    private String nom;
    private String mdp;
    private static DS instance;

    private DS() {
        try {
            this.url = "jdbc:postgresql://psqlserv/but2";
            this.nom = "adhamberrakaneetu";
            this.mdp = "moi";
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection connexion() {
        try {
            return DriverManager.getConnection(this.url, this.nom, this.mdp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DS getInstance() {
        if (DS.instance == null) DS.instance = new DS();
        return DS.instance;
    }

    public static Connection getConnection() {
        return getInstance().connexion();
    }
}