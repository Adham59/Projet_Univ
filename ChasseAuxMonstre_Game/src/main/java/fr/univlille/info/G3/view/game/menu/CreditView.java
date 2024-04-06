package fr.univlille.info.G3.view.game.menu;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CreditView extends Stage {

    private MediaPlayer mediaPlayer;

    public CreditView() {
        setTitle("Crédits");
        Image icon = new Image(getClass().getResourceAsStream("/img/icon.png"));
        super.getIcons().add(icon);
        initializeCreditsView();
        try {
            Media media = new Media(getClass().getResource("/sound/credit.mp3").toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        } catch (Exception e) {
            System.out.println("Erreur de lecture du son");
        }

        show();
    }

    private void initializeCreditsView() {
        VBox creditsBox = new VBox(10);
        creditsBox.setStyle("-fx-background-color: #1A1C3B; -fx-alignment: center;");
        creditsBox.getChildren().add(createStyledText("—————————————— ⬡ ——————————————"));
        creditsBox.getChildren().add(createStyledText(" "));
        creditsBox.getChildren().add(createStyledText("Merci d'avoir joué à notre jeu !"));
        creditsBox.getChildren().add(createStyledText(" "));
        creditsBox.getChildren().add(createStyledText("—————————————— ⬡ ——————————————"));
        creditsBox.getChildren().add(createStyledText(" "));
        creditsBox.getChildren().add(
                createStyledText("Ce jeu a été réalisé dans le cadre du projet \"SAE : Developpement d'application\""));
        creditsBox.getChildren().add(createStyledText(" "));
        creditsBox.getChildren().add(createStyledText("—————————————— ⬡ ——————————————"));
        creditsBox.getChildren().add(createStyledText(" "));
        ImageView iut = new ImageView("file:src/main/resources/img/credit/iut.png");
        iut.setFitHeight(50);
        iut.setPreserveRatio(true);
        creditsBox.getChildren().add(iut);
        creditsBox.getChildren().add(createStyledText("IUT de Lille"));
        ImageView univlille = new ImageView("file:src/main/resources/img/credit/univlille.png");
        univlille.setFitHeight(50);
        univlille.setPreserveRatio(true);
        creditsBox.getChildren().add(univlille);
        creditsBox.getChildren().add(createStyledText("Université de Lille"));
        creditsBox.getChildren().add(createStyledText(" "));
        creditsBox.getChildren().add(createStyledText("—————————————— ⬡ ——————————————"));
        creditsBox.getChildren().add(createStyledText(" "));
        creditsBox.getChildren().add(createStyledText("Développeurs :"));
        creditsBox.getChildren().add(createStyledText(" "));
        creditsBox.getChildren().add(createStyledText("Kryptonn - Nathan DORNY"));
        creditsBox.getChildren().add(createStyledText("Limule45 - Théo CATTANEO"));
        creditsBox.getChildren().add(createStyledText("Adham59 - Adham BERRAKANE"));
        creditsBox.getChildren().add(createStyledText("Simon - Simon BARBEAU"));
        creditsBox.getChildren().add(createStyledText(" "));
        creditsBox.getChildren().add(createStyledText("—————————————— ⬡ ——————————————"));
        creditsBox.getChildren().add(createStyledText(" "));
        creditsBox.getChildren().add(createStyledText("Vanished - Crystal Castles (Slowed Version)"));
        creditsBox.getChildren().add(createStyledText(" "));
        creditsBox.getChildren().add(createStyledText("—————————————— ⬡ ——————————————"));
        creditsBox.getChildren().add(createStyledText(" "));
        creditsBox.getChildren().add(createStyledText("Merci à vous !"));
        creditsBox.getChildren().add(createStyledText(" "));
        creditsBox.getChildren().add(createStyledText("—————————————— ⬡ ——————————————"));

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(creditsBox);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setStyle("-fx-background: #1A1C3B; -fx-background-color: #1A1C3B;");
        creditsBox.setAlignment(Pos.CENTER);

        StackPane container = new StackPane(scrollPane);
        container.setAlignment(Pos.CENTER);

        Scene scene = new Scene(container, 565, 800);
        scene.setFill(Color.web("#1A1C3B"));
        setScene(scene);

        Timeline timeline = new Timeline();
        KeyValue startKeyValue = new KeyValue(scrollPane.vvalueProperty(), 0);
        KeyFrame startKeyFrame = new KeyFrame(Duration.ZERO, startKeyValue);
        KeyValue endKeyValue = new KeyValue(scrollPane.vvalueProperty(), 1);
        KeyFrame endKeyFrame = new KeyFrame(Duration.seconds(30), endKeyValue);
        timeline.getKeyFrames().addAll(startKeyFrame, endKeyFrame);
        timeline.setCycleCount(1);
        timeline.play();

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                try {
                    mediaPlayer.stop();
                } catch (Exception e) {
                    System.out.println("Erreur de lecture du son");
                }
                this.close();
                new MenuView().show();
            }
        });
    }

    private Text createStyledText(String content) {
        Text text = new Text(content);
        text.setStyle("-fx-fill: white; -fx-font-size: 16;");
        return text;
    }
}
