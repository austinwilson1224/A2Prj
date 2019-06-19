package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AboutCommand extends Command {

    private GameWorld gw;


    public AboutCommand(GameWorld gw) {
        super("About");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        //TODO
    }
}
