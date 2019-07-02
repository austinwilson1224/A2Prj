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


    private Label points, lives, missiles,  time, sound;
    String soundOn;
    private IGameWorld gw;

    public PointsView(GameWorld gw) {

        //set layout to border layout
        this.setLayout(new GridLayout(1,5));
        this.gw = gw;


        //creating labels for the grid
        points = new Label("POINTS:"+ gw.getPlayerScore());
        lives = new Label("LIVES:" + gw.getNumberOfLives());
        missiles = new Label("MISSILES:" + gw.getNumMissiles());
        time = new Label("TIME:" + gw.getTimeElapsed());
        if(gw.soundOn()){
            soundOn = "ON";
        }else soundOn = "OFF";
        sound = new Label("SOUND:" );




        this.add(points);
        this.add(lives);
        this.add(missiles);
        this.add(time);
        this.add(sound);




    }
    @Override
    public void update(Observable o, Object arg){

        //use arg here for full points on proxy
        //IGameWorld gw = (IGameWorld) o;
        gw = (IGameWorld) o;
        //Iterator<GameWorld> i;
        points.setText("POINTS: " +  gw.getPlayerScore());
        lives.setText("LIVES: " + gw.getNumberOfLives());
        missiles.setText("MISSILES: " + gw.getNumMissiles());
        time.setText("TIME: " + gw.getTimeElapsed() / 10);
        if(gw.soundOn()){
            sound.setText("SOUND:ON");
        }else sound.setText("SOUND:OFF");



    }
}
