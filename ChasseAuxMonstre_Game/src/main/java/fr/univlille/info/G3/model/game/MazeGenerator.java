package fr.univlille.info.G3.model.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.univlille.info.G3.model.perception.Coordinate;

public class MazeGenerator implements Serializable {

    /**
     * Map of the walls
     */
    private boolean[][] walls;

    /**
     * Exit of the maze
     */
    private Coordinate exit;

    /**
     * Starting position of the monster in the maze
     */
    private Coordinate monsterStartingPosition;

    /**
     * Get the walls of the maze
     * @return boolean[][]
     */
    public boolean[][] getWalls() {
        return this.walls;
    }

    /**
     * Get the exit of the maze
     * @return Coordinate
     */
    public Coordinate getExit() {
        return this.exit;
    }

    /**
     * Get the starting position of the monster in the maze
     * @return Coordinate
     */
    public Coordinate getMonsterStartingPosition() {
        return this.monsterStartingPosition;
    }

    /**
     * Constructor
     */
    public MazeGenerator() {

        if(Parameter.isMapFile()){
            this.generateMazeWithFiles();
        } else {
            this.generateRandomWalls();
        }
        this.generateRandomExit();
        this.generateMonsterStartingPosition();
    }

    public MazeGenerator(String[] mapNames) {
        throw new UnsupportedOperationException();
    }

    /**
     * Generate a random wall map for the maze
     */
    private void generateRandomWalls(){
        this.walls = new boolean[Parameter.getMazeVerticalSize()][Parameter.getMazeHorizontalSize()];
        for(int i = 1; i < this.walls.length - 1; i++) {
            for (int j = 2; j < this.walls[0].length - 1; j++) {
                this.walls[i][j] = Math.random() < Parameter.getMazeWallSpawnRate();
            }
        }
        for(int i = 0; i < walls[0].length; i++) {
            this.walls[0][i] = true;
            this.walls[this.walls.length - 1][i] = true;
        }
        for(int i = 0; i < this.walls.length; i++) {
            this.walls[i][0] = true;
            this.walls[i][walls[0].length - 1] = true;
        }
    }

    /**
     * Generate the exit of the maze
     */
    private void generateRandomExit() {
        if(Parameter.isMapFile()){
            int row = (int)(Math.random() * (this.walls.length - 2)) + 1;

            if(this.walls[row][this.walls[0].length - 2] == false){
                this.walls[row][this.walls[0].length - 1] = false;
                this.exit = new Coordinate(row, this.walls[0].length - 1);
            } else {
                this.walls[row][1] = false;
                this.exit = new Coordinate(row, 1);
            }

        }

        if(!Parameter.isMapFile()){
            int row = (int)(Math.random() * (this.walls.length - 2)) + 1;
            int col = (int)(Math.random() * (this.walls[0].length - 2 - (this.walls[0].length / 2))) + 1 + (this.walls[0].length / 2);
            walls[row][col] = false;
            this.exit = new Coordinate(row, col);
        }




    }

    /**
     * Generate the monster starting position in the maze
     */
    private void generateMonsterStartingPosition() {
        this.monsterStartingPosition = new Coordinate((int)(Math.random() * (this.walls.length - 2)) + 1, 1);
    }


    private boolean[][] generateMapWithFiles(String filePath){
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            int rows = 0;
            int cols = 0;

            // Comptez le nombre de lignes et la longueur maximale pour créer le tableau
            while ((line = br.readLine()) != null) {
                rows++;
                cols = Math.max(cols, line.length());
            }
            this.walls = new boolean[rows][cols];
            br.close();


            br = new BufferedReader(new FileReader(filePath));
            int row = 0;

            // Lisez le fichier à nouveau et remplissez le tableau
            while ((line = br.readLine()) != null) {
                for (int col = 0; col < line.length(); col++) {
                    char currentChar = line.charAt(col);
                    if(currentChar == '#'){
                        this.walls[row][col] = true;
                    }
                    if(currentChar == '*'){
                        this.walls[row][col] = false;
                    }
                }
                row++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.walls;
    }

    private String pickRandomMap(List<String> mapNames) {
        Random random = new Random();
        int randomIndex = random.nextInt(mapNames.size());
        String mapName = mapNames.get(randomIndex);
        return mapName;
    }

    public boolean[][] generateMazeWithFiles(){
        List<String> listeMap = getAllMapsInDirectory("src/main/resources/maps/");
        String map = pickRandomMap(listeMap);
        String filePath = ("src/main/resources/maps/" + map);
        return this.generateMapWithFiles(filePath);
    }

        private List<String> getAllMapsInDirectory(String directoryPath) {
        List<String> mapList = new ArrayList<>();

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        mapList.add(file.getName());
                    }
                }
            }
        }

        return mapList;
    }


    public static void main(String[] args) {
        MazeGenerator maze = new MazeGenerator();
        boolean[][] map = maze.generateMazeWithFiles();
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length ; j++) {
                System.out.print(map[i][j] ? "#" : "*");
            }
            System.out.println();
        }
    }
}

