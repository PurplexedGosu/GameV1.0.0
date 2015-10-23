import greenfoot.*;

/**
 * Functionality in this class:
 */
public class Inferno extends World
{
    private Kyobashi inferno;
    private int delay = 0;
    Ninja n1;
    public Inferno(Ninja n1)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1); 
        this.n1 = n1;
        this.inferno = inferno;
        prepare();
    }
    
    public void act()
    {
    }
    private void prepare()
    {
        Ninja n1;
        n1 = new Ninja();
        addObject(n1, 100,400);
    }
}