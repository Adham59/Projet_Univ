package fr.univlille.info.G3.model.game;

import java.util.List;

import fr.univlille.info.G3.model.perception.Coordinate;

public class GameLoader {
    private String monsterName;
    private String hunterName;
    private List<Coordinate> HunterPosition;
    private List<Coordinate> MonsterPosition;

    public GameLoader(String monsterName, String hunterName, List<Coordinate> hunterPosition,
            List<Coordinate> monsterPosition) {
        this.monsterName = monsterName;
        this.hunterName = hunterName;
        HunterPosition = hunterPosition;
        MonsterPosition = monsterPosition;
    }

    public String getMonsterName() {
        return monsterName;
    }
    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }
    public String getHunterName() {
        return hunterName;
    }
    public void setHunterName(String hunterName) {
        this.hunterName = hunterName;
    }
    public List<Coordinate> getHunterPosition() {
        return HunterPosition;
    }
    public void setHunterPosition(List<Coordinate> hunterPosition) {
        HunterPosition = hunterPosition;
    }
    public List<Coordinate> getMonsterPosition() {
        return MonsterPosition;
    }
    public void setMonsterPosition(List<Coordinate> monsterPosition) {
        MonsterPosition = monsterPosition;
    }

    
}
