package fr.univlille.info.G3.model.maze;

import java.util.ArrayList;
import java.util.List;

import fr.univlille.info.G3.model.perception.CellEvent;
import fr.univlille.info.G3.model.perception.Coordinate;
import fr.univlille.info.G3.utils.Utils;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent.CellInfo;

public abstract class Maze {

    /**
     * Board containing known information
     */
    protected Cell[][] board;

    /**
     * Current turn
     */
    protected int turn = 0;

    public abstract boolean isValidPlay(ICoordinate move);

    /**
     * Get the cell corresponding to the coordinates
     * @param position
     * @return Cell
     */
    protected Cell getCell(ICoordinate coordinate) {
        if(!isInsideMaze(coordinate)) {
            throw new IllegalArgumentException("Specified coordinate (" + coordinate + ") is outside the maze");
        }
        return board[coordinate.getRow()][coordinate.getCol()];
    }

    public CellInfo getCellGroundInfo(ICoordinate coordinate) {
        return this.getCell(coordinate).getGroundInfo();
    }

    /**
     * Return what turn it is
     * @return int
     */
    public int getTurn() {
        return this.turn;
    }

    /**
     * Get the number of rows
     * @return int
     */
    public int getRowNb() {
        return this.board.length;
    }

    /**
     * Get the number of columns
     * @return
     */
    public int getColNb() {
        return this.board[0].length;
    }

    /**
     * Get the ground info of the Coordinates
     * @return CellInfo - null if unknow
     */
    public CellInfo getGroundInfo(ICoordinate coordinate) {
        return this.getCell(coordinate).getGroundInfo();
    }

    /**
     * Get the turn of the last monster presence on the Cell, return -1 if the monster never went on the cell
     * @return int
     */
    public int getLastMonsterPresence(ICoordinate coordinate) {
        return this.getCell(coordinate).lastMonsterPresence();
    }

    /**
     * Get the turn of the last hunter shot on the Cell, return -1 if the cell was never shot
     * @return int
     */
    public int getLastHunterShot(ICoordinate coordinate) {
        return this.getCell(coordinate).lastHunterShot();
    }

    public boolean isInsideMaze(int row, int col) {
        if(row < 0 || col < 0 || row >= this.getRowNb() || col >= this.getColNb()) {
            return false;
        }
        return true;
    }

    /**
     * Update the maze according the the event
     * @param event
     */
    public boolean updateMaze(ICellEvent event) {
        if (event.getCoord() == null) return false;
        this.getCell(event.getCoord()).applyEvent(event);
        return true;
    }

    /**
     * Update the maze according the the event
     * @param event
     */
    public boolean playMaze(ICoordinate coordinate, CellInfo info) {
        if(coordinate == null) {
            throw new IllegalArgumentException("coordinate is null");
        }
        this.turn++;
        System.out.println(this.getClass().getSimpleName() + " : Passed to turn " + this.getTurn());
        if(!this.isValidPlay(coordinate)) {
            return false;
        }
        this.updateMaze(new CellEvent(coordinate, info, turn));
        return true;
    }

    /**
     * Check if the coordinates are inside the maze
     * @param position
     * @return boolean
     */
    public boolean isInsideMaze(ICoordinate position) {
        return (position.getRow() >= 0) && (position.getRow() < this.getRowNb()) && 
        (position.getCol() >= 0) && (position.getCol() < this.getColNb());
    }


    public List<ICoordinate> getNeighbourgs(ICoordinate coordinates) {
        List<ICoordinate> neighbourg = new ArrayList<ICoordinate>();
        try {
            ICoordinate testedCoordinates;
            testedCoordinates = new Coordinate(coordinates.getRow(), coordinates.getCol() + 1);
            if(this.isInsideMaze(testedCoordinates)) {
                neighbourg.add(testedCoordinates);
            }
            testedCoordinates = new Coordinate(coordinates.getRow() + 1, coordinates.getCol());
            if(this.isInsideMaze(testedCoordinates)) {
                neighbourg.add(testedCoordinates);
            }
            testedCoordinates = new Coordinate(coordinates.getRow(), coordinates.getCol() - 1);
            if(this.isInsideMaze(testedCoordinates)) {
                neighbourg.add(testedCoordinates);
            }
            testedCoordinates = new Coordinate(coordinates.getRow() - 1, coordinates.getCol());
            if(this.isInsideMaze(testedCoordinates)) {
                neighbourg.add(testedCoordinates);
            }
        } catch (Exception e) {}
        
        return neighbourg;
    }



    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n" + this.getClass().getSimpleName() + ": \n");
        sb.append("------------------------------------------\n");
        for (int i = 0; i < this.board.length; i++) {
            sb.append("|");
            for (int j = 0; j < this.board[0].length; j++) {
                ICoordinate coordinate = new Coordinate(i, j);
                if(this.getLastMonsterPresence(coordinate) > -1 && this.getLastMonsterPresence(coordinate) >= this.turn) {
                    sb.append(Utils.getCellChar(CellInfo.MONSTER) + " ");
                } else if(this.getLastHunterShot(coordinate) > -1 && this.getLastHunterShot(coordinate) >= this.turn) {
                    sb.append(Utils.getCellChar(CellInfo.HUNTER) + " ");
                } else {
                    sb.append(Utils.getCellChar(this.getGroundInfo(coordinate)) + " ");
                }
                
            }
            sb.append("|\n");
        }
        sb.append("------------------------------------------\n");
        return sb.toString();
    }

    public ICoordinate getExit() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) { 
                if(this.getCellGroundInfo(new Coordinate(i, j)).equals(CellInfo.EXIT)) {
                    return new Coordinate(i, j);
                }
            }
        }
        return null;
    }

    public ICoordinate getMonsterPosition() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) { 
                if(this.getLastMonsterPresence(new Coordinate(i, j)) > -1 && this.getLastMonsterPresence(new Coordinate(i, j)) >= this.turn) {
                    return new Coordinate(i, j);
                }
            }
        }
        return null;
    }

    public boolean[][] getWalls(){
        boolean[][] walls = new boolean[this.getRowNb()][this.getColNb()];
        for(int i = 0; i < this.getRowNb(); i++) {
            for(int j = 0; j < this.getColNb(); j++) {
                walls[i][j] = this.getCell(new Coordinate(i, j)).getGroundInfo().equals(CellInfo.WALL);
            }
        }
        return walls;
    }

    public boolean isWall(ICoordinate coordinate) {
        return this.getCell(coordinate).getGroundInfo().equals(CellInfo.WALL);
    }


    public ICoordinate getNorthWall(ICoordinate coordinate) {
        ICoordinate northWall = new Coordinate(coordinate.getRow() - 1, coordinate.getCol());
        if(this.isInsideMaze(northWall) && this.isWall(northWall)) {
            return northWall;
        }
        return null;
    }

    public ICoordinate getSouthWall(ICoordinate coordinate) {
        ICoordinate southWall = new Coordinate(coordinate.getRow() + 1, coordinate.getCol());
        if(this.isInsideMaze(southWall) && this.isWall(southWall)) {
            return southWall;
        }
        return null;
    }

    public ICoordinate getEastWall(ICoordinate coordinate) {
        ICoordinate eastWall = new Coordinate(coordinate.getRow(), coordinate.getCol() + 1);
        if(this.isInsideMaze(eastWall) && this.isWall(eastWall)) {
            return eastWall;
        }
        return null;
    }

    public ICoordinate getWestWall(ICoordinate coordinate) {
        ICoordinate westWall = new Coordinate(coordinate.getRow(), coordinate.getCol() - 1);
        if(this.isInsideMaze(westWall) && this.isWall(westWall)) {
            return westWall;
        }
        return null;
    }


    public int getCellWeigthToExit(ICoordinate coordinate) {
        int weigth = 0;
        ICoordinate exit = this.getExit();
        if(exit == null) {
            return -1;
        }
        
        if(coordinate.getRow() < exit.getRow()) {
            weigth += exit.getRow() - coordinate.getRow();
        } else {
            weigth += coordinate.getRow() - exit.getRow();
        }

        if(coordinate.getCol() < exit.getCol()) {
            weigth += exit.getCol() - coordinate.getCol();
        } else {
            weigth += coordinate.getCol() - exit.getCol();
        }
        return weigth;
    }



}
