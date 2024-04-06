package fr.univlille.info.G3.model.player;


import fr.univlille.info.G3.model.maze.Maze;
import fr.univlille.info.G3.utils.Subject;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

public abstract class Player extends Subject {

    public Maze maze;
    private static String pseudo;

    /**
     * Get the map of the player
     * @return Maze
     */
    public Maze getMap() {
        return this.maze;
    }

    /**
     * Get the pseudo for the Player
     */
    public static String getPseudo() {
        return Player.pseudo;
    }

    /**
     * Set the pseudo for the Player
     */
    public static void setPseudo(String newPseudo) {
        Player.pseudo = newPseudo;
    }

    /**
     * Update Monster maze with new information
     * @param event
     */
    public void update(ICellEvent event) {
        this.maze.updateMaze(event);
    }


    /**
     * Make the model play a move if valid, return false otherwise
     * @param move
     * @return boolean
     */
    public abstract boolean playMove(ICoordinate move);

    
}