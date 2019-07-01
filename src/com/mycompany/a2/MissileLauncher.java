package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class MissileLauncher extends MovableGameObject {
    private int missileCount;
    
    public MissileLauncher() {
        super();

        this.setColor(ColorUtil.BLACK);
    }

    @Override
    public void draw(Graphics graphics, Point2D point){

        int length = 25;
        int x = (int) (point.getX() + this.getX() );
        int y = (int) (point.getY() + this.getY() );
        double dX = length * Math.cos(Math.toRadians( 90 - getDirection()));
        double dY = length * Math.sin(Math.toRadians( 90 - getDirection()));
        graphics.setColor(this.getColor());
        graphics.drawLine(x, y, (int) (x + dX), (int)(y - dY));
    }

}
