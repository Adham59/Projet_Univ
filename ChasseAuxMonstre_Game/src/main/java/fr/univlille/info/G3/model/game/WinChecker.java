package fr.univlille.info.G3.model.game;

import fr.univlille.info.G3.view.game.menu.WinWindowView;
import fr.univlille.iutinfo.cam.player.IStrategy;

public class WinChecker {
    
    public WinChecker(IStrategy player) {
        new WinWindowView(player);
    }

}
