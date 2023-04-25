import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Write a description of class PlayerSalaries here.
 * 
 * This class has all of my methods that are run in SalaryLookUp. 
 * The class uses a file, Salaries.csv to read and parse into an
 * array. 
 *
 * CSCI 221, Summer 2022, Programming HW 3
 * <Gavin Hammersley>
 * 
 * This work is entirely my own. 
 */
public class PlayerSalaries
{
    //create the instance variable
    int yearID;
    String teamID;
    String leagueID;
    String playerID;
    int salary;

    static ArrayList<PlayerSalary> people = new ArrayList<>();
    /**
     * Constructor for objects of class PlayerSalaries
     */
    public PlayerSalaries(String filename) throws FileNotFoundException
    {
        //Scanner to read the file for this homework
        Scanner input = new Scanner(new File("Salaries.csv"));

        //Set the delimiter commas or newlines
        input.useDelimiter(",|\n");
        input.nextLine();
        input.nextLine();

        //while there are more lines create the players
        while(input.hasNext())
        {
            //get the players year
            yearID = Integer.parseInt(input.next());
            //get the players team
            teamID = input.next();
            //get the players league
            leagueID = input.next();
            //get the players id
            playerID = input.next();
            //get the players salary
            salary = Integer.parseInt(input.next().trim());

            //create the player
            people.add(new PlayerSalary(yearID, teamID, leagueID, playerID, salary));
        }
    }

    public static int averageSalaryInYear(int year) throws FileNotFoundException
    {
        //initializing instance variables
        int i;

        long sumSalary = 0;
        long avgSalary = 0;
        int count = 0;

        //Scanner to take user unput for the avg salary
        // Scanner keyboard = new Scanner(System.in);
        // System.out.println("What year do you want to see an avg salary for? ");
        // year = keyboard.nextInt();

        for(i = 0; i < people.size(); i++)
        {
            if(people.get(i).getYearID() == year)
            {
                count++;
                sumSalary = sumSalary + people.get(i).getSalary();
                avgSalary = sumSalary / count;
            }
        }

        if (count == 0)
        {
            System.out.print("The year " + year + " does not exist in the file..." + "\n");
        }
        else
        {
            System.out.print("There are " + count + " players in " + year + "\n");
            //System.out.print("The sum salary is : " + sumSalary + "\n");
            System.out.println("The average salary is : " + avgSalary + "\n");
        }

        return 0;
    }

    public static PlayerSalary findPlayerInYear(String player, int year) throws FileNotFoundException
    {
        //initializing instance variables
        int i; 
        int count = 0;
        int yearCount = 0;
        int playerCount = 0;
        //Scanner for user input to find year and player 
        // Scanner keyboard = new Scanner(System.in);
        // System.out.println("What year would you like to look at? ");
        // System.out.print("What player would you like to find? ");
        // year = keyboard.nextInt();
        // player = keyboard.next();

        for(i = 0; i < people.size(); i++)
        {
            if(people.get(i).getYearID() == year)
            {
                yearCount++;
            }

            if(people.get(i).getYearID() == year && people.get(i).getPlayerID().equals(player))
            {
                System.out.println("Found " + player + " in " + year + "\n" + people.get(i));
                playerCount++;
            }
        }

        if (yearCount == 0)
        {
            System.out.println("Player " + player + " did not play in year " + year + "....");
        }
        else if (playerCount == 0)
        {
            System.out.println("Player " + player + " does not exist....");
        }

        return null;
    }

    public static PlayerSalary highestSalaryInYear(int year) throws FileNotFoundException
    {
        //initializing instance variables
        int i; 
        int count = 0;
        int yearCount = 0;

        long playerSalary = 0;
        long highSalary = 0;

        //Scanner for user input to find the year 
        // Scanner keyboard = new Scanner(System.in);
        // System.out.println("What year would you like to find the highest Salary for? ");
        // playerSalary = keyboard.nextInt();

        for(i = 0; i < people.size(); i++)
        {
            if(people.get(i).getYearID() == year)
            {
                playerSalary = people.get(i).getSalary();
                if(count == 0)
                {
                    highSalary = playerSalary;
                    count++;
                }

                if(playerSalary > highSalary)
                {
                    highSalary = playerSalary;
                }
            }
        }

        if (count != 0)
        {
            System.out.println("The highest salary for " + year + " was " + 
                highSalary + "\n");
        }
        else if (yearCount == 0)
        {
            System.out.println("The year " + year + " isnt in the file....");
        }

        return null;
    }

    public static PlayerSalary lowestSalaryInYear(int year) throws FileNotFoundException
    {
        //initializing instance variables
        int i; 
        int count = 0;
        int yearCount = 0;

        long playerSalary = 0;
        long lowSalary = 0;

        //Scanner for user input to find the year
        // Scanner keyboard = new Scanner(System.in);
        // System.out.println("What year would you like to find the lowest salary for? ");
        // playerSalary = keyboard.nextInt();

        for(i = 0; i < people.size(); i++)
        {
            if(people.get(i).getYearID() == year)
            {
                playerSalary = people.get(i).getSalary();

                if(count == 0)
                {
                    lowSalary = playerSalary;
                    count++;
                }

                if(playerSalary < lowSalary)
                {
                    lowSalary = playerSalary;
                }
            }
        }

        if (count != 0)
        {
            System.out.println("The lowest salary for " + year + " was " + 
                lowSalary + "\n");
        }
        else if (yearCount == 0)
        {
            System.out.println("The year " + year + " isnt in the file....");
        }

        return null;
    }

    public static PlayerSalary highestSalaryInTeamInYear(String team, int year) throws FileNotFoundException
    {
        //initializing instance variables
        int i;
        int count = 0;
        int yearCount = 0;
        int teamCount = 0;

        long teamSalary = 0;
        long highSalary = 0; 

        //Scanner for user input to find the team and year 
        // Scanner keyboard = new Scanner(System.in);
        // System.out.println("What team would you like to see the highest salary for? ");
        // System.out.println("What year would you like that to be for? ");
        // year = keyboard.nextInt();
        // teamSalary = keyboard.nextInt();

        for(i = 0; i < people.size(); i++)
        {
            if(people.get(i).getYearID() == year)
            {
                yearCount++;

                if (people.get(i).getTeamID().equals(team))
                {
                    teamCount++;
                    teamSalary = people.get(i).getSalary();

                    if (count == 0)
                    {
                        highSalary = teamSalary;
                        count++;
                    }

                    if (teamSalary > highSalary)
                    {  
                        highSalary = teamSalary;
                    }
                }
            }
        }

        if (yearCount == 0)
        {
            System.out.println("The year " + year + " does not exist" + "\n");
        }
        
        if (teamCount == 0)
        {
            System.out.println("The team " + team + " does not exist in " + year + "\n");
        }

        if (yearCount > 0 && teamCount > 0)
        {
            System.out.println("The highest salary for team " + team + " in " + year 
                                + " was " + highSalary + "\n");
        }

        return null;
    }

    public static PlayerSalary lowestSalaryInTeamInYear(String team, int year) throws FileNotFoundException
    {
        //initializing instance variables
        int i;
        int count = 0;
        int yearCount = 0;
        int teamCount = 0;

        long teamSalary = 0;
        long lowSalary = 0;

        //Scanner for user input to find the team and year
        // Scanner keyboard = new Scanner(System.in);
        // System.out.println("What team would you like to see the lowest salary for? ");
        // System.out.println("What year would you like that to be for? ");
        // year = keyboard.nextInt();
        // teamSalary = keyboard.nextInt();
        
        for(i = 0; i < people.size(); i++)
        {
            if(people.get(i).getYearID() == year)
            {
                yearCount++;

                if (people.get(i).getTeamID().equals(team))
                {
                    teamCount++;
                    teamSalary = people.get(i).getSalary();

                    if (count == 0)
                    {
                        lowSalary = teamSalary;
                        count++;
                    }

                    if (teamSalary < lowSalary)
                    {  
                        lowSalary = teamSalary;
                    }
                }
            }
        }

        if (yearCount == 0)
        {
            System.out.println("The year " + year + " does not exist" + "\n");
        }
        
        if (teamCount == 0)
        {
            System.out.println("The team " + team + " does not exist in " + year + "\n");
        }

        if (yearCount > 0 && teamCount > 0)
        {
            System.out.println("The lowest salary for team " + team + " in " + year 
                                + " was " + lowSalary + "\n");
        }

        return null;
    }

    public static PlayerSalary highestSalaryInLeagueInYear(String leag, int year) throws FileNotFoundException
    {
        //initializing instance variables
        int i;
        int count = 0;
        int yearCount = 0;
        int leagueCount = 0;

        long leagueSalary = 0;
        long highSalary = 0;

        //Scanner for user input to find the league and year
        // Scanner keyboard = new Scanner(System.in);
        // System.out.println("What league would you like to see the highest salary for? ");
        // System.out.println("What year would you like that to be for? ");
        // year = keyboard.nextInt();
        // leagueSalary = keyboard.nextInt();

        for(i = 0; i < people.size(); i++)
        {
            if(people.get(i).getYearID() == year)
            {
                yearCount++;

                if (people.get(i).getLeagueID().equals(leag))
                {
                    leagueCount++;
                    leagueSalary = people.get(i).getSalary();

                    if (count == 0)
                    {
                        highSalary = leagueSalary;
                        count++;
                    }

                    if (leagueSalary > highSalary)
                    {  
                        highSalary = leagueSalary;
                    }
                }
            }
        }

        if (yearCount == 0)
        {
            System.out.println("The year " + year + " does not exist" + "\n");
        }
        
        if (leagueCount == 0)
        {
            System.out.println("The league " + leag + " does not exist in " + year + "\n");
        }

        if (yearCount > 0 && leagueCount > 0)
        {
            System.out.println("The highest salary for league " + leag + " in " + year 
                                + " was " + highSalary + "\n");
        }
        
        
        return null;
    }

    public static PlayerSalary lowestSalaryInLeagueInYear(String leag, int year) throws FileNotFoundException
    {
        //initializing instance variables
        int i;
        int count = 0;
        int yearCount = 0;
        int leagueCount = 0;

        long leagueSalary = 0;
        long lowSalary = 0;

        //Scanner for user input to find the league and year
        // Scanner keyboard = new Scanner(System.in);
        // System.out.println("What league would you like to see the lowest salary for? ");
        // System.out.println("What year would you like that to be for? ");
        // year = keyboard.nextInt();
        // leagueSalary = keyboard.nextInt();

        for(i = 0; i < people.size(); i++)
        {
            if(people.get(i).getYearID() == year)
            {
                yearCount++;

                if (people.get(i).getLeagueID().equals(leag))
                {
                    leagueCount++;
                    leagueSalary = people.get(i).getSalary();

                    if (count == 0)
                    {
                        lowSalary = leagueSalary;
                        count++;
                    }

                    if (leagueSalary < lowSalary)
                    {  
                        lowSalary = leagueSalary;
                    }
                }
            }
        }

        if (yearCount == 0)
        {
            System.out.println("The year " + year + " does not exist" + "\n");
        }
        
        if (leagueCount == 0)
        {
            System.out.println("The league " + leag + " does not exist in " + year + "\n");
        }

        if (yearCount > 0 && leagueCount > 0)
        {
            System.out.println("The lowest salary for league " + leag + " in " + year 
                                + " was " + lowSalary + "\n");
        }

        return null;
    }
}