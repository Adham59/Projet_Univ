package fr.univlille.info.G3.model.player.hunter;


import java.util.List;

import fr.univlille.info.G3.model.maze.MazeHunter;
import fr.univlille.info.G3.model.perception.Coordinate;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

public class HunterBotClever extends Hunter {

    @Override
    public void initialize(int nbRows, int nbCols) {
        this.maze = new MazeHunter(nbRows, nbCols);
    }


    @Override
    public ICoordinate play() {

        ICoordinate higherTurnMonster = new Coordinate(0, 0);

        //Parmi ces cellules, on cherche celle qui a ete touchee le plus tard

        for(int i = 0; i < this.maze.getRowNb(); i++) {
            for (int j = 0; j < this.maze.getColNb(); j++) {
                if(this.maze.getLastMonsterPresence(new Coordinate(i, j)) > this.maze.getLastMonsterPresence(higherTurnMonster)) {
                    higherTurnMonster = new Coordinate(i, j);
                }
            }
        }

        if(this.maze.getLastMonsterPresence(higherTurnMonster) < 0) {
            return new Coordinate((int)(Math.random() * this.maze.getRowNb()), (int)(Math.random() * this.maze.getColNb()));
        }

        List<ICoordinate> neighbourgs = this.maze.getNeighbourgs(higherTurnMonster);

        if(neighbourgs.isEmpty()) {
            return new Coordinate((int)(Math.random() * this.maze.getRowNb()), (int)(Math.random() * this.maze.getColNb()));
        }

        
        return neighbourgs.get((int)(Math.random() * neighbourgs.size()));
    }


}