import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K10 extends Trap
{
    Ninja ninja;
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    int delay = 11;
    private List<NPCS> npcs;
    /**
     * Constructor for objects of class K8.
     * 
     */
    public K10(Ninja ninja)
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
                      for (int i = 0; i<6; i++)
        {
            Fence fence = new Fence();
            addObject(fence, 50*i+25, 375);
        }

        for (int i = 0; i<6; i++)
        {
            Fence fence = new Fence();
            addObject(fence, 50*i+475, 375);
        }
        doorT10 doort10 = new doorT10();
        addObject(doort10, 80, 670);
        addObject(healthCounter, 70, 730);

        addObject(shurikenCounter, 225, 730);
        
        addObject(powerCounter, 500, 730);

        addObject(levelCounter, 355, 730);
        addObject(ninja, 100, 100);
        levelCounter.setValue(3);
       

        
                addObject(ninja, 650, 650);
                
                HealthGlobe healthglobe = new HealthGlobe();
        addObject(healthglobe, 678, 309);
        HealthGlobe healthglobe2 = new HealthGlobe();
        addObject(healthglobe2, 678, 436);
        HealthGlobe healthglobe3 = new HealthGlobe();
        addObject(healthglobe3, 78, 666);
        addShuriken addshuriken = new addShuriken();
        addObject(addshuriken, 675, 85);
        addShuriken addshuriken2 = new addShuriken();
        addObject(addshuriken2, 84, 438);
        addShuriken addshuriken3 = new addShuriken();
        addObject(addshuriken3, 92, 318);
        RedMM redmm = new RedMM(3, 3);
        addObject(redmm, 237, 214);
        RedMM redmm2 = new RedMM(3, 3);
        addObject(redmm2, 385, 213);
        RedMM redmm3 = new RedMM(3, 3);
        addObject(redmm3, 532, 214);
        BlueRM bluerm = new BlueRM(5, 3);
        addObject(bluerm, 381, 376);
        RedMM redmm4 = new RedMM(3, 3);
        addObject(redmm4, 237, 566);
        RedMM redmm5 = new RedMM(3, 3);
        addObject(redmm5, 400, 559);
        redmm5.setLocation(382, 545);
        redmm4.setLocation(227, 547);
        
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
            Greenfoot.setWorld(new K11(ninja));
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
