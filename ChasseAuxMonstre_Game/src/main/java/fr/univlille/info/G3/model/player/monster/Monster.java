package fr.univlille.info.G3.model.player.monster;

import fr.univlille.info.G3.model.maze.Maze;
import fr.univlille.info.G3.model.maze.MazeMonster;
import fr.univlille.info.G3.model.player.Player;
import fr.univlille.info.G3.view.player.PlayerView;
import fr.univlille.iutinfo.cam.player.monster.IMonsterStrategy;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent.CellInfo;

public class Monster extends Player implements IMonsterStrategy {
    
    public Maze getMap() {
        return this.maze;
    }

     /**
     * Initialize the Monster
     */
    @Override
    public void initialize(boolean[][] walls) {
        this.maze = new MazeMonster(walls);
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
    public boolean playMove(ICoordinate move) {
        if(!this.maze.playMaze(move, CellInfo.MONSTER)) {
            return false;
        }
        ((MazeMonster)(this.maze)).setMonsterPosition(move);
        return true;
    }

}
