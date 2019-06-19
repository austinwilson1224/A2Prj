package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class QuitCommand extends Command {

    private GameWorld gw;

    public QuitCommand(GameWorld gw) {
        super("Quit*");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        //TODO
        gw.quit();

    }
}
