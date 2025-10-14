package Funky_Game;

import java.util.Random;

/**
 * RandomToken moves to any random position on the board.
 * If the spot already has a token, it is replaced and removed from the board.
 */
public class RandomToken extends FunkyToken {
    private Random rand;

    /**
     * Constructor for RandomToken
     * @param token The character symbol for the token
     */
    public RandomToken(char token) {
        super(token);
        this.rand = new Random();
    }

    /**
     * Moves the token to a random position on the board.
     * Uses placeToken to handle movement and potential token replacement.
     * @param board The game board on which the token moves
     */
    @Override
    public void move(FunkyBoard board) {
        if (!active) return; // Skip move if token is inactive

        // Generate random row and column within board bounds
        int newRow = rand.nextInt(board.size);
        int newCol = rand.nextInt(board.size);

        // Move to the random position
        board.placeToken(this, newRow, newCol);
    }
}