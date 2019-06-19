package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PSFireCommand extends Command {

    private GameWorld gw;

    public PSFireCommand(GameWorld gw){
        super("PS Fire");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        gw.fireMissilePS();
    }
}
