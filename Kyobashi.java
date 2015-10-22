import greenfoot.*;

/**
 * The world of Tristam
 * @author Sean Wallace
 * @version (a version number or a date)
 */
public class Kyobashi extends World
{
    private int delay = 11;    //Constructor for objects of class Kyobashi
    private Ninja n1;
    private Ninja2 n2;
    GreenfootSound backgroundTheme = new GreenfootSound("ninja_backgroundtheme.mp3");
    Inferno inferno;
    public Kyobashi()
    {    
        super(750, 750, 1); 
        createWorld();

        prepare();
    }

    public void createWorld()
    {
        //Creates the Ninja Hero [Sean]
        n1 = new Ninja();
        addObject(n1, 100,400);
        
        n2 = new Ninja2();
        addObject(n2, 350,415);
        
        // Health [Sean]
        Counter healthCounter = new Counter("Health: ");
        addObject(healthCounter, 70, 730);
        healthCounter.setValue(100);
        // Shurikens [Sean]
        Counter shurikenCounter = new Counter("Shurikens: ");
        addObject(shurikenCounter, 225, 730);
        shurikenCounter.setValue(6);
        
        // Each fence is 50x50
        // Fence fence = new Fence();
        
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        BlueRM blueRM = new BlueRM();
        addObject(blueRM, 623, 99);
        RedRM redRM = new RedRM();
        addObject(redRM, 619, 347);
        BlackRM blackRM = new BlackRM();
        addObject(blackRM, 614, 611);

        Fence fence = new Fence();
        addObject(fence, 100, 408);
        Fence fence2 = new Fence();
        addObject(fence2, 207, 228);
        Fence fence3 = new Fence();
        addObject(fence3, 351, 427);
        Fence fence4 = new Fence();
        addObject(fence4, 204, 586);
        fence3.setLocation(352, 434);
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
           Cinematic cinematic = new Cinematic(getThisWorld());
           Greenfoot.setWorld(cinematic);
           delay = 0;
       }
       delay++;
   }
   
   public Kyobashi getThisWorld()
   {
       return this;
   }
   
   public Ninja getNinja()
   {
       return n1;
   }
   public void infernostart()
   {
        inferno = new Inferno(n1);
        Greenfoot.setWorld(inferno);
   }
}
