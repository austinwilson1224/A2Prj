package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class Asteroid extends MovableGameObject {
    private int size;
    private final int SIZE_MIN = 6;
    private final int SIZE_MAX = 30;
    private final int MAX_SPEED = 15;

    public Asteroid(){
        //size  = random value between 6 and 30
        super();
        this.size = GameObject.R.nextInt(SIZE_MAX - SIZE_MIN + 1) + SIZE_MIN;
        super.setLocation(R.nextDouble() * GameWorld.WIDTH ,R.nextDouble() * GameWorld.HEIGHT);
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
}
