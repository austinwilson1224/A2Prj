package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.IIterator;

public class NewCommand extends Command {

    private GameWorld gw;

    public NewCommand(GameWorld gw){
        super("New");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("New button clicked");
        if(gw.getPlayerShip() != null){
            gw.getCollection().remove(gw.getPlayerShip());
        }
        IIterator iterator = gw.getIterator();
        while(iterator.hasNext()) {
            gw.getCollection().clear();
        }

        gw.init();

    }
}
