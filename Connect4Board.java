
public class Connect4Board {

	final int NUM_SLOTS = 7;
	final int SLOT_HEIGHT = 6;
	
	enum Color { NOT_SET, RED, BLACK }

	Color[][] board;
	int[] slotNext;
	int numPlayed;

	Connect4Board() {
		board = new Color[NUM_SLOTS][SLOT_HEIGHT];
		for (int i = 0; i < NUM_SLOTS; i++)
			for (int j = 0; j < SLOT_HEIGHT; j++)
				board[i][j] = Color.NOT_SET;
		
		slotNext = new int[NUM_SLOTS];
		for (int i = 0; i < NUM_SLOTS; i++)
			slotNext[i] = 0;
		
		numPlayed = 0;
	}

	private int checkLeft(int slot, int slotIndex) {
		Color c = board[slot][slotIndex];
		int count = 0;
		while ((--slot >= 0) && (board[slot][slotIndex] == c))
			count++;
		return count;
	}

	private int checkRight(int slot, int slotIndex) {
		Color c = board[slot][slotIndex];
		int count = 0;
		while ((++slot < NUM_SLOTS) && (board[slot][slotIndex] == c))
			count++;
		return count;
	}

	private int checkUp(int slot, int slotIndex) {
		Color c = board[slot][slotIndex];
		int count = 0;
		while ((++slotIndex < SLOT_HEIGHT) && (board[slot][slotIndex] == c))
			count++;
		return count;
	}

	private int checkDown(int slot, int slotIndex) {
		Color c = board[slot][slotIndex];
		int count = 0;
		while ((--slotIndex >= 0) && (board[slot][slotIndex] == c))
			count++;
		return count;
	}

	private boolean checkWin(int slot) {
		int slotIndex = slotNext[slot] - 1;
		if (checkLeft(slot, slotIndex) + checkRight(slot, slotIndex) >= 3)
			return true;
		if (checkUp(slot, slotIndex) + checkDown(slot, slotIndex) >= 3)
			return true;
		return false;
	}

	public boolean canDrop(int slot) {
		return slotNext[slot] < SLOT_HEIGHT;
	}
	
	public boolean drop(int slot, Color color) {
		board[slot][slotNext[slot]++] = color;
		numPlayed += 1;
		return checkWin(slot);
	}
	
	public boolean isBoardFilled() {
		return numPlayed == NUM_SLOTS * SLOT_HEIGHT;
	}

	private char colorToChar(Color c) {
		switch (c) {
		case RED:
			return 'R';
		case BLACK:
			return 'B';
		default:
			return '-';
		}
	}

	public void printBoard() {
		for (int i = SLOT_HEIGHT-1; i >= 0 ; i--) {
			System.out.print(i + " ");
			for (int j = 0; j < NUM_SLOTS; j++)
				System.out.print(" " + colorToChar(board[j][i]));
			System.out.println();
		}
		
		System.out.print("  ");
		for (int i = 0; i < NUM_SLOTS; i++)
			System.out.print(" " + (i+1));
		System.out.println();
	}
	
	public static void main(String[] args) {
		Connect4Board c4b = new Connect4Board();
		c4b.printBoard();
		c4b.drop(0, Color.RED);
		c4b.drop(1, Color.BLACK);
		c4b.drop(1, Color.RED);
		c4b.drop(2, Color.BLACK);
		System.out.println();
		c4b.printBoard();
	}
}
