package com.mycompany.a2;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

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
        setLocation(Game.getWIDTH() / 2,Game.getHEIGHT() / 2 );
        setSpeed(0);
        setDirection(0);
        setMissileCount(10);
        setColor(0,225,0);
        setSize(50);
        launcher = new SteerableMissileLauncher();
        launcher.setDirection(this.getDirection());
        
    }
    //getter
    public SteerableMissileLauncher getLauncher() {
    	return this.launcher;
    }

    @Override
    public void move(double time) {
        super.move(time);

        this.getLauncher().setLocation(this.getX(), this.getY());
    }

    @Override
    public void turnLeft() {
    	if(this.getDirection() == 0) {
    		this.setDirection(350);
    	}else this.setDirection(this.getDirection() - 10);
    }
    @Override
    public void turnRight() {
    	if(this.getDirection() == 350) {
    		this.setDirection(0);
    	}else this.setDirection(this.getDirection() + 10);
    }
    @Override
    public String toString(){
        return ("Player Ship: " + super.toString() +
                " missiles = " + getMissileCount() +
                " Missile Launcher dir = " + getLauncher().getDirection()
        );
    }
    @Override
    public void draw(Graphics graphics, Point2D point){
        int x = (int) (point.getX() + this.getX() );
        int y = (int) (point.getY() + this.getY() );
        graphics.setColor(this.getColor());

        int [] polyGonX = new int[] { x - getSize() / 2, x - getSize() / 2, x + getSize() / 2, x + getSize() / 2};

        int [] polyGonY = new int[] { y + getSize() / 2, y - getSize() / 2,  y + getSize() / 2, y - getSize() / 2};

        graphics.drawPolygon(polyGonX, polyGonY, 4);
        graphics.fillPolygon(polyGonX, polyGonY, 4);
        //graphics.drawRect(x - getSize() / 2, y - getSize() / 2, getSize(),getSize(),5);
        this.getLauncher().draw(graphics,point);
    }

}
