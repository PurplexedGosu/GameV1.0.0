import greenfoot.*;

public class Menu extends World
{
    // Menu Variables Start [Bill]
    private Trap trap;
    private int delay = 0;
    private TempText text1;
    private TempText text2;
    private TempText text3;
    private TempText text4;
    private TempText text5;
    // Menu Variables End [Bill]
    // Button Constructor Start [Billl]
    public Menu(Trap trap)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1); 
        this.trap = trap;
        Button button1 = new Button(1);
        addObject(button1, 100, 250);
        Button button2 = new Button(2);
        addObject(button2, 100, 450);
        Button button3 = new Button(3);
        addObject(button3, 100, 650);
        text1 = new TempText("Melee Damage: "+Integer.toString(trap.getNinja().getMeleeDamage()));
        addObject(text1, 250, 250);
        text2 = new TempText("Range Damage: "+Integer.toString(trap.getNinja().getRangeDamage()));
        addObject(text2, 250, 450);
        text3 = new TempText("Armor: "+Integer.toString(trap.getNinja().getArmor()));
        addObject(text3, 250, 650);
        text4 = new TempText("Points: "+Integer.toString(trap.getNinja().getPoints()));
        addObject(text4, 250, 150);
        text5 = new TempText("You need five points to level up.");
        addObject(text5, 150, 100);
    }
    // Button Constructor End [Billl]
    // Menu Implementation Start [Bill]
    public void act()
    {
       if (Greenfoot.isKeyDown("j")&&delay>10) 
       {
           Greenfoot.setWorld(trap);
           delay = 0;
       }
       delay++;
       text1.updateImage("Melee Damage: "+Integer.toString(trap.getNinja().getMeleeDamage()));
       text2.updateImage("Range Damage: "+Integer.toString(trap.getNinja().getRangeDamage()));
       text3.updateImage("Armor: "+Integer.toString(trap.getNinja().getArmor()));
       text4.updateImage("Points: "+Integer.toString(trap.getNinja().getPoints()));
    }
    // Menu Implementation End [Bill]
    // [Bill]
    public Trap getTrap()
    {
        return trap;
    }
}