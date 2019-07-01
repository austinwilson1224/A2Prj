package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddSpaceStationCommand extends Command {
    private GameWorld gw;

    public AddSpaceStationCommand(GameWorld gw){
        super("+ Space Station");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getKeyEvent() != -1)
            gw.addSpaceStation();
    }
}
