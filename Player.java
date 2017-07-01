
public class Player {

    public int guess(int guessLimit) {
    int number = (int) (Math.random() * guessLimit);

    return number;
    }
}
