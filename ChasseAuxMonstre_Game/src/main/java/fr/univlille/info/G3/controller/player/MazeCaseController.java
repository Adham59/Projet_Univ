package fr.univlille.info.G3.controller.player;

import fr.univlille.info.G3.model.game.Game;
import fr.univlille.info.G3.model.perception.Coordinate;
import fr.univlille.info.G3.model.player.Player;
import fr.univlille.info.G3.model.player.hunter.HunterBotCleverWithView;
import fr.univlille.info.G3.model.player.hunter.HunterBotRandomWithView;
import fr.univlille.info.G3.model.player.monster.MonsterBotAStarWithView;
import fr.univlille.info.G3.model.player.monster.MonsterBotRandomWithView;
import fr.univlille.info.G3.view.player.PlayerView;
import fr.univlille.iutinfo.cam.player.hunter.IHunterStrategy;
import fr.univlille.iutinfo.cam.player.monster.IMonsterStrategy;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent.CellInfo;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MazeCaseController extends Canvas {

    private Player model;
    private PlayerView view;
    private int x;
    private int y;

    public void setupDisplay(CellInfo ground, int lastMonsterPresence, int lastHunterShot, int turn) {
        // Set ground
        if(ground == CellInfo.EMPTY) {
            this.getGraphicsContext2D().drawImage(new Image("/img/case/ground.png"), 0, 0, 50, 50);
        } else if(ground == CellInfo.WALL) {
            this.getGraphicsContext2D().drawImage(new Image("/img/case/wall.png"), 0, 0, 50, 50);
        } else if(ground == CellInfo.EXIT) {
            this.getGraphicsContext2D().drawImage(new Image("/img/case/exit.png"), 0, 0, 50, 50);
        } else if(ground == null) {
            this.getGraphicsContext2D().drawImage(new Image("/img/case/unknow.png"), 0, 0, 50, 50);
        }

        if(lastMonsterPresence > -1) {
            if(lastMonsterPresence >= turn) {
                this.getGraphicsContext2D().drawImage(new Image("/img/case/monster.png"), 0, 0, 50, 50);
            } else {
                this.getGraphicsContext2D().drawImage(new Image("/img/case/step.png"), 0, 0, 50, 50);
            }
            
        }
        if(lastHunterShot > -1) {
            this.getGraphicsContext2D().drawImage(new Image("/img/case/shot.png"), 0, 0, 50, 50);
        }

        if(lastMonsterPresence > -1) {
            this.getGraphicsContext2D().setFill(Color.RED);
            this.getGraphicsContext2D().setFont(Font.font("Sans Noto", FontWeight.BOLD, 15));
            this.getGraphicsContext2D().fillText("" + lastMonsterPresence, 5, 45);
        }

        if(lastHunterShot > -1) {
            this.getGraphicsContext2D().setFill(Color.BLACK);
            this.getGraphicsContext2D().setFont(Font.font("Sans Noto", FontWeight.BOLD, 15));
            this.getGraphicsContext2D().fillText("" + lastHunterShot, 5, 15);
        }
    }


    public MazeCaseController(double arg0, double arg1, Player model, PlayerView view, int x, int y) {
        super(arg0, arg1);
        this.model = model;
        this.view = view;
        this.x = x;
        this.y = y;
        doAction();
    }

    public void doAction(){
        this.setOnMouseClicked(event -> {
            ICoordinate coordinate = new Coordinate(x, y);
            System.out.println(this.getClass().getSimpleName() + " : " + this.model.getClass().getSimpleName() + " clicked on " + coordinate);

            if(this.model instanceof MonsterBotRandomWithView ) {
                this.view.hide();
                Game.getInstance().monsterMove(MonsterBotRandomWithView.getBotMove());

            } else if(this.model instanceof MonsterBotAStarWithView ) {
                this.view.hide();
                Game.getInstance().monsterMove(MonsterBotAStarWithView.getBotMove());

            } else if(this.model instanceof HunterBotRandomWithView) {
                this.view.hide();
                Game.getInstance().hunterShoot(HunterBotRandomWithView.getBotMove());
            
            } else if(this.model instanceof HunterBotCleverWithView) {
                this.view.hide();
                Game.getInstance().hunterShoot(HunterBotCleverWithView.getBotMove());

            
            
            
            } else if (this.model.playMove(coordinate)) {
                System.out.println(this.getClass().getSimpleName() + " : " + "Valid play");
                
                if(this.model instanceof IMonsterStrategy ) {
                    this.view.hide();
                    Game.getInstance().monsterMove(coordinate);

                } else if(this.model instanceof IHunterStrategy ) {
                    this.view.hide();
                    Game.getInstance().hunterShoot(coordinate);
                }
                System.out.println(this.getClass().getSimpleName() + " : " + this.model.getClass().getSimpleName() + "played at " + x + ", " + y);
            } else {
                System.out.println(this.getClass().getSimpleName() + " : Invalid play");
            }
        });
    }

}
