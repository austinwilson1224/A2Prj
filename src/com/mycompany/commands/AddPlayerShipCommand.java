package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddPlayerShipCommand extends Command {

    private GameWorld gw;

    public AddPlayerShipCommand(GameWorld gw){
        super("+ PS");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getKeyEvent() != -1)
            gw.addPlayerShip();
    }
}
