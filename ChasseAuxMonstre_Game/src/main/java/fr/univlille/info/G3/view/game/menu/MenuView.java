package fr.univlille.info.G3.view.game.menu;

import fr.univlille.info.G3.controller.menu.CreditButton;
import fr.univlille.info.G3.controller.menu.ExitButton;
import fr.univlille.info.G3.controller.menu.NewGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuView extends Stage {

    public MenuView() {
        setTitle("Menu");
        Image icon = new Image(getClass().getResourceAsStream("/img/icon.png"));
        super.getIcons().add(icon);
        setMenuView();
        show();
    }

    public void setMenuView() {
        VBox root = new VBox(10); // Espacement entre les éléments
        root.setAlignment(Pos.CENTER);
        root.setBackground(new Background(new BackgroundFill(Color.web("#1A1C3B"), CornerRadii.EMPTY, Insets.EMPTY)));
    
        HBox buttonsContainer = new HBox(10); // Espacement entre les boutons
        buttonsContainer.setAlignment(Pos.CENTER);
    
        // Ajout des boutons avec images
        buttonsContainer.getChildren().add(new NewGame("file:src/main/resources/img/menu/newGame.png", this));
        buttonsContainer.getChildren().add(new CreditButton("file:src/main/resources/img/menu/credit.png", this));
        buttonsContainer.getChildren().add(new ExitButton("file:src/main/resources/img/menu/exit.png"));
    
        ImageView imageView = new ImageView(new Image("file:src/main/resources/img/logo.png"));
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);
        root.getChildren().addAll(imageView, buttonsContainer);
    
        setScene(new Scene(root, 1080, 720));
        this.setResizable(false);
    }
}
