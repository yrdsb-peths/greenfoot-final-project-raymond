import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main actor in the video game, the character the player controls
 * 
 * @author: Raymond
 * @version: June 2022
 */



public class Amongus extends Actor
{
    public double vSpeed = 0;
    private int margins;
    //gravitation constant
    public double gravity = 2; 
    private double jumpHeight = -30;
    GreenfootImage[] idle = new GreenfootImage[13]; 
    static GreenfootSound Score = new GreenfootSound("10score.mp3");

    
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
        setLocation(getX(), (getY() + (int)vSpeed));
        vSpeed += gravity;
    }
    
    boolean onGround()
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Brick.class);
        return under != null;
    }
    
    //plays hype sound effect everytime score goes up by 10
    public void increaseDifficulty()
    {
        MyWorld world = (MyWorld) getWorld();
        if (world.getScore() % 5 == 0 && world.getScore() != 0)
        {
            Score.play();
            //make the character jump higher and fall faster
            gravity+=0.01;
            jumpHeight-=0.15;
        }
    }

    public void grabCoins()
    {
        if(isTouching(Coin.class))
        {
            removeTouching(Coin.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            ((MyWorld)getWorld()).spawnCoin();
        }
   
    }
    
    public void checkMoving()
    {
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
        grabCoins();
        //change world to gameOver if amongus touches the bottom.
        MyWorld world = (MyWorld)getWorld();
        if(getY() >= world.getHeight())
        {
            GameOverWorld overWorld = new GameOverWorld();
            Greenfoot.setWorld(overWorld);
    
        }
        increaseDifficulty();
    }
}
