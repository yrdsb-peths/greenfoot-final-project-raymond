import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brick extends Scroll
{
    /**
     * Act - do whatever the Brick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Brick()
    {
        getImage().scale(100,100);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            setRotation(0);
            move(8);
            ((MyWorld)getWorld()).shiftX(-1);
        }   
        if (Greenfoot.isKeyDown("d"))
        {
            setRotation(0);
            move(-8);
            ((MyWorld)getWorld()).shiftX(1);
        }
        if (getX()==0)
        {
            setLocation(getWorld().getWidth()-1, Greenfoot.getRandomNumber(getWorld().getHeight()/2 + 200));
        }
    }
}
