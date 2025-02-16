import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A ScoreCounter class that allows you to display a numerical value on screen.
 * 
 * The ScoreCounter is an actor, so you will need to create it, and then add it to
 * the world in Greenfoot.  If you keep a reference to the ScoreCounter then you
 * can adjust its value. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreCounter extends Actor
{
   private static final Color transparent = new Color(0,0,0,0);
   private GreenfootImage background;
   private int value;
   private int target;
   private int lives;
   private String prefix;
    
   public ScoreCounter()
   {
       this(new String());
   }

   /**
    * Create a new counter, initialised to 0.
    */
   public ScoreCounter(String prefix)
   {
        background = getImage();  // get image from class
        value = 0;
        target = 0;
        this.prefix = prefix;
        updateImage();
   }
   /**
   * Animate the display to count up (or down) to the current target value.
   */
   public void act() 
   {
        if (value < target) {
            value++;
            updateImage();
        }
        else if (value > target) {
            value--;
            updateImage();
        }
   }

   /**
   * Add a new score to the current counter value.  This will animate
   * the counter over consecutive frames until it reaches the new value.
   */
   public void add(int score)
   {
        target += score;
   }
   /**
   * Return the current counter value.
   */
   public int getValue()
   {
        return target;
   }

   /**
   * Set a new counter value.  This will not animate the counter.
   */
   public void setValue(int newValue)
   {
        target = newValue;
        value = newValue;
        updateImage();
   }
    
   /**
   * Sets a text prefix that should be displayed before
   * the counter value (e.g. "Score: ").
   */
   public void setPrefix(String prefix)
   {
        this.prefix = prefix;
        updateImage();
   }

   /**
   * Update the image on screen to show the current value.
   */
   private void updateImage()
   {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage(prefix + value, 22, Color.BLACK, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
   }
}
