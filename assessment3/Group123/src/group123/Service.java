package group123;
import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 *
 * @author Peter
 */
public class Service {
    //declaration
    private static Scanner scanner = new Scanner(System.in);
    String[] HEADERS ={"Round 1", "Round 2 ", "Round 3", "Round 4",};
    private final static String PATH = System.getProperty("user.dir") + "\\";
    private final static String PLAYERS_PATH = PATH + "Score.dat";
    private final static String DISPLAYER_PATH = PATH + "score_displayer.dat";
    
    
    
   
    
    //This method will display the ScoreCard

    /**
     *
     * @param arrangement
     * @return
     */
    public String displayScoreCard(Player[][] arrangement) {
        //separator
        
        int zero = 0;
           String displayer = "\n\n       ";
        
       //this for loop will display the HEADERS in order
       for (int i = 0; i < 5; i++) {
            if (i >= 1) {
                displayer += HEADERS[i - 1];
                 
            } displayer += " ";
        }
                
        displayer += "   \n";
    //this for loop will display the player's SCORE
        for (int x = arrangement.length - 4; x <= 3; x++) {
            displayer += "Player" + (x + 1);
            for (int i = 0; i < 4 - String.valueOf(x + 1).length(); i++) { displayer += " "; }
            for (int y = 0; y < 4; y++) {
                if (arrangement[x][y] != null) 
                { 
                    displayer += " " + arrangement[x][y].getScore()+ "     ";
                }
                //else { displayer += " -     "; }
                else {displayer += " " + zero + "     ";}
            }
            displayer += "\n";
        }
    
    
        
      
        /*for(int i=0; i<4; i++)
        {
            for(int j=0; j<4; j++){
            if(arrangement[i][j].getScore() == 0)
                {
                   arrangement[i][j].setScore(0);
                }
            }
        }*/
                //int score1 = arrangement[0][0].getScore();
             
               
              
                  //int playerTwoTotal = arrangement[1][0].getScore() +arrangement[1][1].getScore()+arrangement[1][2].getScore()+arrangement[1][3].getScore() ;
                  int playerOneTotal = 0;
                  for (int i =0; i<4; i++) {
                      if (arrangement[0][i] != null) 
                        playerOneTotal += arrangement[0][i].getScore();
                  }
                  
                  int playerTwoTotal = 0;
                  for (int i =0; i<4; i++) {
                      if (arrangement[1][i] != null) 
                        playerTwoTotal += arrangement[1][i].getScore();
                  }
                  
                  int playerThreeTotal = 0;
                  for (int i =0; i<4; i++) {
                      if (arrangement[2][i] != null) 
                        playerTwoTotal += arrangement[2][i].getScore();
                  }
                  
                  int playerFourTotal = 0;
                  for (int i =0; i<4; i++) {
                      if (arrangement[3][i] != null) 
                        playerTwoTotal += arrangement[3][i].getScore();
                  }
                     //int playerThreeTotal = arrangement[2][0].getScore() +arrangement[2][1].getScore()+arrangement[2][2].getScore()+arrangement[2][3].getScore() ;
                        //int playerFourTotal = arrangement[3][0].getScore() +arrangement[3][1].getScore()+arrangement[3][2].getScore()+arrangement[3][3].getScore() ;
               
                        
                       
        return displayer + "PLAYER 1 Total Score = " + playerOneTotal + '\n' +
                "PLAYER 2 Total Score = " + playerTwoTotal + '\n'  +"PLAYER 3 Total Score = " + playerThreeTotal + '\n' + "PLAYER 4 Total Score = " + playerFourTotal;//arrangement[0][0].getScore() +arrangement[0][1].getScore()+arrangement[0][2].getScore()+arrangement[0][3].getScore() ;
        

        
    }
    
     
     /** A method that will get the ScoreCard from a file.
     * @return  */
    public Player[][] getPlayerScore() {
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(PLAYERS_PATH))) {
            Player[][] allocs = (Player[][]) input.readObject();
            input.close();
            return allocs;
        } catch (Exception e) {
            System.out.println("Exception in file reading: " + e.getMessage() + "\n\nCreating a new file!");
            saveScore(new Player[4][4]);
            return getPlayerScore();
        }
    }
    
     /** A method that will save the Score based on the arrangement, into a text file.
     * @param arrangement */
    public void saveScore(Player[][] arrangement) {
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(PLAYERS_PATH))) {
            output.writeObject(arrangement);
            output.close();
        } catch (IOException ioe) {
            System.out.println("IOException in file writing: " + ioe.getMessage() + "\n\nFile writing will stop.");
        }
    }
    
    /** A method that will get the Score from the random binary file.
     * @param position
     * @return  */
    public char saveScoreCardDisplayer(int position) {
        char ch = ' ';
        try(RandomAccessFile file = new RandomAccessFile(DISPLAYER_PATH, "rw")) {
            file.seek(position);
            byte[] bytes = new byte[1];
            file.read(bytes);
            ch = new String(bytes).charAt(0);
            file.close();
            System.out.println(ch);
            scanner.nextLine();
        } catch (IOException ioe) {
            System.out.println("IOException in random file reading: " + ioe.getMessage() + "\n\nCreating a new random file!");
        }
        return ch;
    }
    
     /** A method that will have the ScoreCard displayer stored in a binary file, via random access.
     * @param type
     * @param position */
    public void storeScoreCardDisplayer(int type, int position) {
        try(RandomAccessFile file = new RandomAccessFile(DISPLAYER_PATH, "rw")) {
            file.seek(position);
            file.write(type);
            file.close();
        } catch (IOException ioe) {
            System.out.println("IOException in random file writing: " + ioe.getMessage() + "\n\nRandom file writing will stop.");
        }
    }
     
     
      private void assignScore(Player player) {
        Player[][] arrangement = getPlayerScore();
        //the selectedRow and the selectedColumn is set to -1 because this will make sure the row selected is set to the exact one
        int selectedRow = -1;
        int selectedColumn = -1;

        //the rows and columns for the Players are determined
        for (int row = arrangement.length - 1; row >= 0; row--) {
            //here the row will be determined by the playerId.
            //for example if the selected playerId is 1 then the row[0] will be selected
            if((row == 0 && player.getId() == 1) || (row == 1 && player.getId() == 2) || (row == 2 && player.getId() == 3) || (row == 3 && player.getId() == 4))
            {
                 selectedRow = row;
                 
                 //here the column will be determined by the Game Round.
                 //for example if the getWhichRound == 1 the the column will be set to column[0]
                 if(player.getWhichRound() == 1)
                 {
                     if (arrangement[row][0] == null) { selectedColumn = 0; }
                 }
                 if(player.getWhichRound() == 2)
                 {
                     if (arrangement[row][1] == null) { selectedColumn = 1; }
                 }
                     
                 if(player.getWhichRound() == 3)
                 {
                     if (arrangement[row][2] == null) { selectedColumn = 2; }
                 }
                 
                 if(player.getWhichRound() == 4)
                 {
                     if (arrangement[row][3] == null) { selectedColumn = 3; }
                 }                      
                 }
            } // for loop 
            
           


        //the score is assigned to the ScoreCard based on the row and column given
        try {
            if (selectedRow == -1 || selectedColumn == -1) 
            { 
                System.out.println("Player"+ player.getId()+ " has already a score in round" + player.getWhichRound());

                
            }
            else {              
                arrangement[selectedRow][selectedColumn] = player;
                saveScore(arrangement);
                storeScoreCardDisplayer(player.getScore(), selectedRow*4 + selectedColumn + 1);
                System.out.println("Score successfully assigned.");
           
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Press ENTER to continue...");
            scanner.nextLine();
        }
    }
      
      //Here the user will be able to choose to which player he/she wants to assign Score to, and at which round as well

      public void displayTotalScore()
      {
       
        
            
      }
      
    /**
     *
     */
      public void allocateScore() {
        try {
            System.out.print("\n--------------------------\n");
         

                System.out.println("Which Player? ");
            //char playerId = scanner.nextLine().charAt(0);
            int playerId = scanner.nextInt();
            
            if(playerId == 1 || playerId == 2 || playerId == 3 || playerId == 4)
                {
                    System.out.println("Player" +playerId+ " Selected\n");
                }
            else
            {
                System.out.println("PlayerId must be from 1 to 4");
                return;
            }
            
            //game Round input
            System.out.println("Which Game Round?");
            //char gameRound = scanner.nextLine().charAt(0);
            int gameRound = scanner.nextInt();
            
            if(gameRound == 1 || gameRound == 2 || gameRound == 3 || gameRound == 4)
                {
                    System.out.println("Round" + gameRound + " Selected\n");
                }
            else
            {
                System.out.println("Game Round must be from 1 to 4");
                return;
            }
            
            //Player Score input
                System.out.println("\nInput a score from 0-5: ");
               // char playerScore = scanner.nextLine().charAt(0);'
               int playerScore = scanner.nextInt();
                
                if(playerScore == 1 || playerScore == 2 || playerScore == 3 || playerScore == 4 ||playerScore == 5)
                {
                    
                    System.out.println("In round" +gameRound+ " Player" +playerId+ " scored " +playerScore+ " points\n");
                 }
             
                 
                else{ System.out.println("Score must be from 1 to 5");
                    return;
                }
  
                
                
            //here this is based on the constructor in the Player class
            assignScore(new Player(playerId, gameRound ,playerScore));
            }
            //PlayerId input
            
        catch(Exception e)
        {
            System.out.print("An exception has occurred. The allocation will now cancel. Exception: " + e.getMessage() + "\nPress ENTER to continue...");
            scanner.nextLine();
        }
     }
    
     
}

    

