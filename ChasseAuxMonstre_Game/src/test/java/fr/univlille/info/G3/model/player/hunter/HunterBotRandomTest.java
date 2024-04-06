package fr.univlille.info.G3.model.player.hunter;

import org.junit.jupiter.api.Test;

import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HunterBotRandomTest {

    @Test
    public void testPlay() {
        HunterBotRandom hunterBot = new HunterBotRandom();
        hunterBot.initialize(5, 5);

        ICoordinate move = hunterBot.play();

        assertNotNull(move, "The play method should return a non-null coordinate.");
        assertTrue(hunterBot.maze.isInsideMaze(move), "The coordinate should be inside the maze.");
    }
}
