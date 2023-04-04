import java.util.Scanner;
import java.io.FileNotFoundException;

class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Player Dan = new Player("dAN");
		Dan.hasPlayed();

		TTT theGame = new TTT();
		System.out.println("Let's make Tic-Tac-Toe");
	}
}