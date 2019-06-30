package com.mycompany.a2;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class SteerableMissileLauncher extends MissileLauncher implements ISteerable{

	private int launcherDirection;
	//private Sound rotate; // = new Sound ("rotate.wav");
	public SteerableMissileLauncher() {
		launcherDirection = super.getDirection();
	}
	//public Sound getLauncherSound() { return new Sound ("rotate.wav"); }




    //getters
    //public Sound getSound() { return this.rotate; }
    //public int getLauncherDirection() {return this.launcherDirection;}
    //public void setLauncherDirection(int direction) {this.launcherDirection = direction;}
    
    @Override
    public void turnLeft() {
    	if(this.getDirection() == 0) {
    		this.setDirection(359);
    	}else this.setDirection(this.getDirection() + 1);
    	//rotate = new Sound("rotate.wav");
        //rotate.play();
    }
    @Override
    public void turnRight() {
    	if(this.getDirection() == 359) {
    		this.setDirection(0);
    	}else this.setDirection(this.getDirection() - 1);
        //rotate = new Sound("rotate.wav");
        //rotate.play();
    }
    @Override
    public void draw(Graphics graphics, Point2D point){
        int x = (int) (point.getX() + this.getX() );
        int y = (int) (point.getY() + this.getY() );
        graphics.setColor(this.getColor());
        graphics.drawRect(x,y,60,60,5);
        graphics.fillRect(x,y,20,20);
        //System.out.println("Drawing...");
    }



}
