package fr.univlille.info.G3.controller.parameter;

import fr.univlille.info.G3.model.game.Parameter;
import javafx.scene.control.RadioButton;

public class HunterBotIsCleverRadio extends RadioButton{
    

        public HunterBotIsCleverRadio(){
            super("Hunter hard");
            setSelected(Parameter.isHunterCleverBot());
            doAction();
    
        }
    
        private void doAction(){
            setOnAction(e -> {
                if(isSelected()){
                    Parameter.setHunterRandomBot(false);
                    Parameter.setHunterCleverBot(true);
                }
            });
        }

}
