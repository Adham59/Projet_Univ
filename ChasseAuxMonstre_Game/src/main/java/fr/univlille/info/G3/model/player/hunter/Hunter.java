package fr.univlille.info.G3.model.player.hunter;

import fr.univlille.info.G3.model.maze.Maze;
import fr.univlille.info.G3.model.maze.MazeHunter;
import fr.univlille.info.G3.model.player.Player;
import fr.univlille.info.G3.view.player.PlayerView;
import fr.univlille.iutinfo.cam.player.hunter.IHunterStrategy;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent.CellInfo;

public class Hunter extends Player implements IHunterStrategy {


    public Maze getMap() {
        return this.maze;
    }

    /**
     * Initialize the hunter maze with given dimensions
     * @param nbRows
     * @param nbCols
     */
    public void initialize(int nbRows, int nbCols) {
        this.maze = new MazeHunter(nbRows, nbCols);
        new PlayerView(this);
    }

    /**
     * Make the model play and return the move
     * @return ICoordinate
     */
    @Override
    public ICoordinate play() {
        notifyObservers();
        return null;
    }

    @Override
    public boolean playMove(ICoordinate shot) {
        if(!this.maze.playMaze(shot, CellInfo.HUNTER)) {
            return false;
        }
        return true;
    }
}
