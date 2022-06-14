import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instructions for the game.
 * 
 * @Raymond 
 * @June 2022
 */
public class InstructionWorld extends World
{

    /**
     * Constructor for objects of class InstructionWorld.
     * 
     */
    public InstructionWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
    }
    
    /*
     * Checks if user presses <r>
     * @r: Create new Title world 
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("r"))
        {
            TitleWorld world = new TitleWorld();
            Greenfoot.setWorld(world);
        }
    }
}
