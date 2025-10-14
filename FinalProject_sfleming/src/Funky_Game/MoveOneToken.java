package Funky_Game;

import java.util.Random;

/**
 * MoveOneToken moves one space in a random direction (all eight directions: up, down, left, right, and diagonals).
 * If the move would go off the board, it tries a different direction.
 * If the destination has another token, it is replaced and removed from the board.
 */
public class MoveOneToken extends FunkyToken {
    private Random rand;

    /**
     * Constructor for MoveOneToken
     * @param token The character symbol for the token
     */
    public MoveOneToken(char token) {
        super(token);
        this.rand = new Random();
    }

    /**
     * Moves the token one space in a random direction on the board.
     * Retries random directions until a valid move is found or all directions are invalid.
     * Uses placeToken to handle movement and potential token replacement.
     * @param board The game board on which the token moves
     */
    @Override
    public void move(FunkyBoard board) {
        if (!active) return; // Skip move if token is inactive

        // All eight directions: up, down, left, right, up-left, up-right, down-left, down-right
        int[][] directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1},   // right
            {-1, -1}, // up-left
            {-1, 1},  // up-right
            {1, -1},  // down-left
            {1, 1}    // down-right
        };
        boolean[] tried = new boolean[8]; // Track which directions have been tried
        int attempts = 0;

        // Keep trying random directions until a valid move is found or all are tried
        while (attempts < 8) {
            int dir = rand.nextInt(8); // Pick a random direction index
            if (tried[dir]) continue; // Skip if this direction was already tried

            tried[dir] = true; // Mark direction as tried
            attempts++;

            int newRow = row + directions[dir][0];
            int newCol = column + directions[dir][1];

            // Check if the move is within board bounds
            if (newRow >= 0 && newRow < board.size && newCol >= 0 && newCol < board.size) {
                board.placeToken(this, newRow, newCol);
                return; // Move successful, exit
            }
        }
        // If no valid move is found, stay in place (no change)
    }
}