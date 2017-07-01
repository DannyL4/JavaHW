
public class Connect4Board {

    public enum Color {RED, BLACK, NOT_SET};
    final static int NUM_SLOTS = 7;
    final static int SLOT_HEIGHT = 6;


    Color [][] board;
    int[] slotNext; //richard called this numInSlot
    int numPlayed;

    public Connect4Board () {
        board = new Color[NUM_SLOTS][SLOT_HEIGHT];
        for (int i = 0; i < NUM_SLOTS; i++)
            for (int j = 0; j < SLOT_HEIGHT; j++)
                board [i][j] = Color.NOT_SET;
        slotNext = new int[NUM_SLOTS];
        for (int i = 0; i < NUM_SLOTS; i++)
            slotNext[i] = 0;
        numPlayed = 0;
    }

    private int checkLeft(int slot, int slotIndex) {
        Color c = board[slot][slotIndex];
        int count = 0;
        while((--slot >= 0) && (board[slot][slotIndex] == c)) {
            count++;
        }
        return count;
    }

    private int checkRight(int slot, int slotIndex) {
        Color c = board[slot][slotIndex];
        int count = 0;
        while((++slot < NUM_SLOTS) && (board[slot][slotIndex] == c))
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

    private int checkRightUp(int slot, int slotIndex) {
        Color c = board[slot][slotIndex];
        int count = 0;
        while(++slot < NUM_SLOTS && ++slotIndex <= SLOT_HEIGHT && board[slot][slotIndex] == c)
            count++;
        return count;
    }

    private int checkLeftDown(int slot, int slotIndex) {
        Color c = board[slot][slotIndex];
        int count = 0;
        while(--slot >= 0 && --slotIndex >= 0 && board[slot][slotIndex] == c)
            count++;
        return count;
    }

    private int checkLeftUp(int slot, int slotIndex) { //this method works
        Color c = board[slot][slotIndex];
        int count = 0;
        while (--slot >= 0 && ++slotIndex < SLOT_HEIGHT && board[slot][slotIndex] == c)
            count++;
        return count;
    }

    private int checkRightDown(int slot, int slotIndex) { //this method works
        Color c = board[slot][slotIndex];
        int count = 0;
        while(++slot < NUM_SLOTS && --slotIndex >= 0 && board[slot][slotIndex] == c)
            count++;
        return count;
    }

    private boolean checkWin(int slot) {
        int slotIndex = slotNext[slot] - 1;
        if (checkLeft(slot, slotIndex) + checkRight(slot, slotIndex) >= 3)
            return true;
        if (checkUp(slot, slotIndex) + checkDown(slot, slotIndex) >= 3)
            return true;
        if(checkLeftUp(slot, slotIndex) + checkRightDown(slot, slotIndex) >= 3)
            return true;
        if(checkRightUp(slot,slotIndex) + checkLeftDown(slot, slotIndex) >= 3)
            return true;
        return false;
    }

    boolean drop(int slot, Color c) {

        board[slot][slotNext[slot]++] = c;
        numPlayed++;

        return checkWin(slot);
    }

    public boolean canDrop(int slot) {
        return slotNext[slot] < SLOT_HEIGHT;
    }

    public boolean isFull() {
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

    public void print() {
        for (int i = SLOT_HEIGHT - 1; i >= 0; i--) {
            for (int j = 0; j < NUM_SLOTS; j++)
                System.out.print(" " + colorToChar(board[j][i]));
            System.out.println();
        }
        for (int i = 0; i < NUM_SLOTS; i++)
            System.out.print(" " + (i + 1));
        System.out.println();
    }
}
