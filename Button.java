import greenfoot.*;
/**
 * Functionality in this class:
 */
public class Button extends Actor
{
    private int type;
    private int delay = 21;
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