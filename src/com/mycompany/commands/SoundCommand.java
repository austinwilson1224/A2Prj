package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import sounds.BgSound;

public class SoundCommand extends Command {

    private GameWorld gw;
    private BgSound bGSound;
    private boolean bPause = false;

    public SoundCommand(GameWorld gw){
        super("Sound Check box");
        this.gw = gw;
        bGSound = new BgSound("background.mp3");
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        bPause = !bPause;
        if(bPause){
            bGSound.pause();
        }else bGSound.play();
    }
}
