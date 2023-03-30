import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.*;
import java.lang.NumberFormatException;
import java.util.ArrayList;


public class Player{
  //FIELDS
  String name;
  File stats = new File("PlayerStats.csv");

  //CONSTRUCTOR
  public Player(String name)throws FileNotFoundException{
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
      }
      pw.println();
    }
    pw.close();
    
    
  }
    public void addLoss()throws FileNotFoundException, NumberFormatException{
    Scanner scn = new Scanner(stats);
    ArrayList<String[]> fileReplase = new ArrayList<String[]>();
    while(scn.hasNextLine()){
      String nextLine = scn.nextLine();
      String [] temp = nextLine.split(",");
      if(temp[0].equals(this.name)){
        int t = Integer.valueOf(temp[2]);
        t++;
        temp[2] = String.valueOf(t);
      } 
      fileReplase.add(temp);
    }
    scn.close();
    PrintWriter pw = new PrintWriter(stats);
    for(int i=0;i<fileReplase.size();i++){
      String[] temp2 = fileReplase.get(i);
      for(int j=0;j<temp2.length;j++){
        pw.print(temp2[j]+ ',');
      }
      pw.println();
    }
    pw.close();
    
    
  }
    public boolean hasPlayed() throws FileNotFoundException {
        Scanner scn = new Scanner(stats);
    while (scn.hasNextLine()) {
      String nextLine = scn.nextLine();
      String[] temp = nextLine.split(",");
      for (int i = 0; i < temp.length; i++) {
        if (temp[i].equals(this.name))
          return true;
      }
    }
    return false;
  }
    public void addPlayerToFile()throws FileNotFoundException{
       Scanner scn = new Scanner(stats);
        ArrayList<String> copyFile = new ArrayList<String>();
        while(scn.hasNextLine()){
            copyFile.add(scn.nextLine());
        }
        String newStatLine = this.name + "," + "0" + "," + "0"+ ",";
        copyFile.add(newStatLine);
        scn.close();

        PrintWriter pw = new PrintWriter(stats);
        for(int i = 0;i<copyFile.size();i++){
            pw.println(copyFile.get(i));
        }
        pw.close();
        
    }
    
    
}

