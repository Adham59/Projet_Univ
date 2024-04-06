package fr.univlille.info.G3.view;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class SounManager {
  public static void playShoot(Stage stage) {
    // aleatoire number between 1 and 3
    Integer random = (int) (Math.random() * 3) + 1;
    try {
      Media media = new Media(stage.getClass().getResource("/sound/hunter/shoot" + random.toString() + ".mp3").toString());
      MediaPlayer mediaPlayer = new MediaPlayer(media);
      mediaPlayer.setVolume(0.33);
      mediaPlayer.play();
    } catch (Exception e) {
      System.out.println("Erreur de lecture du son");
    }
  }

  public static void playWin(Stage stage) {
    try {
      Media media = new Media(stage.getClass().getResource("/sound/win.mp3").toString());
      MediaPlayer mediaPlayer = new MediaPlayer(media);
      mediaPlayer.setVolume(0.33);
      mediaPlayer.play();
    } catch (Exception e) {
      System.out.println("Erreur de lecture du son");
    }
  }

  public static void playWalk(Stage stage) {
    try {
      Media media = new Media(stage.getClass().getResource("/sound/monster/walk.mp3").toString());
      MediaPlayer mediaPlayer = new MediaPlayer(media);
      mediaPlayer.setVolume(0.33);
      mediaPlayer.play();
    } catch (Exception e) {
      System.out.println("Erreur de lecture du son");
    }
  }
}
