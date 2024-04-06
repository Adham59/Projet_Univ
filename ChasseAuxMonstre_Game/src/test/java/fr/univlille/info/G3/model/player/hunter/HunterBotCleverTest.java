package fr.univlille.info.G3.model.player.hunter;

import org.junit.jupiter.api.Test;

import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HunterBotCleverTest {

    @Test
    public void testPlayWithNoCellGettingShot() {
        HunterBotClever hunterBot = new HunterBotClever();
        hunterBot.initialize(5, 5);

        ICoordinate result = hunterBot.play();

        assertTrue(result.getRow() >= 0 && result.getRow() < 5);
        assertTrue(result.getCol() >= 0 && result.getCol() < 5);
    }

}
