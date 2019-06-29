package sounds;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

import java.io.InputStream;

public class BgSound implements Runnable {
    private Media m;
    public BgSound (String fileName) {
        try{
            InputStream is = Display.getInstance().getResourceAsStream(getClass(),"/" + fileName);
            m = MediaManager.createMedia(is,"audio/wav", this);
            m.play();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void pause() { m.pause(); }
    public void play() { m.play(); }
    @Override
    public void run(){
        m.setTime(0);
        m.play();
    }
}
