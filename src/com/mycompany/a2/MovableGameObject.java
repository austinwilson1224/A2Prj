package com.mycompany.a2;


/**
 * Movable Game Object
 *
 *
 *
 * Austin Wilson & Elianna Sanchez
 */
public abstract class MovableGameObject extends GameObject implements IMovable {
    private double speed;
    private int direction;
    public static final int MIN_SPEED = 0;
    public static final int MAX_SPEED = 20;
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
    		System.out.println("Speed increased by 1");
    	}
    }
    public void decreaseSpeed() {
    	if(this.speed > MIN_SPEED) {
    		this.speed--;
    		System.out.println("Speed decreased by 1");
    
    	}
    }
    
    
    public void setDirection(int direction){
    	if(direction > 359 || direction < 0) {
    		return;
    	}
        this.direction = direction;
    }

    
    
    @Override
    public void move(double time) {

        // to account for time elapsed
        time %= 10000;
        time %= 1000;
        //time %= 100;
    	
    	double x = this.getLocation().getX();
    	double y = this.getLocation().getY();
    	time /= 100;
    	x -= speed * time * Math.cos(Math.toRadians(90 + direction));
    	y -= speed * time * Math.sin(Math.toRadians(90 + direction));
    	this.setLocation( x, y);

    }
    @Override
    public String toString() {
    	return super.toString() + 
    			" Speed = " + speed + 
    			" dir = " + direction;
    }




}
