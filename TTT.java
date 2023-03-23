import java.util.Arrays;
import java.util.*;

public class TTT {
    // Properties
    private static final int SIZE = 3;
    private char[][][] state;
    private boolean turn;
    private boolean gameOn;
    private String num;
    private char actiaveChar = 'X';

    // Class constructor
    public TTT() {
        this.turn = true;
        this.gameOn = true;
        this.state = new char[SIZE][SIZE][SIZE];
        while(){
            
        }
        move();
        draw();
        System.out.println("I made TTT: " + this);
    }

    // Methods
    public void draw(){
        System.out.println();
        for(char[][] board: state){
            for(char[] rows: board){
                for(char x: rows){
                    x = (x != 0)? ' ' : x;
                    System.out.printf("[ %c ]", x);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void move(){
        Scanner makeMove = new Scanner(System.in);
        System.out.println("Gimme x y z");
        int x = makeMove.nextInt();
        int y = makeMove.nextInt();
        int z = makeMove.nextInt();
        state[x][y][z] = actiaveChar;
    }

    @Override
    public String toString(){
        return "look at how cool i am!!! :)";
    }
}
