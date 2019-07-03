package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class Asteroid extends MovableGameObject {
    private int size;
    private final int SIZE_MIN = 6;
    private final int SIZE_MAX = 30;
    private final int MAX_SPEED = 15;

    public Asteroid(){
        //size  = random value between 6 and 30
        super();
        this.size = GameObject.R.nextInt(SIZE_MAX - SIZE_MIN + 1) + SIZE_MIN;
        super.setLocation(R.nextDouble() * Game.getWIDTH() ,R.nextDouble() * Game.getHEIGHT());
        //super.setColor(0,0,0);
        this.setColor(ColorUtil.BLUE);
    }

    @Override
    public String toString(){
        return ("Asteroid: " +
                super.toString() +
                " size = " + size
        );
    }

    @Override
    public void draw(Graphics graphics, Point2D point){
        int x = (int) (point.getX() + this.getX() );
        int y = (int) (point.getY() + this.getY() );
        graphics.setColor(ColorUtil.rgb(0,150,150));
        graphics.fillArc(x,y,size,size,0,360);
    }

}
