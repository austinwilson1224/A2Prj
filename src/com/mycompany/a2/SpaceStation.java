package com.mycompany.a2;


/**
 * Austin Wilson & Elianna Sanchez
 */
public class SpaceStation extends FixedGameObject {
    //fields
    private int blinkRate;
    private boolean blinkerOn;
    private final int MINBLINKRATE = 0;
    private final int MAXBLINKRATE = 6;

    /**
     * constructor
     * this will set the blink rate to a random value between 0 and 6
     * the color will be white
     * also the station will spawn in the middle of the map by default 
     * because it was not specified
     */
    public SpaceStation(){
        this.blinkRate = GameObject.R.nextInt(MAXBLINKRATE - MINBLINKRATE );
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
}
