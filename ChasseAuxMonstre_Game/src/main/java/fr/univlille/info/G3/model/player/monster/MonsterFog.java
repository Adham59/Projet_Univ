package fr.univlille.info.G3.model.player.monster;

import fr.univlille.info.G3.model.maze.MazeMonsterFog;
import fr.univlille.info.G3.view.player.PlayerView;

public class MonsterFog extends Monster {
     /**
     * Initialize the Monster
     */
    @Override
    public void initialize(boolean[][] walls) {
        this.maze = new MazeMonsterFog(walls);
        new PlayerView(this);
    }
}
