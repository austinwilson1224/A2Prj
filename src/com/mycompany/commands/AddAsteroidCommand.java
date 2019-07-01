package com.mycompany.commands;

import com.codename1.ui.Command;
import com.mycompany.a2.GameWorld;
import com.codename1.ui.events.ActionEvent;

public class AddAsteroidCommand extends Command  {

    private GameWorld gw;

    public AddAsteroidCommand(GameWorld gw){
        super("+ Asteroid");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getKeyEvent() != -1)
            gw.loadNewAsteroid();
    }
}
