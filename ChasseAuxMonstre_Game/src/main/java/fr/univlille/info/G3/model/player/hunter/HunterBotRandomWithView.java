package fr.univlille.info.G3.model.player.hunter;

import fr.univlille.info.G3.model.perception.Coordinate;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

public class HunterBotRandomWithView extends Hunter {

    private static ICoordinate botMove;

    public static ICoordinate getBotMove() {
        return botMove;
    }


    @Override
    public ICoordinate play() {
        HunterBotRandomWithView.botMove = new Coordinate((int)(Math.random() * this.maze.getRowNb()), (int)(Math.random() * this.maze.getColNb()));
        notifyObservers();
        return null;
    }

}
