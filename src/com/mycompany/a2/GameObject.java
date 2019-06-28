package com.mycompany.a2;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;
import com.codename1.charts.util.ColorUtil;



/**
 * Austin Wilson & Elianna Sanchez
 */

public abstract class GameObject implements IDrawable{
	
	public final static int MIN = 0;
    protected static final java.util.Random R = new java.util.Random(); //Random value used by child class
    private Point2D location;
    private int color;


    //constructor
    //initialize objects to the center of the world
    public GameObject(){
        location = new Point2D(GameWorld.WIDTH/2F,GameWorld.HEIGHT/2F);
    }

    //getters
    public Point2D getLocation(){
        return location;
    }
    public double getX(){
        return location.getX();
    }
    public double getY(){
        return location.getY();
    }
    public int getColor(){ return this.color; }

    //setters
    public void setLocation(double x, double y){
        location = new Point2D(x,y);
    }
    public void setColor(int r, int g, int b){
        this.color = ColorUtil.rgb(r,g,b);
    }
    public void setColor(int color) {
        this.color = color;
    }
    public void setX(double x){
        this.location.setX(x);
    }
    public void setY(double y){
        this.location.setY(y);
    }
    
    
    public String toString() {
    	String color = "[" + ColorUtil.red(this.color) + "," + 
    				ColorUtil.green(this.color) + "," + 
    				ColorUtil.blue(this.color) + "]";
    	double x = Math.round(this.location.getX());
    	double y = Math.round(this.location.getY());
    	return "loc = (" + x + "," + y + ") " + "Color = " +color;
    }

    @Override
    public void draw(Graphics graphics, Point2D point){
        int x = (int) (point.getX() + this.getX() );
        int y = (int) (point.getY() + this.getY() );
        graphics.setColor(this.getColor());
        graphics.fillArc(x,y,10,10,0,360);
        System.out.println("Drawing...");
    }

}
