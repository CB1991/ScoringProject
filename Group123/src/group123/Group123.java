/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group123;

import java.util.ArrayList;
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
         
      //  int id, String userName, String teamName, int totalPlaying, int totalScored
     
                
        ArrayList<Player> westEagle = new ArrayList<Player>();
        
           Player w1 = new Player(1,"PlayerName","West Eagle",1,0);
           Player w2 = new Player(1,"PlayerName","West Eagle",1,0); 
           Player w3 = new Player(1,"PlayerName","West Eagle",1,0);
           Player w4 = new Player(1,"PlayerName","West Eagle",1,0); 
           Player w5 = new Player(1,"PlayerName","West Eagle",1,0);
     
                                       
           westEagle.add(w1);
           westEagle.add(w2);
           westEagle.add(w3);
           westEagle.add(w4);
           westEagle.add(w5);
        
           //(String whoGoal, int whichRound, int score)
        
           // player w1 goals in Round 1 and 1 Score
           Goal g1 = new Goal(w1, 1,1);
           
           // Change w1's Total Score
            w1.setTotalScored(1);
            
            
            // Test display changed totalscore's change
             System.out.println("w1's totalscore: "+w1.getTotalScored());
             System.out.println("w2's totalscore: _"+ westEagle.get(0).getTotalScored());
            
           // player w1 goals in Round 1 and 5 Score
           Goal g2 = new Goal(w2, 1,6);                      
           
           // Change w2's Total Score
           w2.setTotalScored(6);
            
           // Test display changed totalscore's change
            System.out.println("w2's totalscore: "+w2.getTotalScored());
             System.out.println("w2's totalscore_"+ westEagle.get(1).getTotalScored());

           
           // Displaying user totalscored 
           // TODO: Saving to Binery File and Load
             for(int i=0; i<westEagle.size(); i++)
                 {
                    System.out.println(westEagle.get(i).getTotalScored());
                 }
                                    
        // TODO code application logic here
                                                 
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
