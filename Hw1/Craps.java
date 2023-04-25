/**
 *
 * This class will creat the craps game. Using the random roll of two die it
 * will determine if that game was a win or lose. This method will return
 * the outcome to the HW2.java method where it will determine wins, loses and 
 * probability of a win.
 * 
 * This code was written entirely by my own
 *
 * @Gavin Hammersley
 * HW 1, Summer 2022
 * 
 * 
 */
//import java.util.Scanner;
public class Craps
{
    /** 
     * instance variables
     */
    private Die die1 = new Die();
    private Die die2 = new Die();

    /**
     * playCraps - simulates a single game of craps
     * @return - 1 indicates a win, 0 a loss
     */  
    public int playCraps()
    {
        // My Craps code

        //Rolling the Die and totaling them
        int roll1 = die1.roll();
        int roll2 = die2.roll();
        int total = roll1 + roll2;
        
        int outcome = 0;

        //Figuring out if it was a win or not
        if (total == 7 || total == 11)
        {
            //System.out.println("Conrgrats you win!");
            outcome = 1;
        }
        else if (total == 2 || total == 3 || total == 12)
        {
            //System.out.println("Sorry you lost.");
            outcome = 0;
        }
        //If they didnt win, point
        else
        {
            int point = total;

            boolean loop = true;
            while(loop)
            {
                //System.out.println("Roll your dice again.");

                roll1 = die1.roll();
                roll2 = die2.roll();
                total = roll1 + roll2;

                //System.out.println("Your second roll was " + total);

                //Matched point
                if (total == point)
                {
                    //System.out.println("Your rolls were a match, sorry you lose.");
                    loop = false;
                    outcome = 0;
                }
                // Rolled a 7
                else if (total == 7)
                {
                    //System.out.println("You rolled a 7, sorry you lose.");
                    loop = false;
                    outcome = 0; 
                }
            }
        }
        return outcome;
    }
}