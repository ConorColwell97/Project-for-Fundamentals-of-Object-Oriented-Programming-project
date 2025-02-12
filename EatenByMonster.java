import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class displays a game over screen if the 
 * player is eaten by a monster.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EatenByMonster extends Actor
{
   /**
   * Create a constructor that dispalys game over text.
   */
   public EatenByMonster()
   {
       setImage(new GreenfootImage("Game over - Eaten by a monster",50,Color.RED,null));
   }
}
