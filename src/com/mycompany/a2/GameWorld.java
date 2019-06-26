package com.mycompany.a2;


import com.codename1.ui.geom.Point2D;
import java.util.ArrayList;
import java.util.Observable;



/**
 * This is the GameWorld class
 *
 * model
 *
 * Austin Wilson & Elianna Sanchez
 */




public class GameWorld extends Observable implements IGameWorld {



    public final static double HEIGHT = 1024.0;
    public final static double WIDTH = 768.0;


    private SpaceCollection collection;
    private ArrayList<GameObject> objects = new ArrayList<>();

    private static PlayerShip playerShip;
    private static NonPlayerShip nonPlayerShip;

    private int numberOfLives;
    private int playerScore;
    private int numMissiles;
    private int timeElapsed;

    public GameWorld(){
    	collection = new SpaceCollection();
	}

	//getters
    public int getNumberOfLives(){
    	return this.numberOfLives;
	}
	public int getPlayerScore(){
    	return this.playerScore;
	}
	public int getNumMissiles(){ return this.numMissiles; }
	public int getTimeElapsed(){ return this.timeElapsed; }
	public SpaceCollection getSpaceCollection() { return collection;}


    private final static int MAX_MISSILES = 10;




    public void init(){
        numberOfLives = 3;
        playerScore = 0;
        numMissiles = MAX_MISSILES;
        timeElapsed = 0;
    }


    /**
     * make sure the payer ship is not null
     * 
     * increase speed comes from movable game object 
     * 
     */
    public void increasePSSpeed(){
        if(this.playerShip != null) {
        	if(playerShip.getSpeed() < playerShip.MAX_SPEED) {
				this.playerShip.increaseSpeed();
				this.setChanged();
				this.notifyObservers();
			}
        	else System.out.println("traveling at max speed");
        }
        else System.out.println("No player ship in the game");
    }
    public void decreasePSSpeed(){
        if(this.playerShip != null) {
        	if(playerShip.getSpeed() > playerShip.MIN_SPEED) {
				playerShip.decreaseSpeed();
				this.setChanged();
				this.notifyObservers();
			}
        	else System.out.println("traveling at minimum speed");

        }
        else System.out.println("No player ship in the game");
    }

    //user command r turn player ship right
    public void turnPSRight(){
        if(playerShip!=null) {
        	playerShip.turnRight();
			this.setChanged();
			this.notifyObservers();
        }
    }
    
    
    
    /**
     * 
     * from user command 'l'
     * this is ell not I 
     * this command should turn the PS left by a small amount
     * change the heading of the ship by a small amount in the counter-clockwise direction
     * 
     * should check to see if the current heading is at 359, then the new heading would be 0
     * otherwise the heading should just add one 
     * 
     * finished
     */
    public void turnPSLeft(){
        if(playerShip != null) {
        	playerShip.turnLeft();
			this.setChanged();
			this.notifyObservers();
        }
    }


    //a
    public void loadNewAsteroid(){
    	//TODO
        Asteroid asteroid = new Asteroid();
        collection.add(asteroid);
        System.out.println("New ASTEROID has been created");
        System.out.println(asteroid);
    }

    //s
    public void addPlayerShip(){
        playerShip = new PlayerShip();
        collection.add(playerShip);
        System.out.println("New PLAYER SHIP has been created");
        System.out.println(playerShip);
    }

    //y
    public void addNonPlayerShip(){
        nonPlayerShip = new NonPlayerShip();
        objects.add(nonPlayerShip);
        System.out.println("New NON PLAYER SHIP has been created");
        System.out.println(nonPlayerShip);
    }


    //b
    public void addSpaceStation(){
        SpaceStation spaceStation = new SpaceStation();
        objects.add(spaceStation);
        System.out.println("New BLINKING SPACE STATION has been created");
        System.out.println(spaceStation);
    }


	/**
	 * f
	 * method to fire a missile from the NPS
	 */

	public void fireMissilePS(){


        //precondition is to check that the playerShip is in GameWorld
        if(playerShip == null){
            System.out.print("NO SHIP IN GAME");
            return;
        }
        
        //this will only return true if the ship has missiles available to fire
        if (playerShip.fireMissiles()){

            //compute missile location, speed, and heading
            Point2D missileLocation = playerShip.getLocation();
            //ship speed plus constant value is 5
            double missileSpeed = playerShip.getSpeed() + 5.0;
            int missileHeading = playerShip.getLauncher().getDirection();
            Missile missile = new Missile(missileSpeed,missileHeading,missileLocation);
            objects.add(missile);
            System.out.println("New missile added to the world");
            System.out.println(missile);

            //playerShip controls the missiles
			// reference in GameWorld set to same value
            numMissiles = playerShip.getMissileCount();
            this.setChanged();
            this.notifyObservers();
        }
    }

    /**
     * method associated with 'L'
     * first check to see that there is a NPS in the game
     * if so then we will fire the missiles, since that method already checks to see that the ship has missiles available to fire
     * then create a new missile to add to the game world 
     */
    public void fireMissileNPS(){
        if(nonPlayerShip == null){
            System.out.print("NO NON PLAYER SHIP IN GAME");
            return;
        }
        //will only return true if the player ship has missiles available to fire 
        if(nonPlayerShip.fireMissiles()) {
        	//System.out.println("Missile fired!");
        	Point2D missileLocation = nonPlayerShip.getLocation();
        	//ship speed plus constant value is 5
        	double missileSpeed = nonPlayerShip.getSpeed() + 5;
        	int missileHeading = nonPlayerShip.getDirection();
        	Missile missile = new Missile(missileSpeed,missileHeading,missileLocation);
        	objects.add(missile);
        	System.out.println("New missile added to the world");
        	System.out.println(missile);
        }

    }


    //m
    public void printMap(){
    	System.out.println("\nWorld Map");
        for(int i = 0;i < objects.size();i++){
            System.out.println(objects.get(i).toString());
        }
        System.out.println("\n");
    }

    public void print(){
        System.out.println("\nPlayer Score: " + playerScore);
        if(playerShip != null){
            System.out.println("Number of missiles: " + playerShip.getMissileCount());
        }else System.out.println("Number of missiles: No ships..");
        System.out.println("Current time elapsed: " + timeElapsed);
        System.out.println("Number of lives: " + numberOfLives + "\n");
    }


    
    /**
     * j
	 *
     * this will cause the location to be reset to the center of the map
     * which is located at (512,384)
     */
	public void jump() {
		if(playerShip != null) {
			if(playerShip.getLocation().getX() == 512.0 && playerShip.getLocation().getY() == 384.0)
				System.out.println("PLAYER SHIP ALREADY IN CENTER");
			else {
				playerShip.setLocation(512, 384);
				System.out.println("PS jumped to " + playerShip.getLocation());
			}
		}
		else System.out.println("No player ship in game");
		
	}


	
	/**
	 * >
	 *
	 * this method causes the player ships missile launcher to revolve around the center
	 * in a clockwise direction 
	 * 
	 * each time the player hits the > button the ship will change direction by one degree
	 * so I will just update playerShip direction to be increment by one
	 * 
	 */
	public void revolvePSML() {
		//first check that the player ship exists in game 
		if(playerShip != null) {			
			playerShip.getLauncher().setDirection(playerShip.getLauncher().getDirection() + 10);
		}
		else System.out.println("No player ship in the game");	
	}


	public void reloadPS() {
		if(playerShip != null) {
			if(playerShip.getMissileCount() < MAX_MISSILES){
				playerShip.setMissileCount(MAX_MISSILES);
				System.out.println("Player Ship missiles resupplied");
			}
			else System.out.println("Ammo full");

		}
		else System.out.println("NO player ship in game");
		
	}


	
	/**
	 * k
	 *
	 * this is when an asteroid and a missile collide, the asteroid and the missile would be destroyed
	 *
	 * first check that 
	 * 
	 *  The program is not required to have any code that actually checks for collisions between objects; 
	 *  that’s something we’ll be adding later. 
	 *  For now, the program simply relies on the user to say when such events have occurred, 
	 *  using for example the ‘k’ and ‘c’ commands.
	 * 
	 * 
	 */
	public void killAsteroid() {
		if(playerShip == null) {
			System.out.println("No player ship in game!");
			return;
		}
		Missile missile = null;
		Asteroid asteroid = null;
		
		for(GameObject i : objects) {
			if(i instanceof Missile) {
				missile = (Missile)i;
			}
			else if(i instanceof Asteroid)
				asteroid = (Asteroid)i;
		}

		//make sure the for loop instantiated missile and asteroid 
		//then check that they have the same location --- unnecessary 
		if( missile != null ) {//case where there is a missile in the world
			if (asteroid != null) {
				objects.remove(asteroid);
				objects.remove(missile);
				System.out.println("Player ship killed an asteroid!");
			}else System.out.println("No asteroids");
		}else System.out.println("No missiles");
	}

	
	/**
	 * e
	 * 
	 * this is the method that will kill and NPS
	 * if a missile is fired from a player ship 
	 * and it hit a NPS in game world then both instances of
	 * missile and NPS will be removed from objects
	 * 
	 * not sure if its necessary to search through the list of objects in the world f
	 * for both objects 
	 * should just search for the correct NPS and then eliminate both objects
	 */

	public void eliminateNPS() {
		
		
		if(playerShip == null) {
			System.out.println("No player ship in game!");
			return;
		}
		//declaring these here so we have access
		NonPlayerShip NPS = null;
		Missile missile = null;
		//find the NPS in question and assign it to NPS
		for(GameObject i : objects) {
			if(i instanceof NonPlayerShip) {
				NPS = (NonPlayerShip) i;
			}
		}
		//find the missile in question and assign it to missile
		for(GameObject i : objects) {
			if(i instanceof Missile) {
				missile = (Missile) i;
			}
		}
		
		if(missile != null && NPS != null) {
			objects.remove(missile);
			objects.remove(NPS);
			System.out.println("Player ship missile killed NPS!");
		}
		
	}
	
	
	
	/**
	 * method associated with E 
	 * 
	 * this method will be synonymous with eliminateNPS
	 * instead of NPS we will have a PlayerShip (PS)
	 * 
	 * NPS's missile has struck and killed a PS
	 * 
	 * finished 
	 */
	public void eliminatePS() {
		if(playerShip == null) {
			System.out.println("No player ship in game!");
			return;
		}
		//declaring these here so we have access
		PlayerShip PS = null;
		Missile missile = null;
		//find the NPS in question and assign it to NPS
		for(GameObject i : objects) {
			if(i instanceof PlayerShip) {
				PS = (PlayerShip) i;
			}
			else if(i instanceof Missile) {
				missile = (Missile) i;

				
			}
		}
				
		if(missile != null && PS != null) {
			objects.remove(missile);
			objects.remove(PS);
			System.out.println("Non player ship missile eliminated player ship!");
			
			if(numberOfLives == 0) {
				playerShip = null;
				System.out.println("GAME OVER");
			}else {
				numberOfLives--;
				playerShip = new PlayerShip();
			}
		}
	}
	
	
	
	
	/**
	 * method associated with 'c'
	 * playerShip has crashed into an asteroid 
	 * in this case remove the ship and the asteroid from the world
	 * don't worry about which asteroid for now...
	 * 
	 * if there are more lives left decrement lives 
	 * and add a new playerShip into the world...?
	 * 
	 */
	public void crashAsteroid() {
		if(playerShip == null) {
			System.out.println("No player ship in game!");
			return;
		}
		Asteroid asteroid = this.findAsteroid();
		objects.remove(playerShip);
		objects.remove(asteroid);
		System.out.println("Player ship crashed into an asteroid!");
		if(this.numberOfLives > 0) {
			this.numberOfLives--;
			playerShip = new PlayerShip();
			objects.add(playerShip);
		}
			//this code will never print out 
		else {
			playerShip = null;
			System.out.println("0 lives, GAME OVER!");
		}
		
	}
	
	
	/**
	 * method associated with 'h'
	 * PS has crashed into an NPS
	 * tell game world to remove the NPS (and the PS?) and decrement the number of lives 
	 * 
	 * finished 
	 */
	public void crashNPS() {
		if(playerShip == null) {
			System.out.println("No player ship in game!");
			return;
		}
		NonPlayerShip NPS = this.findNonPlayerShip();
		if(NPS != null) {
			objects.remove(NPS);
			objects.remove(playerShip);
			System.out.println("PlayerShip has crashed into a non player ship");
		}
		else {
			System.out.println("No NPS in game");
			return;
		}
		if(this.numberOfLives > 0) {
			numberOfLives--;
			playerShip = new PlayerShip();
			objects.add(playerShip);
		}
		else {
			playerShip = null;
			System.out.println("0 lives, GAME OVER!");
		}
	}
	
	
	/**
	 * method associated with the 'x' command 
	 * two asteroids have collided into each other 
	 * 
	 * 
	 * first check that there are at least two asteroids in gameworld using asteroid count
	 * then remove two asteroids 
	 * 
	 * finished
	 */
	public void asteroidCrash() {
		if(this.asteroidCount() > 1) {
			
		
			Asteroid a1 = this.findAsteroid();
			objects.remove(a1);
			Asteroid a2 = this.findAsteroid();
			objects.remove(a2);
			System.out.println("Two asteroids have collided!");
		}
	}

	
	/**
	 * associated with the player input 'I'
	 * 
	 * one asteroid have collided and impacted the NPS
	 * tell the game world to remove them from the game 
	 * 
	 * choose one asteroid and one NPS to be remove worry about which ones later 
	 */
	public void asteroidCrashNPS() {
		Asteroid asteroid = findAsteroid();
		NonPlayerShip NPS = findNonPlayerShip();
		if(asteroid != null && NPS != null) {
			objects.remove(findAsteroid());
			objects.remove(findNonPlayerShip());
			System.out.println("Asteroid collided into a non player ship!");
		}
		else if(asteroid == null) {
			System.out.println("No asteroid in game!");
		}
		else if(NPS == null) {
			System.out.println("No NPS is game!");
		}
	}
	
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
	public void tick() {
		for(GameObject i : objects) {
			
			//1 update all movable objects positions 
			if(i instanceof IMovable) {
				((IMovable) i).move();
			}
			
			//2 update all missiles fuel levels 
			if(i instanceof Missile) {
				if(((Missile)i).getFuelLevel() == 0) {
					objects.remove(i);
				}
				else ((Missile)i).decrementFuelLevel();
			}
			
			//3 toggle space stations blinker 
			if(i instanceof SpaceStation) {
				//this is the 
				if(timeElapsed % ((SpaceStation)i).getBlinkRate()  == 0)
					((SpaceStation)i).toggleBlinker();
			}
			//4 increment time elapsed by 1 
			timeElapsed++;
		}
		System.out.println("GAME TICKED");
	}
	
	
	
	/**
	 * these methods will be auxiliary method for finding certain objects in the objects list
	 */
	
	
	public Asteroid findAsteroid() {
		
		for(GameObject i : objects) {
			if(i instanceof Asteroid) {
				return (Asteroid) i;
				
			}
		}
		return null;
	}
	public int asteroidCount() {
		int count = 0;
		for(GameObject i : objects) {
			if(i instanceof Asteroid) {
				count++;
			}
		}
		return count;
		
	}

	
	public NonPlayerShip findNonPlayerShip() {
		for(GameObject i : objects) {
			if(i instanceof NonPlayerShip) {
				return (NonPlayerShip) i;
			}
		}
		return null;
	}
		
	public void quit(){
		System.exit(0);
	}
	
	
	
	
	
	
	
	

}
