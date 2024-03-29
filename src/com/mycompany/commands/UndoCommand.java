package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class UndoCommand extends Command {

    private GameWorld gw;

    public UndoCommand(GameWorld gw){
        super("Undo");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Undo button clicked");
    }
}
