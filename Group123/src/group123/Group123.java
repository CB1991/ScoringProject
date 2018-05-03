/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group123;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author J378843
 */
public class Group123 {
          
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        boolean isUserGoOn = true;
           
      //  int id, String userName, String teamName, int totalPlaying, int totalScored
     
                
        ArrayList<Player> westEagle = new ArrayList<Player>();
        ArrayList<Goal> goalList = new ArrayList<Goal>();
        
        
           Player w1 = new Player(1,"Choongbae","West Eagle",1,0);
           Player w2 = new Player(2,"Han","West Eagle",1,0); 
           Player w3 = new Player(3,"Peter","West Eagle",1,0);
           Player w4 = new Player(4,"Ivone","West Eagle",1,0); 
           Player w5 = new Player(5,"Adrian","West Eagle",1,0);
                                            
           westEagle.add(w1);
           westEagle.add(w2);
           westEagle.add(w3);
           westEagle.add(w4);
           westEagle.add(w5);
                                 
        // TODO code application logic here
                 
        while(isUserGoOn==true){        
                   
            // Create Read Update Delete
            System.out.println("Welcome to Footy recording"
            + "\nPress number "
            + "\n1. Display Record "
            + "\n2. Add scores "
            + "\n3. Save and Exit" );
         Scanner input = new Scanner(System.in);                         

       try{
      System.out.println("Please input an integer");
     int usrInput=input.nextInt();
        switch(usrInput){
            case 1:   
                  System.out.println("Display Record");  
                  
                  // Displaying user totalscored 
                  // TODO: Saving to Binery File and Load
                      for(int i=0; i<westEagle.size(); i++)
                          {
                             System.out.println(westEagle.get(i).getTotalScored());
                                                                                
                          }
                                                          
         
                  
                break;
            case 2:      
                   //(String whoGoal, int whichRound, int score)
         
                for(int i=0; i<westEagle.size(); i++)
                {
                          System.out.println(i+1+"-Which Player :"+westEagle.get(i).getPlayerName());  
                }
                
          System.out.println("Who has goal?");                             
          int whosegoal=input.nextInt();
          Goal g1 = new Goal();          
          g1.setWhoGoal(westEagle.get(whosegoal-1));
          
           System.out.println("Which round? 1. round1 , 2. round2, 3.round3, 4.round4");                             
          int whichRound=input.nextInt();                    
          g1.setWhichRound(whichRound);
          
           System.out.println("How many point? 1. 1point , 6. 6points");                             
          int howManyPoint=input.nextInt();                              
          g1.setScore(howManyPoint);
                    // Change w1's Total Score
                          goalList.add(g1);
                          
                               for(int i=0; i<goalList.size(); i++)
                {
                          System.out.println ("\nwhose goal?"+ goalList.get(i).getWhoGoal() +
                                              "\nwhichRound goal?"+ goalList.get(i).getWhichRound() +
                                              "\nHow many points?"+ goalList.get(i).getScore() 
                          );  
                }
            
//            
//           // player w1 goals in Round 1 and 6 Score
//           Goal g2 = new Goal(w2, 1,6);                      
//           2
//           // Change w2's Total Score
//           w2.setTotalScored(6);
                
                break;                
            case  3:                                                                      
                 System.out.println("Exit Thank you for using");
                  isUserGoOn = false;
                  break;
                          
            default:System.out.println("Input is invaild");
            } // switch loop ends                                                           
         } // While loop ends  
        catch(InputMismatchException exception)
              {
              System.out.println("Invalid inputs should be numeric");
              }                                                     
    }
   }
            
    public void Valiate() // Method valiate user's input is numeric
    {
    Scanner input = new Scanner(System.in);

    int userType = 0;

    boolean isUserInputNumeric = true;

    boolean isNumThere;

    while(isUserInputNumeric==true)
        {
            if(input.hasNextInt())
            {
                userType= input.nextInt();
                isUserInputNumeric = false;        
            }
            else if (!input.hasNextInt())
            {
            System.out.println("Please type numeric numbers");
            input.next();
            }
        }           
    }        
}
