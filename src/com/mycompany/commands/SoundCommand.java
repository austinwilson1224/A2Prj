package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class SoundCommand extends Command {

    private GameWorld gw;

    public SoundCommand(GameWorld gw){
        super("Sound Check box");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        //TODO
    }
}
