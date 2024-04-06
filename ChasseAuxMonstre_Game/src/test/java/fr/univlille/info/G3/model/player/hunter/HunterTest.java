package fr.univlille.info.G3.model.player.hunter;

import fr.univlille.iutinfo.cam.player.perception.ICoordinate;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent.CellInfo;
import fr.univlille.info.G3.model.maze.Maze;
import fr.univlille.info.G3.model.maze.MazeHunter;
import fr.univlille.info.G3.model.perception.CellEvent;
import fr.univlille.info.G3.model.perception.Coordinate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HunterTest {

    private Hunter hunter;

    @BeforeEach
    public void setUp() {
        hunter = new Hunter() {
            @Override
            public void initialize(int nbRows, int nbCols) {
                this.maze = new MazeHunter(nbRows, nbCols);
            }
        };
        hunter.initialize(5, 5);
    }

    @Test
    public void testPlayMoveValid() {
        ICoordinate validMove = new Coordinate(2, 3);
        assertTrue(hunter.playMove(validMove));
    }

    @Test
    public void testPlayMoveInvalid() {
        ICoordinate invalidMove = new Coordinate(6, 6);  
        assertFalse(hunter.playMove(invalidMove));
    }

    @Test
    public void testIsValidSelection() {
        ICoordinate validMove = new Coordinate(1, 1);
        assertTrue(hunter.maze.isValidPlay(validMove));

        ICoordinate invalidMove = new Coordinate(6, 6); 
        assertFalse(hunter.maze.isValidPlay(invalidMove));
    }

    @Test
    public void testUpdateMaze() {
        Maze maze = new MazeHunter(5, 5);

        ICoordinate eventCoordinate = new Coordinate(2, 2);
        CellEvent cellEvent = new CellEvent(eventCoordinate, CellInfo.MONSTER,0);

        assertTrue(maze.updateMaze(cellEvent));

        //assertEquals(CellInfo.MONSTER, maze.getCurrentCellState(eventCoordinate));
    }
}
