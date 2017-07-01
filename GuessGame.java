
public class GuessGame {

   public void startGame() {
	   
       Player p1 = new Player();
       Player p2 = new Player();
       Player p3 = new Player();
       
       int targetNumber = (int) (Math.random() * 10);
       System.out.println("I'm thinking of a number between 0 and 9...");
       
       while (true) {
    	   
           System.out.println("Number to guess is " + targetNumber);
           
           int guessp1 = p1.guess();
           int guessp2 = p2.guess();
           int guessp3 = p3.guess();
           
           System.out.println("Player 1 guessed " + guessp1);
           System.out.println("Player 2 guessed " + guessp2);
           System.out.println("Player 3 guessed " + guessp3);
           
           boolean p1isRight = (guessp1 == targetNumber);
           boolean p2isRight = (guessp2 == targetNumber);
           boolean p3isRight = (guessp3 == targetNumber);
           
           if (p1isRight || p2isRight || p3isRight)
           {
               System.out.println("We have a winner!");
               System.out.println("Player one got it right? " + p1isRight);
               System.out.println("Player two got it right? " + p2isRight);
               System.out.println("Player three got it right? " + p3isRight);
               System.out.println("Game is over");
               break;
           }
           else
           {
               System.out.println("Players will have to try again.");
           }
       }
   }

   public static void main (String[] args) {
       GuessGame game = new GuessGame();
       game.startGame();
   }
}
