package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

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
