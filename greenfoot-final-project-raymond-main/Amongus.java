import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class amongus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class Amongus extends Actor
{
    private int STEP;
    public int vSpeed = 0;
    private int margins;
    //gravitation constant
    public static int GRAVITY = 2; 
    private int jumpHeight = -30;
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
    
    boolean onGround()
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Brick.class);
        return under != null;
    }
    
    public void checkMoving()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            setRotation(0);
            move(-8);
            animateAmongus();
           // Scroll.shiftX(1);
        }   
        if (Greenfoot.isKeyDown("d"))
        {
            setRotation(0);
            move(8);
            animateAmongus();
           // Scroll.shiftX(-1);
        }
        if (Greenfoot.isKeyDown("space") && (onGround()==true))
        {
            vSpeed = jumpHeight;
            fall();
        }
 
    }
    
    public void checkFalling()
    {
        if (onGround() == false)
        {
            fall();
        }
        if (onGround() == true)
        {
            vSpeed = 0;
        }
    }
    

    
    
    /**
     * Act - do whatever the amongus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //allow for player input with wasd
        checkMoving();
        //check if it is on brick, if not, let it fall
        checkFalling();
    }
}
