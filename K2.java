import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K2 extends Trap
{
    Ninja ninja;
    Counter healthCounter = new Counter("Health: ");
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    int delay = 11;
    private List<NPCS> npcs;
    public K2(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
    }

    private void prepare()
    {
                for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
            Fence fence = new Fence();
            addObject(fence, 25+j*700, 50*i+25);
            }
        for(int i = 1;i<24; i++)
            for(int j = 0; j<2; j++)
            {
                Fence fence = new Fence();
                addObject(fence, 50*i+25, 25+j*700);
            }
        
        doorT10 doort10 = new doorT10();
        addObject(doort10, 85, 650);

        addObject(healthCounter, 70, 730);

        addObject(shurikenCounter, 225, 730);
        addObject(powerCounter, 500, 730);
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(2);
        addObject(ninja, 150, 100);
        Fence fence77 = new Fence();
        addObject(fence77, 177, 163);
        Fence fence78 = new Fence();
        addObject(fence78, 73, 171);
        Fence fence79 = new Fence();
        addObject(fence79, 128, 176);
        Fence fence80 = new Fence();
        addObject(fence80, 152, 175);
        Fence fence81 = new Fence();
        addObject(fence81, 239, 178);
        Fence fence82 = new Fence();
        addObject(fence82, 318, 184);
        Fence fence83 = new Fence();
        addObject(fence83, 368, 184);
        Fence fence84 = new Fence();
        addObject(fence84, 279, 172);
        Fence fence85 = new Fence();
        addObject(fence85, 209, 172);
        Fence fence86 = new Fence();
        addObject(fence86, 422, 191);
        Fence fence87 = new Fence();
        addObject(fence87, 682, 191);
        fence79.setLocation(120, 170);
        fence80.setLocation(142, 169);
        fence77.setLocation(180, 169);
        fence85.setLocation(216, 170);
        fence81.setLocation(244, 170);
        fence84.setLocation(278, 170);
        fence82.setLocation(319, 172);
        fence82.setLocation(326, 170);
        fence83.setLocation(374, 170);
        fence86.setLocation(422, 170);
        RedRM redRM = new RedRM(2, 1);
        addObject(redRM, 253, 523);
        RedRM redRM2 = new RedRM(2, 1);
        addObject(redRM2, 557, 327);
        RedRM redRM3 = new RedRM(2, 1);
        addObject(redRM3, 90, 236);
        RedRM redRM4 = new RedRM(2, 1);
        addObject(redRM4, 659, 666);
        RedMM redrm = new RedMM(2, 1);
        addObject(redrm, 314, 339);
        RedMM redrm2 = new RedMM(2, 1);
        addObject(redrm2, 513, 543);
        Fence fence88 = new Fence();
        addObject(fence88, 683, 442);
        Fence fence89 = new Fence();
        addObject(fence89, 416, 443);
        Fence fence90 = new Fence();
        addObject(fence90, 199, 322);
        
                npcs = getObjects(NPCS.class);
       for(int i = 0; i<npcs.size(); i++)
       {
           TempText2 text = new TempText2(npcs.get(i));
           addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
       }
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("h")&&delay>10) 
        {
            Menu menu = new Menu(getThisWorld());
            Greenfoot.setWorld(menu);
            delay = 0;

        }
        if(getObjects(Ninja.class).size() != 0)
        {
            healthCounter.setValue(ninja.getNINJAHP());
            shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
            powerCounter.setValue(ninja.getPOWERBAR());
            checkDoor();
            /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
        }
        delay++;
    }

    public void checkDoor()
    {
        if(ninja.checkDoor()==true)
            Greenfoot.setWorld(new K3(ninja));
    }

    public Ninja getNinja()
    {
        return ninja;
    }
    public Trap getThisWorld()
    {
        return this;
    }
}
