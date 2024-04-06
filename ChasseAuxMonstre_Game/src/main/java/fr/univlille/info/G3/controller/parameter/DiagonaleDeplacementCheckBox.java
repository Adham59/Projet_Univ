package fr.univlille.info.G3.controller.parameter;

import fr.univlille.info.G3.model.game.Parameter;
import javafx.scene.control.CheckBox;

public class DiagonaleDeplacementCheckBox extends CheckBox{
    
    public DiagonaleDeplacementCheckBox() {
        super("Diagonale deplacement");
        this.setSelected(Parameter.isFogMode());
        doAction();
    }


    private void doAction() {
        setOnAction(e -> {
            if(isSelected()) {
                Parameter.setDiagonaleDeplacementPossible(true);
            } else {
                Parameter.setDiagonaleDeplacementPossible(false);
            }
        });
    }

}
