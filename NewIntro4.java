import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Intro1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewIntro4 extends Trap
{
        Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    private GreenfootSound bloodBourne = new GreenfootSound("Bloodborne - Celestial Emissary.mp3");
    Boy boy;
    int delay = 0;
    /**
     * Constructor for objects of class Intro1.
     * 
     */
    public NewIntro4(Boy boy)
    {
        super();
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

        addObject(boy, 600, 500);

        OldManBot2 oldmanbot = new OldManBot2();
        addObject(oldmanbot, 220, 268);

        IntroRM bluerm = new IntroRM(1, 1);
        addObject(bluerm, 174, 505);

        IntroFence introfence123 = new IntroFence();
        addObject(introfence123, 672, 428);
        introfence123.setLocation(657, 437);
        boy.setLocation(651, 515);

        IntroFence introfence124 = new IntroFence();
        addObject(introfence124, 666, 586);
        introfence124.setLocation(657, 583);
        IntroFence introfence125 = new IntroFence();
        addObject(introfence125, 513, 446);
        introfence125.setLocation(503, 437);
        IntroFence introfence126 = new IntroFence();
        addObject(introfence126, 594, 590);
        introfence126.setLocation(588, 582);
        introfence126.setLocation(588, 583);
        IntroFence introfence127 = new IntroFence();
        addObject(introfence127, 524, 590);
        introfence127.setLocation(518, 583);
        removeObject(introfence123);
        removeObject(introfence125);
        bluerm.setLocation(280, 481);
        removeObject(introfence126);
        removeObject(introfence124);
        removeObject(introfence127);
        bluerm.setLocation(299, 516);
        boy.setLocation(647, 518);
        boy.setLocation(640, 520);
        IntroFence introfence128 = new IntroFence();
        addObject(introfence128, 665, 440);
        IntroFence introfence129 = new IntroFence();
        addObject(introfence129, 528, 444);
        IntroFence introfence130 = new IntroFence();
        addObject(introfence130, 666, 605);
        IntroFence introfence131 = new IntroFence();
        addObject(introfence131, 607, 614);
        IntroFence introfence132 = new IntroFence();
        addObject(introfence132, 553, 614);
        IntroFence introfence133 = new IntroFence();
        addObject(introfence133, 484, 620);
        IntroFence introfence134 = new IntroFence();
        addObject(introfence134, 416, 622);
        IntroFence introfence135 = new IntroFence();
        addObject(introfence135, 359, 625);
        IntroFence introfence136 = new IntroFence();
        addObject(introfence136, 364, 444);
        introfence129.setLocation(517, 440);
        introfence136.setLocation(364, 440);
        introfence130.setLocation(668, 601);
        introfence131.setLocation(599, 601);
        introfence132.setLocation(529, 601);
        introfence133.setLocation(461, 602);
        introfence134.setLocation(399, 602);
        introfence135.setLocation(330, 602);
        introfence132.setLocation(461, 680);
        introfence132.setLocation(460, 671);
        IntroFence introfence137 = new IntroFence();
        addObject(introfence137, 299, 446);
        introfence137.setLocation(292, 440);
        IntroFence introfence138 = new IntroFence();
        addObject(introfence138, 301, 607);
        introfence138.setLocation(291, 602);
        IntroFence introfence139 = new IntroFence();
        addObject(introfence139, 606, 669);
        introfence139.setLocation(599, 670);
        IntroFence introfence140 = new IntroFence();
        addObject(introfence140, 665, 668);
        HealthGlobe healthglobe = new HealthGlobe();
        addObject(healthglobe, 533, 654);
        healthglobe.setLocation(525, 646);

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
          Greenfoot.setWorld(new NewIntro5(boy));
      }
      
       checkDoor();
       
      
    }
     public void checkDoor()
       {
        if(boy.checkDoor()==true)
        bloodBourne.stop();
        
            Greenfoot.setWorld(new NewIntro5(boy));
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
       Greenfoot.setWorld(new NewIntro4(boy));
    }
}

