
/**
 * Write a description of class Pitcher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pitcher extends Player implements Comparable
{
    // instance variables
    private int YearID;
    private int Wins;
    private int Losses;
    private Double ERA;
    private String TeamID;

    /**
     * Constructor for object Pitcher
     */
    public Pitcher(int yearID, String teamID, int wins, int losses, double era)
    {
        super();
        YearID = yearID;
        TeamID = teamID;
        Wins = wins;
        Losses = losses;
        ERA = era;
    }

    /**
     * Constructor for object Pitcher
     */
    public Pitcher(String playerID, String firstName, String lastName, String birthDate, 
    String birthLocation, int height, int weight, int yearID, 
    String teamID, int wins, int losses, double era) 
    {
        super(playerID, firstName, lastName, birthDate, birthLocation, height, weight);
        YearID = yearID;
        TeamID = teamID;
        Wins = wins;
        Losses = losses;
        ERA = era;
    }

    /**
     * returns the string of playerSalary object
     */
    public String toString()
    {
        return
        "PlayerID: " + this.getPlayerID() +
        "\nYear: " + YearID +
        "\nWins: " + Wins +
        "\nLosses: " + Losses + 
        "\nERA: " + ERA +
        "\nTeam: " + TeamID + 
        "\n";
    }

    /**
     * returns all the getter/setter methods
     */
    public int getYearID()
    {
        return YearID;
    }
    public void setYearID(int yearID)
    {
        YearID = yearID;
    }

    public String getTeamID()
    {
        return TeamID;
    }
    public void setTeamID(String teamID)
    {
        TeamID = teamID;
    }

    public int getWins()
    {
        return Wins;
    }
    public void setWins(int wins)
    {
        Wins = wins;
    }

    public int getLosses()
    {
        return Losses;
    }
    public void setLosses(int losses)
    {
        Losses = losses;
    }

    public double getERA()
    {
        return ERA;
    }
    public void setERA(double ERA)
    {
        this.ERA = ERA;
    }
    
    //compare to's for the pitchers
    public int compareToERA(Object comp1)
    {
        if(this.getERA() > ((Pitcher) comp1).getERA())
        {
            return 1;
        }
        else if(this.getERA() == ((Pitcher) comp1).getERA())
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }

    public int compareTo(Object comp1)
    {
        Pitcher pitch1 = (Pitcher) comp1;

        int winLoss1 = pitch1.getWins() - pitch1.getLosses();
        int winLoss2 = this.getWins() - this.getWins();

        if(winLoss2 > winLoss1) 
        {
            return 1;
        }
        else if(winLoss2 == winLoss1)
        {
            //compareToERA(comp1);
            if(this.getERA() > ((Pitcher) comp1).getERA())
            {
                return 1;
            }
            else if(this.getERA() == ((Pitcher) comp1).getERA())
            {
                return 0;
            }
            else
            {
                return -1;
            }

        }
        else 
        {
            return -1;
        }
    }
}