
/**
 * This class will run the craps.java method in a loop untill 10000 games
 * have been played. After it will print the total wins, loses and 
 * win probablity percentage. 
 * 
 * This code was written entirely by my own
 *
 * @Gavin Hammersley
 * HW 1, Summer 2022

 */
public class HW2
{

    /**
     * main - drives the game of craps test of wins/losses in 10000 games
     */
    public static void main (String [] args)
    {
        // start a new game
        Craps game = new Craps();  // an instance of a Craps class
        //game.playCraps();// call the method that plays the game

        double win = 0;
        double lose = 0; 

        for (int i = 0; i < 10000; i++)
        {
            int total = game.playCraps();
            if (total == 1)
            {
                win += 1;
            }
            else if (total == 0)
            {
                lose += 1;
            }
        }
        System.out.println("Your total wins are: " + win);
        System.out.println("Your total loses are: " + lose);

        double percentWin = (win / (win + lose) * 100);
        System.out.println("The win probability is: " + String.format("%.02f", percentWin)+ "%");

    }
}
