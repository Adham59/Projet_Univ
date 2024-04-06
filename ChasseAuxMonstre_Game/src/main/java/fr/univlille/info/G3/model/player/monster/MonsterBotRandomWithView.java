package fr.univlille.info.G3.model.player.monster;

import java.util.ArrayList;
import java.util.List;

import fr.univlille.info.G3.model.maze.MazeMonster;
import fr.univlille.info.G3.model.perception.Coordinate;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

public class MonsterBotRandomWithView extends Monster {

    private static ICoordinate botMove;

    public static ICoordinate getBotMove() {
        return botMove;
    }

    @Override
    public ICoordinate play() {
        List<Coordinate> potentialMoves = new ArrayList<Coordinate>();
        if(this.maze.isValidPlay(new Coordinate(((MazeMonster)(this.maze)).getMonsterPosition().getRow(), ((MazeMonster)(this.maze)).getMonsterPosition().getCol() + 1))) {
            potentialMoves.add(new Coordinate(((MazeMonster)(this.maze)).getMonsterPosition().getRow(), ((MazeMonster)(this.maze)).getMonsterPosition().getCol() + 1));
        }
        if(this.maze.isValidPlay(new Coordinate(((MazeMonster)(this.maze)).getMonsterPosition().getRow() + 1, ((MazeMonster)(this.maze)).getMonsterPosition().getCol()))) {
            potentialMoves.add(new Coordinate(((MazeMonster)(this.maze)).getMonsterPosition().getRow() + 1, ((MazeMonster)(this.maze)).getMonsterPosition().getCol()));
        }
        if(this.maze.isValidPlay(new Coordinate(((MazeMonster)(this.maze)).getMonsterPosition().getRow(), ((MazeMonster)(this.maze)).getMonsterPosition().getCol() - 1))) {
            potentialMoves.add(new Coordinate(((MazeMonster)(this.maze)).getMonsterPosition().getRow(), ((MazeMonster)(this.maze)).getMonsterPosition().getCol() - 1));
        }
        if(this.maze.isValidPlay(new Coordinate(((MazeMonster)(this.maze)).getMonsterPosition().getRow() - 1, ((MazeMonster)(this.maze)).getMonsterPosition().getCol()))) {
            potentialMoves.add(new Coordinate(((MazeMonster)(this.maze)).getMonsterPosition().getRow() - 1, ((MazeMonster)(this.maze)).getMonsterPosition().getCol()));
        }
        if(potentialMoves.isEmpty()) {
            throw new UnsupportedOperationException("Monster cannot move");
        }
        MonsterBotRandomWithView.botMove = potentialMoves.get((int)(Math.random() * potentialMoves.size()));
        notifyObservers();
        return null;
    }
}