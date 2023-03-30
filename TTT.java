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
            same = x[0] == x[i];
        }
        return same;
    }

    private boolean checkWin() {
        char[] vals = new char[SIZE];

        // Multi-board diagonals
        for (int i = 0; i < vals.length; i++)
            vals[i] = state[i][i][i];
        if (isSame(vals))
            return true;
        else {
            for (int i = 0; i < vals.length; i++)
                vals[i] = state[vals.length - i - 1][i][i];
        }
        if (isSame(vals))
            return true;
        else {
            for (int i = 0; i < vals.length; i++)
                vals[i] = state[vals.length - i][vals.length - i][i];
        }
        if (isSame(vals))
            return true;
        else {
            for (int i = 0; i < vals.length; i++)
                vals[i] = state[i][i][vals.length - i];
        }
        if (isSame(vals))
            return true;

        // Single board diagonals
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals.length; j++) {
                vals[i] = state[i][j][j];
            }
            if (isSame(vals))
                return true;
        }
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals.length; j++) {
                vals[i] = state[i][SIZE - j][j];
            }
            if (isSame(vals))
                return true;
        }
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals.length; j++) {
                vals[i] = state[j][i][j];
            }
            if (isSame(vals))
                return true;
        }
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals.length; j++) {
                vals[i] = state[j][SIZE - i][j];
            }
            if (isSame(vals))
                return true;
        }
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals.length; j++) {
                vals[i] = state[j][j][i];
            }
            if (isSame(vals))
                return true;
        }
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals.length; j++) {
                vals[i] = state[j][SIZE - j][i];
            }
            if (isSame(vals))
                return true;
        }
        return true;
    }

    @Override
    public String toString() {
        return "look at how cool i am!!! :)";
    }
}
