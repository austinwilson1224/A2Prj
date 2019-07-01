package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class SaveCommand extends Command {

    private GameWorld gw;

    public SaveCommand(GameWorld gw){
        super("Save");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Save button clicked");
    }
}
