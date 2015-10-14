import greenfoot.*;

/**
 * Write a description of class cinematic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cinematic extends World
{
    private Kyobashi cinematic;
    private double time = 0;
    private int delay = 0;
    private double cloudIncrease = 0;
    private boolean createdOldManBot = false;
    private boolean createdLatestTextBox = false;
    private Text text;
    /**
     * Constructor for objects of class cinematic.
     * 
     */
    public Cinematic(Kyobashi cinematic)
    {    
        super(750, 750, 1, false); 
        this.cinematic = cinematic;
        prepare();
    }
    public void prepare()
    {
        // Create Ninja
        Ninja ninja = new Ninja();
        addObject(ninja, 97, 362);
        // Create many bushes at random locations not blocking the middle of the screen
        for (int i = 0; i < 150; i++)
        {
            Bush topBush = new Bush();
            addObject(topBush, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight())/2 -100);
            Bush bottomBush = new Bush();
            addObject(bottomBush, Greenfoot.getRandomNumber(getWidth()), (getHeight() + 70 - Greenfoot.getRandomNumber(getHeight()/2)));
        }
    }
    public void act()
    {
        // Allows us to change between worlds smoothly
        if (Greenfoot.isKeyDown("k")&&delay>10) 
        {
            Greenfoot.setWorld(cinematic);
            delay = 0;
        }
       delay++;
       time += 0.01602;
       
       // CINEMATIC TIME RELATED FUNCTIONS
       if (time >= 3)
       {
           cloudFunction();
       }
       if (time >= 5 && createdOldManBot == false)
       {
           OldManBot oldManBot = new OldManBot();
           addObject(oldManBot, 544, 362);
           createdOldManBot = true;
       }
       if (time >= 8 && time <= 10 &&createdLatestTextBox == false)
       {
           Text text = new Text("One day, the village of Kyobashi was threatened. \nA terrible force, the darkness, began to swarm.\nA lone berrypicker remained in the fields.");
           addObject(text, 315, 465);
           createdLatestTextBox = true;
       }
       if (time > 10)
       {
           createdLatestTextBox = false;
       }
       if (time >=10 && time <= 27 && createdLatestTextBox == false)
       {
           createdLatestTextBox = true;
           //text.setText("An old man appeared\n\"Come with me.\"\n\"I will save you.\"");
           //Text text2 = new Text("An old man appeared\n\"Come with me.\"\n\"I will save you.\"");
           //addObject(text2, 310, 465);
       }
       
    }
    // Create continous clouds at random locations with differing speeds not blocking the middle of the screen
    public void cloudFunction()
    {
        if (cloudIncrease < 25)
        {
            cloudIncrease+= 0.05;
        }
        if (Greenfoot.getRandomNumber(1000) < 15 + (int)cloudIncrease)
        {
            Smoke topSmoke = new Smoke(Greenfoot.getRandomNumber(2)+ 1);
            addObject(topSmoke, -100, Greenfoot.getRandomNumber(getHeight()/2 - 100));
            Smoke bottomSmoke = new Smoke(Greenfoot.getRandomNumber(2) + 1);
            addObject(bottomSmoke, -10, (getHeight() + 125 - Greenfoot.getRandomNumber(getHeight()/2)));
        }
    }
}
