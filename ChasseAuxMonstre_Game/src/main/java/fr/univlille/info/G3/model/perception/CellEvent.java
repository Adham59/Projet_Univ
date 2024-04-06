package fr.univlille.info.G3.model.perception;


import fr.univlille.iutinfo.cam.player.perception.ICellEvent;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

/**
 * Implementation of the ICoordinate interface
 */
public class CellEvent implements ICellEvent {

    /**
     * Coordinates of the cell
     */
    private ICoordinate coordinate;

    /**
     * State of the cell
     */
    private CellInfo info;

    /**
     * Turn at at which the action happened, default is -1
     */
    private int turn;

    /**
     * Constructor
     * @param coordinate - Cannot be null
     * @param state - Cannot be null
     * @param turn
     */
    public CellEvent(ICoordinate coordinate, CellInfo state, int turn) {
        // Check arguments validity
        if(coordinate == null) {
            throw new IllegalArgumentException("Cannot create CellEvent with null coordinate");
        }
        if(state == null) {
            throw new IllegalArgumentException("Cannot create CellEvent with null state");
        }
        // Set attributes
        this.coordinate = coordinate;
        this.info = state;
        this.turn = turn;
    }

    /**
     * Constructor
     * @param coordinate - Cannot be null
     * @param state - Cannot be null
     */
    public CellEvent(ICoordinate coordinate, CellInfo state) {
        this(coordinate, state, -1);
    }

    /**
     * Get the coordinate of the event
     * @return ICoordinate
     */
    @Override
    public ICoordinate getCoord() {
        return this.coordinate;
    }

    /**
     * Get the state of the event
     * @return CellInfo
     */
    @Override
    public CellInfo getState() {
        return this.info;
    }

    /**
     * Get the turn at which the event happened, default is -1
     * @return boolean
     */
    @Override
    public int getTurn() {
        return this.turn;
    }

    /**
     * Create a String of the CellEvent instance
     * @return String
     */
    @Override
    public String toString() {
        return "[" + this.coordinate +  ", " + this.info + ", " + this.turn + "]";
    }
}