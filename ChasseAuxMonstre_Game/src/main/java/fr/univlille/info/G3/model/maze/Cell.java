package fr.univlille.info.G3.model.maze;

import java.util.List;
import java.util.ArrayList;

import fr.univlille.iutinfo.cam.player.perception.ICellEvent;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent.CellInfo;

/**
* Implementation of the ICellevent interface
*/
public class Cell {

    /**
     * Info about the Cell Ground
     */
    private CellInfo groundInfo;

    /**
     * Events which happened on the cell
     */
    private List<ICellEvent> events;


    /**
     * Main Constructor
     * @param groundInfo - ground info of the cell, cannot be CellInfo.HUNTER or CellInfo.MONSTER
     */
    public Cell(CellInfo groundInfo) {
        // Check argument validity
        if(groundInfo == CellInfo.HUNTER || groundInfo == CellInfo.MONSTER) {
            throw new IllegalArgumentException("Cannot create Cell with groundInfo as MONSTER or HUNTER (" + groundInfo + ")");
        }
        // Set attributes
        this.groundInfo = groundInfo;
        this.events = new ArrayList<ICellEvent>();
    }

    /**
     * Constructor
     */
    public Cell() {
        this(null);
    }

    /**
     * Get the ground info of the Cell
     * @return CellInfo - null if unknow
     */
    public CellInfo getGroundInfo() {
        return this.groundInfo;
    }

    /**
     * Set the ground info of the Cell
     * @param groundInfo
     */
    public void setGroundInfo(CellInfo groundInfo) {
        if(groundInfo == CellInfo.HUNTER || groundInfo == CellInfo.MONSTER) {
            throw new IllegalArgumentException("Cannot set groundInfo to MONSTER or HUNTER (" + groundInfo + ")");
        }
        this.groundInfo = groundInfo;
    }

    /**
     * Get the list event corresponding to info
     * @param info
     * @return List<ICellEvent>
     */
    private List<ICellEvent> correspondingEvents(CellInfo info) {
        List<ICellEvent> correspondingEvents = new ArrayList<ICellEvent>();
        for (ICellEvent event : this.events) {
            if(event.getState() == info) {
                correspondingEvents.add(event);
            }
        }
        return correspondingEvents;
    }

  
    /**
     * Get the turn of the last event corresponding to info, return -1 if no corresponding event found
     * @param info
     * @return int
     */
    private int lastCorrespondingEvents(CellInfo info) {
        List<ICellEvent> correspondingEvents = this.correspondingEvents(info);
        int lastCorespondingEvent = -1;
        for (ICellEvent cellEvent : correspondingEvents) {
            if(cellEvent.getTurn() > lastCorespondingEvent) {
                lastCorespondingEvent = cellEvent.getTurn();
            }
        }
        return lastCorespondingEvent;
    }

    /**
     * Get the turn of the last monster presence on the Cell, return -1 if the monster never went on the cell
     * @return int
     */
    public int lastMonsterPresence() {
        return this.lastCorrespondingEvents(CellInfo.MONSTER);
    }

    /**
     * Get the turn of the last hunter shot on the Cell, return -1 if the cell was never shot
     * @return int
     */
    public int lastHunterShot() {
        return this.lastCorrespondingEvents(CellInfo.HUNTER);
    }

    /**
     * Apply event on the cell
     * @param event
     * @return boolean
     */
    public void applyEvent(ICellEvent event) {
        if(event == null) {
            throw new IllegalArgumentException("Cannot apply null event");
        }
        // If event state monster or hunter
        if(event.getState() == CellInfo.MONSTER || event.getState() == CellInfo.HUNTER) {
            // Verify turn is not negative
            if(event.getTurn() < 0) {
                throw new IllegalArgumentException("Cannot apply monster or hunter event if turn is negative (" + event + ")");
            }
            // Apply event
            this.events.add(event);
        // Update ground
        } else {
            this.setGroundInfo(event.getState());
        }
        
    }

    @Override
    public String toString() {
        return "[" + this.groundInfo + ", " + this.events + "]";
    }


}