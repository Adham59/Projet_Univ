package fr.univlille.info.G3.controller.parameter;

import fr.univlille.info.G3.model.game.Parameter;
import javafx.scene.control.RadioButton;

public class LoadRandomMapRadio extends RadioButton {
    

    public LoadRandomMapRadio(){
        super("Charger une map aléatoire");
        setSelected(Parameter.isMapRandom());
        doAction();

    }

    private void doAction(){
        setOnAction(e -> {
            if(isSelected()  && !Parameter.isMapRandom()){
                Parameter.setMapRandom(true);
                Parameter.setMapFile(false);
            }
        });
    }
}
