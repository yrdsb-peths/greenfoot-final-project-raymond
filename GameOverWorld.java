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
    Label gameOverLabel = new Label("Game Over", 100);
    public GameOverWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        addObject(gameOverLabel, getWidth()/2, getHeight()/2);
        Label instructionLabel = new Label("Press <s> to play again", 70);
        addObject(instructionLabel, getWidth()/2, 500);
        TitleWorld titleworld = new TitleWorld();
        titleworld.background.pause();
    }   
    
    
    public void playAgain()
    {
        if(Greenfoot.isKeyDown("s"))
        {
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
            TitleWorld titleworld = new TitleWorld();
            titleworld.background.playLoop();
        }
    }
    
    public void act()
    {
        playAgain();
    }
}
