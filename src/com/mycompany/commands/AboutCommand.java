package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
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
        System.out.println("About button clicked");
        Boolean about = Dialog.show("About","this is my asteroids game","ok","canel");
    }
}
