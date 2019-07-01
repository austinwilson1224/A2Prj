package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class SteerableMissileLauncher extends MissileLauncher implements ISteerable{

	private int launcherDirection;
	public SteerableMissileLauncher() {

	    launcherDirection = super.getDirection();
	    this.setColor(ColorUtil.BLACK);
	}

    
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



}
