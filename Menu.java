import greenfoot.*;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private Kyobashi menu;
    private int delay = 0;
    GreenfootSound menuTheme = new GreenfootSound("Fable Theme.mp3");
    private boolean isTheme = false;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu(Kyobashi menu)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1); 
        this.menu = menu;
        if (isTheme == false)
        {
            //Greenfoot.playSound("Fable Theme.mp3");
            isTheme = true;
        }
    }
    
    public void act()
    {
          menuTheme.playLoop(); 
           if (Greenfoot.isKeyDown("j")&&delay>10) 
           {
           if(menuTheme.isPlaying())
           {
               menuTheme.pause();
           }
               Greenfoot.setWorld(menu);
               delay = 0;
           }
           delay++;
    }
}
