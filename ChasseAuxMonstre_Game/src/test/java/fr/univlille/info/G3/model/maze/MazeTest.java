package fr.univlille.info.G3.model.maze;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.univlille.info.G3.model.perception.Coordinate;

public class MazeTest {

    private Maze maze;
    private final int rows = 5;
    private final int cols = 5;
    private boolean[][] walls;

    @BeforeEach
    public void setUp() {
        maze = new MazeHunter(rows, cols);
        walls = new boolean[][] {
            {false, true, false, false, false},
            {false, false, false, false, false},
            {false, false, false, false, false},
            {false, false, false, false, false},
            {false, false, false, false, false}
        };
    }

    @Test
    public void testMazeConstruction() {
        assertNotNull(maze);
        assertEquals(rows, maze.getRowNb());
        assertEquals(cols, maze.getColNb());
    }

    @Test
    public void testMazeWalls() {
        //Maze mazeWithWalls = new MazeMonster(walls);
        for (int i = 0; i < walls.length; i++) {
            for (int j = 0; j < walls[i].length; j++) {

            }
        }
    }

    @Test
    public void testGetCell() {
        //ICoordinate coord = new Coordinate(0, 0);

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testNextTurn() {

    }

    @Test
    public void testIsInsideMaze() {
        assertTrue(maze.isInsideMaze(new Coordinate(0, 0)));
        assertFalse(maze.isInsideMaze(new Coordinate(0, 5)));
        assertTrue(maze.isInsideMaze(new Coordinate(4, 4)));
    }


}
