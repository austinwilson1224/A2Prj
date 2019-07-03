package com.mycompany.a2;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class NonPlayerShip extends Ship {
    private MissileLauncher missileLauncher;
    private int size;

    
    public NonPlayerShip(){
    	//NPS starts with 4 missiles and is red
        super.setMissileCount(4);
        super.setColor(225, 0, 0);
        super.setLocation(R.nextDouble() * Game.getWIDTH(), R.nextDouble() * Game.getHEIGHT());
        //randomly setting the size to large or small using random number 0-1
        int small = 15, large = 25, rand = R.nextInt(2);
        if(rand == 0) {
        	this.size = small;
        }else this.size = large;
        missileLauncher = new MissileLauncher();
        missileLauncher.setDirection(this.getDirection());
    }
    
    
    
    /**
     * this method is a boolean so we can check if there are any missiles available to fire
     * if there aren't any missiles in the ship then it will return false 
     * when this method returns false, the command L in game world will not add a new missile to the world
     * @return
     */
    public boolean fireMissiles(){
    	if(super.getMissileCount() > 0) {
    		decrementMissileCount();
    		System.out.println("NON PLAYER SHIP missile fired!\n" + super.getMissileCount() + " missiles left");
    		return true;
    	}else {
    		System.out.println("NPS out of missiles");
    		return false;
    	}
    }
    
    //missile count comes from Ship
    @Override
    public String toString(){
        return ("NPS: " + 
        		super.toString() +
        		" size = " + size +
                " missile = " + getMissileCount() + 
                " missile launcher direction = " + missileLauncher.getDirection()
        );
    }

    @Override
    public void draw(Graphics graphics, Point2D point){
        int x = (int) (point.getX() + this.getX() );
        int y = (int) (point.getY() + this.getY() );
        graphics.setColor(this.getColor());
        graphics.fillArc(x,y,size,size,0,360);
    }

}
