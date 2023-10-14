/**
 * A Hello World program in Java.
 * This is a Javadoc comment.
 *
 * @author Miralem Banovi
 * @version 1.0
*/
package miralembanovi319;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Tic-Tac-To-319 class implements the tic-tac-toe-game.
 */
public class miralembanovi319 {
	private char[][] board;
	private char currentPlayer;
	private boolean gameOver;

	/**
	 * The main method creates a Tic-Tac-To-319 object and starts the game. *
	 * 
	 * @param args command line parameters
	 */
	public static void main(String[] args) {
		miralembanovi319 game = new miralembanovi319();
		game.startGame();
	}

	/**
	 * The constructor initializes the game board and game variables.
	 */
	public miralembanovi319() {
		board = new char[3][3];
		gameOver = false;
		currentPlayer = 'X';

		// Initialize the game board
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	/**
	 * The startGame method starts the tic-tac-toe game.
	 */
	public void startGame() {
		System.out.println("Welcome to Tic-Tac-Toe!");
		try (Scanner scanner = new Scanner(System.in)) {
			while (!gameOver) {
				displayBoard1();
				System.out
						.println("Player " + currentPlayer + ", please enter the row and column numbers (e.g., 0 1 2 ): ");

				try {
					int row = scanner.nextInt();
					int col = scanner.nextInt();

					if (isValidMove1(row, col)) {
						board[row][col] = currentPlayer;

						if (hasPlayerWon1()) {
							displayBoard1();
							System.out.println("Player " + currentPlayer + " has won!");
							gameOver = true;
						} else if (isBoardFull1()) {
							displayBoard1();
							System.out.println("It's a draw!");
							gameOver = true;
						} else {
							currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
						}
					} else {
						System.out.println("Invalid move! Please try again.");
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid input! Please enter numbers.");
					scanner.nextLine(); // Clear the input buffer
				}

				if (gameOver) {
					System.out.println("Do you want to start a new game or exit? (new/exit): ");
					String choice = scanner.next();

					if (choice.equals("new")) {
						resetGame1();
					} else {
						System.out.println("Thank you for playing. Goodbye!");
						scanner.close();
						return;
					}
				}
			}
		}
	}

	/**
	 * The display Board method displays the current board on the console.
	 */
	private void displayBoard1() {
		System.out.println("-------------");

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("| " + board[i][j] + " ");
			}
			System.out.println("|");
			System.out.println("-------------");
		}
	}

	/**
	 * The isValidMove method checks if the player's move is valid.
	 *
	 * @param row the row number of the train
	 * @param col the column number of the train
	 * @return true if the move is valid, otherwise false
	 */
	private boolean isValidMove1(int row, int col) {
		if (row < 0 || row >= 3 || col < 0 || col >= 3) {
			return false;
		}

		return board[row][col] == ' ';
	}

	/**
	 * The hasPlayerWon method checks if the current player has won.
	 *
	 * @return true if the player won, otherwise false
	 */
	private boolean hasPlayerWon1() {
		// Check rows and columns
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
				return true;
			}

			if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
				return true;
			}
		}

		// Check diagonals
		if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
			return true;
		}

		if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
			return true;
		}

		return false;
	}

	/**
	 * The isBoardFull method checks if the board is full (tie).
	 *
	 * @return true if the board is full, otherwise false
	 */
	private boolean isBoardFull1() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * The resetGame method resets the game.
	 */
	private void resetGame1() {
		currentPlayer = 'X';
		gameOver = false;

		// Clear the game board
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}
}