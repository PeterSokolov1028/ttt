import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.*;
import java.lang.NumberFormatException;
import java.util.ArrayList;


public class Player1{
  //FIELDS
  String name;
  File stats = new File("PlayerStats.csv");

  //CONSTRUCTOR
  public Player1(String name)throws FileNotFoundException{
    this.name = name;
  }

  //METHODS
  public void addWin()throws FileNotFoundException, NumberFormatException{
    Scanner scn = new Scanner(stats);
    ArrayList<String[]> fileReplase = new ArrayList<String[]>();
    while(scn.hasNextLine()){
      String nextLine = scn.nextLine();
      String [] temp = nextLine.split(",");
      if(temp[0].equals(this.name)){
        int t = Integer.valueOf(temp[1]);
        t++;
        temp[1] = String.valueOf(t);
      } 
      fileReplase.add(temp);
    }
    scn.close();
    PrintWriter pw = new PrintWriter(stats);
    for(int i=0;i<fileReplase.size();i++){
      String[] temp2 = fileReplase.get(i);
      for(int j=0;j<temp2.length;j++){
        pw.print(temp2[j]+ ',');
        System.out.println(temp2[j]+',');
      }
      pw.println();
    }
    pw.close();
    
    
  }
}
