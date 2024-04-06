package fr.univlille.info.G3.model.perception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.univlille.iutinfo.cam.player.perception.ICellEvent.CellInfo;

import static org.junit.jupiter.api.Assertions.*;

public class CellEventTest {

    private Coordinate coordinate;
    private CellEvent event;

    @BeforeEach
    public void init() {
        this.coordinate = new Coordinate(1, 2);
        this.event = new CellEvent(coordinate, CellInfo.MONSTER, 42); 
    }

    @Test
    public void testConstructorException() {
        assertDoesNotThrow(() -> {new CellEvent(new Coordinate(1, 2), CellInfo.MONSTER, 42);});
        assertThrows(IllegalArgumentException.class, () -> {new CellEvent(null, CellInfo.MONSTER, 42);});
        assertThrows(IllegalArgumentException.class, () -> {new CellEvent(new Coordinate(1, 2), null, 42);});
    }

    @Test
    public void testGetters() {
        assertTrue(event.getCoord() == coordinate);
        assertEquals(CellInfo.MONSTER, event.getState());
        assertEquals(42, event.getTurn());
    }

    @Test
    public void testToString() {
        assertEquals("[(1, 2), MONSTER, 42]", this.event.toString());
    }
}

