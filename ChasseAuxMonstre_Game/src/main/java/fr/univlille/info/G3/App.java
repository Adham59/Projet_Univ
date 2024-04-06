package fr.univlille.info.G3;

import fr.univlille.info.G3.view.game.menu.MenuView;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
 * Le code marche normalement
 */
public class App extends Application {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        launch(args);
    }

    public void start(Stage stage) {
        Image icon = new Image(getClass().getResourceAsStream("/img/icon.png"));
        stage.getIcons().add(icon);
        MenuView menu = new MenuView();
        menu.setMenuView();
    }

}
