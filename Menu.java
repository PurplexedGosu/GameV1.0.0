import greenfoot.*;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private Kyobashi kyo;
    private int delay = 0;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu(Kyobashi kyo)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1); 
        this.kyo = kyo;
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("j")&&delay>10) 
       {
           Greenfoot.setWorld(kyo);
           delay = 0;
       }
       delay++;
    }
}
