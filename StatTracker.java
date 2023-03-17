import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class StatTracker {
  // Fields
  Player activePlayer;
  File stats = new File("PlayerStats.csv");
  File copyStats = new File("PlayerStats.csv");

  // Constuctor
  public StatTracker(Player activePlayer) throws FileNotFoundException {
    this.activePlayer = activePlayer;
  }

  // Methods
  public boolean hasPlayed() throws FileNotFoundException {
    Scanner scn = new Scanner(stats);
    while (scn.hasNextLine()) {
      String nextLine = scn.nextLine();
      String[] temp = nextLine.split(",");
      for (int i = 0; i < temp.length; i++) {
        if (temp[i].equals(activePlayer.getName()))
          return true;
      }
    }
    return false;
  }

  public void addToFile(String a) throws FileNotFoundException {
    try (FileWriter writer = new FileWriter(stats, true)) {
      writer.write(a);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}