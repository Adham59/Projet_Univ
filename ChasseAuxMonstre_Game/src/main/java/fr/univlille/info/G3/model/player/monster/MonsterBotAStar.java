package fr.univlille.info.G3.model.player.monster;

import java.util.List;

import fr.univlille.info.G3.model.maze.MazeMonsterBot;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

public class MonsterBotAStar extends Monster{

    protected ICoordinate exit;
    protected List<ICoordinate> path;
    private int[][] steps;


    @Override
    public void initialize(boolean[][] walls) {
        this.maze = new MazeMonsterBot(walls);
    }

    @Override
    public ICoordinate play() {
        this.exit = ((MazeMonsterBot)this.getMap()).getExit();
        if(this.steps == null) {
            this.steps = ((MazeMonsterBot)this.getMap()).calculate(exit);
        }
        ICoordinate monsterPosition = ((MazeMonsterBot)this.getMap()).getMonsterPosition();
        List<ICoordinate> neighbours = this.getMap().getNeighbourgs(monsterPosition);
        for (ICoordinate neighbour : neighbours) {
            if(steps[neighbour.getRow()][neighbour.getCol()] >= 0 && steps[neighbour.getRow()][neighbour.getCol()] < steps[monsterPosition.getRow()][monsterPosition.getCol()]) {
                return neighbour;
            }
        }
        return null;
    }
}