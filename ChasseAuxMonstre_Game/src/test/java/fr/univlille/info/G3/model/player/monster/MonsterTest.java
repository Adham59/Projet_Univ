package fr.univlille.info.G3.model.player.monster;

import fr.univlille.info.G3.model.maze.MazeMonster;
import fr.univlille.info.G3.model.perception.CellEvent;
import fr.univlille.info.G3.model.perception.Coordinate;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent.CellInfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest {

    private Monster monster;

    @BeforeEach
    public void setUp() {
        monster = new Monster() {
            @Override
            public void initialize(boolean[][] walls) {
                this.maze = new MazeMonster(walls);
                ICoordinate initialMonsterPosition = new Coordinate(0, 0);
                ((MazeMonster) this.maze).setMonsterPosition(initialMonsterPosition);
            }
        };
        boolean[][] walls = {
                { false, false, false, false, false },
                { false, true, false, true, false },
                { false, true, false, true, false },
                { false, true, false, true, false },
                { false, false, false, false, false }
        };
        monster.initialize(walls);
    }

    /*
     * @Test
     * public void testPlayMoveValid() {
     * ICoordinate validMove = new Coordinate(1, 0);
     * assertTrue(monster.playMove(validMove));
     * }
     * 
     * @Test
     * public void testPlayMoveInvalid() {
     * ICoordinate invalidMove = new Coordinate(6, 6);
     * assertFalse(monster.playMove(invalidMove));
     * }
     * 
     * @Test
     * public void testIsValidSelection() {
     * ICoordinate validMove = new Coordinate(1, 0);
     * assertTrue(monster.maze.isValidPlay(validMove));
     * 
     * ICoordinate invalidMove = new Coordinate(1, 1);
     * assertFalse(monster.maze.isValidPlay(invalidMove));
     * }
     * 
     * @Test
     * public void testUpdateMaze() {
     * MazeMonster maze = new MazeMonster(new boolean[5][5]);
     * 
     * ICoordinate eventCoordinate = new Coordinate(2, 2);
     * CellEvent cellEvent = new CellEvent(eventCoordinate, CellInfo.HUNTER, 0);
     * 
     * assertTrue(maze.updateMaze(cellEvent));
     * 
     * // assertEquals(CellInfo.HUNTER, maze.getCurrentCellState(eventCoordinate));
     * }
     */
}
