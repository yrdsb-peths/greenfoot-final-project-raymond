import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Initial Title world 
 * @author (raymond) 
 * @version (june 2022)
 */
public class TitleWorld extends World
{

    //title label
    Label titleLabel = new Label("Amongus", 100);
    static GreenfootSound background = new GreenfootSound("amongus_background.mp3");
    
    public TitleWorld()
    {
        super(1280, 720, 1);
        addObject(titleLabel, getWidth()/2, getHeight()/2);
        Label instructionLabel = new Label("Press <space> to begin", 70);
        addObject(instructionLabel, getWidth()/2, 500);
 
    }
    

    public void act() 
    {
        //background music
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
            background.playLoop();
        }

    }
}
