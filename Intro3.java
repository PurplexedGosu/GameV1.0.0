import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Intro1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro3 extends Trap
{
        Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    Ninja ninja;
    int delay = 11;
    /**
     * Constructor for objects of class Intro1.
     * 
     */
    public Intro3(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        
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
        
        addObject(ninja, 600, 600);
        
        TextBox3 textbox3 = new TextBox3();
        addObject(textbox3, 357, 186);
        OldManBot2 oldmanbot = new OldManBot2();
        addObject(oldmanbot, 220, 268);
        
        BlueRM bluemm = new BlueRM(1, 1);
        addObject(bluemm, 300, 600);
        
        addShuriken as = new addShuriken();
        addObject(as, 625, 500);
        addShuriken as1 = new addShuriken();
        addObject(as1, 575, 500);
    }
    public void act(){
      
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
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       }
       delay++;
      }
    }
      public void checkDoor()
       {
        if(ninja.checkDoor()==true)
            Greenfoot.setWorld(new Intro4(ninja));
       }
      public Ninja getNinja()
      {
       return ninja;
      }
      public Trap getThisWorld()
     {
       return this;
     }
       public void gameover(){
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new Intro3(ninja));
    }
}
