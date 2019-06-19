package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PrintCommand extends Command {


    private GameWorld gw;

    public PrintCommand(GameWorld gw){
        super("Print command");
        this.gw = gw;
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        gw.print();
    }
}
