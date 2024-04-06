package fr.univlille.info.G3.controller.parameter;

import fr.univlille.info.G3.model.game.Parameter;
import javafx.scene.control.RadioButton;

public class MonsterBotShowViewRadio extends RadioButton {
    

    public MonsterBotShowViewRadio(){
        super("Monster vue");
        setSelected(Parameter.isBotMonsterVueOpen());
        doAction();
    }

    private void doAction(){
        setOnAction(e -> {
            if(isSelected()){
                Parameter.setMonsterVueBot(true);
            } else {
                Parameter.setMonsterVueBot(false);
            }
        });
    }
}
