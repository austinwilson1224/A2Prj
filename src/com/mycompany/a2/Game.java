package com.mycompany.a2;
//package com.mycompany.commands;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

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
        mv = new MapView();
        pv = new PointsView();
        gw.addObserver(mv);
        gw.addObserver(pv);
        this.show();





        /**
        old code
        gw.init();
        play();
        */
    }

    public void play(){
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
                    	
                    /**
                     * turn PS left by a small amount (ell)
                     * method increments the PlayerShips direction by 1
                     * if the player ship is in direction 359 it resets to zero 
                     * 
                     * 
                     * finished 
                     */
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
                        
                    /**
                     * control the direction of the PS's missile launcher
                     * by revolving it around the center of the PS in a clockwise direction
                     * 
                     * PSML stands for Player Ship Missile Launcher
                     * 
                     * finished
                     */
                    case '>':
                    	gw.revolvePSML();
                    	break;
                    	
                    	
                    	
                    /**
                     * load a new supply of missiles into the PS
                     * increased the missile count to maximum 
                     * 
                     * finished 
                     */
                    
                    case 'n':
                    	gw.reloadPS();
                    	break;
                    	
                    	
                    /**
                     * a PS's missile struck and killed an asteroid 
                     * 
                     * finished 
                     */
                    case 'k':
                    	gw.killAsteroid();
                    	break;
                    	
                    /**
                     * PS's missile has struck and eliminated an NPS 
                     * 
                     * finished 
                     */
                    case 'e':
                        gw.eliminateNPS();
                        break;
                        
                    /**
                     * NPS's missile has struck and exploded a PS
                     * 
                     * finished 
                     * 
                     */
                    case 'E':
                    	gw.eliminatePS();
                    	break;
                    	
                    /**
                     * PS crashed into an asteroid
                     * tell game world to remove the ship and an asteroid and to decrement the count of lives left 
                     * if no lives are left then the game is over
                     * you may choose any asteroid to be removed 
                     * later we'll worry about asteroids needing to be close to the ship
                     * 
                     * finished 
                     */
                    case 'c':
                    	gw.crashAsteroid();
                    	break;
                    
                    	
                    /**
                     * PS has hit an NPS
                     * 		
                     * finished		
                     */
                    case 'h':
                    	gw.crashNPS();
                    	break;
                    	
                    	
                    /**
                     * two asteroids have collided
                     * 
                     * finished 
                     */
                    case 'x':
                    	gw.asteroidCrash();
                    	break;
                    	
                    //asteroid and NPS crash I (eye) = IMPACTED 
                    case 'I':
                    	gw.asteroidCrashNPS();
                    	break;
                    	
                    /**
                     * game world game clock has ticked
                     * 
                     * has the effect of 
                     * 1. all movable objects are told to update their positions 
                     * 2. every missile's fuel level is reduced by one and 
                     * 	any missiles which are now out of fuel are removed from the game
                     * 3. each space stations toggles its blinking light if the tick count modulo 
                     * the stations blink rate is zero
                     * 4. the "elapsed game time" is incremented by one 
                     */
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


                }
            }
        });

    }


    private void quit(){
        System.exit(0);
    }
}
