import greenfoot.*;

/**
 * Write a description of class K3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K3 extends Trap
{
    Ninja ninja;
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    /**
     * Constructor for objects of class K3.
     * 
     */
    public K3(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
    }

    private void prepare()
    {
        Door door = new Door();
        addObject(door, 685, 50);

        addObject(healthCounter, 70, 730);

        addObject(shurikenCounter, 225, 730);
        
        addObject(powerCounter, 500, 730);

        addObject(levelCounter, 355, 730);
        addObject(ninja, 200, 200);
        levelCounter.setValue(3);
        addObject(ninja, 100, 100);
        Fence fence77 = new Fence();
        addObject(fence77, 521, 80);
        Fence fence78 = new Fence();
        addObject(fence78, 530, 188);
        Fence fence79 = new Fence();
        addObject(fence79, 538, 329);
        fence78.setLocation(520, 188);
        fence77.setLocation(517, 75);
        fence79.setLocation(521, 299);
        BlackRM blackrm = new BlackRM();
        addObject(blackrm, 521, 134);
        BlackRM blackrm2 = new BlackRM();
        addObject(blackrm2, 526, 248);
        Fence fence80 = new Fence();
        addObject(fence80, 294, 275);
        Fence fence81 = new Fence();
        addObject(fence81, 276, 486);
        Fence fence82 = new Fence();
        addObject(fence82, 376, 493);
        Fence fence83 = new Fence();
        addObject(fence83, 492, 490);
        fence82.setLocation(375, 487);
        fence83.setLocation(480, 488);
        BlackMM blackmm = new BlackMM();
        addObject(blackmm, 159, 492);
        BlackMM blackmm2 = new BlackMM();
        addObject(blackmm2, 609, 494);
        BlackRM blackrm3 = new BlackRM();
        addObject(blackrm3, 335, 617);
        BlackRM blackrm4 = new BlackRM();
        addObject(blackrm4, 459, 620);
        BlackRM blackrm5 = new BlackRM();
        addObject(blackrm5, 305, 394);
        BlackRM blackrm6 = new BlackRM();
        addObject(blackrm6, 416, 276);
        checkDoor();
    }

    public void act()
    {
        if(getObjects(Ninja.class).size() != 0)
        {
            healthCounter.setValue(ninja.getNINJAHP());
            shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
            powerCounter.setValue(ninja.getPOWERBAR());
            /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 

            /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
        }
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
}
