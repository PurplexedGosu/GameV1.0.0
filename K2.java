import greenfoot.*;

/**
 * Write a description of class K2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K2 extends Kyobashi
{
    Kyobashi K2;
    Ninja n1;
    Counter healthCounter;
    Counter shurikenCounter;
    Counter levelCounter;
    public K2(Ninja n1, Counter healthCounter, Counter shurikenCounter, Counter levelCounter)
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
        addObject(door, 85, 650);
        
        addObject(healthCounter, 70, 730);
        
        addObject(shurikenCounter, 225, 730);
        
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(levelCounter.getValue());
    }
    public void act()
    {
        changeLevel();
    }
    private void changeLevel()
    {
        if (getLevel() == 3)
        {
            k3Start();
        }
    }
}
