import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Intro0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro0 extends Trap
{
        Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    Ninja ninja;
    int delay = 11;
    int timer = 0;
    /**
     * Constructor for objects of class Intro0.
     * 
     */
    public Intro0(Ninja ninja)
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

        addObject(healthCounter, 70, 730);
        
        addObject(shurikenCounter, 225, 730);
        addObject(powerCounter, 500, 730);
        
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(0);
        addObject(ninja, 600, 600);
        
        TextBox0 textbox0 = new TextBox0();
        addObject(textbox0, 357, 186);
        OldManBot2 oldmanbot = new OldManBot2();
        addObject(oldmanbot, 220, 268);
        

    }
        public void act(){
      
        {
       if (Greenfoot.isKeyDown("j")&&delay>10) 
       {
           Menu menu = new Menu(getThisWorld());
           Greenfoot.setWorld(menu);
           delay = 0;
           
       }
        if(getObjects(Ninja.class).size() != 0)
        {
        
        //healthCounter.setValue(ninja.getNINJAHP());
        //shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
        //powerCounter.setValue(ninja.getPOWERBAR());
        //checkDoor();
        /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       }
       delay++;
      }
              timer++;
        if (timer >= 1000 || Greenfoot.isKeyDown("space")) 
        //want to be all keys
        {
            Greenfoot.setWorld(new Intro1(ninja));
        }
    }
      /*public void checkDoor()
       {
        if(ninja.checkDoor()==true)
            Greenfoot.setWorld(new Intro2());
       }
       */
      public Ninja getNinja()
      {
       return ninja;
      }
      public Trap getThisWorld()
     {
       return this;
     }
     
}
