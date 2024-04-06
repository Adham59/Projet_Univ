package fr.univlille.info.G3.controller.parameter;

import fr.univlille.info.G3.model.game.Parameter;
import javafx.scene.control.RadioButton;

public class MonsterBotIsAStarRadio extends RadioButton {
    

    public MonsterBotIsAStarRadio(){
        super("Monster hard");
        setSelected(Parameter.isMonsterAStarBot());
        doAction();

    }

    private void doAction(){
        setOnAction(e -> {
            if(isSelected()){
                Parameter.setMonsterAStarBot(true);
                Parameter.setMonsterRandomBot(false);
            }
        });
    }
}
