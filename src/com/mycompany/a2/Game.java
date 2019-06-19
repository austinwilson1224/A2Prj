package com.mycompany.a2;
//package com.mycompany.commands;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;


/**
 * This is the Game class which is the primary class that encapsulates the whole game
 *
 *
 *
 * Austin Wilson & Elianna Sanchez
 */

public class Game extends Form {

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


        /**
        old code
        gw.init();
        play();
        */
    }

    public void playA2() {



        this.setLayout(new BorderLayout());




        //toolbar
        Toolbar toolbar = new Toolbar();
        setToolbar(toolbar);
        toolbar.setTitle("ASTEROIDS");


        //commands
        Command about = new Command("About");
        Command New = new Command("New");
        Command undo = new Command("Undo");
        Command save = new Command("Save");
        Command quit = new Command("Quit");
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
        topContainer.add(pv);
        this.add(BorderLayout.NORTH,topContainer);





        //this will be the left container
        Container leftContainer = new Container();

        leftContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        //buttons to add
        Button addAsteroid = new Button("+Asteroid");
        Button addNPS = new Button("+NPS");
        Button addStation = new Button("+Station");
        Button addPlayerShip = new Button("+PlayerShip");
        Button firePS = new Button("Fire PS");
        Button jumpPS = new Button("Jump PS");


        //left container
        leftContainer.add(addAsteroid);
        leftContainer.add(addNPS);
        leftContainer.add(addStation);
        leftContainer.add(addPlayerShip);
        leftContainer.add(firePS);
        leftContainer.add(jumpPS);
        this.add(BorderLayout.WEST,leftContainer);



        /*
        this.add(new GridLayout(5,1));
        this.setLayout(new GridLayout(5,1));
        Label points = new Label("POINTS");
        this.add(points);
        */





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
}
