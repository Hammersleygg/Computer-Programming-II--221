import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Players here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Players
{
    // instance variables
    private ArrayList<Player> Roster;
    private String PitData;
    private String BatData;
    private String MasterData;

    /**
     * defaut constructor
     */
    public Players()
    {
        PitData = "Pitching.csv";
        BatData = "Batting.csv";
        MasterData = "Master.csv";
    }

    /**
     * Constructor for objects of Players
     */
    public Players(String pitData, String batData, String masterData)  
    {
        PitData = pitData;
        BatData = batData;
        MasterData = masterData;
    }

    /**
     * getters and setters for the objects
     */
    public String getPitData()
    {
        return PitData;
    }
    public void setPitData(String pitData)
    {
        PitData = pitData;
    }

    public String getBatData()
    {
        return BatData;
    }
    public void setBatData(String batData)
    {
        BatData = batData;
    }

    public String getMasterData()
    {
        return MasterData;
    }
    public void setMasterData(String masterData)
    {
        MasterData = masterData;
    }

    /**
     * returns the string of the Players object
     */
    public String toString()
    {
        return 
        "Players: " +
        "Roster: " + Roster + "\n" +
        "PitData: " + PitData + "\n" + 
        "BatData: " + BatData + "\n" +
        "MasterData: " + MasterData + 
        "\n";
    }

    //Batters array work
    public static ArrayList <Batter> getBattersList(String fileLocation) throws Exception
    {
        int i;
        //Scanner to find and scan the file in
        Scanner batterScnr = new Scanner(new File(fileLocation));
        //Creating the array list
        ArrayList <Batter> batterArray = new ArrayList<>();

        //Parsing the Batter list
        while(batterScnr.hasNext())
        {
            String bat = batterScnr.nextLine();
            String info[] = bat.split(",");

            for(i = 0; i < info.length; i++)
            {

                if(info[i].equals(""))
                {
                    info[i] = "0";
                }

            }

            if(!info[0].equalsIgnoreCase("playerID"))
            {
                //Creating the batter 
                Batter batter = new Batter(Integer.parseInt(info[1]), info[3], Integer.parseInt(info[11]),
                        Integer.parseInt(info[12]));

                //Setting the first spot in the array to PlayerID
                batter.setPlayerID(info[0]);

                //Adding the batter to the array
                batterArray.add(batter);
            }
        }
        return batterArray;
    }

    //pitcher array work
    public static ArrayList <Pitcher> getPitcherList(String fileLocation) throws Exception
    {
        int i;
        //Scanner to find and scan the file in
        Scanner pitcherScnr = new Scanner(new File(fileLocation));
        //Creating the array list
        ArrayList <Pitcher> pitcherArray = new ArrayList<>();

        //Parsing the pitcher list
        while(pitcherScnr.hasNext())
        {
            String pitch = pitcherScnr.nextLine();
            String info[] = pitch.split(",");

            for(i = 0; i < info.length; i++)
            {

                if(info[i].equals(""))
                {
                    info[i] = "0";
                }

            }

            if(!info[0].equalsIgnoreCase("playerID"))
            {
                //Creating the pitcher 
                Pitcher pitcher = new Pitcher(Integer.parseInt(info[1]), info[3], Integer.parseInt(info[5]),
                        Integer.parseInt(info[6]), Double.parseDouble(info[19]));

                //Setting the first spot in the array to PlayerID
                pitcher.setPlayerID(info[0]);

                //Adding the batter to the array
                pitcherArray.add(pitcher);
            }
        }
        return pitcherArray;
    }

    //player array work
    public static ArrayList <Player> getPlayerList(String fileLocation) throws Exception
    {
        int i;
        String date;
        //Scanner to find and scan the file in
        Scanner playerScnr = new Scanner(new File(fileLocation));
        //Creating the array list
        ArrayList <Player> playerArray = new ArrayList<>();

        //Parsing the player list
        while(playerScnr.hasNext())
        {
            String player = playerScnr.nextLine();
            String info[] = player.split(",",-1);
            
            if(!info[0].equalsIgnoreCase("playerID"))
            {

                if(info.length < 23)
                {
                    String [] newInfo = new String[23];

                    for(i = 0; i < info.length; i++) 
                    {
                        newInfo[i] = info[i];
                    }
                    info = newInfo;
                }
                
                //if there are blank spots in the data set it to none
                if(info[13].equals(" ") || info[13].equals(""))
                {
                    info[13] = "None";
                }

                if(info[14].equals(" ") || info[14].equals(""))
                {
                    info[14] = "None";
                }

                if(info[16].length() == 0)
                {
                    info[16] = "-1"; //"None";
                }

                if(info[17].length() == 0) 
                {
                    info[17] = "-1"; //"None";
                }
                //date = info[1] + "/" + info[2] + "/" + info[3];

                //month / day / year
                date = info[2] + "/" + info[3] + "/" + info[1];

                Player players = new Player(info[0], info[13], info[14], date, info[6],
                        Integer.parseInt(info[17]),Integer.parseInt(info[16]));

                playerArray.add(players);
            }
        }
        ///  System.out.print(playerArray);
        return playerArray;
    }

    //top batter sorted
    public ArrayList <Batter> getTopBattersSorted(int n) throws Exception
    {
        //Creating the batter array using the getBattersList method
        ArrayList <Batter> batArray = getBattersList(BatData);

        //Instance variables 
        int i;
        int g;   

        //looping through the data to find the top
        for (i = 0; i < batArray.size() - 1; i++)
        {

            for(g = 0; g < ((batArray.size() - 1) - i); g++)
            {

                if(batArray.get(g).compareTo(batArray.get(g + 1)) < 0)
                {
                    Batter temp = batArray.get(g);

                    batArray.set(g, batArray.get(g + 1));

                    batArray.set(g + 1, temp);
                }

            }

        }

        //creating the array for the top batters
        ArrayList <Batter> topBatSort = new ArrayList<>();

        //setting the batArray with the top batters to the topSort array
        for(g = 0; g < n; g++)
        {
            topBatSort.add(batArray.get(g));
        }
        return topBatSort;
    }

    public ArrayList <Pitcher> getTopPitchersSorted(int n) throws Exception
    {
        //Creating the pitcher array using the getBattersList method
        ArrayList <Pitcher> pitchArray = getPitcherList(PitData);

        //instance variables 
        int i;
        int g;
        
        //looping through the data to find the top 
        for(i = 0; i < pitchArray.size() - 1; ++i)
        {

            for(g = 0; g < (pitchArray.size() - 1) - i; ++g)
            {

                if(pitchArray.get(g).compareTo(pitchArray.get(g + 1)) < 0) 
                {
                    Pitcher temp = pitchArray.get(g);

                    pitchArray.set(g, pitchArray.get(g + 1));

                    pitchArray.set(g + 1, temp);

                }

            }

        }

        ArrayList <Pitcher> topPitchSort = new ArrayList<>();

        for(i = 0; i < n; ++i)
        {
            topPitchSort.add(pitchArray.get(i));
        }
        return topPitchSort;
    }

    public Player getPlayer(String PlayerID) throws Exception
    {

        ArrayList <Player> players = getPlayerList(MasterData);

        int i;
        Player person = null;

        //finding the users player
        for(i = 0; i < players.size() - 1; ++i)
        {
            if(players.get(i).getPlayerID().equalsIgnoreCase(PlayerID))
            {
                person = players.get(i);
            }
        }
        return person;
    }

    public ArrayList <Batter> getTopHomerunHittersSorted(int n) throws Exception
    {
        ArrayList <Batter> batArray = getBattersList(BatData);

        //instance variables 
        int i;
        int g;

        //looping through the data to find the top
        for(i = 0; i < batArray.size() - 1; ++i)
        {

            for(g = 0; g < (batArray.size() - 1) - i; g++)
            {

                if(batArray.get(i).compareToHomeRuns(batArray.get(i + 1)) < 0)
                {
                    Batter temp = batArray.get(i);

                    batArray.set(i, batArray.get(i + 1));

                    batArray.set(i + 1, temp);

                }

            }

        }
        ArrayList <Batter> topHomeRunSort = new ArrayList<>();

        for(i = 0; i < n; i++)
        {
            topHomeRunSort.add(batArray.get(i));
        }
        return topHomeRunSort;
    }

    public ArrayList <Pitcher> getLowestERASorted(int n) throws Exception
    {
        ArrayList<Pitcher> pitcherArray = getPitcherList(PitData);

        //create instance variables
        int i;
        int g;

        //looping through the data to find the lowest
        for (i = 0; i < pitcherArray.size() - 1; ++i) 
        {

            for (g = 0; g < (pitcherArray.size() - 1) - i; ++g) 
            {

                if (pitcherArray.get(g).compareToERA(pitcherArray.get(g + 1)) > 0) 
                {
                    Pitcher temp = pitcherArray.get(g);

                    pitcherArray.set(g, pitcherArray.get(g + 1));

                    pitcherArray.set(g + 1, temp);
                }

            }

        }
        //create array list 
        ArrayList <Pitcher> pitchSorted = new ArrayList<>();

        for(i = 0; i < n; ++i)
        {
            pitchSorted.add(pitcherArray.get(i));
        }
        return pitchSorted;
    }
}
