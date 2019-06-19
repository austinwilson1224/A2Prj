package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class NewCommand extends Command {

    private GameWorld gw;

    public NewCommand(GameWorld gw){
        super("New");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        //TODO
    }
}
