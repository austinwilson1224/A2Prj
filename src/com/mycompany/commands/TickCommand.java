package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TickCommand extends Command {

    private GameWorld gw;

    public TickCommand(GameWorld gw){
        super("Tick*");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        gw.tick();
    }
}