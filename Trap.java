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
}
