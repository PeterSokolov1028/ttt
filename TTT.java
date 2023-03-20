import java.util.Arrays;

public class TTT {
    // Properties
    private static final int SIZE = 3;
    private char[][][] state;

    // Class constructor
    public TTT() {
        this.state = new char[SIZE][SIZE][SIZE];
        System.out.println("I made TTT: " + this);
        draw();
    }

    // Methods
    public void draw(){
        System.out.println();
        for(char[][] board: state){
            for(char[] rows: board){
                for(char x: rows){
                    System.out.printf("[ %c ]", x);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public String toString(){
        return "look at how cool i am!!! :)";
    }
}
