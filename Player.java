import java.util.Scanner;

public class Player{
  char active;
  char[][] gameGrid;

  public Player(char active, char[][] gameGrid){
    this.active = active;
    this.gameGrid = gameGrid;
  }

 public void makeMove(){
    Scanner s = new Scanner(System.in);
   System.out.println("Select the X coordinate of your move");
    int x = s.nextInt();
   System.out.println("Select the Y coordinate of your move");
    int y = s.nextInt();
    gameGrid[y][x] = active;
 }
  public char getActive(){
    return active;
  }
    public boolean checkWin(){
    boolean win = true;
    for(int i = 0; i < gameGrid.length;i++){
      win = true;
      for(int j = 0; j < gameGrid.length; j++){
        if(active != gameGrid[i][j]){
          win = false;
        }
    
      }
      System.out.println("Row " + i + ": " + win);
      if(win) return true;
    }
      return win;
  }

  
}
