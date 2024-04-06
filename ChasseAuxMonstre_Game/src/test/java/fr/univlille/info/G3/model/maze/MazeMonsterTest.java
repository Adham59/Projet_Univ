package fr.univlille.info.G3.model.maze;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.univlille.info.G3.model.perception.CellEvent;
import fr.univlille.info.G3.model.perception.Coordinate;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent.CellInfo;

public class MazeMonsterTest {

    private MazeMonster mazeMonster;

    @BeforeEach
    public void setUp() {
        boolean[][] walls = {
                { false, false, false },
                { false, false, false },
                { false, false, false }
        };
        mazeMonster = new MazeMonster(walls);
        mazeMonster.setMonsterPosition(new Coordinate(0, 0));
    }

    @Test
    public void testIsValidPlayValidMove() {
        ICoordinate validMove = new Coordinate(1, 0);
        assertTrue(mazeMonster.isValidPlay(validMove));
    }

    @Test
    public void testIsValidPlayInvalidMoveOutsideMaze() {
        ICoordinate invalidMove = new Coordinate(4, 4);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            // Le code qui devrait lever l'exception
            mazeMonster.isValidPlay(invalidMove);
        });

        // Assertions supplémentaires sur l'exception (facultatif)
        assertEquals("Specified coordinate ((4, 4)) is outside the maze", exception.getMessage());
    }

    @Test
    public void testIsValidPlayInvalidMoveOnWall() {
        boolean[][] walls = {
                { false, true, false },
                { false, false, false },
                { false, false, false }
        };
        mazeMonster = new MazeMonster(walls);
        mazeMonster.setMonsterPosition(new Coordinate(0, 0));
        ICoordinate invalidMove = new Coordinate(0, 1);
        assertFalse(mazeMonster.isValidPlay(invalidMove));
    }

    @Test
    public void testIsValidPlayInvalidMoveDiagonal() {
        ICoordinate invalidMove = new Coordinate(1, 1);
        assertFalse(mazeMonster.isValidPlay(invalidMove));
    }

    @Test
    public void testUpdateMaze() {
        ICoordinate eventCoordinate = new Coordinate(1, 0);
        ICellEvent cellEvent = new CellEvent(eventCoordinate, CellInfo.MONSTER, 0);

        assertTrue(mazeMonster.updateMaze(cellEvent));

        assertEquals(eventCoordinate, mazeMonster.getMonsterPosition());
    }
}
