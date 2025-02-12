import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the player. The goal of the player is to collect as many coins
 * as possible before the timer runs out while avoiding the spiked balls and 
 * the monsters.
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Declare the instance variables
     */
    private ScoreCounter counter;
    private static final int SPEED = 3;
    private int legCount = 0;
    private GreenfootImage image1 = new GreenfootImage("Man.png");
    private GreenfootImage image2 = new GreenfootImage("Man2.png");
    private GreenfootImage image3 = new GreenfootImage("Man3.png");
    private GreenfootImage image4 = new GreenfootImage("Man4.png");
    
    /**
     * Create Player constructor that refernces the Counter class
     */
    public Player(ScoreCounter coinCounter)
    {
        counter = coinCounter;
    }
    
    /**
    * Act - do whatever the Player wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    */
    public void act()
    {
        checkKeyInput();
        collectCoins();
        switchImage();
    }
    
    /**
     * Method checks if the player is pressing a key [W/A/S/D]
     * and then moves in the direction that the key is assigned to.
     */
    public void checkKeyInput()
    {
        if(Greenfoot.isKeyDown("D"))
        {
            move(3);
        }
        if(Greenfoot.isKeyDown("A"))
        {
            move(-3);
        }
        if(Greenfoot.isKeyDown("W"))
        {
            moveUp();
        }
        if(Greenfoot.isKeyDown("S"))
        {
            moveDown();
        }
    }
    
    /**
     * Method checks if the player has collected a coin and then adds 1 to the coin counter.
     */
    public void collectCoins()
    {
        if(isTouching(Coin.class))
        {
            removeTouching(Coin.class);
            counter.add(1);
            Greenfoot.playSound("ChaChing.wav");
            createCoins();
        }
    }
    
    /**
     * Method creates an object of class Coin and then adds a new Coin to the world.
     */
    private void createCoins()
    {
        Coin newCoin;
        newCoin = new Coin();
        
        World coinWorld;
        coinWorld = getWorld();
        
        coinWorld.addObject(newCoin,Greenfoot.getRandomNumber(1110),Greenfoot.getRandomNumber(620));
    }
    /**
     * Method moves the player upwards
     */
    public void moveUp()
    {
         setLocation ( getX(), getY()- SPEED );
    }
    
    /**
     * Method moves the player downwards
     */
    public void moveDown()
    {
         setLocation ( getX(), getY()+ SPEED );
    }
    
    /**
     * Method creates forwards/backwards walking animation for the player.
     */
    public void switchImage()
    {
        if(Greenfoot.isKeyDown("D"))
        {  
            if(legCount < 12)
            {
                legCount++;
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
                legCount=0;
            }
        }
        if(Greenfoot.isKeyDown("A"))
        {
            if(legCount < 12)
            {
                legCount++;
            }
            else
            {
                if(getImage()==image3)
                {
                    setImage(image4);
                }
                else
                {
                    setImage(image3);
                }
                legCount=0;
            }
        }
    }
}
