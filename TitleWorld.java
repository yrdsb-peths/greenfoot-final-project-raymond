import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Initial Title world 
 * @author (raymond) 
 * @version (june 2022)
 */
public class TitleWorld extends World
{

    Label titleLabel = new Label("Amongus", 100);     //title label
    //set background
    static GreenfootSound background = new GreenfootSound("amongus_background.mp3");
    
    public TitleWorld()
    {
        //TitleWorld constructor creates world and adds the labels required
        super(1280, 720, 1);
        addObject(titleLabel, getWidth()/2, getHeight()/2-150);
        Label startLabel = new Label("Press <space> to begin", 70);
        addObject(startLabel, getWidth()/2, 300);
        Label instructionLabel = new Label("Press <s> for instructions", 40);
        addObject(instructionLabel, getWidth()/2, 650);
 
    }
    

    /*
     * @space: Create new MyWorld to start the game
     * @s: Create new InstructionWorld to display instructions
     */
    public void act() 
    {
        //background music
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
            background.playLoop();
        }
        if(Greenfoot.isKeyDown("s"))
        {
            InstructionWorld instructions = new InstructionWorld();
            Greenfoot.setWorld(instructions);
        }

    }
}
