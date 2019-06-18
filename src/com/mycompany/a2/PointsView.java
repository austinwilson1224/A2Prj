package com.mycompany.a2;

import com.codename1.ui.Container;
import com.codename1.ui.layouts.*;
import com.codename1.ui.Label;

import java.util.Observable;
import java.util.Observer;

public class PointsView extends Container implements Observer {


    public PointsView(){

        //set layout to border layout
        this.setLayout(new BorderLayout());
        Label points = new Label("POINTS");
        this.add(BorderLayout.NORTH,points);





    }
    @Override
    public void update(Observable o, Object arg){
        //TODO

    }
}
