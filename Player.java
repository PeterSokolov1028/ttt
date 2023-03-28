import java.util.Scanner;

public class Player {
  String name;
  char active;
  char[][][] gameGrid;

  /// CONSTRUCTOR
  public Player(String name, char active, char[][][] gameGrid) {
    this.name = name;
    this.active = active;
    this.gameGrid = gameGrid;
  }

  public void makeMove() {
    Scanner s = new Scanner(System.in);
    System.out.println("Select the Grid you are moving on and the X and Y coordinates of your move");
    int z = s.nextInt();
    getCoordinate(z);
    int x = s.nextInt();
    getCoordinate(x);
    int y = s.nextInt();
    getCoordinate(y);
    gameGrid[z][y][x] = active;
  }

  public char getActive() {
    return active;
  }

  public String getName() {
    return name;
  }

  public boolean checkWin() {
    boolean winH = true;
    boolean winV = true;
    boolean winD = true;
    boolean winD2 = true;
    boolean winStack = true;
    for (int k = 0; k < gameGrid.length; k++) {
      for (int i = 0; i < gameGrid.length; i++) {
        winH = true;
        winV = true;
        winD = true;
        winD2 = true;
        winStack = true;
        for (int j = 0; j < gameGrid.length; j++) {
          if (active != gameGrid[k][i][j]) {
            winH = false;
          }
          if (active != gameGrid[k][j][i]) {
            winV = false;
          }
          if (active != gameGrid[k][j][j]) {
            winD = false;
          }
          if (active != gameGrid[k][j][2 - j]) {
            winD2 = false;
          }
          if (active != gameGrid[j][i][k]) {
            winStack = false;
          }

        }
        if (winH || winV || winD || winD2 || winStack)
          return true;
      }
    }
    return false;
  }

  public void getCoordinate(int coordinate) {
    Scanner s = new Scanner(System.in);
    while (coordinate < 0 || coordinate > 2 || active == '-') {
      System.out.println("The coordinate you have entered is invalid please try agian");
      System.out.println("Select the Grid you are moving on and the X and Y coordinates of your move");
      coordinate = s.nextInt();
    }
  }

}
