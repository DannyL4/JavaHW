
import java.util.*;

public class GuessGame {

    public void startGame(int numPlayers, int guessLimit) {

        ArrayList<Player> playerList = new ArrayList<Player>(numPlayers);

        for (int i = 0; i < numPlayers; i++)
            playerList.add(new Player());

        int targetNumber = (int) (Math.random() * guessLimit);
        System.out.println("I'm thinking of a number between 0 and " + guessLimit + "...");

        while (true) {

            System.out.println("Number to guess is " + targetNumber);

            ArrayList<Integer> guesses = new ArrayList<Integer>(numPlayers);
            ArrayList<Boolean> isRight = new ArrayList<Boolean>(numPlayers);


            for (int i = 0; i < numPlayers; i++) {
                int guess = playerList.get(i).guess(guessLimit);
                guesses.add(guess);
                System.out.println("Player " + (i + 1) + " guessed " + guesses.get(i));
                isRight.add(guesses.get(i) == targetNumber);
            }

            if (isRight.contains(true)) {
                System.out.println("We have a winner!");
                for (int i = 0; i < numPlayers; i++) {
                    System.out.println("Player " + (i + 1) + " got it right? " + isRight.get(i));
                }
                System.out.println("Game is over\n");
                break;
            }
            else {
               System.out.println("No winner. Players will have to try again.\n");
            }
        }
    }

    public static void main(String[] args) {
        int numPlayers = Integer.parseInt(args[0]);
        int guessLimit = Integer.parseInt(args[1]);
        GuessGame game = new GuessGame();
        game.startGame(numPlayers, guessLimit);
    }

}
