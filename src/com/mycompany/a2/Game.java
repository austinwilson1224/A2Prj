package com.mycompany.a2;
//package com.mycompany.commands;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.mycompany.commands.*;


/**
 * This is the Game class which is the primary class that encapsulates the whole game
 *
 * controller
 *
 *
 *
 * Austin Wilson & Elianna Sanchez
 */

public class Game extends Form implements Runnable {

    //fields
    private GameWorld gw;
    private MapView mv;
    private PointsView pv;




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
        Command about = new AboutCommand(gw);
        Command New = new NewCommand(gw);
        Command undo = new UndoCommand(gw);
        Command save = new SaveCommand(gw);
        Command quit = new QuitCommand(gw);
        CheckBox sound = new CheckBox("sound");
        sound.getAllStyles().setBgTransparency(255);
        toolbar.addCommandToLeftSideMenu(about);
        toolbar.addCommandToLeftSideMenu(New);
        toolbar.addCommandToLeftSideMenu(undo);
        toolbar.addCommandToLeftSideMenu(save);
        toolbar.addCommandToLeftSideMenu(quit);
        toolbar.addComponentToLeftSideMenu(sound);


        //Points View is held in the top container
        Container topContainer = new Container();
        topContainer.getAllStyles().setBorder(Border.createLineBorder(5));
        topContainer.add(pv);
        this.add(BorderLayout.NORTH,topContainer);
        //commands in left container
        Container leftContainer = new Container();
        leftContainer.getAllStyles().setBorder(Border.createLineBorder(5));
        leftContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        leftContainer.getAllStyles().setAlignment(LEFT);




        //buttons to add
        Button addAsteroid = new Button("+Asteroid");
        Button addNPS = new Button("+NPS");
        Button addStation = new Button("+Station");
        Button addPlayerShip = new Button("+PlayerShip");
        Button firePS = new Button("Fire PS");
        Button jumpPS = new Button("Jump PS");



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
        this.addKeyListener(97,addAsteroidCommand);
        //s = add player ship
        this.addKeyListener(115,addPlayerShipCommand);
        //y = add NPS
        this.addKeyListener(121,addNPSCommand);
        //b  = add space station
        this.addKeyListener(98,addSpaceStationCommand);




        //i = increase PS speed
        this.addKeyListener( 105,increasePSSpeedCommand);
        //d = decrease PS speed
        this.addKeyListener(100,decreasePSSpeedCommand);


        //steering player ship
        //l = steer player sip left
        this.addKeyListener(108,turnPlayerShipLeftCommand);
        //r = turn player ship right
        this.addKeyListener(114,turnPlayerShipRightCommand);


        //rotate player ship missile launcher
        //> = 62
        this.addKeyListener(62,turnMLRightCommand);



        //f = fire missile out of player ship
        this.addKeyListener(102,psFireCommand);
        //L = launch missile out of NPS
        this.addKeyListener(76,npsFireCommand);


        //j = jump to hyperspace
        this.addKeyListener(106,jumpCommand);

        //n = reload
        this.addKeyListener(110,loadPSMissilesCommand);

        //k = PS missile has struck and killed an asteroid
        this.addKeyListener(107,psMissileHitAsteroidCommand);

        //e = PS missile struck and killed NPS
        this.addKeyListener(101,psHitsNPSCommand);

        //E = NPS missile struck and killed PS
        this.addKeyListener(121,npsMissileHitPSCommand);

        //c = PS crashed into an asteroid
        this.addKeyListener(99,psHitsAsteroidCommand);

        //h = PS hit and NPS
        this.addKeyListener(104,psHitsNPSCommand);

        //x = two asteroids have collided
        this.addKeyListener(120,asteroidsCrashCommand);

        //I = 73 NPS hit asteroid
        this.addKeyListener(73, asteroidHitsNPSCommand);

        //t = tick
        this.addKeyListener(116,tickCommand);

        //p = print
        this.addKeyListener(112,printCommand);

        //m = print a map
        this.addKeyListener(109,mapCommand);












        //q = quit
        this.addKeyListener(113,quitCommand);


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
        //Container centerContainer = new Container();
        //centerContainer.add(mv);
        this.add(BorderLayout.CENTER,mv);

        UITimer.timer(100, true, this);
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
    public void quit(){
        System.exit(0);
    }

    @Override
    public void run() {
        this.gw.tick();
    }
}
