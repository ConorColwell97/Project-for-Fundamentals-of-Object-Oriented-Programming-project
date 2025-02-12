import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class displays a game over screen if the player is killed
 * by a spiked ball.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KilledByBall extends Actor
{
    /**
     * Create a constructor that dispalys game over text.
     */
    public KilledByBall()
    {
         setImage(new GreenfootImage("Game over - Killed by a spiked ball",50,Color.RED,null));
    }
}
