package fr.univlille.info.G3.model.player.monster;

import java.util.List;

import fr.univlille.info.G3.model.maze.MazeMonsterBot;
import fr.univlille.info.G3.view.player.PlayerView;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

public class MonsterBotAStarWithView extends MonsterBotAStar {

    private static ICoordinate botMove;

    private int[][] steps;

    public static ICoordinate getBotMove() {
        return botMove;
    }

    @Override
    public void initialize(boolean[][] walls) {
        this.maze = new MazeMonsterBot(walls);
        new PlayerView(this);
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
                MonsterBotAStarWithView.botMove = neighbour;
                break;
            }
        }
        notifyObservers();
        return null;
    }
}