import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K1 extends Trap
{
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    List<NPCS> npcs;
    Ninja ninja;
    int delay = 11;
    public K1(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
    }

    private void prepare()
    {
        Door door = new Door();
        addObject(door, 663, 651);
        
        addObject(healthCounter, 70, 730);
        
        addObject(shurikenCounter, 225, 730);
        addObject(powerCounter, 500, 730);
        
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(1);
        addObject(ninja, 100, 100);
        Fence fence77 = new Fence();
        addObject(fence77, 481, 682);
        Fence fence78 = new Fence();
        addObject(fence78, 486, 641);
        Fence fence79 = new Fence();
        addObject(fence79, 486, 604);
        Fence fence80 = new Fence();
        addObject(fence80, 492, 563);
        Fence fence81 = new Fence();
        addObject(fence81, 490, 523);
        Fence fence82 = new Fence();
        addObject(fence82, 192, 295);
        Fence fence83 = new Fence();
        addObject(fence83, 366, 176);
        Fence fence84 = new Fence();
        addObject(fence84, 405, 365);
        Fence fence85 = new Fence();
        addObject(fence85, 207, 574);
        Fence fence86 = new Fence();
        addObject(fence86, 634, 124);
        fence78.setLocation(481, 639);
        fence79.setLocation(480, 594);
        fence80.setLocation(479, 552);
        fence81.setLocation(480, 510);
        BlueRM bluemm = new BlueRM(3, 2);
        addObject(bluemm, 207, 453);
        BlueRM bluemm2 = new BlueRM(4, 2);
        addObject(bluemm2, 530, 183);
        BlueRM bluemm3 = new BlueRM(5, 2);
        addObject(bluemm3, 609, 368);
        BlueMM bluerm = new BlueMM(2, 2);
        addObject(bluerm, 360, 580);
        BlueMM bluerm2 = new BlueMM(2, 2);
        addObject(bluerm2, 487, 420);
        BlueMM bluerm3 = new BlueMM(2, 2);
        addObject(bluerm3, 323, 282);
        npcs = getObjects(NPCS.class);
       for(int i = 0; i<npcs.size(); i++)
       {
           TempText2 text = new TempText2(npcs.get(i));
           addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
       }
    }
    public void act()
    {
       if (Greenfoot.isKeyDown("j")&&delay>10) 
       {
           Menu menu = new Menu(getThisWorld());
           Greenfoot.setWorld(menu);
           delay = 0;
           
       }
        if(getObjects(Ninja.class).size() != 0)
        {
        checkDoor();
        healthCounter.setValue(ninja.getNINJAHP());
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
        powerCounter.setValue(ninja.getPOWERBAR());
        /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       }
       delay++;
    }
    public void checkDoor()
    {
        if(ninja.checkDoor()==true)
            Greenfoot.setWorld(new K2(ninja));
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