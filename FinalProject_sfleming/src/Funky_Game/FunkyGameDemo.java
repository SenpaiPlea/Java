package Funky_Game;

public class FunkyGameDemo {

	public static void main(String[] args) {
		// 
		FunkyToken winner = null;
		FunkyBoard board = new FunkyBoard(7);
		FunkyToken[] tokens = new FunkyToken[3];
		tokens[0] = new RandomToken('@');
		tokens[1] = new MoveOneToken('$');
		tokens[2] = new RandomToken('&');
		board.placeToken(tokens[0], 3, 1);
		board.placeToken(tokens[1], 4, 4);
		board.placeToken(tokens[2], 0, 0);

		board.displayBoard();
		
		do {
			for (int i = 0; i < tokens.length; i++) {
				if (tokens[i].active) {
					tokens[i].move(board);
					System.out.println(tokens[i].token + "move");
					board.displayBoard();
					winner = board.getWinner();
					if (winner != null)
						break;
				}
			}
		} while (winner == null);
		System.out.println(winner.token + " won!");
	}
}
