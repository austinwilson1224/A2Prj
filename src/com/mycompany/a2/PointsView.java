package com.mycompany.a2;

import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.GridLayout;

import java.util.Observable;
import java.util.Observer;

/**
 * view
 * Austin Wilson & Elianna Sanchez
 */

public class PointsView extends Container implements Observer {


    private Label points, lives, missiles, score, time;
    private GameWorld gw;

    public PointsView(GameWorld gw) {

        //set layout to border layout
        this.setLayout(new GridLayout(1,5));
        this.gw = gw;


        //creating labels for the grid
        points = new Label("POINTS:"+ gw.getPlayerScore());
        lives = new Label("LIVES:" + gw.getNumberOfLives());
        missiles = new Label("MISSILES:" + gw.getNumMissiles());
        score = new Label("SCORE:" + gw.getPlayerScore());
        time = new Label("TIME:" + gw.getTimeElapsed());




        this.add(points);
        this.add(lives);
        this.add(missiles);
        this.add(score);
        this.add(time);




    }
    @Override
    public void update(Observable o, Object arg){
        //TODO
        //GameWorld gw = (GameWorld) o;
        //Iterator<GameWorld> i;
        points.setText("POINTS:" +  gw.getTimeElapsed());
        lives.setText("LIVES" + gw.getNumberOfLives());
        missiles.setText("MISSILES:" + gw.getNumMissiles());
        score.setText("SCORE:" + gw.getPlayerScore());
        time.setText("TIME:" + gw.getTimeElapsed());



    }
}
