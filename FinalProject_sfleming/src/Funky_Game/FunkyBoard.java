package Funky_Game;

public class FunkyBoard {

	private FunkyToken[][] board;
	public int size;
	public char emptySpace = '-';
	
	
	void displayBoard() {
		
	}
	
//	from the token's perspective, it's called a move
//	from the board's perspective, it is a place token
//	used to form the association between the two 
//	when you call the .move method, the placeToken method should be called inside of it for that board
//	from the board, you need to know exactly which token is being placed and at what location [via row and column]
	
	void placeToken(FunkyToken token, int row, int column) {
		
	}

	
//	return FunkyToken by going through entire board to see if only one token remains, then declares that FunkyToken as the winner
	FunkyToken getWinner() {
		
		
		
		return null;
	}
	
	
}
