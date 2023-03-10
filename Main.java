import java.util.Scanner;


class Main {
  public static void main(String[] args) {
      char [][] board = new char[3][3];
      Grid g = new Grid(3,board);
      Player p1 = new Player('X', board);
      Player p2 = new Player('O', board);
      g.initializeGrid();
    while(!p1.checkWin() || !p2.checkWin()){
        g.drawGrid();
        p1.makeMove();
    }
      // g.drawGrid();
    System.out.println("GAME OVER");
  }   
  
}