import greenfoot.*;
/**
 * Functionality in this class:
 */
public class Kyobashi extends World
{
    public int level = 0;
    private int delay = 11;    //Constructor for objects of class Kyobashi
    private Ninja n1;
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    GreenfootSound backgroundTheme = new GreenfootSound("ninja_backgroundtheme.mp3");
    // Levels
    Inferno inferno;
    K1 k1;
    K2 k2;
    K3 k3;
    public Kyobashi()
    {    
        super(750, 750, 1); 
        n1 = new Ninja();

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        addObject(n1, 100,400);
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
        healthCounter.setValue(n1.getNINJAHP());
        // Shurikens [Sean]
        
        addObject(shurikenCounter, 225, 730);
        shurikenCounter.setValue(n1.getSHURIKENNUMBER());
        
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(level);
        
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
           inferno = new Inferno(n1);
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
       if (Greenfoot.isKeyDown("1")&&delay>10) 
       {
           k1Start();
           delay = 0;
       }
       if (Greenfoot.isKeyDown("2")&&delay>10) 
       {
           k2Start();
           delay = 0;
       }
       if (Greenfoot.isKeyDown("3")&&delay>10) 
       {
           k3Start();
           delay = 0;
       }
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       
       delay++;
       healthCounter.setValue(n1.getNINJAHP());
       shurikenCounter.setValue(n1.getSHURIKENNUMBER());
       
   }
   
   public Kyobashi getThisWorld()
   {
       return this;
   }
   
   public Ninja getNinja()
   {
       return n1;
   }
   
   // Starting Levels
   public void infernostart()  // [Hayden]
   {
        inferno = new Inferno(n1);
        Greenfoot.setWorld(inferno);
   }
   public void k1Start() // [Sean]
   {
       k1 = new K1(n1, healthCounter, shurikenCounter, levelCounter);
       Greenfoot.setWorld(k1);
   }
   public void k2Start() // [Sean]
   {
       k2 = new K2(n1, healthCounter, shurikenCounter, levelCounter);
       Greenfoot.setWorld(k2);
   }
   public void k3Start() // [Sean]
   {
       k3 = new K3(n1, healthCounter, shurikenCounter, levelCounter);
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
}
