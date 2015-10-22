
//Bill's code

import greenfoot.*;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private Kyobashi kyo;
    private int delay = 0;
    private TempText text1;
    private TempText text2;
    private TempText text3;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu(Kyobashi kyo)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1); 
        this.kyo = kyo;
        Button button1 = new Button(1);
        addObject(button1, 100, 250);
        Button button2 = new Button(2);
        addObject(button2, 100, 450);
        Button button3 = new Button(3);
        addObject(button3, 100, 650);
        text1 = new TempText("Melee Damage: "+Integer.toString(kyo.getNinja().getMeleeDamage()));
        addObject(text1, 250, 250);
        text2 = new TempText("Range Damage: "+Integer.toString(kyo.getNinja().getRangeDamage()));
        addObject(text2, 250, 450);
        text3 = new TempText("Armor: "+Integer.toString(kyo.getNinja().getArmor()));
        addObject(text3, 250, 650);
    }
    
    public void act()
    {
       if (Greenfoot.isKeyDown("j")&&delay>10) 
       {
           Greenfoot.setWorld(kyo);
           delay = 0;
       }
       delay++;
       text1.updateImage("Melee Damage: "+Integer.toString(kyo.getNinja().getMeleeDamage()));
       text2.updateImage("Range Damage: "+Integer.toString(kyo.getNinja().getRangeDamage()));
       text3.updateImage("Armor: "+Integer.toString(kyo.getNinja().getArmor()));
    }
    
    public Kyobashi getKyo()
    {
        return kyo;
    }
}