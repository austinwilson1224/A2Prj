package com.mycompany.a2;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.UITimer;
import com.mycompany.commands.*;


/**
 * This is the Game class which is the primary class that encapsulates the whole game
 *
 * controller
 *
 * Austin Wilson & Elianna Sanchez
 */

public class Game extends Form implements Runnable {

    //fields
    private GameWorld gw;
    private MapView mv;
    private PointsView pv;


    private static int HEIGHT;
    private static int WIDTH;
    public static final int TICK_RATE = 20;


    public static int getHEIGHT() { return Game.HEIGHT; }
    public static int getWIDTH() { return Game.WIDTH; }
    public static int getTickRate() { return TICK_RATE;}



    //methods
    //constructor
    public Game(){


        gw = new GameWorld();
        gw.init();
        mv = new MapView();
        pv = new PointsView(gw);
        gw.addObserver(mv);
        gw.addObserver(pv);
        this.show();
        playA2();
    }

    public void playA2() {



        this.setLayout(new BorderLayout());




        //toolbar
        Toolbar toolbar = new Toolbar();
        setToolbar(toolbar);
        toolbar.setTitle("ASTEROIDS");


        //commands
        AboutCommand about = new AboutCommand(gw);
        NewCommand New = new NewCommand(gw);
        UndoCommand undo = new UndoCommand(gw);
        SaveCommand save = new SaveCommand(gw);
        QuitCommand quit = new QuitCommand(gw);



        toolbar.addCommandToLeftSideMenu(about);
        toolbar.addCommandToLeftSideMenu(New);
        toolbar.addCommandToLeftSideMenu(undo);
        toolbar.addCommandToLeftSideMenu(save);
        toolbar.addCommandToLeftSideMenu(quit);



        //Points View is held in the top container
        Container topContainer = new Container();
        //topContainer.getAllStyles().setBorder(Border.createLineBorder(5));
        topContainer.add(pv);
        this.add(BorderLayout.NORTH,topContainer);
        //commands in left container
        Container leftContainer = new Container();
        //kleftContainer.getAllStyles().setBorder(Border.createLineBorder(5));
        leftContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        leftContainer.getAllStyles().setAlignment(LEFT);




        //buttons to add
        MyButton addAsteroid = new MyButton("+Asteroid");
        MyButton addNPS = new MyButton("+NPS");
        MyButton addStation = new MyButton("+Station");
        MyButton addPlayerShip = new MyButton("+PlayerShip");
        MyButton firePS = new MyButton("Fire PS");
        MyButton jumpPS = new MyButton("Jump PS");



        //initiaizing commands
        AddAsteroidCommand addAsteroidCommand = new AddAsteroidCommand(gw);
        AddNPSCommand addNPSCommand = new AddNPSCommand(gw);
        AddPlayerShipCommand addPlayerShipCommand = new AddPlayerShipCommand(gw);
        AddSpaceStationCommand addSpaceStationCommand = new AddSpaceStationCommand(gw);
        AsteroidHitsNPSCommand asteroidHitsNPSCommand = new AsteroidHitsNPSCommand(gw);
        AsteroidsCrashCommand asteroidsCrashCommand = new AsteroidsCrashCommand(gw);
        DecreasePSSpeedCommand decreasePSSpeedCommand = new DecreasePSSpeedCommand(gw);
        IncreasePSSpeedCommand increasePSSpeedCommand = new IncreasePSSpeedCommand(gw);
        JumpCommand jumpCommand = new JumpCommand(gw);
        LoadPSMissilesCommand loadPSMissilesCommand = new LoadPSMissilesCommand(gw);
        NPSFireCommand npsFireCommand = new NPSFireCommand(gw);
        NPSMissileHitPSCommand npsMissileHitPSCommand = new NPSMissileHitPSCommand(gw);
        PSFireCommand psFireCommand = new PSFireCommand(gw);
        PSHitsAsteroidCommand psHitsAsteroidCommand = new PSHitsAsteroidCommand(gw);
        PSHitsNPSCommand psHitsNPSCommand = new PSHitsNPSCommand(gw);
        PSMissileHitAsteroidCommand psMissileHitAsteroidCommand = new PSMissileHitAsteroidCommand(gw);
        PSMissileHitNPSCommand psMissileHitNPSCommand = new PSMissileHitNPSCommand(gw);
        QuitCommand quitCommand = new QuitCommand(gw);
        TickCommand tickCommand = new TickCommand(gw);
        TurnMLLeftCommand turnMLLeftCommand = new TurnMLLeftCommand(gw);
        TurnMLRightCommand turnMLRightCommand = new TurnMLRightCommand(gw);
        TurnPlayerShipRightCommand turnPlayerShipRightCommand = new TurnPlayerShipRightCommand(gw);
        TurnPlayerShipLeftCommand turnPlayerShipLeftCommand = new TurnPlayerShipLeftCommand(gw);

        //other comands
        PrintCommand printCommand = new PrintCommand(gw);
        MapCommand mapCommand = new MapCommand(gw);



        //command key binding

        //a = add asteroid
        this.addKeyListener('a',addAsteroidCommand);
        //s = add player ship
        this.addKeyListener('s',addPlayerShipCommand);
        //y = add NPS
        this.addKeyListener('y',addNPSCommand);
        //b  = add space station
        this.addKeyListener('b',addSpaceStationCommand);




        //i = increase PS speed right arrow
        this.addKeyListener( -91,increasePSSpeedCommand);
        //d = decrease PS speed
        this.addKeyListener(-92,decreasePSSpeedCommand);


        //steering player ship
        //l = steer player sip left
        this.addKeyListener(-93,turnPlayerShipLeftCommand);
        //r = turn player ship right
        this.addKeyListener(-94,turnPlayerShipRightCommand);


        //rotate player ship missile launcher
        //> = 62
        this.addKeyListener('>',turnMLRightCommand);
        // < rotate PSML ccw
        this.addKeyListener('<',turnMLLeftCommand);



        //f = fire missile out of player ship
        this.addKeyListener(-90,psFireCommand);
        //L = launch missile out of NPS
        this.addKeyListener('L',npsFireCommand);


        //j = jump to hyperspace
        this.addKeyListener('j',jumpCommand);

        //n = reload
        this.addKeyListener('n',loadPSMissilesCommand);

        //k = PS missile has struck and killed an asteroid
        this.addKeyListener('k',psMissileHitAsteroidCommand);

        //e = PS missile struck and killed NPS
        this.addKeyListener('e',psHitsNPSCommand);

        //E = NPS missile struck and killed PS
        this.addKeyListener('E',npsMissileHitPSCommand);

        //c = PS crashed into an asteroid
        this.addKeyListener('c',psHitsAsteroidCommand);

        //h = PS hit and NPS
        this.addKeyListener('h',psHitsNPSCommand);

        //x = two asteroids have collided
        this.addKeyListener('x',asteroidsCrashCommand);

        //I = 73 NPS hit asteroid
        this.addKeyListener('I', asteroidHitsNPSCommand);

        //t = tick
        this.addKeyListener('t',tickCommand);

        //p = print
        this.addKeyListener('p',printCommand);

        //m = print a map
        this.addKeyListener('m',mapCommand);

        //q = quit
        this.addKeyListener('q',quitCommand);


        //associating the command with correct buttons
        addAsteroid.setCommand(addAsteroidCommand);
        addNPS.setCommand(addNPSCommand);
        addStation.setCommand(addSpaceStationCommand);
        addPlayerShip.setCommand(addPlayerShipCommand);
        firePS.setCommand(psFireCommand);
        jumpPS.setCommand(jumpCommand);



        //left container
        leftContainer.add(addAsteroid);
        leftContainer.add(addNPS);
        leftContainer.add(addStation);
        leftContainer.add(addPlayerShip);
        leftContainer.add(firePS);
        leftContainer.add(jumpPS);
        leftContainer.getAllStyles().setAlignment(LEFT);
        this.add(BorderLayout.WEST,leftContainer);


        //MapView
        this.add(BorderLayout.CENTER,mv);
        //UITimer.timer(100, true, this);
        UITimer t = new UITimer(this);
        t.schedule(TICK_RATE,true,this);


        //sound
        SoundCommand soundCommand = new SoundCommand(gw);
        CheckBox sound = new CheckBox("Sound");
        sound.setSelected(true);
        sound.setCommand(soundCommand);
        toolbar.addComponentToLeftSideMenu(sound);
        sound.getAllStyles().setBgTransparency(255);

        this.show();

        Game.WIDTH = mv.getWidth();
        Game.HEIGHT = mv.getHeight();
    }
    public void playA1(){
        //code later
        Label myLabel = new Label("Enter a command:");
        this.addComponent(myLabel);
        final TextField myTextField = new TextField();
        this.addComponent(myTextField);
        this.show();
        myTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String sCommand =  myTextField.getText();
                myTextField.clear();
                switch (sCommand.charAt(0)){


                    /*
                    //make a new asteroid...
                    case 'a':
                        gw.loadNewAsteroid();
                        break;

                    //add a non player ship to the GameWorld
                    case 'y':
                        gw.addNonPlayerShip();
                        break;
                        
                    //add a space station to the world
                    case 'b':
                        gw.addSpaceStation();
                        break;
                        
                        
                    //add a player ship to the world
                    case 's':
                        gw.addPlayerShip();
                        break;
                        
                    //increase the speed of the PS by a small amount
                    case 'i':
                    	gw.increasePSSpeed();
                    	break;
                    	
                    //decrease the speed of PS by a small amount
                    case 'd':
                    	gw.decreasePSSpeed();
                    	break;
                    	

                    case 'l': 
                    	gw.turnPSLeft();
                    	break;
                    	
                    //turn PS right by a small amount 
                    case 'r':
                    	gw.turnPSRight();
                    	break;
                    //fire a missile out of PS
                    case 'f':
                        gw.fireMissilePS();
                        break;


                    //fire a missile out of NPS
                    case 'L':
                        gw.fireMissileNPS();
                        break;


                    //print a map showing the current world state
                    case 'm':
                        gw.printMap();
                        break;
                        
                    //print the score, missiles in the ship, current time elapsed and number of lives left 
                    case 'p':
                        gw.print();
                        break;




                        //third delivery
                        //June 7th
                        

                    case '>':
                    	gw.revolvePSML();
                    	break;
                    	

                    
                    case 'n':
                    	gw.reloadPS();
                    	break;
                    	

                    case 'k':
                    	gw.killAsteroid();
                    	break;

                    case 'e':
                        gw.eliminateNPS();
                        break;
                        

                    case 'E':
                    	gw.eliminatePS();
                    	break;
                    	

                    case 'c':
                    	gw.crashAsteroid();
                    	break;
                    
                    	

                    case 'h':
                    	gw.crashNPS();
                    	break;
                    	

                    case 'x':
                    	gw.asteroidCrash();
                    	break;
                    	
                    //asteroid and NPS crash I (eye) = IMPACTED 
                    case 'I':
                    	gw.asteroidCrashNPS();
                    	break;

                    case 't':
                    	gw.tick();
                    	break;
                    	
                    
                    	
                    //jump to hyper space
                    case 'j':
                    	gw.jump();
                    	break;
                    	
                    //quit the game 
                    case 'q':
                    	quit();
                    	break;
            */

                }
            }
        });

    }
    public void quit(){ System.exit(0); }

    @Override
    public void run() {
        this.gw.tick();
    }
}
