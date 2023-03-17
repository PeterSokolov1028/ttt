// this is manas
//This is Peter huy
// This is israel
// this is manas again

import java.util.Scanner;

public class Grid {
  int size;
  char[][][] activeGrid;

  // Constructor set to default
  public Grid(int size, char[][][] activeGrid) {
    this.size = size;
    this.activeGrid = activeGrid;
  }

  // draws grid
  public void drawGrid() {
    for (int k = 0; k < size; k++) {
      for (int i = 0; i < size; i++) {
        System.out.println();
        for (int j = 0; j < size; j++) {
          System.out.print("[" + activeGrid[k][i][j] + "]");
        }
      }
      System.out.println();
    }
  }

  // gives grid initial values
  public void initializeGrid() {
    for (int k = 0; k < size; k++) {
      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          activeGrid[k][i][j] = '-';
        }
      }
    }
  }

}