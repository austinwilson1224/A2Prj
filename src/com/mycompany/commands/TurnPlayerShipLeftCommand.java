package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TurnPlayerShipLeftCommand extends Command {
    private GameWorld gw;

    public TurnPlayerShipLeftCommand(GameWorld gw){
        super("Turn player ship left");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        gw.turnPSLeft();
    }
}
