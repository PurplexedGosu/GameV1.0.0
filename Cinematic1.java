import greenfoot.*;

/**
 * Write a description of class Cinamatic1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cinematic1 extends Trap
{
    Ninja ninja;
    private int timec1 = 0;
    //private List<Flash> flash;
    /**
     * Constructor for objects of class Cinamatic1.
     * 
     */
    public Cinematic1(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
        
    }
    public void act(){
        timec1++;
        flash();
    }
    public void prepare(){
               for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
            InfernoFence fence = new InfernoFence();
            addObject(fence, 25+j*700, 50*i+25);
            }
        for(int i = 1;i<24; i++)
            for(int j = 0; j<2; j++)
            {
                InfernoFence fence = new InfernoFence();
                addObject(fence, 50*i+25, 25+j*700);
            }
            addObject(ninja, 100, 375);
            InfernoBoss1 ifb1 = new InfernoBoss1();
            addObject(ifb1, 620, 375);
            
            
    }
    public void flash(){
        if (timec1 <= 201 && timec1 >= 200){
            Flash flash = new Flash();
            addObject(flash, 375, 375);
        }
        
        if (timec1 >= 201){
            //flash = getObjects(Flash.class);
            //removeObject(flash);
        }
        
    }
    
}
