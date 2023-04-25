import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Write a description of class PlayerStatPortal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerStatPortal
{
    public static void main(String[] args) throws Exception, InputMismatchException {
        Players playersData = new Players("Pitching.csv","Batting.csv","Master.csv");
        Scanner scnr = new Scanner(System.in);
        
        int choice = 0;
        String usrStr = "";

        do {
            System.out.println("The methods that use the compare run at an average of 4min to print... They all");
            System.out.println("work I just wasnt able to fully figure out/implement the sort for optimization");
            System.out.println();
            System.out.println("1: Find the top Batter(s)");
            System.out.println("2: Find the top Pitcher(s)");
            System.out.println("3: Find a Player using their ID");
            System.out.println("4: Find the top HomeRun Hitter(s)");
            System.out.println("5: Find the top Lowest ERA(s)");
            System.out.println("6: Quit Program");
            System.out.println();
            System.out.print("Enter a Number 1-6: ");

            try{
                choice = scnr.nextInt();
                
                switch(choice) {
                    case 1:
                        try
                        {
                            System.out.print("Enter the Number of Batters you would like displayed: ");
                            choice = scnr.nextInt();
                            System.out.println("Top " + choice + " Batters are: ");
                            System.out.println(playersData.getTopBattersSorted(choice));
                        }
                        catch (InputMismatchException error1)
                        {
                            System.out.println("Invalid.");
                            scnr.nextLine(); //flushes out the input
                            break;
                        }
                        break;
                    case 2:
                        try
                        {
                            System.out.print("Enter the Number of Pitchers you would like displayed: ");
                            choice = scnr.nextInt();
                            System.out.println("Top " + choice + " Pitchers are: ");
                            System.out.println(playersData.getTopPitchersSorted(choice));
                        }
                        catch (InputMismatchException error2)
                        {
                            System.out.println("Invalid.");
                            scnr.nextLine(); //flushes out the input
                            break;
                        }
                        break;
                    case 3: 
                        try
                        {
                            System.out.print("Enter PlayerID: ");
                            usrStr = scnr.next();
                            System.out.println(playersData.getPlayer(usrStr));
                        }
                        catch (InputMismatchException error3)
                        {
                            System.out.println("Invalid.");
                            scnr.nextLine(); //flushes out the input
                            break;
                        }
                        break;
                    case 4: 
                        try
                        {
                            System.out.print("Enter the Number of Home Run Hitters you would like displayed: ");
                            choice = scnr.nextInt();
                            System.out.println(choice + " Top HomeRun Hitters: ");
                            System.out.println(playersData.getTopHomerunHittersSorted(choice));
                        }
                        catch (InputMismatchException error4)
                        {
                            System.out.println("Invalid.");
                            scnr.nextLine(); //flushes out the input
                            break;
                        }
                        break;
                    case 5: 
                        try
                        {
                            System.out.print("Enter the Number of pitchers for ERA you would like displayed: ");
                            choice = scnr.nextInt();
                            System.out.println("Lowest " + choice + " ERA players: ");
                            System.out.println(playersData.getLowestERASorted(choice));
                        }
                        catch (InputMismatchException error5)
                        {
                            System.out.println("Invalid.");
                            scnr.nextLine(); //flushes out the input
                            break;
                        }
                        break;
                    case 6:
                        System.out.println();
                        System.out.println("GoodBye!");
                        break;
                    default:
                        System.out.println("Please enter an integer between 1 and 6");
                }

            }
            catch(InputMismatchException e)
            {
                System.out.println();
                System.out.println("Could not find");
            }
            
        }while (choice != 6);
    }
}