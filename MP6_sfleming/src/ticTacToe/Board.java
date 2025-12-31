package ticTacToe;

public class Board {
	private char[][] board;
	private int size;
	public char emptySpace;


	public Board(int size) {
		this.size = size;
		this.emptySpace = '-';
		this.board = new char[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = emptySpace;
			}
		}
	}


	public void displayBoard() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}


	public boolean isTaken(int row, int col) {
		// Adjust for 1-based input to 0-based index
		row--;
		col--;

		return board[row][col] != emptySpace;
	}


	public boolean isFull() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board[i][j] == emptySpace) {
					return false;
				}
			}
		}
		return true;
	}


	public void placeToken(char token, int row, int col) {
		// Adjust for 1-based input to 0-based index
		row--;
		col--;

		if (board[row][col] == emptySpace) {
			board[row][col] = token;
		} else {
			System.out.println("That space is already taken!");
		}
	}


	public char getHorizontalWinner() {
		for (int i = 0; i < size; i++) {
			boolean same = true;
			char first = board[i][0];
			if (first == emptySpace) {
				continue;
			}
			for (int j = 1; j < size; j++) {
				if (board[i][j] != first) {
					same = false;
					break;
				}
			}
			if (same) {
				return first;
			}
		}
		return emptySpace;
	}


	public char getVerticalWinner() {
		for (int j = 0; j < size; j++) {
			boolean same = true;
			char first = board[0][j];
			if (first == emptySpace) {
				continue;
			}
			for (int i = 1; i < size; i++) {
				if (board[i][j] != first) {
					same = false;
					break;
				}
			}
			if (same) {
				return first;
			}
		}
		return emptySpace;
	}


	public char getDiagonalWinner() {
		// Check main diagonal (top-left to bottom-right)
		boolean same = true;
		char first = board[0][0];
		if (first != emptySpace) {
			for (int i = 1; i < size; i++) {
				if (board[i][i] != first) {
					same = false;
					break;
				}
			}
			if (same) {
				return first;
			}
		}

		// Check other diagonal (top-right to bottom-left)
		same = true;
		first = board[0][size - 1];
		if (first != emptySpace) {
			for (int i = 1; i < size; i++) {
				if (board[i][size - 1 - i] != first) {
					same = false;
					break;
				}
			}
			if (same) {
				return first;
			}
		}
		return emptySpace;
	}


	public char getWinner() {
		char winner = getHorizontalWinner();
		if (winner != emptySpace) {
			return winner;
		}
		winner = getVerticalWinner();
		if (winner != emptySpace) {
			return winner;
		}
		winner = getDiagonalWinner();
		if (winner != emptySpace) {
			return winner;
		}
		return emptySpace;
	}
}