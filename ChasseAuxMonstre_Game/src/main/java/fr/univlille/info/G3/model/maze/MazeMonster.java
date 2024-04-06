package fr.univlille.info.G3.model.maze;

import fr.univlille.iutinfo.cam.player.perception.ICellEvent.CellInfo;
import fr.univlille.info.G3.model.game.Parameter;
import fr.univlille.info.G3.model.perception.Coordinate;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

public class MazeMonster extends Maze {

    /**
     * Monster current
     */
    protected ICoordinate monsterPosition;

    /**
     * Constructor - Create new maze according to walls tab, true for wall, false for empty
     * @param walls
     */

     public ICoordinate getMonsterPosition() {
        return monsterPosition;
    }
    public MazeMonster(boolean[][] walls) {
        this.board = new Cell[walls.length][walls[0].length];
        for (int i = 0; i < walls.length; i++) {
            for (int j = 0; j < walls[0].length; j++) {
                if(walls[i][j]) {
                    this.board[i][j] = new Cell(CellInfo.WALL);
                } else {
                    this.board[i][j] = new Cell(CellInfo.EMPTY);
                }
            }
        }
    }


    public void setMonsterPosition(ICoordinate monsterPosition) {
        this.monsterPosition = monsterPosition;
    }


    @Override
    public boolean isValidPlay(ICoordinate move) {


        if(this.getCellGroundInfo(move) == CellInfo.WALL) {
            System.out.println("INFO : " + this.getClass().getSimpleName() + " : Monster tried to move on a wall");
            this.turn--;
            return false;
        }
        if(!this.isInsideMaze(move)) {
            System.out.println("INFO : " + this.getClass().getSimpleName() + " : Monster tried to move outside the maze");
            this.turn--;
            return false;
        }

        if(!Parameter.isDiagonaleDeplacementPossible()){
            Coordinate delta = new Coordinate(Math.abs(this.monsterPosition.getRow() - move.getRow()), Math.abs(this.monsterPosition.getCol() - move.getCol()));

            if (delta.getRow() + delta.getCol() != 1) {
                System.out.println("INFO : " + this.getClass().getSimpleName() + " : Monster in diagonal");
                this.turn--;
                return false;
            }
        }
        if(Parameter.isDiagonaleDeplacementPossible()) {
            if(move.getRow() == this.monsterPosition.getRow() || move.getCol() == this.monsterPosition.getCol()){
                return true;
            }
            if(move.getRow() == this.monsterPosition.getRow() + 1 && move.getCol() == this.monsterPosition.getCol() + 1) {
                if(this.getCellGroundInfo(new Coordinate(this.monsterPosition.getRow() + 1, this.monsterPosition.getCol())) == CellInfo.WALL) {
                    this.turn--;
                    return false;
                }
                if(this.getCellGroundInfo(new Coordinate(this.monsterPosition.getRow(), this.monsterPosition.getCol() + 1)) == CellInfo.WALL) {
                    this.turn--;
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public boolean updateMaze(ICellEvent event) {
        if (event.getCoord() == null) return false;
        if(event.getState() == CellInfo.MONSTER) {
            this.monsterPosition = event.getCoord();
        }
        this.getCell(event.getCoord()).applyEvent(event);
        return true;
    }

    public ICoordinate getExit() {
        for(int i = 0; i < this.getRowNb(); i++){
            for(int j = 0; j < this.getColNb(); j++){
                if(this.getGroundInfo(new Coordinate(i, j)) == CellInfo.EXIT){
                    return new Coordinate(i, j);
                }
            }
        }
        return null;   
    }
}