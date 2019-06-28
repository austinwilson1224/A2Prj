package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
/**
 * method associated with the 'x' command
 * two asteroids have collided into each other
 *
 *
 * first check that there are at least two asteroids in gameworld using asteroid count
 * then remove two asteroids
 *
 * finished
 */

public class AsteroidsCrashCommand extends Command {

    private GameWorld gw;

    public AsteroidsCrashCommand(GameWorld gw){
        super("Asteroid*(Asteroid)");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        gw.asteroidCrash();
    }
}
