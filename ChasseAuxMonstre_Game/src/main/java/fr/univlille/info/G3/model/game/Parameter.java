package fr.univlille.info.G3.model.game;

public class Parameter {

    private static String pseudoHunter = "hunter";
    private static String pseudoMonster = "monster";
    private static int mazeHorizontalSize = 20;
    private static int mazeVerticalSize = 12;
    private static double mazeWallSpawnRate = 0.2;
    private static boolean mapRandom = true;
    private static boolean mapFile = false;

    private static boolean isMonsterBot = false;
    private static boolean isHunterBot = false;


    private static boolean isMonsterAStarBot = false;
    private static boolean isMonsterRandomBot = false;

    private static boolean isHunterCleverBot = false;
    private static boolean isHunterRandomBot = false;

    private static boolean BotMonsterVue = false;
    private static boolean BotHunterVue = false; 

    private static boolean fogMode = false;
    private static int fogRange = 2;

    private static boolean diagonaleDeplacementPossible = false;


    public static void resetParameters() {

        Parameter.pseudoHunter = "hunter";
        Parameter.pseudoMonster = "monster";
        Parameter.mazeHorizontalSize = 20;
        Parameter.mazeVerticalSize = 12;
        Parameter.mazeWallSpawnRate = 0.2;
        Parameter.mapRandom = true;
        Parameter.mapFile = false;

        Parameter.isMonsterBot = false;
        Parameter.isHunterBot = false;


        Parameter.isMonsterAStarBot = false;
        Parameter.isMonsterRandomBot = false;

        Parameter.isHunterCleverBot = false;
        Parameter.isHunterRandomBot = false;

        Parameter.BotMonsterVue = false;
        Parameter.BotHunterVue = false; 

        Parameter.fogMode = false;
        Parameter.fogRange = 2;

        Parameter.diagonaleDeplacementPossible = false;
        
    }


    //Getter
    public static String getPseudoHunter() {
        return pseudoHunter;
    }

    public static String getPseudoMonster() {
        return pseudoMonster;
    }

    public static int getMazeHorizontalSize() {
        return mazeHorizontalSize;
    }

    public static int getMazeVerticalSize() {
        return mazeVerticalSize;
    }

    public static double getMazeWallSpawnRate() {
        return mazeWallSpawnRate;
    }

    public static boolean isMapRandom() {
        return mapRandom;
    }

    public static boolean isMapFile() {
        return mapFile;
    }

    public static boolean isFogMode() {
        return fogMode;
    }

    public static int getFogRange() {
        return fogRange;
    }

    public static boolean isMonsterAStarBot() {
        return isMonsterAStarBot;
    }


    public static boolean isMonsterRandomBot() {
        return isMonsterRandomBot;
    }

    public static boolean isHunterCleverBot() {
        return isHunterCleverBot;
    }

    public static boolean isHunterRandomBot() {
        return isHunterRandomBot;
    }

    public static boolean isMonsterBot() {
        return isMonsterBot;
    }

    public static boolean isHunterBot() {
        return isHunterBot;
    }

    public static boolean isBotMonsterVueOpen() {
        return BotMonsterVue;
    }

    public static boolean isBotHunterVueOpen() {
        return BotHunterVue;
    }

    public static boolean isDiagonaleDeplacementPossible() {
        return diagonaleDeplacementPossible;
    }




    //Setter

    public static void setDiagonaleDeplacementPossible(boolean diagonaleDeplacementPossible) {
        Parameter.diagonaleDeplacementPossible = diagonaleDeplacementPossible;
    }


    public static void setBotHunterVue(boolean BotHunterVue) {
        Parameter.BotHunterVue = BotHunterVue;
    }

    public static void setBotMonsterVue(boolean BotMonsterVue) {
        Parameter.BotMonsterVue = BotMonsterVue;
    }

    public static void setMonsterBot(boolean isMonsterBot) {
        Parameter.isMonsterBot = isMonsterBot;
    }

    public static void setHunterBot(boolean isHunterBot) {
        Parameter.isHunterBot = isHunterBot;
    }

    public static void setMonsterAStarBot(boolean isMonsterAStarBot) {
        Parameter.isMonsterAStarBot = isMonsterAStarBot;
    }

    public static void setMonsterRandomBot(boolean isMonsterRandomBot) {
        Parameter.isMonsterRandomBot = isMonsterRandomBot;
    }

    public static void setHunterCleverBot(boolean isHunterCleverBot) {
        Parameter.isHunterCleverBot = isHunterCleverBot;
    }

    public static void setHunterRandomBot(boolean isHunterRandomBot) {
        Parameter.isHunterRandomBot = isHunterRandomBot;
    }

    public static void setPseudoHunter(String pseudoHunter) {
        Parameter.pseudoHunter = pseudoHunter;
    }

    public static void setPseudoMonster(String pseudoMonster) {
        Parameter.pseudoMonster = pseudoMonster;
    }

    public static void setMazeHorizontalSize(int mazeHorizontalSize) {
        Parameter.mazeHorizontalSize = (int)mazeHorizontalSize;
    }

    public static void setMazeVerticalSize(int mazeVerticalSize) {
        Parameter.mazeVerticalSize = mazeVerticalSize;
    }

    public static void setMazeWallSpawnRate(double mazeWallSpawnRate) {
        Parameter.mazeWallSpawnRate = mazeWallSpawnRate;
    }
    
    public static void setMapRandom(boolean mapRandom) {
        Parameter.mapRandom = mapRandom;
    }

    public static void setMapFile(boolean mapFile) {
        Parameter.mapFile = mapFile;
    }

    public static void setFogMode(boolean fogMode) {
        Parameter.fogMode = fogMode;
    }

    public static void setFogRange(int fogRange) {
        Parameter.fogRange = fogRange;
    }

    public static void setMonsterVueBot(boolean b) {
        Parameter.BotMonsterVue = b;
    }

    public static void setHunterVueBot(boolean b) {
        Parameter.BotHunterVue = b;
    }
    

}
