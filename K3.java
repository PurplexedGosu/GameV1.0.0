import greenfoot.*;

/**
 * Write a description of class K3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K3 extends Kyobashi
{
    Kyobashi K3;
    Ninja n1;
    Counter healthCounter;
    Counter shurikenCounter;
    Counter levelCounter;
    /**
     * Constructor for objects of class K3.
     * 
     */
    public K3(Ninja n1, Counter healthCounter, Counter shurikenCounter, Counter levelCounter)
    {
        super();
        this.n1 = n1;
        this.healthCounter = healthCounter;
        this.shurikenCounter = shurikenCounter;
        this.levelCounter = levelCounter;
        prepare();
    }
    
    private void prepare()
    {
        Door door = new Door();
        addObject(door, 685, 50);
        
        addObject(healthCounter, 70, 730);
        
        addObject(shurikenCounter, 225, 730);
        
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(levelCounter.getValue());
        
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
    }
    
    public void act()
    {
        changeLevel();
        
        /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       if (Greenfoot.isKeyDown("1")) 
       {
           k1Start();
       }
       if (Greenfoot.isKeyDown("2")) 
       {
           k2Start();
       }
       if (Greenfoot.isKeyDown("3")) 
       {
           k3Start();
       }
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
    }
    private void changeLevel()
    {
        if (getLevel() == 4)
        {
            //addLevel();
            // Change Level
        }
    }
    
}
