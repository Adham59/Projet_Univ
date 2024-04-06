package fr.univlille.info.G3.model.player.monster;

import java.util.List;

import fr.univlille.info.G3.model.maze.MazeMonster;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

public class MonsterBotRandom extends Monster {

    /**
     * Initialize the Monster
     */
    @Override
    public void initialize(boolean[][] wall) {
        this.maze = new MazeMonster(wall);
    }

    /**
     * Make the model play and return the move
     * @return ICoordinate
     */
    @Override
    public ICoordinate play() {
        List<ICoordinate> potentialMoves = this.maze.getNeighbourgs(this.maze.getMonsterPosition());

        if(potentialMoves.isEmpty()) {
            throw new UnsupportedOperationException("Monster cannot move");
        }
        
        return potentialMoves.get((int)(Math.random() * potentialMoves.size()));
    }
}