import greenfoot.*;
import java.awt.Color;
/**
 * Code from danpost on Greenfoot forums
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TempText extends Actor
{
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TempText(String text) 
    {
        updateImage(text);
    }    
    
    public void updateImage(String text)
    {
        setImage(new GreenfootImage(text, 18, Color.black, new Color(0,0,0,0)));
    }
}
