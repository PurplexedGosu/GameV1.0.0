import greenfoot.*;
/**
 * Functionality in this class:
 */
public class Kyobashi extends World
{
    public int level = 0;
    private int delay = 11;    //Constructor for objects of class Kyobashi
    private Ninja ninja;
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter powerCounter = new Counter("Power: ");
    Counter levelCounter = new Counter("Level: ");
    GreenfootSound backgroundTheme = new GreenfootSound("ninja_backgroundtheme.mp3");
    // Levels
    Inferno inferno;
    public Kyobashi(Ninja ninja)
    {    
        super(750, 750, 1); 
        this.ninja = ninja;
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        addObject(ninja, 100, 100);
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
        addObject(healthCounter, 70, 730);
        healthCounter.setValue(ninja.getNINJAHP());
        // Shurikens [Sean]
        
        addObject(shurikenCounter, 225, 730);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
        
        addObject(powerCounter, 500, 730);
        powerCounter.setValue(ninja.getPOWERBAR());
        
        
        
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(level);
        Door door = new Door();
        addObject(door, 500, 500);
    }
    
   public void act()
   {
       backgroundTheme.setVolume(65);
       //backgroundTheme.playLoop(); 
       
       
       
       if (Greenfoot.isKeyDown("j")&&delay>10) 
       {
           if(backgroundTheme.isPlaying())
           {
               backgroundTheme.pause();
           }
           Menu menu = new Menu(getThisWorld());
           Greenfoot.setWorld(menu);
           delay = 0;
           
       }
       if (Greenfoot.isKeyDown("h")&&delay>10) 
       {
           if(backgroundTheme.isPlaying())
           {
               backgroundTheme.pause();
           }
           inferno = new Inferno(ninja);
           Greenfoot.setWorld(inferno);
           delay = 0;
       }
       if (Greenfoot.isKeyDown("k")&&delay>10) 
       {
           if(backgroundTheme.isPlaying())
           {
               backgroundTheme.pause();
           }
           k1Start();
           delay = 0;
       }
       if (Greenfoot.isKeyDown("l")&&delay>10) 
       {
           if(backgroundTheme.isPlaying())
           {
               backgroundTheme.pause();
           }
           Cinematic cinematic = new Cinematic(getThisWorld());
           Greenfoot.setWorld(cinematic);
           delay = 0;
       }
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       
       delay++;
       healthCounter.setValue(ninja.getNINJAHP());
       shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
       powerCounter.setValue(ninja.getPOWERBAR());
       checkDoor();
   }
   
   public Kyobashi getThisWorld()
   {
       return this;
   }
   
   public Ninja getNinja()
   {
       return ninja;
   }
   
   // Starting Levels
   
   public void k1Start() // [Sean]
   {
       K1 k1 = new K1(ninja);
       Greenfoot.setWorld(k1);
   }
   public void k2Start() // [Sean]
   {
       K2 k2 = new K2(ninja);
       Greenfoot.setWorld(k2);
   }
   public void k3Start() // [Sean]
   {
       K3 k3 = new K3(ninja);
       Greenfoot.setWorld(k3);
   }
   public void addLevel()
   {
       level++;
       levelCounter.add(1);
   }
   public int getLevel()
   {
       return level;
   }
   public void checkDoor()
   {
       if(ninja.checkDoor()==true)
            Greenfoot.setWorld(new K1(ninja));
   }
}
