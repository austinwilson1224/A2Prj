package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;
import com.codename1.ui.plaf.Border;

import java.util.Observable;
import java.util.Observer;

public class MapView extends Container implements Observer {
    private IGameWorld gw;



    public MapView(){
        this.getAllStyles().setBorder(Border.createLineBorder(5,ColorUtil.BLACK));
        this.getAllStyles().setBgColor(ColorUtil.BLACK);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        if(this.gw == null) return;

        Point2D parentsPosition = new Point2D(this.getX(),this.getY());
        IIterator iterator = gw.getIterator();
        while(iterator.hasNext()){
            GameObject object = (GameObject) iterator.getNext();
            object.draw(g,parentsPosition);

        }
    }

    @Override
    public void update(Observable o, Object arg){
        //use arg here for full points on proxy
        //IGameWorld gw = (IGameWorld) arg;
        this.gw = (IGameWorld) o;
        this.repaint();
//        IIterator iterator = gw.getIterator();
//        while(iterator.hasNext()){
//            repaint();
//            GameObject go = (GameObject) iterator.getNext();
//            if(go instanceof IDrawable){
//                //go.draw(o, new Point2D(this.getX(),this.getY()));
//            }
//        }
    }
}
