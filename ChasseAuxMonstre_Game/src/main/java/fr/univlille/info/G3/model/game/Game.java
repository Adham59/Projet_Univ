package fr.univlille.info.G3.model.game;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import fr.univlille.info.G3.model.maze.Maze;
import fr.univlille.info.G3.model.maze.MazeMonster;
import fr.univlille.info.G3.model.perception.CellEvent;
import fr.univlille.info.G3.model.perception.Coordinate;
import fr.univlille.iutinfo.cam.player.hunter.IHunterStrategy;
import fr.univlille.iutinfo.cam.player.monster.IMonsterStrategy;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent.CellInfo;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;

public class Game {

    private static Game instance;
    private IMonsterStrategy monster;
    private IHunterStrategy hunter;
    private MazeMonster maze;

    public static Game getInstance() {
        return Game.instance;
    }

    public Game(IMonsterStrategy monster, IHunterStrategy hunter) {
        Game.instance = this;
        this.displayDebugMsg(null);
        this.displayDebugMsg("Creating new game (" + monster.getClass().getSimpleName() + " vs "
                + hunter.getClass().getSimpleName() + ")");
        this.monster = monster;
        this.hunter = hunter;
        this.initializeGame();
        this.makeMonsterPlay();
    }

    private void initializeGame() {
        MazeGenerator mg;
        do {
            System.out.println("try again");
            mg = new MazeGenerator();
            // Setup walls
            this.maze = new MazeMonster(mg.getWalls());

            // Setup exit
            this.maze.updateMaze(new CellEvent(mg.getExit(), CellInfo.EXIT, 0));
            this.maze.updateMaze(new CellEvent(mg.getMonsterStartingPosition(), CellInfo.MONSTER, 0));
        } while (!asValidPathToExitWithBFSAlgo(this.maze) && !Parameter.isMapFile());
        this.hunter.initialize(mg.getWalls().length, mg.getWalls()[0].length);
        this.monster.initialize(mg.getWalls());
        this.monster.update(new CellEvent(mg.getExit(), CellInfo.EXIT, 0));
        // Setup monster starting position

        monster.update(new CellEvent(mg.getMonsterStartingPosition(),
                this.maze.getGroundInfo(mg.getMonsterStartingPosition())));
        monster.update(new CellEvent(mg.getMonsterStartingPosition(), CellInfo.MONSTER, 0));

        if (Parameter.isFogMode()) {
            for (int i = this.maze.getMonsterPosition().getRow() - Parameter.getFogRange(); i < this.maze
                    .getMonsterPosition().getRow() + Parameter.getFogRange() + 1; i++) {
                for (int j = this.maze.getMonsterPosition().getCol() - Parameter.getFogRange(); j < this.maze
                        .getMonsterPosition().getCol() + Parameter.getFogRange() + 1; j++) {
                    if (this.maze.isInsideMaze(i, j)) {
                        this.monster.update(
                                new CellEvent(new Coordinate(i, j), this.maze.getCellGroundInfo(new Coordinate(i, j))));
                    }
                }
            }
        }
    }

    /**
     * Make the monster play
     */
    private void makeMonsterPlay() {
        this.displayDebugMsg(null);
        this.displayDebugMsg("Asking " + this.monster.getClass().getSimpleName() + " to play");
        ICoordinate monsterPlay = this.monster.play();
        if (monsterPlay != null) {
            this.monsterMove(monsterPlay);
        }
    }

    public boolean asValidPathToExitWithBFSAlgo(Maze maze) {

        // Partie bonne pour le moment
        ICoordinate exit = maze.getExit();
        ICoordinate monsterPosition = maze.getMonsterPosition();

        if (exit == null || monsterPosition == null) {
            return false;
        }

        Queue<ICoordinate> queue = new LinkedList<>();
        Set<ICoordinate> visited = new HashSet<>();
        queue.add(monsterPosition);
        visited.add(monsterPosition);

        while (!queue.isEmpty()) {
            ICoordinate current = queue.poll(); // On prend le premier element de la queue

            if (current.getCol() == exit.getCol() && current.getRow() == exit.getRow()) {
                return true;
            }

            for (ICoordinate neighbor : maze.getNeighbourgs(current)) {
                ICoordinate neighborWeightLess = maze.getCellWeigthToExit(neighbor) <= maze.getCellWeigthToExit(current)
                        ? neighbor
                        : current; // On prend le plus petit poids
                if (!visited.contains(neighborWeightLess)
                        && this.maze.getCellGroundInfo(neighborWeightLess) != CellInfo.WALL) {
                    queue.add(neighborWeightLess);
                    visited.add(neighborWeightLess);
                }
                if (neighborWeightLess == exit) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Make the hunter play
     */
    private void makeHunterPlay() {
        this.displayDebugMsg(null);
        this.displayDebugMsg("Asking " + this.hunter.getClass().getSimpleName() + " to play");
        ICoordinate hunterPlay = this.hunter.play();
        if (hunterPlay != null) {
            this.hunterShoot(hunterPlay);
        }
    }

    /**
     * Register monster move to specified coordinate
     * 
     * @param coordinate - ICoordinates
     */
    public void monsterMove(ICoordinate coordinate) {
        this.displayDebugMsg(this.getClass().getSimpleName() + " : " + this.monster.getClass().getSimpleName()
                + " moved at " + coordinate);
        // Register and share move info
        ICellEvent event = new CellEvent(coordinate, CellInfo.MONSTER, this.maze.getTurn());
        this.maze.playMaze(event.getCoord(), event.getState());
        this.monster.update(event);
        if (Parameter.isFogMode()) {
            for (int i = this.maze.getMonsterPosition().getRow() - Parameter.getFogRange(); i < this.maze
                    .getMonsterPosition().getRow() + Parameter.getFogRange() + 1; i++) {
                for (int j = this.maze.getMonsterPosition().getCol() - Parameter.getFogRange(); j < this.maze
                        .getMonsterPosition().getCol() + Parameter.getFogRange() + 1; j++) {
                    if (this.maze.isInsideMaze(i, j)) {
                        this.monster.update(
                                new CellEvent(new Coordinate(i, j), this.maze.getCellGroundInfo(new Coordinate(i, j))));
                    }
                }
            }
        }

        // Continue game if the monster hasn't won
        if (!monsterVictoryCondition(coordinate)) {
            this.makeHunterPlay();
        }
    }

    /**
     * Register hunter shot to specified coordinate
     * 
     * @param coordinate - ICoordinates
     */
    public void hunterShoot(ICoordinate coordinate) {
        this.displayDebugMsg(this.hunter.getClass().getSimpleName() + " shot at " + coordinate);
        // Register and share shot info
        ICellEvent event = new CellEvent(coordinate, CellInfo.HUNTER, this.maze.getTurn());
        this.maze.updateMaze(event);
        this.monster.update(event);
        this.hunter.update(event);
        this.hunter.update(new CellEvent(coordinate, this.maze.getCellGroundInfo(coordinate)));
        if (this.maze.getLastMonsterPresence(coordinate) > -1) {
            this.hunter
                    .update(new CellEvent(coordinate, CellInfo.MONSTER, this.maze.getLastMonsterPresence(coordinate)));
        }
        // Contine game if the hunter hasn't won
        if (!hunterVictoryCondition(coordinate)) {
            this.makeMonsterPlay();
        }
    }

    /**
     * Check if the monster won
     * 
     * @param coordinate
     * @return boolean
     */
    private boolean monsterVictoryCondition(ICoordinate coordinate) {
        this.displayDebugMsg("Checking if " + this.monster.getClass().getSimpleName() + " won");
        if (this.maze.getCellGroundInfo(coordinate).equals(CellInfo.EXIT)) {
            this.displayDebugMsg(this.monster.getClass().getSimpleName() + " won !");
            new WinChecker(this.monster);
            return true;
        }
        return false;
    }

    /**
     * Check if the hunter won
     * 
     * @param coordinate
     * @return boolean
     */
    private boolean hunterVictoryCondition(ICoordinate coordinate) {
        this.displayDebugMsg("Checking if " + this.hunter.getClass().getSimpleName() + "won");
        if (this.maze.getLastMonsterPresence(coordinate) > -1
                && this.maze.getLastMonsterPresence(coordinate) >= this.maze.getTurn()) {
            this.displayDebugMsg(this.hunter.getClass().getSimpleName() + "won !");
            new WinChecker(this.hunter);
            return true;
        }
        return false;
    }

    /**
     * Display debug message
     * 
     * @param msg
     */
    private void displayDebugMsg(String msg) {
        if (msg != null) {
            System.out.println(this.getClass().getSimpleName() + " : " + msg);
        } else {
            System.out.println();
        }
    }
}