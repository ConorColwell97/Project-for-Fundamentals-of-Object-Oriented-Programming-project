import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents a monster. The monsters will move around the world
 * and try to eat the player. If they eat the player, the game ends.
 * The monsters can be killed by the spiked balls but will respawn infinitely.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Actor
{
    /**
     * Declare instance variables
     */
    private int mouthOpenClose = 0;
    private GreenfootImage image1 = new GreenfootImage("Monster.png");
    private GreenfootImage image2 = new GreenfootImage("Monster2.png");
    
    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(-3);
        randomTurn();
        atEdge();
        eatPlayer();
        switchImage();
    }
    
    /**
     * Method adds random movement to the monster
     */
    public void randomTurn()
    {
        if(Greenfoot.getRandomNumber(100)<10)
        {
            turn(Greenfoot.getRandomNumber(90)-45);
        }
    }
    
    /**
     * Method checks if the monster is at the edge of the world. If yes, turn 45 degrees.
     */
    public void atEdge()
    {
        if(isAtEdge())
        {
            turn(45);
        }
    }
    
    /**
     * Method checks if a monster is touching the player. If yes, eat the player and end the game.
     */
    public void eatPlayer()
    {
        if(isTouching(Player.class))
        {
            Greenfoot.playSound("Chomp.wav");
            removeTouching(Player.class);
            addText();
            Greenfoot.stop();
        }
    }
    
    /**
     * Method adds animation to the monster that makes it open and close its mouth.
     */
    public void switchImage()
    {
        if(mouthOpenClose < 6)
        {
            mouthOpenClose++;
        }
        else
        {
            if(getImage()==image1)
            {
                setImage(image2);
            }
            else
            {
                setImage(image1);
            }
            mouthOpenClose=0;
        }
    }
    
     /**
     * Method creates a new object of class EatenByMonster and then adds it to the world.
     */
    private void addText()
    {
        EatenByMonster newText;
        newText = new EatenByMonster();
        
        World world;
        world = getWorld();
        
        world.addObject(newText,600,350);
    }
}
