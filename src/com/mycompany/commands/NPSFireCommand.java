package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class NPSFireCommand extends Command {
    private GameWorld gw;

    public NPSFireCommand(GameWorld gw){
        super("NPS Fire*");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        gw.fireMissileNPS();
    }
}
