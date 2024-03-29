package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class JumpCommand extends Command {

    private GameWorld gw;

    public JumpCommand(GameWorld gw){
        super("Jump*");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getKeyEvent() != -1)
            gw.jump();
    }
}
