package fr.univlille.info.G3.controller.parameter;

import fr.univlille.info.G3.model.game.Parameter;
import javafx.scene.control.RadioButton;

public class HunterBotShowViewRadio extends RadioButton{
    

        public HunterBotShowViewRadio(){
            super("Hunter vue");
            setSelected(Parameter.isBotHunterVueOpen());
            doAction();
    
        }
    
        private void doAction(){
            setOnAction(e -> {
                if(isSelected()){
                    Parameter.setHunterVueBot(true);
                } else {
                    Parameter.setHunterVueBot(false);
                }
            });
        }
        
}
