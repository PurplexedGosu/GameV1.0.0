import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Intro1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewIntro5 extends Trap
{
        Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    private GreenfootSound bloodBourne = new GreenfootSound("Bloodborne - Celestial Emissary.mp3");
    Ninja ninja;
    Boy boy;
    int delay = 0;
    /**
     * Constructor for objects of class Intro1.
     * 
     */
    public NewIntro5(Boy boy)
    {
        super();
        ninja = new Ninja();
        this.boy = boy;
        bloodBourne.setVolume(25);
        prepare();
    }
    
    public void prepare(){
        for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
                IntroFence fence = new IntroFence();
                addObject(fence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<24; i++)
            for(int j = 0; j<2; j++)
            {
                IntroFence fence = new IntroFence();
                addObject(fence, 50*i+25, 25+j*700);
        }

        for(int i = 1;i<24; i++)
            for(int j = 0; j<2; j++)
            {
                IntroFence fence = new IntroFence();
                addObject(fence, 50*i+25, 360);
        }
        doorT10 doort10 = new doorT10();
        addObject(doort10, 100, 640);

        addObject(healthCounter, 70, 730);

        addObject(shurikenCounter, 225, 730);
        addObject(powerCounter, 500, 730);

        addObject(levelCounter, 355, 730);
        levelCounter.setValue(0);

        addObject(boy, 600, 600);

        OldManBot2 oldmanbot = new OldManBot2();
        addObject(oldmanbot, 220, 268);

        SwordIcon swordicon = new SwordIcon();
        addObject(swordicon, 89, 373);
        ShurikenIcon shurikenicon = new ShurikenIcon();
        addObject(shurikenicon, 142, 373);
    }

    public void act(){
       delay++;
        bloodBourne.playLoop();
       if (Greenfoot.isKeyDown("h")&&delay>10) 
       {
           Menu menu = new Menu(getThisWorld());
           Greenfoot.setWorld(menu);
           delay = 0;
           
       }
        if (Greenfoot.isKeyDown("escape") && delay > 20) 
      //want to be all keys
      {
          bloodBourne.stop();
          Greenfoot.setWorld(new Kyobashi(ninja));
          
      }
      
       checkDoor();
      
      
    }
      public void checkDoor()
       {
        if(boy.checkDoor()==true)
            Greenfoot.setWorld(new Kyobashi(ninja));
       }
      public Boy getBoy()
      {
       return boy;
      }
      public Trap getThisWorld()
      {
       return this;
      }
       public void gameover(){
       boy.setHP(boy.getArmor());
       bloodBourne.stop();
       Greenfoot.setWorld(new NewIntro5(boy));
      }
}
