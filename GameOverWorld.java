import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        Label instructionLabel = new Label("Press <space> to play again", 70);
        addObject(instructionLabel, getWidth()/2, 500);
    }   
}
