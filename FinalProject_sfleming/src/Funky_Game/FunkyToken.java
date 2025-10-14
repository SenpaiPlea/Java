package Funky_Game;

public abstract class FunkyToken {
    // Token symbol (e.g., @, $, &)
    public char token;
    
    // Position on the board
    public int row;
    public int column;
    
    // Active status to determine if token can still move
    public boolean active;
    
    /**
     * Constructor for FunkyToken
     * @param token The character symbol for the token
     */
    public FunkyToken(char token) {
        this.token = token;
        this.active = true; // Initialize token as active
        this.row = -1;     // Initialize position as invalid until placed
        this.column = -1;
    }
    
    /**
     * Abstract method to define token movement behavior
     * @param board The game board on which the token moves
     */
    public abstract void move(FunkyBoard board);
}