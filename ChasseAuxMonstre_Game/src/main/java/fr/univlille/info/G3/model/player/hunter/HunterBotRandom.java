package fr.univlille.info.G3.model.player.hunter;

import fr.univlille.info.G3.model.maze.MazeHunter;
import fr.univlille.info.G3.model.perception.Coordinate;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

public class HunterBotRandom extends Hunter {

    /**
     * Initialize the Monster
     */
    @Override
    public void initialize(int nbRows, int nbCols) {
        this.maze = new MazeHunter(nbRows, nbCols);
    }

    @Override
    public ICoordinate play() {
        return new Coordinate((int)(Math.random() * this.maze.getRowNb()), (int)(Math.random() * this.maze.getColNb()));
    }

}
