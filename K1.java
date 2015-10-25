import greenfoot.*;

/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K1 extends Kyobashi
{
    Kyobashi K1;
    Ninja n1;
    Counter healthCounter;
    Counter shurikenCounter;
    Counter levelCounter;
    public K1(Ninja n1, Counter healthCounter, Counter shurikenCounter, Counter levelCounter)
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
        addObject(door, 663, 651);
        
        addObject(healthCounter, 70, 730);
        
        addObject(shurikenCounter, 225, 730);
        
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(levelCounter.getValue() + 1);
        
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
        BlueMM bluemm = new BlueMM();
        addObject(bluemm, 207, 453);
        BlueMM bluemm2 = new BlueMM();
        addObject(bluemm2, 530, 183);
        BlueMM bluemm3 = new BlueMM();
        addObject(bluemm3, 609, 368);
        BlueRM bluerm = new BlueRM();
        addObject(bluerm, 360, 580);
        BlueRM bluerm2 = new BlueRM();
        addObject(bluerm2, 487, 420);
        BlueRM bluerm3 = new BlueRM();
        addObject(bluerm3, 323, 282);
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
        if (getLevel() == 2)
        {
            k2Start();
        }
    }
    
}
