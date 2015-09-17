package Terrain;

import java.util.Random;

// @author Leevi
public class CartesianMap {

    int xLim;
    int yLim;
    int[][] map;

    public CartesianMap(int x, int y) {

        this.xLim = x;
        this.yLim = y;
        this.map = new int[x][y];

    }

    public void generateTerrain(boolean hasRoughTerrain) {

        for (int y = 0; y < yLim; y++) {
            for (int x = 0; x < xLim; x++) {
                Random rand = new Random();
                int tileValue;
                if (!hasRoughTerrain) {
                    tileValue = rand.nextInt(38 + 1);
                }
                else {
                    tileValue = rand.nextInt(18 + 1);
                }
                
                if (tileValue < 7) {
                    tileValue = 0; // Dirtroad
                }
                else if (tileValue < 10) {
                    tileValue = 1; // Traffic
                }
                else if (tileValue < 18) {
                    tileValue = 2; // Road
                }
                else {
                    tileValue = 3; // Highway
                }
                map[x][y] = tileValue;
            }
        }

    }

    public int getSingleTile(int xPos, int yPos) {

        return map[xPos][yPos];

    }

    public void displayMap() {

        for (int y = 0; y < yLim; y++) {
            for (int x = 0; x < xLim; x++) {
                if (getSingleTile(x, y) == 0) { // Dirtroad
                    System.out.print(" * ");
                }
                else if (getSingleTile(x, y) == 1) { // Traffic
                    System.out.print(" / ");
                }
                else if (getSingleTile(x, y) == 2) { // Road
                    System.out.print(" - ");
                }
                else if (getSingleTile(x, y) == 3) { // Highway
                    System.out.print(" = ");
                }
            }
            System.out.println("");
        }

    }

}
