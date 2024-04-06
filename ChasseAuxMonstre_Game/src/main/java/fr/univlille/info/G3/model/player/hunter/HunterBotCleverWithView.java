package fr.univlille.info.G3.model.player.hunter;


import java.util.ArrayList;
import java.util.List;

import fr.univlille.info.G3.model.maze.MazeHunter;
import fr.univlille.info.G3.model.perception.Coordinate;
import fr.univlille.info.G3.view.player.PlayerView;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent.CellInfo;

public class HunterBotCleverWithView extends Hunter {

    private static ICoordinate botMove;

    public static ICoordinate getBotMove() {
        return botMove;
    }

    @Override
    public void initialize(int nbRows, int nbCols) {
        this.maze = new MazeHunter(nbRows, nbCols);
        new PlayerView(this);
    }


    @Override
    public ICoordinate play() {
        ICoordinate co = new Coordinate((int)(Math.random() * this.maze.getRowNb()), (int)(Math.random() * this.maze.getColNb()));

        if(this.maze.getGroundInfo(co) == CellInfo.WALL) {
            return co;
        }
        
        
        // Recuperation des cellules qui ont ete touchees par le chasseur

        List<ICoordinate> celluleGettingShot = new ArrayList<ICoordinate>();

        for(int i = 0; i < this.maze.getRowNb(); i++) {
            for (int j = 0; j < this.maze.getColNb(); j++) {
                if(this.maze.getLastHunterShot(new Coordinate(i, j)) != -1) {
                    celluleGettingShot.add(new Coordinate(i, j));
                }
            }
        }

        if(celluleGettingShot.size() == 0) {
            return co;
        }

        int higherTurnMonster = 0;

        //Parmi ces cellules, on cherche celle qui a ete touchee le plus tard

        for(ICoordinate c : celluleGettingShot) {
            if(this.maze.getLastMonsterPresence(c) > higherTurnMonster) {
                higherTurnMonster = this.maze.getLastMonsterPresence(c);
                co = new Coordinate(c.getRow(), c.getCol());
            }
        }

        List<ICoordinate> neighbourgs = this.maze.getNeighbourgs(co);


        //Parmis la cellule touchee le plus tard, on cherche celle qui a ete touchee le plus tard par le monstre

        for(ICoordinate c : neighbourgs) {
            if(this.maze.getLastMonsterPresence(c) > higherTurnMonster) {
                higherTurnMonster = this.maze.getLastMonsterPresence(c);
                co = new Coordinate(c.getRow(), c.getCol());
            }
        }
        HunterBotCleverWithView.botMove = co;
        notifyObservers();
        return null;
    }


}