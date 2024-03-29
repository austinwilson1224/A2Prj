package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
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
        System.out.println("Quit button clicked");
        Boolean bOk = Dialog.show("Confirm quit","Are you sure you want to quit?", "Ok","Canel");
        if(bOk){
            Display.getInstance().exitApplication();
        }
    }
}
