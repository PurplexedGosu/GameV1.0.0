import greenfoot.*;

/**
 * Functionality in this class:
 */
public class Inferno extends World
{
    private Kyobashi inferno;
    private int delay = 0;
    Ninja ninja;
    public Inferno(Ninja ninja)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1); 
        this.ninja = ninja;
        this.inferno = inferno;
        prepare();
    }
    
    public void act()
    {
    }
    private void prepare()
    {
        addObject(ninja, 100,400);
    }
}