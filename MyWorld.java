import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main world class where the player plays the game.
 * 
 * @author: Raymond
 * @version: June 2022
 */
public class MyWorld extends World
{
    public int xDirection;
    public int xOff;
    public int speed = 1;    
    public int score = 0;
    Label scoreLabel;

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
        
        //create score label
        scoreLabel = new Label(0, 100);
        addObject(scoreLabel, 30, 30);
    }
    
    /** 
     * Method used to randomly spawn a coin at the edge of the screen
     */
    public void spawnCoin()
    {
        int y = Greenfoot.getRandomNumber(300) + 50;
        int x = 1540;
        Coin coin = new Coin();
        addObject(coin, x, y);
    }
    
    /**
     * Method that increases the score and changes the label to reflect the new score.
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }

    public int getScore()
    {
        return score;
    }
    
    /**
     * Shifts the background of the world, depending on the xDirection the Amongus actor is heading in
     * Replaces moving the actor with S and D by moving the background instead.
     */
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
        Coin coin = new Coin();
        addObject(coin,924,295);
        Coin coin2 = new Coin();
        addObject(coin2,159,335);
        brick.setLocation(617,359);
        Coin coin3 = new Coin();
        addObject(coin3,332,116);
        Coin coin4 = new Coin();
        addObject(coin4,635,322);
    }
}
