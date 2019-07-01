package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

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
    @Override
    public void draw(Graphics graphics, Point2D point){

	    int length = 100;
        int x = (int) (point.getX() + this.getX() );
        int y = (int) (point.getY() + this.getY() );
        double dX = length * Math.cos(Math.toRadians( 90 - getDirection()));
        double dY = length * Math.sin(Math.toRadians( 90 - getDirection()));
        graphics.setColor(ColorUtil.BLACK);
        graphics.drawLine(x, y, (int) (x + dX), (int)(y + dY));
        //graphics.fillArc(x,y,100,100,0,360);
    }


}
