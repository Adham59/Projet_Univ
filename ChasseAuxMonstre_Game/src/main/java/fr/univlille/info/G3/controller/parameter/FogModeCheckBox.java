package fr.univlille.info.G3.controller.parameter;

import fr.univlille.info.G3.model.game.Parameter;
import javafx.scene.control.CheckBox;

public class FogModeCheckBox  extends CheckBox{
    
    public FogModeCheckBox() {
        super("Fog mode");
        this.setSelected(Parameter.isFogMode());
        doAction();
    }


    private void doAction() {
        setOnAction(e -> {
            if(isSelected()) {
                Parameter.setFogMode(true);
            } else {
                Parameter.setFogMode(false);
            }
        });
    }

}
