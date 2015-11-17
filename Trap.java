import greenfoot.*;

/**
 * Write a description of class Trap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trap extends World
{
    Ninja ninja;
    Boy boy;
    DeathWorld deathWorld;
    /**
     * Constructor for objects of class Trap.
     * 
     */
    public Trap()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1); 
    }
    public Ninja getNinja()
    {
        return ninja;
    }
    public Boy getBoy()
    {
        return boy;
    }
    public void infernostart()  // [Hayden]
   {
        deathWorld = new DeathWorld(ninja);
        Greenfoot.setWorld(deathWorld);
   }
      public void gameover(){
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new Kyobashi(ninja));
    }
}
