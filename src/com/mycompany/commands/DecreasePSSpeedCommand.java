package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class DecreasePSSpeedCommand extends Command {

    private GameWorld gw;

    public DecreasePSSpeedCommand(GameWorld gw){
        super("Decrease speed");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        gw.addSpaceStation();
    }
}
