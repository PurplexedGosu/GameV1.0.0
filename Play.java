import greenfoot.*;

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Clickables
{
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound mainMenuTheme;
    public Play(GreenfootSound mainMenuTheme)
    {
        this.mainMenuTheme = mainMenuTheme;
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)){
            mainMenuTheme.stop();
            Greenfoot.setWorld(new Cinematic(new Kyobashi(new Ninja())));
        
        }
    }    
}
