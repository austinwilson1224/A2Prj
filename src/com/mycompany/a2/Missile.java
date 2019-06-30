package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;
/**
 * Austin Wilson & Elianna Sanchez
 */
public class Missile extends MovableGameObject {
    private int fuelLevel;
    private boolean isPlayer;


    public Missile(double missileSpeed, int missileDirection, Point2D missileLocation, boolean isPlayer){
        setSpeed(missileSpeed);
        setDirection(missileDirection);
        setLocation(missileLocation.getX(),missileLocation.getY());
        fuelLevel = 15;
        this.isPlayer = isPlayer;
    }
    //getter
    public int getFuelLevel() {
    	return this.fuelLevel;
    }
    public boolean isPlayer() { return isPlayer; }


    public void decrementFuelLevel(){
    	if(this.fuelLevel > 0)
    		fuelLevel--;
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
