/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables
    private int Height;
    private int Weight;
    private String PlayerID;
    private String FirstName;
    private String LastName;
    private String BirthDate;
    private String BirthLocation;
    
    public Player()
    {
        this.PlayerID = null;
        this.FirstName = null;
        this.LastName = null;
        this.BirthDate = null;
        this.BirthLocation = null;
        this.Height = 0;
        this.Weight = 0;
    }
    
    /**
     * Constructor for objects of class Player
     */
    public Player(String playerID, String firstName, String lastName, String birthDate, 
    String birthLocation, int height, int weight)
    {
        PlayerID = playerID;
        FirstName = firstName;
        LastName = lastName;
        BirthDate = birthDate;
        BirthLocation = birthLocation;
        Height = height;
        Weight = weight;
    }
    
    /**
     * Returns the string of the Player object
     */
    public String toString()
    {
        String Height1 = Integer.toString(Height);
        String Weight1 = Integer.toString(Weight);
        
        if (Height == -1)
        {
             Height1 = "None listed";
        }
        
        if (Weight == -1) 
        {
             Weight1 = "None listed";
        }
        
        return
        "Player: " + PlayerID +
        "\nFirst Name: " + FirstName + 
        "\nLast Name: " + LastName + 
        "\nHeight: " + Height1 +
        "\nWeight: " + Weight1 + 
        "\nBirth Day: " + BirthDate + 
        "\nBirth Location: " + BirthLocation +
        "\n";
    }
    
    /**
     * returns all the getter/setter methods
     */
    public String getPlayerID()
    {
        return PlayerID;
    }
    public void setPlayerID(String playerID)
    {
        PlayerID = playerID;
    }

    public String getFirstName()
    {
        return FirstName;
    }
    public void setFirstName(String firstName)
    {
        FirstName = firstName;
    }

    public String getLastName()
    {
        return LastName;
    }
    public void setLastName(String lastName)
    {
        LastName = lastName;
    }

    public String getBirthDate()
    {
        return BirthDate;
    }
    public void setBirthDate(String birthDate)
    {
        BirthDate = birthDate;
    }

    public String getBirthLocation()
    {
        return BirthLocation;
    }
    public void setBirthLocation(String birthLocation)
    {
        BirthLocation = birthLocation;
    }

    public int getHeight()
    {
        return Height;
    }
    public void setHeight(int height)
    {
        Height = height;
    }

    public int getWeight()
    {
        return Weight;
    }
    public void setWeight(int weight)
    {
        Weight = weight;
    }

}
