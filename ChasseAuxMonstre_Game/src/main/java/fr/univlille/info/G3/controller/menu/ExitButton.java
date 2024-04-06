package fr.univlille.info.G3.controller.menu;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class ExitButton extends Button {
    

    public ExitButton(String imagePath){
        super("Quitter", new ImageView(new Image(imagePath)));
        ImageView imageView = (ImageView) getGraphic();
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);
    
        this.setContentDisplay(ContentDisplay.TOP); 
        this.setMaxWidth(Double.MAX_VALUE);
        this.setFont(new Font("Arial", 14));
        this.setStyle("-fx-border-color: #fff; -fx-border-width: 3; -fx-border-radius: 5px ; -fx-background-color: #1A1C3B; -fx-color: #fff; -fx-text-fill: #fff; -fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
        doAction();
        setMinSize(150, 150);
    }


    public void doAction(){
        setOnAction(e -> {
            System.exit(0);
        });
    }
}
