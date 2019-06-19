package com.mycompany.a2;

import com.codename1.ui.Container;
import com.codename1.ui.layouts.*;
import com.codename1.ui.Label;

import java.util.Observable;
import java.util.Observer;

public class PointsView extends Container implements Observer {




    public PointsView(GameWorld gw) {

        //set layout to border layout
        this.setLayout(new GridLayout(1,5));

        Label points = new Label("POINTS:"+ gw.getPlayerScore());
        Label lives = new Label("LIVES:" + gw.getNumberOfLives());
        Label missiles = new Label("MISSILES:" + gw.getNumMissiles());
        Label score = new Label("SCORE:" + gw.getPlayerScore());
        Label time = new Label("TIME:" + gw.getTimeElapsed());
        this.add(points);
        this.add(lives);
        this.add(missiles);
        this.add(score);
        this.add(time);




    }
    @Override
    public void update(Observable o, Object arg){
        //TODO

    }
}
