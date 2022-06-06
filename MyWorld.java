import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        Amongus sus = new Amongus();
        Brick brick = new Brick();
        addObject(sus, getWidth()/2, 350);
        addObject(brick, getWidth()/2, 500);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Brick brick = new Brick();
        addObject(brick,717,444);
        Brick brick2 = new Brick();
        addObject(brick2,173,424);
    }
}
