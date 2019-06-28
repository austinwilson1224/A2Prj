package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;
import com.codename1.ui.plaf.Border;

import java.util.Observable;
import java.util.Observer;

public class MapView extends Container implements Observer {
    private GameWorld gw;



    public MapView(GameWorld gw){
        this.gw = gw;
        this.getAllStyles().setBorder(Border.createLineBorder(30,ColorUtil.BLACK));
        this.getAllStyles().setBgColor(ColorUtil.BLACK);
        repaint();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Point2D parentsPosition = new Point2D(this.getX(),this.getY());
        IIterator iterator = gw.getIterator();
        while(iterator.hasNext()){
            GameObject object = (GameObject) iterator.getNext();
            object.draw(g,parentsPosition);

        }
    }

    @Override
    public void update(Observable o, Object arg){
        IGameWorld gw = (IGameWorld) o;
        IIterator iterator = gw.getIterator();
        while(iterator.hasNext()){
            repaint();
        }
    }
}
