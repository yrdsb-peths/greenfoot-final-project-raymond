import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scroll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Scroll extends Actor
{
    public int speed, xOff, xDirection;
    //direction marker for where to scroll
    public void shiftX(int X)
    {
        this.xDirection = xDirection;
        if (this.xDirection <0)
        {
            xOff = 1;
        }
        if (this.xDirection > 0)
        {
            xOff = -1;
        }
        GreenfootImage bg = new GreenfootImage(getImage());
        getImage().drawImage(bg, (speed * xOff), 0);
        getImage().drawImage(bg, (getWorld().getWidth() * xOff * -1) + (speed * xOff), 0);
        
    }
     
    /**
     * Act - do whatever the Scroll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    

}
