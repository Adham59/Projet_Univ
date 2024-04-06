package fr.univlille.info.G3.controller.parameter;

import fr.univlille.info.G3.model.game.Parameter;
import javafx.scene.control.RadioButton;

public class LoadMapRadio extends RadioButton {
    
    public LoadMapRadio(){
        super("Charger une map prédefinie");
        setSelected(Parameter.isMapFile());
        doAction();
    }

    private void doAction(){
        setOnAction(e -> {
            if(isSelected()){
                Parameter.setMapRandom(false);
                Parameter.setMapFile(true);
            }
        });
    }




}
