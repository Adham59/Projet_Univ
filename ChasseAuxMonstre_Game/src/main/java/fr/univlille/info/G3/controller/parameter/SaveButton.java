package fr.univlille.info.G3.controller.parameter;

import fr.univlille.info.G3.model.game.Game;
import fr.univlille.info.G3.model.game.Parameter;
import fr.univlille.info.G3.model.player.hunter.Hunter;
import fr.univlille.info.G3.model.player.hunter.HunterBotClever;
import fr.univlille.info.G3.model.player.hunter.HunterBotCleverWithView;
import fr.univlille.info.G3.model.player.hunter.HunterBotRandom;
import fr.univlille.info.G3.model.player.hunter.HunterBotRandomWithView;
import fr.univlille.info.G3.model.player.monster.Monster;
import fr.univlille.info.G3.model.player.monster.MonsterBotAStar;
import fr.univlille.info.G3.model.player.monster.MonsterBotAStarWithView;
import fr.univlille.info.G3.model.player.monster.MonsterBotRandom;
import fr.univlille.info.G3.model.player.monster.MonsterBotRandomWithView;
import fr.univlille.info.G3.model.player.monster.MonsterFog;
import fr.univlille.iutinfo.cam.player.hunter.IHunterStrategy;
import fr.univlille.iutinfo.cam.player.monster.IMonsterStrategy;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SaveButton extends Button{
    
    public SaveButton(TextField pseudoMonster, TextField pseudoHunter, Slider probaWalls, Slider gridColSize, Slider gridRowSize, Stage stage){
        super("Sauvegarder");
        doAction( pseudoMonster,  pseudoHunter,  probaWalls,  gridColSize,  gridRowSize, stage);
    }

    private void doAction(TextField pseudoMonster, TextField pseudoHunter, Slider probaWalls, Slider gridColSize, Slider gridRowSize, Stage stage){
        setOnAction(e -> {
            Parameter.setPseudoMonster(pseudoMonster.getText());
            Parameter.setPseudoHunter(pseudoHunter.getText());
            Parameter.setMazeWallSpawnRate(probaWalls.getValue());
            Parameter.setMazeHorizontalSize((int)gridColSize.getValue());
            Parameter.setMazeVerticalSize((int)gridRowSize.getValue());


            IMonsterStrategy monster = null;
            IHunterStrategy hunter = null;

            // Monster is a Bot
            if(Parameter.isMonsterBot()) {
                // Monster is an advanced bot
                if(Parameter.isMonsterAStarBot()) {
                    if(Parameter.isBotMonsterVueOpen()) {
                        monster = new MonsterBotAStarWithView();
                    } else {
                        monster = new MonsterBotAStar();
                    }
                // Monster is a random Bot
                } else {
                    if(Parameter.isBotMonsterVueOpen()) {
                        monster = new MonsterBotRandomWithView();
                    } else {
                        monster = new MonsterBotRandom();
                    }
                }
            // Monster is human
            } else if(Parameter.isFogMode()){
                monster = new MonsterFog();
            } else{
                monster = new Monster();
            }

            // Hunter is a Bot
            if(Parameter.isHunterBot()) {
                // Hunter is a clever bot
                if(Parameter.isHunterCleverBot()){
                    if(Parameter.isBotHunterVueOpen()){
                        hunter = new HunterBotCleverWithView();
                    } else {
                        hunter = new HunterBotClever();
                    }
                // Hunter is a random bot
                } else {
                    if(Parameter.isBotHunterVueOpen()){
                        hunter = new HunterBotRandomWithView();
                    } else {
                    hunter = new HunterBotRandom();
                    }
                }
            // Hunter is human
            } else {
                hunter = new Hunter();
            }


            new Game(monster, hunter);
            stage.close();
        });
    }

}
