import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends ScrollingObjects
{
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public int numCoins = 4;
    GreenfootImage[] idle = new GreenfootImage[6]; 
    
    public Coin()
    {
        for (int i = 0; i < 6; i++)
        {
            idle[i] = new GreenfootImage("images/coin/tile00" + i + ".png");
            idle[i].scale(50, 60);
        }
        setImage(idle[0]);
    }
    
    public void coinCounter()
    {
        if (numCoins < 4)
        {
            ((MyWorld)getWorld()).spawnCoin();
            numCoins++;
        }        
    }
    
    int imageIndex = 0;
    public void animateCoin()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    public void act()
    {
        animateCoin();
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
        //makes num coin infinitely low; find a way to call the method only once/ remove the current object
        if (getX() <= 1)
        {
            world.removeObject(this);
            numCoins=3;
        }
        coinCounter();
        
    }
}
