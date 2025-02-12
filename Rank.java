import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class displays the rank that the player recieved at the end of the 
 * game if they survived until the timer reached 0. The players rank is
 * determined by the total number of coins that they collected at the 
 * end of the game. F - Very Poor, E - Poor, D - Not bad, C - Decent,
 * B - Good, A - Very good & S - Superb!
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rank extends Actor
{
    /**
    * Declare instance variable. 
    */
    private ScoreCounter counter;
    
    /**
     * Create a constructor that references the counter class
     */
    public Rank(ScoreCounter giveRank)
    {
        counter = giveRank;
    }
    
    /**
     * Act - do whatever the Rank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        playerRank();
    }
    
    /**
     * Method displays the rank that the player achieved at the end of the game
     * based on how many coins that they managed to collect. [S/A/B/C/D/E/F]
     */
    public void playerRank()
    {
         if(counter.getValue()<20)
         {
             setImage(new GreenfootImage("Rank: F - Very Poor",100,Color.RED,null));
             Greenfoot.playSound("boo.wav");
         }
         else if(counter.getValue()>=20 && counter.getValue()<25)
         {
             setImage(new GreenfootImage("Rank: E - Poor",100,Color.RED,null));
             Greenfoot.playSound("boo.wav");
         }
         else if(counter.getValue()>=25 && counter.getValue()<=30)
         {
             setImage(new GreenfootImage("Rank: D - Not Bad",100,Color.YELLOW,null));
             Greenfoot.playSound("Victory.wav");
         }
         else if(counter.getValue()>30 && counter.getValue()<=35)
         {
             setImage(new GreenfootImage("Rank: C - Decent",100,Color.YELLOW,null));
             Greenfoot.playSound("Victory.wav");
         }
         else if(counter.getValue()>35 && counter.getValue()<=45)
         {
             setImage(new GreenfootImage("Rank: B - Good",100,Color.YELLOW,null));
             Greenfoot.playSound("Victory.wav");
         }
         else if(counter.getValue()>45 && counter.getValue()<=60)
         {
             setImage(new GreenfootImage("Rank: A - Very Good",100,Color.YELLOW,null));
             Greenfoot.playSound("Victory.wav");
         }
         else if(counter.getValue()>60)
         {
             setImage(new GreenfootImage("Rank: S - Superb!",100,Color.YELLOW,null));
             Greenfoot.playSound("Victory.wav");
         }
    }
}
