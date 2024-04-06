package fr.univlille.info.G3.view.player;

import fr.univlille.info.G3.controller.player.MazeCaseController;
import fr.univlille.info.G3.model.perception.Coordinate;
import fr.univlille.info.G3.model.player.Player;
import fr.univlille.info.G3.utils.Observer;
import fr.univlille.info.G3.utils.Subject;
import fr.univlille.info.G3.view.SounManager;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PlayerView extends Stage implements Observer {

    private Label turnDisplay = new Label();

    private Player model;
    private MazeCaseController[][] mazeCaseGrid;
    private static int CASE_SIZE = 50;
    private static int INSET = 2;

    /**
     * Constructor
     * @param model
     */
    public PlayerView(Player model) {
        System.out.println(this.getClass().getSimpleName() + " : Creating view for " + model.getClass().getSimpleName());
        Image icon = new Image(getClass().getResourceAsStream("/img/icon.png"));
        super.getIcons().add(icon);
        this.model = model;
        this.model.attach(this);
        this.setTitle(this.model.getClass().getSimpleName());
        this.setScene(new Scene(setUpMazeDisplay() , this.model.getMap().getColNb() * (CASE_SIZE + INSET * 2), this.model.getMap().getRowNb() * (CASE_SIZE + INSET * 2)));
    }

    @Override
    public void update(Subject subj, Object data) {
        displayMaze();
    }

    @Override
    public void update(Subject subj) {
        System.out.println("dddd" + this.model.getClass().getSimpleName());
        if (this.model.getClass().getSimpleName().equals("Monster")) {
            SounManager.playShoot(this);
        } else {
            SounManager.playWalk(this);
        }
        this.update(subj, null);
    }

    /**
     * Setup the Maze view skeleton but do not show
     */
    private GridPane setUpMazeDisplay() {
        System.out.println(this.getClass().getSimpleName() + "Setting up maze display for " + this.model.getClass().getSimpleName());
        this.mazeCaseGrid = new MazeCaseController[this.model.getMap().getRowNb()][this.model.getMap().getColNb()];
        GridPane mazeDisplay = new GridPane();
        for (int i = 0; i < this.model.getMap().getRowNb(); i++) {
            for (int j = 0; j < this.model.getMap().getColNb(); j++) {
                int finalI = i;
                int finalJ = j;
                MazeCaseController mazeCase = new MazeCaseController(50, 50, this.model, this, finalI, finalJ);
                this.mazeCaseGrid[i][j] = mazeCase;
                mazeDisplay.add(mazeCase, j, i);
                //lztruck
            }
        }
        return mazeDisplay;
	}

    /**
     * Update and display Maze View
     */
    private void displayMaze() {
        System.out.println(this.getClass().getSimpleName() + " : displaying maze for " + this.model.getClass().getSimpleName());
        this.turnDisplay.setText("" + this.model.getMap().getTurn());
        for (int i = 0; i < this.model.getMap().getRowNb(); i++) {
            for (int j = 0; j < this.model.getMap().getColNb(); j++) { 
                ICoordinate coordinate = new Coordinate(i, j);               
                this.mazeCaseGrid[i][j].setupDisplay(this.model.getMap().getCellGroundInfo(coordinate), this.model.getMap().getLastMonsterPresence(coordinate), this.model.getMap().getLastHunterShot(coordinate), this.model.getMap().getTurn());
                GridPane.setMargin(mazeCaseGrid[i][j], new Insets(INSET, INSET, INSET, INSET));
            }
        }


        this.show();
	}

    /**
     * Hide the Maze View
     */
    public void closeStage() {
        System.out.println("INFO : hiding maze for " + this.model.getClass().getSimpleName());
        this.close();
    }
}