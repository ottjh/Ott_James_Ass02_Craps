import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        //Okay, we are making a game of craps. It's a game of dice where two dice are rolled.
        //In the first round, rolling a sum of 2, 3, or 12 causes you to lose, while 7 or 11 is a win.
        //If one doesn't roll any of those numbers, then the sum of the first round becomes the goal.
        //Rolling a 7 in subsequent rounds causes a loss.
        int die1 = 0;
        int die2 = 0;
        int dieSum = 0;
        int playerPoint;
        String playerDone = "";
        boolean gameOver;
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the game of Craps");

        //Now to start the game
        do {
            gameOver = false;
            do {
                playerPoint = 0;
                die1 = rnd.nextInt(6) + 1;
                die2 = rnd.nextInt(6) + 1;
                dieSum = die1 + die2;
                if (dieSum == 2 || dieSum == 3 || dieSum == 12)
                {
                    System.out.println("You have rolled: " + dieSum +". You have crapped out and lost.");
                    gameOver = true;
                }
                else if (dieSum == 7 || dieSum == 11)
                {
                    System.out.println("You have rolled: " + dieSum + ". You have scored a natural and won!");
                    gameOver = true;
                }
                else
                {
                    playerPoint = dieSum;
                    System.out.println("You have rolled: " + dieSum + ". You are now trying to hit it to win.");
                    do {
                        System.out.println("");
                        die1 = rnd.nextInt(6) + 1;
                        die2 = rnd.nextInt(6) + 1;
                        dieSum = die1 + die2;

                        if (dieSum == playerPoint)
                        {
                            System.out.println("You have hit your point number of: " + playerPoint + ". You have won!");
                            gameOver = true;
                        }
                        else if (dieSum == 7)
                        {
                            System.out.println("You have hit 7 and lost.");
                            gameOver = true;
                        }
                        else
                        {
                            System.out.println("You rolled a: " + die1 + " and a " + die2 + " for a sum of" + dieSum + ". \n You are still trying for the point.");
                        }
                    } while (!gameOver);
                }

            } while (!gameOver);

            System.out.print("If you would like to quit, enter [Q]. Otherwise we will play again: ");
            playerDone = in.nextLine();
        } while (!playerDone.equalsIgnoreCase("Q"));

    }
}