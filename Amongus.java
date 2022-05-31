import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class amongus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class Amongus extends Actor
{
    
    public int vSpeed = 0;
    //gravitation constant
    public static int GRAVITY = 3; 
    
    GreenfootImage[] idle = new GreenfootImage[13]; 
    
    public Amongus()
    {
        for (int i = 0; i < 13; i++)
        {
            idle[i] = new GreenfootImage("images/amongus_walking/Walk000" + i + ".png");
            idle[i].scale(50, 60);
        }
        setImage(idle[0]);
    }
    
    int imageIndex = 0;
    public void animateAmongus()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    //use gravitational constant to simulate gravity
    public void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        vSpeed += GRAVITY;
    }
    
    /**
     * Act - do whatever the amongus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //allow for player input with wasd
        if(Greenfoot.isKeyDown("a"))
        {
            setRotation(0);
            move(-12);
        }   
        if (Greenfoot.isKeyDown("d"))
        {
            setRotation(0);
            move(12);
        }
        if (Greenfoot.isKeyDown("w"))
        {
            setRotation(270);
            move(12);
        }
        if (Greenfoot.isKeyDown("s"))
        {
            //rotate the amongus everytime it moves
            setRotation(90);
            move(12);
        }
        
        fall();
        //animate the amongus
        animateAmongus();
    }
}
