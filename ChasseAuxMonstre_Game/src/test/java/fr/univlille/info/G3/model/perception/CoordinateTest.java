package fr.univlille.info.G3.model.perception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {

    private Coordinate coordinate;

    @BeforeEach
    public void init() {
        this.coordinate = new Coordinate(2, 4);
    }

    @Test
    public void testConstructorException() {
        assertDoesNotThrow(() -> {new Coordinate(0, 0);});
        assertThrows(IllegalArgumentException.class, () -> {new Coordinate(-1, 0);});
        assertThrows(IllegalArgumentException.class, () -> {new Coordinate(0, -1);});
    }

    @Test
    public void testCoordinateGetters() {
        assertEquals(2, this.coordinate.getRow());
        assertEquals(4, this.coordinate.getCol());
    }

    @Test
    public void testToString() {
        assertEquals("(2, 4)", this.coordinate.toString());
    }
}

