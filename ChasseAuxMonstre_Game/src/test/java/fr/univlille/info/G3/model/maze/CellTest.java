package fr.univlille.info.G3.model.maze;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.univlille.iutinfo.cam.player.perception.ICellEvent.CellInfo;
import fr.univlille.info.G3.model.perception.CellEvent;
import fr.univlille.info.G3.model.perception.Coordinate;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    private ICoordinate coordinate;
    private Cell c1;
    private Cell c2;

    @BeforeEach
    public void init() {
        this.coordinate = new Coordinate(0, 0);
        this.c1 = new Cell(CellInfo.EMPTY);
        this.c2 = new Cell();
        this.c1.applyEvent(new CellEvent(this.coordinate, CellInfo.MONSTER, 42));
        this.c2.applyEvent(new CellEvent(this.coordinate, CellInfo.HUNTER, 42));
    }

    @Test
    public void testConstructorException() {
        // Correct arguments
        assertDoesNotThrow(() -> {new Cell(CellInfo.WALL);});
        assertDoesNotThrow(() -> {new Cell(null);});
        // Cellinfo is wrong
        assertThrows(IllegalArgumentException.class, () -> {new Cell(CellInfo.MONSTER);});
        assertThrows(IllegalArgumentException.class, () -> {new Cell(CellInfo.HUNTER);});
    }

    @Test
    public void testGetGroundInfo() {
        assertEquals(CellInfo.EMPTY, c1.getGroundInfo());
        assertNull(c2.getGroundInfo());
    }

    @Test
    public void testSetGroundInfo() {
        c1.setGroundInfo(CellInfo.WALL);
        assertEquals(CellInfo.WALL, c1.getGroundInfo());
    }

    @Test
    public void testSetGroundInfoException() {
        assertDoesNotThrow(() -> {c1.setGroundInfo(CellInfo.WALL);;});
        assertThrows(IllegalArgumentException.class, () -> {new Cell(CellInfo.MONSTER);});
        assertThrows(IllegalArgumentException.class, () -> {new Cell(CellInfo.HUNTER);});
    }

    @Test
    public void lastMonsterPresence() {
        assertEquals(42, c1.lastMonsterPresence());
    }

    @Test
    public void lastHunterShot() {
        assertEquals(42, c2.lastHunterShot());
    }


    @Test
    public void testApplyEvent() {
        assertEquals(-1, c1.lastHunterShot());
        c1.applyEvent(new CellEvent(this.coordinate, CellInfo.HUNTER, 64));
        assertEquals(64, c1.lastHunterShot());
    }

    @Test
    public void testApplyEventException() {;
        assertThrows(IllegalArgumentException.class, () -> {c1.applyEvent(null);});
        assertThrows(IllegalArgumentException.class, () -> {c1.applyEvent(new CellEvent(new Coordinate(1, 0), CellInfo.MONSTER));});
    }

    @Test
    public void testToString() {
        assertEquals("[EMPTY, [[(0, 0), MONSTER, 42]]]", c1.toString());
    }

}