import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K12 extends Trap
{
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<Bosses> dashboss;
    Ninja ninja;
    int delay = 11;
    public K12(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
    }

    private void prepare()
    {
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
        
       addObject(ninja, 375, 375);
            
       
        DashBoss dashboss = new DashBoss(40);
        addObject(dashboss, 200, 200);
        addObject(healthCounter, 70, 730);
        
        addObject(shurikenCounter, 225, 730);
        addObject(powerCounter, 500, 730);
        
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(1);
        
        Fence fence77 = new Fence();
        addObject(fence77, 335, 384);
        Fence fence78 = new Fence();
        addObject(fence78, 436, 384);
        
        HealthGlobe hg = new HealthGlobe();
        addObject(hg, 90, 90);
                HealthGlobe hg1 = new HealthGlobe();
        addObject(hg1, 660, 660);
        
        
        
       
           TempText3 text = new TempText3(dashboss);
           addObject(text, dashboss.getX(), dashboss.getY()-20);
       
    }
    public void act()
    {
        createdoor();
       if (Greenfoot.isKeyDown("h")&&delay>10) 
       {
           Menu menu = new Menu(getThisWorld());
           Greenfoot.setWorld(menu);
           delay = 0;
           
       }
        if(getObjects(Ninja.class).size() != 0)
        {
        checkDoor();
        healthCounter.setValue(ninja.getNINJAHP());
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
        powerCounter.setValue(ninja.getPOWERBAR());
        /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       }
       delay++;
    }
    public void checkDoor()
    {
        if(ninja.checkDoor()==true)
            Greenfoot.setWorld(new Kyobashi1(ninja));
    }
   public Ninja getNinja()
   {
       return ninja;
   }
   public Trap getThisWorld()
   {
       return this;
   }
   
   public boolean isbossthere(){
        List<Bosses> list = getObjects(DashBoss.class);
        if (list.size()>0)
        
        
        
        
        if (list.size() >0){
            return true;
        }
        else{
            return false;
        }
        return false;
    }
        
    public void createdoor(){
        if(isbossthere() == false){
            doorT10 doort10 = new doorT10();
        addObject(doort10, 375, 660);
        }
    }
       public void gameover(){
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new K12(ninja));
    }
    
   }

