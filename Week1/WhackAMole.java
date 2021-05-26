package Week1;

import java.util.Scanner;

public class WhackAMole {
    int score, molesLeft, attemptsLeft;
    char [][] moleGrid;
    //constructor Whackmole
   public WhackAMole (int numAttempts, int gridDimension) 
   {
	attemptsLeft = numAttempts;
	moleGrid = new char [gridDimension] [gridDimension];
	
	for(int i = 0; i < gridDimension ; i++)
	{
	    for(int j =0 ; j < gridDimension ; j++)
	    {
		moleGrid[i][j] = '*';
	    }
	}
    }
   // Mole Location and updating the number of moles left
   boolean place (int x, int y)
   {
       if(moleGrid[x][y] == '*')
       {
	   moleGrid[x][y] ='M';
	   molesLeft++;
	   return true;
       }
       else
       {
	   return false;
       }
   }
   
   void whack(int x ,int y)
   {
       if(x == -1 && y == -1) 
       {
	   attemptsLeft = 0;
	   printGrid();
       }
       else if (moleGrid[x][y] == 'M')
       {
	   moleGrid[x][y] = 'W';
	   score++;
	   attemptsLeft--;
	   molesLeft--;
	   printGridToUser();
       }
       else
       {
	   attemptsLeft--;
	   printGridToUser();
       }  
   }
   
   void printGridToUser() 
   {
       for(int i = 0; i < moleGrid.length ; i++) 
       {
	   for(int j = 0; j < moleGrid.length ; j++) 
	   {
		if(moleGrid[i][j] == 'W') {
		    System.out.print("W" +" "); 
		}
		else 
		{
		    System.out.print("*" + " ");
		}
	   } 
	   System.out.print("\n");
       }
   }
   
   void printGrid() {
       for(int i = 0; i < moleGrid.length ; i++) 
       {
	   for(int j = 0; j < moleGrid.length ; j++) 
	   {
	       System.out.println(moleGrid[i][j] + " ");
	   }
	   System.out.println("");
       }
   }
   public String toString() 
   {
       String status = "";
       status+= "Score: " + score;
       status+="\n";
       status+= "Moles Left: " + molesLeft;
       status+="\n";
       status+= "Attempts Left: "+ attemptsLeft;
       return status;
   }
   
   public static void main(String[] args) {
    
       WhackAMole game = new WhackAMole (50 , 10);
       int placedMoles = 0;
       while(placedMoles < 10) 
       {
	   int randomGuessX = (int)(Math.random()*10);
	   int randomGuessY = (int)(Math.random()*10);
	   
	   if(game.place(randomGuessX, randomGuessY) == true) 
	   {
	       placedMoles++;
	   }
       }
       while(game.attemptsLeft > 0 && game.molesLeft > 0) 
       {
	   @SuppressWarnings("resource")
	    Scanner userInput = new Scanner(System.in);
	   System.out.print("Enter x and y coordinates ow where you would like to take a whack" + "\n");
	   System.out.println("You have a max. of 50 attempts to get all the moles." + "\n");
	   System.out.print("Coordinate x of the mole: ");
	   int userGuessX = userInput.nextInt();
	   System.out.println("");
	   System.out.print("Coordinate y of the mole: ");
	   int userGuessY = userInput.nextInt();
	   game.whack(userGuessX, userGuessY);
       }
   }
   
}
