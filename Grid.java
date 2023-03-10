import java.util.Scanner;

public class Grid{
  int size;
  char[][] activeGrid;

  //Constructor set to default
  public Grid(int size, char[][] activeGrid){
    this.size = size;
    this.activeGrid = activeGrid;
  }



  
  //draws grid 
  public void drawGrid(){
    for(int i = 0 ; i < size; i++){
      System.out.println();
      for(int j = 0; j < size; j++){
        System.out.print("[" + activeGrid[i][j] + "]");
        }
      }
     System.out.println();
    }
  //gives grid initial values
  public void initializeGrid(){
      for(int i = 0 ; i < size; i++){
        for(int j = 0; j < size; j++){
          activeGrid[i][j] = '-';
        }
      }
    }

  
}