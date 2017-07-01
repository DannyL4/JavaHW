import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Connect4Game {

	private static int getMove(Connect4Board.Color color) {

		System.out.print("Player " + color + ", what is your move? ");

		String inputLine = null;
		try {
			while (true) {
				BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
				inputLine = is.readLine();
				if (inputLine.length() != 0)
					break;
			}
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}

		return Integer.parseInt(inputLine) - 1;
	}

	private static Connect4Board.Color otherPlayer(Connect4Board.Color player) {
		switch (player) {
		case RED:
			return Connect4Board.Color.BLACK;
		case BLACK:
			return Connect4Board.Color.RED;
		default:
			return Connect4Board.Color.NOT_SET;
		}
	}

	public static void main(String[] args) {

		Connect4Board c4b = new Connect4Board();
		Connect4Board.Color player = Connect4Board.Color.BLACK;

		while (!c4b.isBoardFilled()) {

			int slot = getMove(player);
			boolean win = c4b.drop(slot, player);
			c4b.printBoard();

			if (win) {
				System.out.println("Player " + player + " wins!");
				break;
			}
			
			System.out.println();

			player = otherPlayer(player);
		}
	}
}
