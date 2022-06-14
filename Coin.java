import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Coin class used to increase the score for the player
 * 
 * @author: Raymond
 * @version: June 2022
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
    
    /*
     * Increases the variable numCoins everytime a coin is spawned
     */
    public void createCoin()
    {
        ((MyWorld)getWorld()).spawnCoin();
        numCoins++;   
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
        //scrolls the coins
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
        //Replaces coins that are out of bounds
        if (getX() <= 1)
        {
            createCoin();
            world.removeObject(this);
            numCoins--;
        }
        
    }
}
