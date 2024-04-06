package fr.univlille.info.G3.model.maze;

import java.util.ArrayList;
import java.util.List;

import fr.univlille.info.G3.model.perception.Coordinate;
import fr.univlille.iutinfo.cam.player.perception.ICoordinate;
import fr.univlille.iutinfo.cam.player.perception.ICellEvent.CellInfo;

public class MazeMonsterBot extends MazeMonster {

    private int[][] visited;
    private int[][] steps;
    private ICoordinate exit;

    public MazeMonsterBot(boolean[][] walls) {
        super(walls);
        this.visited = new int[walls.length][walls[0].length];
        this.steps = new int[walls.length][walls[0].length];
        for(int i = 0; i < walls.length; i++) {
            for(int j = 0; j < walls[0].length; j++) {
                this.visited[i][j] = -1;
                this.steps[i][j] = -1;
            }
        }
    }

    private void calculateNeighboursSteps(ICoordinate current) {
        List<ICoordinate> neighbourgs = this.getNeighbourgs(current);
        for (ICoordinate neighbourg : neighbourgs) {
            System.out.println("one neighbourg");
            if(this.steps[neighbourg.getRow()][neighbourg.getCol()] < 0 && this.getCell(neighbourg).getGroundInfo() != CellInfo.WALL) {
                System.out.println("test1");
                this.steps[neighbourg.getRow()][neighbourg.getCol()] = this.steps[current.getRow()][current.getCol()] + 1;
            }
        }
    }












    public int[][] calculate(ICoordinate exit) {
        this.exit = exit;

        ICoordinate current = this.exit;
        steps[current.getRow()][current.getCol()] = 0;
        visited[current.getRow()][current.getCol()] = 0;
        // While exit is not found
        int stepNb = 1;
        calculateNeighboursSteps(current);
        while(current.getCol() != this.monsterPosition.getCol() || current.getRow() != this.monsterPosition.getRow()) {
            
            ICoordinate next = null;
            for(int i = 0; i < this.steps.length; i++) {
                System.out.println("each line");
                for(int j = 0; j < this.steps[0].length; j++) {
                    if(this.steps[i][j] >= 0 && this.visited[i][j] < 0 && this.isInsideMaze(new Coordinate(i, j))) {
                        if(next == null) {
                            System.out.println("next is null");
                            next = new Coordinate(i, j);
                        } else if(this.steps[i][j] + this.calculateManathanDistance(new Coordinate(i, j), this.monsterPosition) < this.steps[next.getRow()][next.getCol()] + this.calculateManathanDistance(next, this.monsterPosition)) {
                            System.out.println("changing next");
                            next = new Coordinate(i, j);
                        }
                    }
                }
            } 
            current = next;
            visited[current.getRow()][current.getCol()] = stepNb;
            stepNb++;
            calculateNeighboursSteps(current);
            
            System.out.println("visited");
            for(int i = 0; i < visited.length; i++) {
                for(int j = 0; j < visited[0].length; j++) {
                    System.out.print(((char)('A' + visited[i][j])) + " ");
                }
                System.out.println();
            }
            System.out.println("steps");
            for(int i = 0; i < steps.length; i++) {
                for(int j = 0; j < steps[0].length; j++) {
                    System.out.print(((char)('A' + steps[i][j])) + " ");
                }
                System.out.println();
            }
        }
        System.out.println("hey");
        System.out.println(this.monsterPosition);
        System.out.println(this.exit);
        
        
        return this.steps;
    }














    public List<ICoordinate> generatePath() {
        System.out.println("Generating path");
        List<ICoordinate> path = new ArrayList<ICoordinate>();
        ICoordinate current = this.exit;
        System.out.println(this.exit);
        int stepCurrent = steps[current.getRow()][current.getCol()];
        path.add(current);
        while(current.getRow() != monsterPosition.getRow() && current.getCol() != monsterPosition.getCol() && this.steps[this.monsterPosition.getRow()][this.monsterPosition.getCol()] != -1) {

            if(isInsideMaze(current.getRow() + 1, current.getCol()) && steps[current.getRow() + 1][current.getCol()] < stepCurrent) {
                path.add(new Coordinate(current.getRow() + 1, current.getCol()));

            } else if(isInsideMaze(current.getRow() - 1, current.getCol()) && steps[current.getRow() - 1][current.getCol()] < stepCurrent) {
                path.add(new Coordinate(current.getRow() - 1, current.getCol()));
                
            } else if(isInsideMaze(current.getRow(), current.getCol() + 1) && steps[current.getRow()][current.getCol() + 1] < stepCurrent) {
                path.add(new Coordinate(current.getRow(), current.getCol() + 1));
                
            } else if(isInsideMaze(current.getRow() - 1, current.getCol()) && steps[current.getRow()][current.getCol() - 1] < stepCurrent) {
                path.add(new Coordinate(current.getRow(), current.getCol() - 1));
            }
            current = path.get(path.size() - 1);
            System.out.println("Current is now " + current);
            System.out.println(steps[current.getRow()][current.getCol()]);
            for(int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i) + " ");
            }
            System.out.println();
        }
        System.out.println("Returning path");


        
        return path;
    }

    private int calculateManathanDistance(ICoordinate coordinate1, ICoordinate coordinate2) {
        return Math.abs(coordinate1.getRow() - coordinate2.getRow()) + Math.abs(coordinate1.getCol() - coordinate2.getCol());
    }

    

    
    
}
