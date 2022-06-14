import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Gameover world after player loses.
 * 
 * @author: Raymond
 * @version: June 2022
 */
public class GameOverWorld extends World
{

    /**
     * Constructor for objects of class GameOverWorld.
     * 
     */
    public GameOverWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        Label instructionLabel = new Label("Press <s> to play again", 80);
        addObject(instructionLabel, getWidth()/2, getHeight()/2+30);
        TitleWorld titleworld = new TitleWorld();
        titleworld.background.pause();
    }   
    
    /*
     * Allows player to play again
     * @s: Create new MyWorld 
     */
    public void playAgain()
    {
        if(Greenfoot.isKeyDown("s"))
        {
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
    
    public void act()
    {
        playAgain();
    }
}
