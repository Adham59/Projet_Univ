package fr.univlille.info.G3.controller.parameter;

import fr.univlille.info.G3.model.game.Parameter;
import javafx.scene.control.Spinner;

public class FogRangeSpinner extends Spinner<Integer>{

    public FogRangeSpinner() {
        super(0, 99, Parameter.getFogRange());
        this.setEditable(true);
        this.setWidth(10);
        doAction();
    }

    private void doAction() {
        this.valueProperty().addListener((obs, oldValue, newValue) -> {
            if(newValue != null) {
                this.getValueFactory().setValue(newValue);
                Parameter.setFogRange(newValue);
            }
        });
    }
}
