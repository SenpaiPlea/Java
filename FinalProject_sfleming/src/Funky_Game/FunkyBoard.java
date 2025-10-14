package Funky_Game;

public class FunkyBoard {

    private FunkyToken[][] board;
    public int size;
    public char emptySpace = '-';
    
    // Constructor to initialize the board with given size
    public FunkyBoard(int size) {
        this.size = size;
        board = new FunkyToken[size][size];
        // Initialize board with null (empty spaces)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = null;
            }
        }
    }
    
    // Display the board
    void displayBoard() {
        // Print column numbers
        System.out.print("  ");
        for (int j = 0; j < size; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        
        // Print board content
        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print(emptySpace + " ");
                } else {
                    System.out.print(board[i][j].token + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // Place token at specified position, removing it from its previous position
    void placeToken(FunkyToken token, int row, int column) {
        // Check if position is valid
        if (row < 0 || row >= size || column < 0 || column >= size) {
            return; // Invalid position, do nothing
        }
        
        // Remove token from its current position if it has one
        if (token.row >= 0 && token.row < size && token.column >= 0 && token.column < size) {
            if (board[token.row][token.column] == token) {
                board[token.row][token.column] = null; // Clear old position
            }
        }
        
        // If there's a token at the destination, mark it as inactive
        if (board[row][column] != null && board[row][column] != token) {
            board[row][column].active = false;
        }
        
        // Place the token at the new position
        board[row][column] = token;
        // Update token's position
        token.row = row;
        token.column = column;
    }
    
    // Check for winner (only one active token remains)
    FunkyToken getWinner() {
        FunkyToken lastToken = null;
        int activeCount = 0;
        
        // Scan the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null && board[i][j].active) {
                    lastToken = board[i][j];
                    activeCount++;
                    // If more than one active token, no winner yet
                    if (activeCount > 1) {
                        return null;
                    }
                }
            }
        }
        
        // If exactly one active token found, it's the winner
        if (activeCount == 1) {
            return lastToken;
        }
        return null;
    }
}