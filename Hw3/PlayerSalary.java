
/**
 * Write a description of class PlayerSalary here.
 * 
 * This class has my get, and to string methods that are used to get
 * information and parse my code so that it can be run in the other
 * classes.
 *
 *CSCI 221, Summer 2022, Programming HW 3
 * <Gavin Hammersley>
 * 
 * This work is entirely my own. 
 */
public class PlayerSalary
{
    // instance variables - replace the example below with your own
    private int yearID;
    private String teamID;
    private String leagueID;
    private String playerID;
    private int salary;

    /**
     * Constructor for objects of class PlayerSalary
     */
    public PlayerSalary(int year, String team, String league, 
    String player, int salary)
    {
        // initialise instance variables
        yearID = year;
        teamID = team;
        leagueID = league;
        playerID = player;
        this.salary = salary;
    }

    //your code goes here
    /**
     * returns the string of playerSalary object
     */
    public String toString()
    {
        return
        "Year : " + yearID + 
        "\nTeam : " + teamID + 
        "\nLeague : " + leagueID + 
        "\nPlayer : " + playerID + 
        "\nSalary : " + salary + 
        "\n";
        //return yearID + "\n" + teamID + "\n" + leagueID + "\n" + playerID + "\n" + salary + "\n";
    }

    /**
     * returns all the getter methods
     */
    public int getYearID() 
    { 
        return yearID; 
    }

    public String getTeamID() 
    { 
        return teamID; 
    }

    public String getLeagueID() 
    { 
        return leagueID; 
    }

    public String getPlayerID() 
    { 
        return playerID; 
    }

    public int getSalary() 
    { 
        return salary; 
    }

    public static void main(String [] args) 
    {
        PlayerSalary test = new PlayerSalary(2022, "Yankees", "MLB", "Gavin", 60);

        System.out.println(test);

    }
}
