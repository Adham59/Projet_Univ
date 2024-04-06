package fr.univlille.info.G3.controller.parameter;

import fr.univlille.info.G3.model.game.Parameter;
import javafx.scene.control.RadioButton;

public class HunterBotIsRandomRadio extends RadioButton {
    

        public HunterBotIsRandomRadio(){
            super("Hunter easy");
            setSelected(Parameter.isHunterRandomBot());
            doAction();
    
        }
    
        private void doAction(){
            setOnAction(e -> {
                if(isSelected()){
                    Parameter.setHunterRandomBot(true);
                    Parameter.setHunterCleverBot(false);
                }
            });
        }
}
