package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

/**
 * method associated with 'c'
 * playerShip has crashed into an asteroid
 * in this case remove the ship and the asteroid from the world
 * don't worry about which asteroid for now...
 *
 * if there are more lives left decrement lives
 * and add a new playerShip into the world...?
 *
 */

public class PSHitsAsteroidCommand extends Command {

    private GameWorld gw;

    public PSHitsAsteroidCommand(GameWorld gw){
        super("PS (Asteroid)*");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        gw.crashAsteroid();
    }
}
