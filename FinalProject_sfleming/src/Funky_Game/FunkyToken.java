package Funky_Game;


/**
 * method to establish game tokens
 * provides positional information on the board to the tokens
 * declares whether the piece is alive[active] and should continue to call the move algorithm or not 
 * Users can pass in the token symbol they want to use.
 * All token pieces should be able to move.
 */
public abstract class FunkyToken {

//	characters @ $ &
	public char token;
	
//	token needs to know position on the board to track where it currently is, where moving takes it, etc.
	public int rowPos;
	public int columnPos;
	
//	decides whether a piece should continue to move or has been eaten
	public Boolean active;
//	public boolean active = true
	
	
	/**
	 * takes in the board as a parameter to decide movement for tokens
	 * @param board
	 */
	public abstract void move(FunkyBoard board);
	
	/**
	 * token constructor
	 * @param token
	 */
public FunkyToken(char token) {
	super();
	this.token = token;
}
	
	
	
	
	
}
