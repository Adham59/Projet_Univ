package fr.univlille.info.G3.model.maze;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.univlille.info.G3.model.perception.Coordinate;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

public class MazeHunterTest {

    private MazeHunter mazeHunter;
    private final int rows = 5;
    private final int cols = 5;

    @BeforeEach
    public void setUp() {
        mazeHunter = new MazeHunter(rows, cols);
    }

    @Test
    public void testMazeHunterConstruction() {
        assertNotNull(mazeHunter);
        assertEquals(rows, mazeHunter.getRowNb());
        assertEquals(cols, mazeHunter.getColNb());
    }

    @Test
    public void testIsValidPlay() {
        ICoordinate validMove = new Coordinate(2, 3);
        assertTrue(mazeHunter.isValidPlay(validMove));

        ICoordinate invalidMove = new Coordinate(6, 6);
        assertFalse(mazeHunter.isValidPlay(invalidMove));
    }

    @Test
    public void testUpdateMaze() {
        ICoordinate eventCoordinate = new Coordinate(2, 2);
        ICellEvent cellEvent = new ICellEvent() {
            @Override
            public ICoordinate getCoord() {
                return eventCoordinate;
            }

            @Override
            public CellInfo getState() {
                return CellInfo.HUNTER;
            }

            @Override
            public int getTurn() {
                return 1;
            }
        };

        assertTrue(mazeHunter.updateMaze(cellEvent));
    }
}
