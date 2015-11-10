import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K5 extends Trap
{
    Ninja ninja;
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    int delay = 11;
    private List<NPCS> npcs;
    /**
     * Constructor for objects of class K5.
     * 
     */
    public K5(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
    }
        private void prepare(){
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
        addObject(doort10, 80, 670);

        addObject(healthCounter, 70, 730);

        addObject(shurikenCounter, 225, 730);
        
        addObject(powerCounter, 500, 730);

        addObject(levelCounter, 355, 730);
        addObject(ninja, 100, 100);
        levelCounter.setValue(3);
            
            
            
            
        Fence fence77 = new Fence();
        addObject(fence77, 218, 76);
        Fence fence78 = new Fence();
        addObject(fence78, 221, 118);
        Fence fence79 = new Fence();
        addObject(fence79, 219, 162);
        Fence fence80 = new Fence();
        addObject(fence80, 223, 213);
        Fence fence81 = new Fence();
        addObject(fence81, 77, 378);
        Fence fence82 = new Fence();
        addObject(fence82, 127, 380);
        Fence fence83 = new Fence();
        addObject(fence83, 179, 385);
        Fence fence84 = new Fence();
        addObject(fence84, 222, 382);
        Fence fence85 = new Fence();
        addObject(fence85, 275, 389);
        Fence fence86 = new Fence();
        addObject(fence86, 334, 391);
        Fence fence87 = new Fence();
        addObject(fence87, 387, 397);
        Fence fence88 = new Fence();
        addObject(fence88, 436, 396);
        Fence fence89 = new Fence();
        addObject(fence89, 440, 356);
        Fence fence90 = new Fence();
        addObject(fence90, 447, 312);
        Fence fence91 = new Fence();
        addObject(fence91, 451, 276);
        Fence fence92 = new Fence();
        addObject(fence92, 456, 238);
        Fence fence93 = new Fence();
        addObject(fence93, 443, 563);
        fence81.setLocation(73, 424);
        fence82.setLocation(121, 423);
        fence83.setLocation(170, 422);
        fence84.setLocation(216, 421);
        fence85.setLocation(263, 420);
        fence86.setLocation(309, 420);
        fence87.setLocation(358, 420);
        fence88.setLocation(408, 420);
        fence89.setLocation(457, 419);
        fence90.setLocation(457, 371);
        fence91.setLocation(458, 323);
        fence92.setLocation(458, 275);
        fence77.setLocation(224, 74);
        fence78.setLocation(223, 124);
        fence79.setLocation(222, 171);
        fence80.setLocation(222, 219);
        RedMM redmm = new RedMM(3, 2);
        addObject(redmm, 134, 321);
        RedMM redmm2 = new RedMM(3, 2);
        addObject(redmm2, 356, 332);
        RedMM redmm3 = new RedMM(3, 2);
        addObject(redmm3, 364, 144);
        BlueRM bluerm = new BlueRM(3, 1);
        addObject(bluerm, 602, 152);
        bluerm.setLocation(593, 144);
        BlueRM bluerm2 = new BlueRM(3, 1);
        addObject(bluerm2, 638, 643);
        RedMM redmm4 = new RedMM(3, 2);
        addObject(redmm4, 601, 418);
        RedMM redmm5 = new RedMM(2, 1);
        addObject(redmm5, 320, 566); 
            
        
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
            Greenfoot.setWorld(new K7(ninja));
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
