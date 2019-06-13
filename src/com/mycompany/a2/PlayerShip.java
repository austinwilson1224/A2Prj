package com.mycompany.a2;

public class PlayerShip extends Ship implements ISteerable{
    private SteerableMissileLauncher launcher;



    /**
     * constructor
     * this will set the location to the center of the map
     * starting speed is zero
     * starting direction is north or 0 degrees
     * Player ships start with 10 missiles
     * the color for player ships will be green (0,225,0)
     * 
     * I will initialize the Steerable Missile Launcher (launcher) here so I can use it
     * and I will set the launcher direction to the same as the ships direction to start 
     */
    public PlayerShip(){
        //super();
        setLocation(512,384);
        setSpeed(0);
        setDirection(0);
        setMissileCount(10);
        setColor(0,225,0);
        launcher = new SteerableMissileLauncher();
        launcher.setDirection(this.getDirection());
        
    }

    public void reloadMissiles(){
        super.setMissileCount(10);
    }
    
    
    //getter
    public SteerableMissileLauncher getLauncher() {
    	return this.launcher;
    }

    public boolean fireMissiles() {
    	if(this.getMissileCount() > 0) {
    		decrementMissileCount();
    		System.out.println("PLAYER SHIP Missile Fired!\n" + super.getMissileCount() + " missiles left");
    		return true;
    	}
    	else {
    		System.out.println("PS out of missiles");
    		return false;
    	}
        
    }
    
    
    
    
    //interfaces and overwritten methods 
    
    @Override
    public void turnLeft() {
    	if(this.getDirection() == 0) {
    		this.setDirection(359);
    	}else this.setDirection(this.getDirection() + 1);
    }
    @Override
    public void turnRight() {
    	if(this.getDirection() == 359) {
    		this.setDirection(0);
    	}else this.setDirection(this.getDirection() - 1);
    }
    @Override
    public String toString(){
        return ("Player Ship: " + super.toString() +
                " missiles = " + getMissileCount() +
                " Missile Launcher dir = " + getLauncher().getDirection()
        );
    }
}
