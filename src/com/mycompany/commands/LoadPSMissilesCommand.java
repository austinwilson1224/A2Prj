package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class LoadPSMissilesCommand extends Command {

    private GameWorld gw;

    public LoadPSMissilesCommand(GameWorld gw){
        super("Load PS*");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        gw.reloadPS();
    }
}
