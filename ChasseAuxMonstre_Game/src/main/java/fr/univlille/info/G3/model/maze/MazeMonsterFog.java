package fr.univlille.info.G3.model.maze;

public class MazeMonsterFog extends MazeMonster {
    
    public MazeMonsterFog(boolean[][] walls) {
        super(walls);
        this.board = new Cell[walls.length][walls[0].length];
        for (int i = 0; i < walls.length; i++) {
            for (int j = 0; j < walls[0].length; j++) {
                this.board[i][j] = new Cell();
            }
        }
    }

}
