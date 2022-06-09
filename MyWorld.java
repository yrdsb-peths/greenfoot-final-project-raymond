import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int xDirection;
    public int xOff;
    public int speed = 2;    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1540, 512, 1, false); 
        Amongus sus = new Amongus();
        Brick brick = new Brick();
        addObject(sus, getWidth()/2, 350);
        addObject(brick, getWidth()/2, 500);
        prepare();
    }
    
    public void shiftX(int xDirection)
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
        GreenfootImage bg = new GreenfootImage(getBackground());
        getBackground().drawImage(bg, (speed * xOff), 0);
        getBackground().drawImage(bg, (getWidth() * xOff * -1) + (speed * xOff), 0);
        
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
        Brick brick3 = new Brick();
        addObject(brick3,932,394);
        Brick brick4 = new Brick();
        addObject(brick4,328,200);
        brick.setLocation(622,398);

        Brick brick5 = new Brick();
        addObject(brick5,1176,405);
        Brick brick6 = new Brick();
        addObject(brick6,1480,364);
    }
}
