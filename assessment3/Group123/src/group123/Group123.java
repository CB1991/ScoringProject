package group123;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.*;

/**
 *
 * @author Hans,Choongbae,Peter
 */
public class Group123 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //declaration
        String PATH = System.getProperty("user.dir") + "\\";
        String PLAYERS_PATH = PATH + "Score.dat";
        String DISPLAYER_PATH = PATH + "score_displayer.dat";
      boolean isUserGoOn = true;
      
      Service service = new Service();
     
      
        System.out.println("Welcome to the ScoreCard");
        //while loop for the menu
       while(isUserGoOn==true){        
                   
            
            System.out.println("Please select one of the following:\n"
            + "\n1. Display ScoreCard "
            + "\n2. Add Scores "
            + "\n3. Clear saved data"
            + "\n4. Save and Exit");
         Scanner input = new Scanner(System.in);    
         
         //try catch for error handling
          try{
                System.out.println("Please input a number");
                int usrInput=input.nextInt();
        switch(usrInput){
            case 1:   
                //display the scoreCard
                System.out.println(service.displayScoreCard(service.getPlayerScore()));
                break;
                
            case 2:
                //Add score to the scoreCard
                 service.allocateScore();
                  
                
                break;

                
            case 3:
                //here this will restart the Scorecard and clear all the data in it by delete the saved files.
                 try
                {
                    Files.deleteIfExists(Paths.get(DISPLAYER_PATH));
                    Files.deleteIfExists(Paths.get(PLAYERS_PATH));
                }
                catch(NoSuchFileException e)
                {
                    System.out.println("No such file/directory exists");
                }
                catch(DirectoryNotEmptyException e)
                {
                    System.out.println("Directory is not empty.");
                }
                catch(IOException e)
                {
                    System.out.println("Invalid permissions.");
                }
         
                    System.out.println("Deletion successful.");
                break;
                
            case 4:
                return;
          
                
            default:System.out.println("Invalid input please try again");
                
        
                        }//switch loop ends  
            }// While loop ends  
          
            catch(InputMismatchException exception)
              {
              System.out.println("Invalid inputs should be numeric");
              }        
         
       }
        
    }
    
}
