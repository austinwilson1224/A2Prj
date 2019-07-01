package com.mycompany.a2;


import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

/**
 * Austin Wilson & Elianna Sanchez
 */
public class SpaceStation extends FixedGameObject {
    //fields
    private int blinkRate;
    private boolean blinkerOn;
    private final int MAXBLINKRATE = 6;

    /**
     * constructor
     * this will set the blink rate to a random value between 0 and 6
     * the color will be white
     * also the station will spawn in the middle of the map by default 
     * because it was not specified
     */
    public SpaceStation(){
        double w = R.nextDouble(), h = R.nextDouble();
        setLocation(Game.getWIDTH() * w, Game.getHEIGHT() * h);
        this.blinkRate = GameObject.R.nextInt( MAXBLINKRATE ) + 1;
        this.blinkerOn = true;
        super.setColor(225, 225, 225); //white
    }
    
    //setter
    public void toggleBlinker() {
    	if(this.blinkerOn) {
    		this.blinkerOn = false;
    	}else this.blinkerOn = true;
    }

    //methods
    public int getBlinkRate(){
        return this.blinkRate;
    }
    public boolean isOn(){
        return blinkerOn;
    }

    @Override
    public String toString(){
        if(blinkerOn) {
            return ("Station: " + super.toString() +
                    " rate = " + blinkRate
            );
        }
        return ("Station: " + super.toString() +
                " rate = " + blinkRate
        );
    }

    @Override
    public void draw(Graphics graphics, Point2D point){
        int x = (int) (point.getX() + this.getX() );
        int y = (int) (point.getY() + this.getY() );
        graphics.setColor(this.getColor());
        graphics.drawRect(x,y,100,100,5);
        if(blinkerOn)
            graphics.fillRect(x,y,100,100);
    }

}
