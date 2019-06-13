package com.mycompany.a2;

public class SteerableMissileLauncher extends MissileLauncher implements ISteerable{

	private int launcherDirection;
	
	public SteerableMissileLauncher() {
		launcherDirection = super.getDirection();
	}

   
    
    
    //getters
    public int getLauncherDirection() {
    	return this.launcherDirection;
    }
    
    //setter
    public void setLauncherDirection(int direction) {
    	this.launcherDirection = direction;
    }
    
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



}
