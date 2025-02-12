import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class dispalys the total amount of coins 
 * that the player managed to collect in a full game
 * if they survive until the timer reaches 0.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinsCollected extends Actor
{
    /**
     * Declare instance variable.
     */
    private ScoreCounter counter;
    
    /**
     * Create a constructor that references the counter class
     */
    public CoinsCollected(ScoreCounter totalCoins)
    {
        counter = totalCoins;
    }
    
    /**
     * Act - do whatever the CoinsCollected wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        totalCoinsCollected();
    }
    
    /**
     * Method displays text on the screen at end the end of the game 
     * that displays the total amount of coins that the player collected.
     */
    public void totalCoinsCollected()
    {
        if(counter.getValue()>=25)
        {
           setImage(new GreenfootImage("Coins collected: "+counter.getValue(),100,Color.YELLOW,null));
        }
        else
        {
            setImage(new GreenfootImage("Coins collected: "+counter.getValue(),100,Color.RED,null));
        }
    }
}
