import greenfoot.*;

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    //http://i1333.photobucket.com/albums/w631/megapowerskills/Background_zps510c32af.jpg
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        NinjaFighter ninjafighter = new NinjaFighter();
        addObject(ninjafighter, 373, 202);
        Play play = new Play();
        addObject(play, 410, 498);
        play.setLocation(374, 469);
    }
}
