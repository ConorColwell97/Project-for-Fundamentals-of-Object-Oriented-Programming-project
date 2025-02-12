import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents a game over screen.
 * It will appear at the end of the game 
 * once the timer reaches 0.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    /**
     * Declare instance variable.
     */
    private ScoreCounter counter;
    
    /**
     * Create a constructor that references the counter class
     */
    public GameOver(ScoreCounter over)
    {
        counter = over;
    }
    
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        gameOver();
    }
    
    /**
     * Method displays a game over screen at the end of the game.
     */
    public void gameOver()
    {
         if(counter.getValue()>=25)
         {
            setImage(new GreenfootImage("Game over",200,Color.YELLOW,null));
         }
         else
         {
            setImage(new GreenfootImage("Game over",200,Color.RED,null));
         }
    }
}
