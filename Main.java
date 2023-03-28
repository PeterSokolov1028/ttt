import java.util.Scanner;
import java.io.FileNotFoundException;

class Main{
  public static void main(String[] args) throws FileNotFoundException  {
    Player1 Peter = new Player1("Peter");
      Peter.addWin();


    
      int SIZE = 3;
      Scanner n = new Scanner(System.in);
      System.out.println("Player 1 select your game symbol");
      char CharOne = n.next().charAt(0);
      System.out.println("Player  select your game symbol");
      char CharTwo = n.next().charAt(0);
      char [][][] board = new char[SIZE][SIZE][SIZE];
      Grid g = new Grid(SIZE,board);
      Player [] players = new Player[2];
      players[0] = new Player("Peter",CharOne, board);
      System.out.println(players[0].getName());
      players[1] = new Player("Retep",CharTwo , board);

    
      StatTracker tracker = new StatTracker(players[0]);
      System.out.println(tracker.hasPlayed());
      tracker.addToFile("AAAAAAAAA");
    
      g.initializeGrid();
      g.drawGrid();
    while(!players[0].checkWin() && !players[1].checkWin()){
        players[0].makeMove();
        g.drawGrid();
        if(players[0].checkWin()) break;
        players[1].makeMove();
        g.drawGrid();
    }
    System.out.println("GAME OVER");
  }   
}