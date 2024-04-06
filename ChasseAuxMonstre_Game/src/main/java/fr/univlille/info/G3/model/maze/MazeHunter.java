package fr.univlille.info.G3.model.maze;

import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

public class MazeHunter extends Maze {

    /**
     * Constructor - Create new maze according to dimensions
     * @param rows
     * @param cols
     */
    public MazeHunter(int rows, int cols) {
        this.board = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    @Override
    public boolean isValidPlay(ICoordinate move) {
        return this.isInsideMaze(move);
    }
    
}