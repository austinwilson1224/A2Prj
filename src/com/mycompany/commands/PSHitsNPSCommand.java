package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

/**
 * method associated with 'h'
 * PS has crashed into an NPS
 * tell game world to remove the NPS (and the PS?) and decrement the number of lives
 *
 * finished
 */

public class PSHitsNPSCommand extends Command {

    private GameWorld gw;

    public PSHitsNPSCommand(GameWorld gw){
        super("PS (NPS)*");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        gw.crashNPS();
    }
}
