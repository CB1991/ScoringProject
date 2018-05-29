package group123;

/**
 *
 * @author Peter
 */
public class Player implements java.io.Serializable{
  
    int id;
    String name;
    String teamName;
    int totalPlaying;
    int totalScored;
    int score;
    int whichRound;
    
   
    //Constructor
    Player(int Id, String Name)
    {
        id = Id;
        name = Name;
    }
    
    Player(int Id, int WhichRound, int Score)
    {
         id = Id;
         whichRound = WhichRound;
         score = Score;
    }
    
   
    
    //Id getter and setter

    /**
     *
     * @return
     */
    
    public int getId()
    {
        return this.id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    //playerName getter and setter

    /**
     *
     * @return
     */
    public String getPlayerName()
    {
        return this.name;
    }

    /**
     *
     * @param name
     */
    public void setPlayerName(String name)
    {
        this.name = name;
    }
    
    //teamName getter and setter

    /**
     *
     * @return
     */
    public String getTeamName()
    {
        return this.teamName;
    }

    /**
     *
     * @param teamName
     */
    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }
    
    //totalPlaying getter and setter

    /**
     *
     * @return
     */
    public int getTotalPlaying()
    {
        return this.totalPlaying;
    }

    /**
     *
     * @param totalPlaying
     */
    public void setTotalPlaying(int totalPlaying)
    {
        this.totalPlaying = totalPlaying;
    }
    
    //totalScored getter and setter

    /**
     *
     * @return
     */
    public int getTotalScored()
    {
        return this.totalScored;
    }

    /**
     *
     * @param totalScored
     */
    public void setTotalScored(int totalScored)
    {
        this.totalScored = totalScored;
    }

    //score getter and setter

    /**
     *
     * @return
     */
     public int getScore()
    {
        return this.score;
    }

    /**
     *
     * @param score
     */
    public void setScore(int score)
    {
        this.score = score;
    }
    
    //Which round getter setter

    /**
     *
     * @return
     */
    public int getWhichRound()
    {
        return this.whichRound;
    }

    /**
     *
     * @param whichRound
     */
    public void setWhichRound(int whichRound)
    {
        this.whichRound = whichRound;
    }
    
  
}
