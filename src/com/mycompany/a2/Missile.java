package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;
/**
 * Austin Wilson & Elianna Sanchez
 */
public class Missile extends MovableGameObject {
    private int fuelLevel;


    public Missile(double missileSpeed, int missileDirection, Point2D missileLocation){
        super.setSpeed(missileSpeed);
        super.setDirection(missileDirection);
        super.setLocation(missileLocation.getX(),missileLocation.getY());
        fuelLevel = 15;
    }
    
    //setter
    public void setFuelLevel(int level) {
    	if(level < 0)
    		return;
    	else if(level + fuelLevel > 15)
    		return;
    	else fuelLevel = level;
    }
    
    //getter
    public int getFuelLevel() {
    	return this.fuelLevel;
    }


    public void decrementFuelLevel(){
    	if(this.fuelLevel > 0) {
    		fuelLevel--;
    
    	}
    }

    @Override
    public String toString(){
        return ("Missile: loc = " + Math.round(getX()) + "," + Math.round(getY()) +
                " color = " + getColor() +
                " speed = " + getSpeed() +
                " dir = " + getDirection()
        );
    }
}
