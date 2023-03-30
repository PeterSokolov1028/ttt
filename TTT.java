import java.util.*;

public class TTT {
    // Properties
    private static final int SIZE = 3;
    public static final char[] marks = { 'X', 'O', '+', '-' };
    Object[] players = new Object[2];
    private int activePlayer = 0;
    private char[][][] state;
    private boolean turn;
    private boolean gameOn;
    private String num;

    // Class constructor
    public TTT() {
        Scanner scn = new Scanner(System.in);
        this.turn = true;
        this.gameOn = true;
        this.state = new char[SIZE][SIZE][SIZE];
        while (gameOn) {
            draw();
            move();
            gameOn = !checkWin();
        }

        System.out.println("I made TTT: " + this);
    }

    // Methods
    public void draw() {
        System.out.println();
        for (char[][] board : state) {
            for (char[] rows : board) {
                for (char x : rows) {
                    if (x == 0) {
                        System.out.print("[ ]");
                    } else {
                        System.out.print("[" + x + "]");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean move() {
        Scanner makeMove = new Scanner(System.in);
        System.out.println("Gimme x y z");
        int x = makeMove.nextInt();
        int y = makeMove.nextInt();
        int z = makeMove.nextInt();

        if (validate(x, y, z)) {
            state[x][y][z] = activatePlayer();
            return true;
        } else
            return false;

    }

    public boolean validate(int x, int y, int z) {
        return (state[x][y][z] == 0 && x < SIZE && y < SIZE && z < SIZE);
    }

    private char activatePlayer() {
        System.out.println(activePlayer);
        activePlayer++;
        activePlayer %= Math.min(players.length, marks.length);
        System.out.println(activePlayer);

        return marks[activePlayer];
    }

    private boolean isSame(char[] x) {
        boolean same = true;
        for (int i = 0; i < x.length; i++) {
            if(x[i] == 0)
                return false;
            same = x[0] == x[i];
        }
        return same;
    }

    private boolean checkWin() {
        char[] vals = new char[SIZE];

        // Multi-board diagonals
        for (int i = 0; i < vals.length; i++)
            vals[i] = state[i][i][i];
        System.out.println("Cross-board 1: " + Arrays.toString(vals));
        if (isSame(vals))
            return true;
        else {
            for (int i = 0; i < vals.length; i++)
                vals[i] = state[vals.length - i - 1][i][i];
        }
        System.out.println("Cross-board 2: " + Arrays.toString(vals));
        if (isSame(vals))
            return true;
        else {
            for (int i = 0; i < vals.length; i++)
                vals[i] = state[vals.length - i - 1][vals.length - i - 1][i];
        }
        System.out.println("Cross-board 3: " + Arrays.toString(vals));
        if (isSame(vals))
            return true;
        else {
            for (int i = 0; i < vals.length; i++)
                vals[i] = state[i][i][vals.length - i - 1];
        }
        System.out.println("Cross-board 4: " + Arrays.toString(vals));
        if (isSame(vals))
            return true;

        // Single board diagonals
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals.length; j++) {
                vals[i] = state[i][j][j];
            }
            System.out.println("Diagonal 1: " + Arrays.toString(vals));
            if (isSame(vals))
                return true;
        }
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals.length; j++) {
                vals[i] = state[i][SIZE - j - 1][j];
            }
            System.out.println("Diagonal 2: " + Arrays.toString(vals));
            if (isSame(vals))
                return true;
        }
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals.length; j++) {
                vals[i] = state[j][i][j];
            }
            System.out.println("Diagonal 3: " + Arrays.toString(vals));
            if (isSame(vals))
                return true;
        }
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals.length; j++) {
                vals[i] = state[j][SIZE - i - 1][j];
            }
            System.out.println("Diagonal 4: " + Arrays.toString(vals));
            if (isSame(vals))
                return true;
        }
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals.length; j++) {
                vals[i] = state[j][j][i];
            }
            System.out.println("Diagonal 5: " + Arrays.toString(vals));
            if (isSame(vals))
                return true;
        }
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals.length; j++) {
                vals[i] = state[j][SIZE - j - 1][i];
            }
            System.out.println("Diagonal 6: " + Arrays.toString(vals));
            if (isSame(vals))
                return true;
        }

        for(int i = 0; i < vals.length; i++){
            for(int j = 0; j < vals.length; j++){
                for(int k = 0; k < vals.length; k++){
                    vals[k] = state[i][j][k];
                }
                System.out.println("Column 1: " + Arrays.toString(vals));
                if(isSame(vals))
                    return true;
            }
        }
        for(int i = 0; i < vals.length; i++){
            for(int j = 0; j < vals.length; j++){
                for(int k = 0; k < vals.length; k++){
                    vals[j] = state[k][i][j];
                }
                System.out.println("Column 2: " + Arrays.toString(vals));
                if(isSame(vals))
                    return true;
            }
        }
        for(int i = 0; i < vals.length; i++){
            for(int j = 0; j < vals.length; j++){
                for(int k = 0; k < vals.length; k++){
                    vals[i] = state[j][k][i];
                }
                System.out.println("Column 3: " + Arrays.toString(vals));
                if(isSame(vals))
                    return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "look at how cool i am!!! :)";
    }
}
