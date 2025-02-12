import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class creates the world for the game and adds all
 * of the created objects to the world.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Decalare instance variables.
     */
    private static final int SPACE = 5; 
    private ScoreCounter counter;
    private ScoreCounter timer;
    SimpleTimer countdown = new SimpleTimer();
    
    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {    
        // Create a new world with 1200x700 cells with a cell size of 1x1 pixels.
        super(1200,700, 1);
        populateWorld();
        addCoins();
        timer = new ScoreCounter("Time left: ");
        timer.setValue(60);
        addObject(timer, 70, 650);
        countdown.mark();
    }
    
    /**
     * Method adds various objects to the world.
     */
    public void populateWorld()
    {
        counter = new ScoreCounter("Coins collected: ");
        addObject(counter, 90, 680);
        addObject(new Player(counter),40,350);
        addObject(new SpikedBall(counter),230,30);
        addObject(new SpikedBall(counter),430,670);
        addObject(new SpikedBall(counter),630,30);
        addObject(new Monster(),1160,50);
        addObject(new MonsterSpawnPoint(),1160,350);
        addObject(new Monster(),1160,650);
    }
    
    /**
     * Act method that starts the timer for the game and 
     * ends the game once the timer reaches 0 
     * and displays game over text. The timer is set to 60 seconds (One minute).
     */
    public void act()
    {
        if(countdown.millisElapsed() > 1000)
        {
            timer.add(-1);
            countdown.mark();
        }
        if(timer.getValue()==0)
        {
            addObject(new GameOver(counter),639,213);
            addObject(new CoinsCollected(counter),651,320);
            addObject(new Rank(counter),642,398);
            Greenfoot.stop();
        }
    }
    
    /**
     * Method adds Coins to the world
     */
    private void addCoins()
    {
        int a = 280;
        
        while(a < 380)
        {
            addObject(new Coin(),a,Greenfoot.getRandomNumber(670));
            a = a + 48 + SPACE;
        }
        
        int b = 480;
        
        while(b < 580)
        {
            addObject(new Coin(),b,Greenfoot.getRandomNumber(670));
            b = b + 48 + SPACE;
        }
        
        int c = 680;
        
        while(c < 1100)
        {
            addObject(new Coin(),c,Greenfoot.getRandomNumber(670));
            c = c + 48 + SPACE;
        }
    }
    
}
