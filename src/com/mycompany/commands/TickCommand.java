package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

/**
 * user input 't'
 *
 * tell the game world the the "game clock" has ticked so increment timeElapsed by 1
 * 1. all movable objects are told to update their positions
 * 2. every missile's fuel level is reduced by one and
 * 	any missiles which are now out of fuel are removed from the game
 * 3. each space stations toggles its blinking light if the tick count modulo
 * 	the stations blink rate is zero
 * 4. the "elapsed game time" is incremented by one
 *
 * will traverse all the objects and execute all of these cases
 */

public class TickCommand extends Command {

    private GameWorld gw;

    public TickCommand(GameWorld gw){
        super("Tick*");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        gw.tick();
    }
}
