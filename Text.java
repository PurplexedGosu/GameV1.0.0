import greenfoot.*;

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Inanimate
{
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Text(String message)
    {
        GreenfootImage text = new GreenfootImage(600, 150);
        text.drawString(message, 1, 10);
        setImage(text);
    }
    public void setText(String text)
    {
        GreenfootImage img = getImage();
        img.clear();
        img.drawString(text, 1, 10);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
