package com.mycompany.a2;


/**
 * Movable Game Object
 *
 *
 *
 * Austin Wilson & Elianna Sanchez
 */
public abstract class MovableGameObject extends GameObject implements Imovable {
    private double speed;
    private int direction;
    private final int MIN_SPEED = 0;
    private final int MAX_SPEED = 20;
    private final int MIN_DIRECTION = 0;
    private final int MAX_DIRECTION = 359;


    public MovableGameObject(){
        this.speed = R.nextInt(MAX_SPEED - MIN_SPEED + 1) + MIN_SPEED;
        this.direction = R.nextInt(MAX_DIRECTION - MIN_DIRECTION + 1) + MIN_DIRECTION;
    }


    public double getSpeed(){
        return this.speed;
    }
    public int getDirection(){
        return this.direction;
    }


    public void setSpeed(double speed){
        this.speed = speed;
    }
    public void increaseSpeed() {
    	if(this.speed < MAX_SPEED) {
    		this.speed++;
    	}
    }
    public void decreaseSpeed() {
    	if(this.speed > MIN_SPEED) {
    		this.speed--;
    
    	}
    }
    
    
    public void setDirection(int direction){
    	if(direction > 359 || direction < 0) {
    		return;
    	}
        this.direction = direction;
    }

    
    
    @Override
    public void move() {
    	
    	//to convert degrees to radians 
    	double conversion = Math.PI / 180;
    	
    	
    	double x = this.getLocation().getX();
    	double y = this.getLocation().getY();
    	
    	
    	
    	
    	System.out.println("\nPrevious location: " + x + "," + y + "\n");
    	
    	
    	
    	y -= (this.getSpeed() * Math.cos( conversion * (double)this.getDirection()));
    	
    	
    	
    	
    	x += (this.getSpeed() * Math.sin( conversion * (double)this.getDirection()));
    	this.setLocation(x, y);
    	System.out.println("\nNew location: " + x + "," + y + "\n");
    }
    @Override
    public String toString() {
    	return super.toString() + 
    			" Speed = " + speed + 
    			" dir = " + direction;
    }


}
