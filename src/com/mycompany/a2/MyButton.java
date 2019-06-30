package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;

public class MyButton extends Button {

    public MyButton(String text){
        super(text);
        this.getAllStyles().setBgColor( ColorUtil.rgb(100,100,100));
        this.getAllStyles().setBgTransparency(225);
        this.getAllStyles().setFgColor(ColorUtil.rgb(225,225,225));
        //this.getAllStyles().setBgColor(0);
        this.getAllStyles().setPadding(TOP,5);
        this.getAllStyles().setPadding(BOTTOM, 5);
    }
}
