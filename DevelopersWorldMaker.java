import greenfoot.*;

/**
 * Write a description of class WorldMaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DevelopersWorldMaker extends World
{

    /**
     * Constructor for objects of class WorldMaker.
     * 
     */
    Ninja ninja;
    public DevelopersWorldMaker()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1); 
        Ninja ninja = new Ninja();
        addObject(ninja, 50, 50);
        Counter healthCounter = new Counter("Health: "); //HAYDENS
        Counter shurikenCounter = new Counter("Shurikens: ");
        Counter powerCounter = new Counter("Power: ");
        Counter levelCounter = new Counter("Level: ");
        
        addObject(healthCounter, 70, 730);
        healthCounter.setValue(ninja.getNINJAHP());
        // Shurikens [Sean]
        
        addObject(shurikenCounter, 225, 730);
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
        
        addObject(powerCounter, 500, 730);
        powerCounter.setValue(ninja.getPOWERBAR());
        
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(1);
        
        prepare();
    }
    
    public void prepare()
    {
        InfernoFence infernofence = new InfernoFence();
        addObject(infernofence, 148, 119);
        InfernoFence infernofence2 = new InfernoFence();
        addObject(infernofence2, 630, 139);
        InfernoFence infernofence3 = new InfernoFence();
        addObject(infernofence3, 622, 601);
        InfernoFence infernofence4 = new InfernoFence();
        addObject(infernofence4, 162, 563);
        infernofence4.setLocation(160, 538);
        infernofence3.setLocation(596, 521);
        infernofence2.setLocation(582, 145);
        infernofence.setLocation(120, 114);
        infernofence4.setLocation(137, 530);
        infernofence4.setLocation(129, 531);
        infernofence3.setLocation(618, 530);
        infernofence3.setLocation(647, 568);
        infernofence4.setLocation(109, 565);
        infernofence4.setLocation(101, 499);
        infernofence2.setLocation(599, 179);
        infernofence.setLocation(152, 95);
        ArmPool armpool = new ArmPool();
        addObject(armpool, 347, 434);
        armpool.setLocation(155, 468);
        armpool.setLocation(150, 492);
        ArmPool armpool2 = new ArmPool();
        addObject(armpool2, 219, 101);
        ArmPool armpool3 = new ArmPool();
        addObject(armpool3, 616, 234);
        ArmPool armpool4 = new ArmPool();
        addObject(armpool4, 584, 542);
        armpool4.setLocation(579, 536);
        armpool3.setLocation(629, 213);
        armpool2.setLocation(213, 99);
        armpool.setLocation(166, 504);
        infernofence2.setLocation(628, 136);
        armpool3.setLocation(649, 185);
        infernofence3.setLocation(647, 602);
        armpool4.setLocation(581, 566);
        BlueMM bluemm = new BlueMM(5, 4);
        addObject(bluemm, 316, 175);
    }
    
}
