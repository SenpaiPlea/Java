package ticTacToe;

public class BoardDemo {

	public static void main(String[] args) {
		// 
		char token1= 'x';
		char token2 = 'o';
		Board board1 = new Board(3);
		board1.displayBoard();
		board1.placeToken(token1, 1, 1);
		board1.placeToken(token2, 1, 1);
		board1.placeToken(token1, 2, 2);
		board1.placeToken(token1, 3, 3);
		board1.displayBoard();
		if (board1.getWinner()!= board1.emptySpace) {
			System.out.println(board1.getWinner()+ " won!");
		};
		Board board2 = new Board(5);
		board2.placeToken(token1, 1, 1);
		board2.placeToken(token2, 2, 1);
		board2.placeToken(token2, 2, 2);
		board2.placeToken(token2, 2, 3);
		board2.placeToken(token2, 2, 4);
		board2.placeToken(token2, 2, 5);
		board2.displayBoard();
		if (board2.getWinner()!= board2.emptySpace) {
			System.out.println(board2.getWinner()+ " won!");
		};
		
		Board board3 = new Board(4);
		board3.placeToken(token1, 1, 3);
		board3.placeToken(token2, 2, 4);
		board3.placeToken(token1, 2, 3);
		board3.placeToken(token1, 3, 3);
		board3.placeToken(token1, 4, 3);
	
		board3.displayBoard();
		if (board3.getWinner()!= board3.emptySpace) {
			System.out.println(board3.getWinner()+ " won!");
		};
		Board board4 = new Board(3);
		board4.placeToken(token1, 1, 1);
		board4.placeToken(token2, 2, 1);
		board4.placeToken(token1, 1, 2);
		board4.placeToken(token2, 1, 3);
		board4.placeToken(token1, 2, 2);
		board4.placeToken(token1, 2, 3);
		board4.placeToken(token1, 3, 1);
		board4.placeToken(token2, 3, 2);
		board4.placeToken(token2, 3, 3);
	
		board4.displayBoard();
		if (board4.getWinner()!= board4.emptySpace) {
			System.out.println(board4.getWinner()+ " won!");
		};
		if(board4.isFull()) {
			System.out.println("board is full");
		}
	}

}
