package fr.univlille.info.G3.controller.parameter;

import fr.univlille.info.G3.model.game.Parameter;
import javafx.scene.control.CheckBox;

public class MonsterIsBotCheckBox extends CheckBox {
    
    public MonsterIsBotCheckBox(){
        super("Monstre est un bot");
        setSelected(Parameter.isMonsterBot());
        doAction();
    }

    private void doAction(){
        setOnAction(e -> {
            if(isSelected()){
                Parameter.setMonsterBot(true);
            } else {
                Parameter.setMonsterBot(false);
            }

        });
    }
}
