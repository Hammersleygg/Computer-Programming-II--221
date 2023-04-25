import java.util.*;
/**
 * Write a description of class Batter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Batter extends Player implements Comparable
{
    // instance variables
    private int YearID;
    private int HomeRuns;
    private int RBI;
    private String TeamID;

    /**
     * Constructor for objects of class Batter
     */
    public Batter(int YearID, String TeamID, int HomeRuns, int RBI)
    {
        super();
        this.YearID = YearID;
        this.TeamID = TeamID;
        this.HomeRuns = HomeRuns;
        this.RBI = RBI;
    }

    /**
     * returns the string of Batter object
     */
    public String toString()
    {
        return 
        "PlayerID: " + this.getPlayerID() +
        "\nYear: " + YearID + 
        "\nTeam: " + TeamID +
        "\nHome Runs: " + HomeRuns + 
        "\nRBI: " + RBI +
        "\n";
    }

    /**
     * returns all the getter/setter methods
     */
    public int getYearID() {
        return YearID;
    }
    public void setYearID(int yearID) {
        yearID = yearID;
    }

    public String getTeamID() {
        return TeamID;
    }
    public void setTeamID(String teamID) {
        TeamID = teamID;
    }

    public int getHomeRuns() {
        return HomeRuns;
    }
    public void setHomeRuns(int homeRuns) {
        HomeRuns = homeRuns;
    }

    public int getRBI() {
        return RBI;
    }
    public void setRBI(int RBI) {
        this.RBI = RBI;
    }

    public int compareToHomeRuns(Object bat1)
    {
        if(this.getHomeRuns() > ((Batter) bat1).getHomeRuns())
        {
            return 1;   
        }
        else if(this.getHomeRuns() == ((Batter) bat1).getHomeRuns())
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }

    public int compareTo(Object bat2)
    {
        if(this.getRBI() == ((Batter) bat2).getRBI()){  

            if(this.getHomeRuns() > ((Batter) bat2).getHomeRuns())
            { 
                return 1;
            }
            else if(this.getHomeRuns() == ((Batter) bat2).getHomeRuns())
            {
                return 0;
            }
            else 
            {
                return -1;
            } 

        }
        else if(this.getRBI() > ((Batter) bat2).getRBI())
        {
            return 1;
        }
        else 
        {
            return -1;
        }
        
        //Collections.sort(Batter);
    }

    public static void main(String [] args)
    {
        Batter test = new Batter(2002, "Yankees", 10, 20);

        System.out.println(test);
    }
}