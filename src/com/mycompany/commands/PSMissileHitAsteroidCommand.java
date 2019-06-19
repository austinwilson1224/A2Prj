package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PSMissileHitAsteroidCommand extends Command {

    private GameWorld gw;

    public PSMissileHitAsteroidCommand(GameWorld gw){
        super("PS Missile*(Asteroid)");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        gw.killAsteroid();
    }
}
