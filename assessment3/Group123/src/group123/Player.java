package group123;


public class Player implements java.io.Serializable{
  
    char id;
    String name;
    String teamName;
    int totalPlaying;
    int totalScored;
    char score;
    char whichRound;
    
   
    //Constructor
    Player(char Id, String Name)
    {
        id = Id;
        name = Name;
    }
    
    Player(char Id, char WhichRound, char Score)
    {
         id = Id;
         whichRound = WhichRound;
         score = Score;
    }
    
   
    
    //Id getter and setter
    
    public char getId()
    {
        return this.id;
    }
    public void setId(char id)
    {
        this.id = id;
    }
    
    //playerName getter and setter
    public String getPlayerName()
    {
        return this.name;
    }
    public void setPlayerName(String name)
    {
        this.name = name;
    }
    
    //teamName getter and setter
    public String getTeamName()
    {
        return this.teamName;
    }
    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }
    
    //totalPlaying getter and setter
    public int getTotalPlaying()
    {
        return this.totalPlaying;
    }
    public void setTotalPlaying(int totalPlaying)
    {
        this.totalPlaying = totalPlaying;
    }
    
    //totalScored getter and setter
    public int getTotalScored()
    {
        return this.totalScored;
    }
    public void setTotalScored(int totalScored)
    {
        this.totalScored = totalScored;
    }

    //score getter and setter
     public char getScore()
    {
        return this.score;
    }
    public void setScore(char score)
    {
        this.score = score;
    }
    
    //Which round getter setter
    public char getWhichRound()
    {
        return this.whichRound;
    }
    public void setWhichRound(char whichRound)
    {
        this.whichRound = whichRound;
    }
    
  
}
