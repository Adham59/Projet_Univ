package fr.univlille.info.G3.model.perception;

import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

/**
 * Implementation of the ICoordinate interface
 */
public class Coordinate implements ICoordinate {
    
    /**
     * The row number
     */
    private int row;
    
    /**
     * The row number
     */
    private int col;
    
    /**
     * Constructor
     * @param row - Cannot be negative
     * @param col - Cannot be negative
     */
    public Coordinate(int row, int col) {
        // Check arguments validity
        if(row < 0 || col < 0) {
            throw new IllegalArgumentException("Cannot create Coordinate with negative values (row = " + row + ", col = " + col + ")" );
        }
        // Set attributes
        this.row = row;
        this.col = col;
    }

    /**
     * Get the row number
     * @return int
     */
    @Override
    public int getRow() {
        return this.row;
    }

    /**
     * Get the column number
     * @return int
     */
    @Override
    public int getCol() {
        return this.col;
    }
    
    /**
     * Create a String of the Coordinate instance
     * @return String
     */
    @Override
    public String toString() {
        return "(" + this.row + ", " + this.col + ")";
    }
}