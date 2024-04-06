package fr.univlille.info.G3.view.game.menu;

import fr.univlille.info.G3.controller.menu.NewGame;
import fr.univlille.info.G3.controller.parameter.BackToMenu;
import fr.univlille.iutinfo.cam.player.IStrategy;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WinWindowView extends Stage {
    
    public WinWindowView(IStrategy player){
        setNewGameWindow(player);
        Image icon = new Image(getClass().getResourceAsStream("/img/icon.png"));
        super.getIcons().add(icon);
        setHeight(500);
        setWidth(500);
        this.show();
    }

    private void setNewGameWindow(IStrategy player) {
        HBox layoutWinner = new HBox(5);
        layoutWinner.setAlignment(Pos.CENTER);
        layoutWinner.setPadding(new javafx.geometry.Insets(5));

        HBox layoutBouton= new HBox(5);
        layoutBouton.setAlignment(Pos.CENTER);
        layoutBouton.setPadding(new javafx.geometry.Insets(5));

        VBox layoutPrincipale = new VBox(5);
        layoutPrincipale.setAlignment(Pos.CENTER);
        layoutPrincipale.setPadding(new javafx.geometry.Insets(5));

        Button gameStart = new NewGame("file:src/main/resources/img/menu/newGame.png",this);
        Button backToMenu = new BackToMenu("file:src/main/resources/img/menu/back.png",this);

        Text winner = new Text();

        winner.setText(player.getClass().getSimpleName() + " a gagné !");

        layoutWinner.getChildren().add(winner);
        layoutBouton.getChildren().addAll(gameStart , backToMenu);
        layoutPrincipale.getChildren().addAll(layoutWinner, layoutBouton);

        Scene scene = new Scene(layoutPrincipale, 250, 125);
        scene.getStylesheets().add("file:src/main/resources/css/parameter.css");
        this.setScene(scene);
    }
}
