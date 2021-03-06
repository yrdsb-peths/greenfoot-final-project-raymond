import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Short brick platform class for player to jump onto.
 * 
 * @author: Raymond
 * @version: June 2022
 */
public class Brick extends ScrollingObjects
{
    /**
     * Act - do whatever the Brick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public Brick()
    {
        getImage().scale(100,100);
    }
    
    /*
     * Scrolls through the world when the user presses A and D
     * Removes Bricks that are out of bounds
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            setRotation(0);
            move(10);
            ((MyWorld)getWorld()).shiftX(-1);
        }   
        if (Greenfoot.isKeyDown("d"))
        {
            setRotation(0);
            move(-10);
            ((MyWorld)getWorld()).shiftX(1);
        }
        MyWorld world = (MyWorld)getWorld();
        if (getX() <= 1)
        {
            randomLocation = Greenfoot.getRandomNumber(150) + 350;
            setLocation(getWorld().getWidth()-1, randomLocation);
        }
    }
}
