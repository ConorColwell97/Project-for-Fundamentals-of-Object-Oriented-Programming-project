import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents a spiked ball. It moves vertically from one end of the
 * world to the other and can kill both the player and the monsters. If it kills
 * the player, the game ends. The balls become progressively more dangerous 
 * the more coins the player collects.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpikedBall extends Actor
{
    /**
     * Declare instance variables
     */
    private int monsterSpawnTimer;
    private static final int DELAY = 120; 
    private ScoreCounter counter;
    
    /**
     * Create a constructor for the SpikedBall class that rotates it 90 degrees.
     * Constructor intialises the monsterSpawnTimer variable to 0.
     * Constructor also adds a reference to the Counter class.
     */
    public SpikedBall(ScoreCounter random)
    {
        setRotation(90);
        monsterSpawnTimer = 0;
        counter = random;
    }
    
    /**
     * Act - do whatever the SpikedBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(3);
        atEdge();
        hitPlayer();
        hitMonster();
        monsterSpawnDelay();
        spikedBallBehavior();
    }
    
    /**
     * Method checks if the Spiked ball is at the edge of the world. If yes, then turn by 180 degrees.
     */
    public void atEdge()
    {
        if(isAtEdge())
        {
            turn(180);
        }
    }
    
    /**
     * Method adds random movement to the Spiked ball when it is called.
     */
    public void randomTurn()
    {
        if(Greenfoot.getRandomNumber(100)<10)
        {
            turn(Greenfoot.getRandomNumber(90)-45);
        }
    }
    
    /**
     * Method changes the behavior of the spiked ball once the player collects a certain amount of coins.
     */
    public void spikedBallBehavior()
    {
        if(counter.getValue()>=25)
        {
            move(1);
        }
        if(counter.getValue()>=35)
        {
            move(1);
        }
        if(counter.getValue()>=45)
        {
            move(1);
        }
        if(counter.getValue()>=55)
        {
            move(1);
        }
        if(counter.getValue()>=60)
        {
            randomTurn();
        }
    }
    
    /**
     * Method checks if a spiked ball is has hit the player. 
     * If yes, kill the player and end the game.
     */
    public void hitPlayer()
    {
        if(isTouching(Player.class))
        {
            Greenfoot.playSound("Scream.wav");
            removeTouching(Player.class);
            addText();
            Greenfoot.stop(); 
        }
    }
    
    /**
     * Method checks if a spiked ball has hit a monster.
     * If yes, kill the monster and start the timer that spawns in a new monster.
     */
    public void hitMonster()
    {
        if(isTouching(Monster.class))
        {
            Greenfoot.playSound("Monsterdeathscream.mp3");
            removeTouching(Monster.class);
            delayTimer();
        }
    }
    
    /**
     * Method creates a delay timer of 2 seconds (120 frames).
     */
    private void delayTimer()
    {
        monsterSpawnTimer = DELAY;
    }
    
    /**
     * Method starts the delay timer and spawns a new monster once it gets to 0.
     */
    private void monsterSpawnDelay()
    {
        if(monsterSpawnTimer > 0 )
        {
            monsterSpawnTimer--;
            
            if(monsterSpawnTimer == 0)
            {
                createMonster();
            }
        }
    }
    
    /**
     * Method creates a new object of class Monster and then adds a new Monster to the world.
     */
    private void createMonster()
    {
        Monster newMonster;
        newMonster = new Monster();
        
        World monsterWorld;
        monsterWorld = getWorld();
        
        monsterWorld.addObject(newMonster,1160,350);
    }
    
    /**
     * Method creates a new object of class KilledByBall and then adds it to the world.
     */
    private void addText()
    {
        KilledByBall newText;
        newText = new KilledByBall();
        
        World world;
        world = getWorld();
        
        world.addObject(newText,600,350);
    }
}
