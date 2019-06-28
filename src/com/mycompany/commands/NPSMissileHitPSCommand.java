package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

/**
 * method associated with E
 *
 * this method will be synonymous with eliminateNPS
 * instead of NPS we will have a PlayerShip (PS)
 *
 * NPS's missile has struck and killed a PS
 *
 * finished
 */

public class NPSMissileHitPSCommand extends Command {

    private GameWorld gw;

    public NPSMissileHitPSCommand(GameWorld gw){
        super("NPS Missile (PS)*");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        gw.eliminatePS();
    }
}
