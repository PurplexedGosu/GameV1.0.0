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
        addObject(door, 85, 50);
        
        addObject(healthCounter, 70, 730);
        
        addObject(shurikenCounter, 225, 730);
        
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(levelCounter.getValue());
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
