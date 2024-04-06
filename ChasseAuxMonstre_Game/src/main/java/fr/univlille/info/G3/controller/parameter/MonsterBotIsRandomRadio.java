package fr.univlille.info.G3.controller.parameter;

import fr.univlille.info.G3.model.game.Parameter;
import javafx.scene.control.RadioButton;

public class MonsterBotIsRandomRadio extends RadioButton{
 
    public MonsterBotIsRandomRadio(){
        super("Monster easy");
        setSelected(Parameter.isMonsterRandomBot());
        doAction();
    }

    private void doAction(){
        setOnAction(e -> {
            if(isSelected()){
                Parameter.setMonsterAStarBot(false);
                Parameter.setMonsterRandomBot(true);
            }
        });
    }
}
