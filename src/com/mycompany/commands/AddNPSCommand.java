package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddNPSCommand extends Command {
    private GameWorld gw;
    public AddNPSCommand(GameWorld gw){
        super("+ NPS");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {

        gw.addNonPlayerShip();
        System.out.println("Add player ship pressed!");
    }
}
