package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TurnMLLeftCommand extends Command {
    private GameWorld gw;

    public TurnMLLeftCommand(GameWorld gw){
        super("Turn missile launcher left");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        //TODO
        //gw.revolvePSML();
    }
}
