package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import sounds.BgSound;

public class SoundCommand extends Command {

    private GameWorld gw;
    private BgSound bGSound;
    private boolean bPause = false;

    //public void bPause(boolean bPause) { this.bPause = bPause; }

    public SoundCommand(GameWorld gw) {
        super("Sound Check box");
        this.gw = gw;
        if (gw.soundOn()) {
            bGSound = new BgSound("Rick-and-Morty-Theme-Song.mp3");
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        bPause = !bPause;
        System.out.println("Sound button clicked");
        if(bPause){
            bGSound.pause();
            gw.setSound(false);
        }else {
            bGSound.play();
            gw.setSound(true);
        }
    }
}
