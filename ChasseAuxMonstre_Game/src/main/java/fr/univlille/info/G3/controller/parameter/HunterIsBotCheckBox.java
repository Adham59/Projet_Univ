package fr.univlille.info.G3.controller.parameter;

import fr.univlille.info.G3.model.game.Parameter;
import javafx.scene.control.CheckBox;

public class HunterIsBotCheckBox extends CheckBox {
    

    public HunterIsBotCheckBox(){
        super("Chasseur est un bot");
        setSelected(Parameter.isHunterBot());
        doAction();

    }

    private void doAction(){
        setOnAction(e -> {
            if(isSelected()){
                Parameter.setHunterBot(true);
            } else {
                Parameter.setHunterBot(true);
            }
        });
    }
}
