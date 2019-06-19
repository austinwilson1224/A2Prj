package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TurnMLRightCommand extends Command {

    private GameWorld gw;

    public TurnMLRightCommand(GameWorld gw) {
        super("Turn missile launcher right");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        //TODO
        //gw.revolvePSML();
    }
}
