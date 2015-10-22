
import greenfoot.*;

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private int type;
    private int delay = 21;
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Button(int type)
    {
        this.type = type;
    }
    public void act() 
    {
        if(delay>20&&Greenfoot.mouseClicked(this)&&type==1)
        {
            delay = 0;
            Menu menu = (Menu) getWorld();
            Ninja ninja = menu.getKyo().getNinja();
            ninja.setMeleeDamage(ninja.getMeleeDamage()+1);
        }
        if(delay>20&&Greenfoot.mouseClicked(this)&&type==2)
        {
            delay = 0;
            Menu menu = (Menu) getWorld();
            Ninja ninja = menu.getKyo().getNinja();
            ninja.setRangeDamage(ninja.getRangeDamage()+1);
        }
        if(delay>20&&Greenfoot.mouseClicked(this)&&type==3)
        {
            delay = 0;
            Menu menu = (Menu) getWorld();
            Ninja ninja = menu.getKyo().getNinja();
            ninja.setArmor(ninja.getArmor()+1);
        }
        delay++;
    }    
}