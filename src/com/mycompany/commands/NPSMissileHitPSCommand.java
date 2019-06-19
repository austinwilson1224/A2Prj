package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

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
