package com.mycompany.a2;


import com.codename1.ui.geom.Point2D;
import sounds.Sound;

import java.util.Observable;


/**
 * This is the GameWorld class
 *
 * model
 *
 * Austin Wilson & Elianna Sanchez
 */



public class GameWorld extends Observable implements IGameWorld {

	private final static int MAX_MISSILES = 10;
    private GameObjectCollection collection;
    private static PlayerShip playerShip;

    private int numberOfLives;
    private int playerScore;
    private int numMissiles;
    private int timeElapsed;

    private boolean soundOn = true;


    public GameWorld(){
    	collection = new GameObjectCollection();
	}

	//getters
    public int getNumberOfLives(){
    	return this.numberOfLives;
	}
	public int getPlayerScore(){
    	return this.playerScore;
	}
	public int getNumMissiles() { return this.numMissiles; }
	public int getTimeElapsed() { return this.timeElapsed; }
	public GameObjectCollection getCollection() { return collection; }
	public IIterator getIterator() { return collection.getIterator(); }
	public boolean soundOn() { return soundOn; }
	public PlayerShip getPlayerShip() { return this.playerShip; }
	//setters
	public void setSound(boolean soundOn) { this.soundOn = soundOn; }

	public void init(){
        numberOfLives = 3;
        playerScore = 0;
        numMissiles = MAX_MISSILES;
        timeElapsed = 0;
        playerShip = null;
    }


    // GameWorld actions
	// i
    public void increasePSSpeed(){
        if(this.playerShip != null) {
        	if(playerShip.getSpeed() < playerShip.MAX_SPEED) {
				this.playerShip.increaseSpeed();
				this.setChanged();
				this.notifyObservers(new GameWorldProxy((this)));
			}
        	else System.out.println("traveling at max speed");
        }
        else System.out.println("No player ship in the game");
    }
    // d
    public void decreasePSSpeed(){
        if(this.playerShip != null) {
        	if(playerShip.getSpeed() > playerShip.MIN_SPEED) {
				playerShip.decreaseSpeed();
				this.setChanged();
				this.notifyObservers(new GameWorldProxy((this)));
			}
        	else System.out.println("traveling at minimum speed");

        }
        else System.out.println("No player ship in the game");
    }
    // r
    public void turnPSRight(){
        if(playerShip!=null) {
        	playerShip.turnRight();
			System.out.println("PS turned right to " + playerShip.getDirection());
			this.setChanged();
			this.notifyObservers(new GameWorldProxy((this)));
        }
    }
	// l
    public void turnPSLeft(){
        if(playerShip != null) {
        	playerShip.turnLeft();
        	System.out.println("PS turned left to " + playerShip.getDirection());
			this.setChanged();
			this.notifyObservers(new GameWorldProxy((this)));
        }
    }

    // a
    public void loadNewAsteroid(){
        Asteroid asteroid = new Asteroid();
        collection.add(asteroid);
        System.out.println("New ASTEROID has been created");
        System.out.println(asteroid);
		this.setChanged();
		this.notifyObservers(new GameWorldProxy((this)));
    }
    //s
    public void addPlayerShip(){
    	if(playerShip == null) {
			playerShip = new PlayerShip();
			collection.add(playerShip);


			//COME BACK HERE!
			//collection.add(playerShip.getLauncher());
			System.out.println("New PLAYER SHIP has been created");
			System.out.println(playerShip);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy((this)));
		}else System.out.println("Player ship already in world");
    }

    // y
    public void addNonPlayerShip(){
        NonPlayerShip nonPlayerShip = new NonPlayerShip();
        collection.add(nonPlayerShip);
        System.out.println("New NON PLAYER SHIP has been created");
        System.out.println(nonPlayerShip);
		this.setChanged();
		this.notifyObservers(new GameWorldProxy((this)));
    }


    // b
    public void addSpaceStation(){
        SpaceStation spaceStation = new SpaceStation();
        collection.add(spaceStation);
        System.out.println("New BLINKING SPACE STATION has been created");
        System.out.println(spaceStation);
		this.setChanged();
		this.notifyObservers(new GameWorldProxy((this)));
    }
    //f
	//HAS SOUND
	public void fireMissilePS(){
        //precondition is to check that the playerShip is in GameWorld
        if(playerShip == null){
            System.out.println("NO SHIP IN GAME");
            return;
        }
        //this will only return true if the ship has missiles available to fire
        if (numMissiles > 0){ //playerShip.fireMissiles()){
        	numMissiles--;
            //compute missile location, speed, and heading
            Point2D missileLocation = playerShip.getLocation();

			double missileSpeed = playerShip.getSpeed() + 5.0;
            int missileHeading = playerShip.getLauncher().getDirection();
            Missile missile = new Missile(missileSpeed,missileHeading,missileLocation,true);
            collection.add(missile);
            System.out.println("New missile added to the world");
            System.out.println(missile);
			System.out.println("PLAYER SHIP Missile Fired!\n" + numMissiles + " missiles left");


			//missile sounds
			if(soundOn) {
				Sound missileFiredSound = new Sound("fire.mp3");
				missileFiredSound.play();
			}

            this.setChanged();
            this.notifyObservers(new GameWorldProxy((this)));
        }
        else System.out.println("No missiles left!");
    }

	// L
    public void fireMissileNPS(){
    	NonPlayerShip nonPlayerShip = findNonPlayerShip();
        if(nonPlayerShip == null){
            System.out.print("NO NON PLAYER SHIP IN GAME");
            return;
        }
        if(nonPlayerShip.getMissileCount() == 0){

        	IIterator iterator = collection.getIterator();
        	while(iterator.hasNext()){
        		Object object = iterator.getNext();
        		if( object instanceof NonPlayerShip)
        			if( object != nonPlayerShip)
        				nonPlayerShip = (NonPlayerShip) object;
			}
		}
        //will only return true if the player ship has missiles available to fire
        if(nonPlayerShip.fireMissiles()) {
        	//System.out.println("Missile fired!");
        	Point2D missileLocation = nonPlayerShip.getLocation();
        	//ship speed plus constant value is 5
        	double missileSpeed = nonPlayerShip.getSpeed() + 5;
        	int missileHeading = nonPlayerShip.getDirection();
        	Missile missile = new Missile(missileSpeed,missileHeading,missileLocation,false);
        	collection.add(missile);
        	System.out.println("New missile added to the world");
        	System.out.println(missile);
        	//sound
        	if(soundOn){
        		Sound missileFiredSound = new Sound("fire.mp3");
        		missileFiredSound.play();
			}
        	this.setChanged();
        	this.notifyObservers(new GameWorldProxy((this)));
        }

    }
	// j
	public void jump() {
		if(playerShip != null) {
			if(playerShip.getLocation().getX() == Game.getWIDTH() / 2 && playerShip.getLocation().getY() == Game.getHEIGHT() / 2 )
				System.out.println("PLAYER SHIP ALREADY IN CENTER");
			else {
				playerShip.setLocation(Game.getWIDTH() / 2, Game.getHEIGHT() / 2);
				System.out.println("PS jumped to " + playerShip.getLocation());
				this.setChanged();
				this.notifyObservers(new GameWorldProxy((this)));
			}
		}
		else System.out.println("No player ship in game");
		
	}

	// >
	// HAS SOUND
	public void turnPSMLRight() {
		//first check that the player ship exists in game 
		if(playerShip != null) {
			if(  (playerShip.getLauncher().getDirection() + 10) >= 360) {
				playerShip.getLauncher().setDirection( playerShip.getLauncher().getDirection() + 10 - 360);
			} else playerShip.getLauncher().setDirection(playerShip.getLauncher().getDirection() + 10);
			if(soundOn) {
				Sound rotate = new Sound("rotate.wav");
				rotate.play();
			}
			System.out.println("Player Ship missile launcher rotated 10 degrees right to " + playerShip.getLauncher().getDirection() );
			this.setChanged();
			this.notifyObservers(new GameWorldProxy((this)));
		}
		else System.out.println("No player ship in the game");	
	}
	public void turnPSMLLeft() {
		//first check that the player ship exists in game
		if(playerShip != null) {
			if(  (playerShip.getLauncher().getDirection() - 10) < 0) {
				playerShip.getLauncher().setDirection( playerShip.getDirection() - 10 + 360);
			} else playerShip.getLauncher().setDirection(playerShip.getLauncher().getDirection() - 10);
			if(soundOn) {
				Sound rotate = new Sound("rotate.wav");
				rotate.play();
			}
			System.out.println("Player Ship missile launcher rotated 10 degrees left to " + playerShip.getLauncher().getDirection() );
			this.setChanged();
			this.notifyObservers(new GameWorldProxy((this)));
		}
		else System.out.println("No player ship in the game");
	}


	public void reloadPS() {
		if(playerShip != null) {
			if(playerShip.getMissileCount() < MAX_MISSILES){
				playerShip.setMissileCount(MAX_MISSILES);
				System.out.println("Player Ship missiles resupplied");
				this.setChanged();
				this.notifyObservers(new GameWorldProxy((this)));
			}
			else System.out.println("Ammo full");

		}
		else System.out.println("NO player ship in game");
		
	}

	//k
	public void killAsteroid() {
		if(playerShip == null) {
			System.out.println("No player ship in game!");
			return;
		}
		Missile missile = null;
		Asteroid asteroid = null;
		IIterator iterator = collection.getIterator();
		while(iterator.hasNext()) {
			Object object = iterator.getNext();
			if(object instanceof Missile ) {
				if( ((Missile) object).isPlayer())
					missile = (Missile) object;
			}
			else if(object instanceof Asteroid){
				asteroid = (Asteroid) object;
			}
		}
		//make sure the for loop instantiated missile and asteroid, check that they have the same location
		if( missile != null ) {
			if (asteroid != null) {
				collection.remove(asteroid);
				collection.remove(missile);
				System.out.println("Player ship killed an asteroid!");
				playerScore++;
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
			}else System.out.println("No asteroids");
		}else System.out.println("No missiles");
	}

	//e
	public void eliminateNPS() {
		if(playerShip == null) {
			System.out.println("No player ship in game!");
			return;
		}
		//declaring these here so we have access
		NonPlayerShip NPS = null;
		Missile missile = null;
		IIterator iterator = collection.getIterator();
		while(iterator.hasNext()){
			Object object = iterator.getNext();
			if(object instanceof NonPlayerShip){
				NPS = (NonPlayerShip) object;
			}
			else if(object instanceof Missile && !((Missile)object).isPlayer()) {
				missile = (Missile) object;
			}
		}
		if(missile != null) {
			if(NPS != null) {
				collection.remove(missile);
				collection.remove(NPS);
				System.out.println("Player ship missile killed NPS!");
				playerScore++;
				this.setChanged();
				this.notifyObservers(new GameWorldProxy((this)));
			}else System.out.println("No NPS in game!");
		}else System.out.println("No missile in world");
		
	}
	
	//E NPS kills PS
	public void eliminatePS() {
		if(playerShip == null) {
			System.out.println("No player ship in game!");
			return;
		}
		NonPlayerShip NPS = null;
		Missile missile = null;
		//find the NPS in question and assign it to NPS
		IIterator iterator = collection.getIterator();
		while(iterator.hasNext()){
			Object object = iterator.getNext();
			if(object instanceof NonPlayerShip){
				NPS = (NonPlayerShip) object;
			}
			else if(object instanceof Missile && !((Missile)object).isPlayer()){
				missile = (Missile) object;
			}
		}
		if(NPS != null) {
			if(missile != null) {
				numberOfLives--;
				collection.remove(missile);
				System.out.println("Non player ship missile eliminated player ship!");
				if (numberOfLives == 0) {
					collection.remove(playerShip);
					playerShip = null;
					System.out.println("GAME OVER");
				} else {
					//numberOfLives--;
					collection.remove(playerShip);
					playerShip = new PlayerShip();
					collection.add(playerShip);
				}
				this.setChanged();
				this.notifyObservers(new GameWorldProxy((this)));
			}else System.out.println("No missile....");
		}else System.out.println("No NPS in world");
	}
	
	//c PS crashed into asteroid
	public void crashAsteroid() {
		if(playerShip == null) {
			System.out.println("No player ship in game!");
			return;
		}
		//Asteroid asteroid = this.findAsteroid();
		Asteroid asteroid = null;
		IIterator iterator = collection.getIterator();
		while(iterator.hasNext()){
			Object object = iterator.getNext();
			if(object instanceof Asteroid){
				asteroid = (Asteroid) object;
			}
		}


		if(asteroid != null) {
			numberOfLives--;
			collection.remove(asteroid);
			collection.remove(playerShip);
			System.out.println("Player ship crashed into an asteroid!");
		}
		if(this.numberOfLives == 0) {
			playerShip = null;
			System.out.println("0 lives, GAME OVER!");


		}
		else {
			playerShip = new PlayerShip();
			collection.add(playerShip);

		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy((this)));
		
	}

	//h PS and NPS crashed into each other
	public void crashNPS() {
		if(playerShip == null) {
			System.out.println("No player ship in game!");
			return;
		}
		NonPlayerShip NPS = null;
		IIterator iterator = collection.getIterator();
		while(iterator.hasNext()){
			Object object = iterator.getNext();
			if(object instanceof NonPlayerShip)
				NPS = (NonPlayerShip) object;
		}


		//NonPlayerShip NPS = this.findNonPlayerShip();
		if(NPS != null) {
			collection.remove(NPS);
			collection.remove(playerShip);
			System.out.println("PlayerShip has crashed into a non player ship");
			if(this.numberOfLives > 0) {
				numberOfLives--;
				playerShip = new PlayerShip();
				collection.add(playerShip);
			}
			else {
				playerShip = null;
				System.out.println("0 lives, GAME OVER!");
			}
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
		else {
			System.out.println("No NPS in game");
			return;
		}

	}

	//x two asteroids collided into each other
	public void asteroidCrash() {
    	Asteroid a1 = null;
    	Asteroid a2 = null;


    	IIterator iterator = collection.getIterator();
    	while(iterator.hasNext()){
    		Object object = iterator.getNext();

    		if( a1 == null && object instanceof Asteroid) {
				a1 = (Asteroid) object;
			} else if( a2 == null && object instanceof Asteroid) {
				a2 = (Asteroid) object;
			}

			if(a1 == null && a2 == null) {
				return;
			}
		}
		if( a1 == null || a2 == null) {
			System.out.println("Not enough asteroids");
			return;
		}
		collection.remove(a1);
		collection.remove(a2);
		System.out.println("Two asteroids collided");

	}

	//I asteroid and NPS crash
	public void asteroidCrashNPS() {
		Asteroid asteroid = findAsteroid();
		NonPlayerShip NPS = findNonPlayerShip();
		if(asteroid != null) {
			if(NPS != null) {
				collection.remove(findAsteroid());
				collection.remove(findNonPlayerShip());
				System.out.println("Asteroid collided into a non player ship!");
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));

			}else System.out.println("No NPS in game");
		}
		else  {
			System.out.println("No asteroid in game!");
		}
	}

	//t
	public void tick() {
		timeElapsed++;
		//gameOver will play the ending sound
		if( gameOver() ){
			return;


		}
		IIterator iterator = collection.getIterator();
    	while(iterator.hasNext()){




    		Object object = iterator.getNext();

    		if(object instanceof GameObject) {
    			GameObject go = (GameObject) object;
    			//wrap x
    			if(go.getX() < 0)
    				go.setX(Game.getWIDTH());
    			else if(go.getX() > Game.getWIDTH())
    				go.setX(0);

    			//wrap y
    			if(go.getY() < 0 ) {
					go.setY(Game.getHEIGHT());
				}

    			else if(go.getY() > Game.getHEIGHT())
    				go.setY(0);
			}



			//1 update all movable objects positions 
			if(object instanceof IMovable) {
				((IMovable) object).move(Game.getTickRate());
			}
			
			//2 update all missiles fuel levels 
			if(object instanceof Missile) {
				if(((Missile)object).getFuelLevel() == 0) {
					collection.remove(object);
				}
				else ((Missile)object).decrementFuelLevel();
			}
			
			//3 toggle space stations blinker 
			if(object instanceof SpaceStation) {
				//this is the 
				if(timeElapsed % ((SpaceStation)object).getBlinkRate()  == 0)
					((SpaceStation)object).toggleBlinker();
			}
		}

		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public boolean gameOver(){
    	if(numberOfLives == 0){
    		if(soundOn) {
    			//Game.soundCommand.bPause(true);
				Sound UFO = new Sound("UFO.wav");

				UFO.play();
				//UFO.pause();
				return true;
			}
		}
		return false;
	}
	
	
	//these methods will be auxiliary method for finding certain objects in the objects list
	public Asteroid findAsteroid() {
		IIterator iterator = collection.getIterator();
		while(iterator.hasNext()){
			if(iterator.getNext() instanceof Asteroid)
				return (Asteroid)iterator.getNext();
		}
		return null;
	}
	public int asteroidCount() {
		IIterator iterator = collection.getIterator();
		int count = 0;
		while(iterator.hasNext()){
			Object object = iterator.getNext();
			if(object instanceof Asteroid)
				count++;
		}
		return count;
	}
	public NonPlayerShip findNonPlayerShip() {
		IIterator iterator = collection.getIterator();
		while(iterator.hasNext()) {
			Object object = iterator.getNext();
			if (object instanceof NonPlayerShip) {
				return (NonPlayerShip) object;
			}
		}
		return null;
	}

	//m
	public void printMap(){
		System.out.println("\nWorld Map");
		for(int i = 0;i < collection.size();i++){
			System.out.println(collection.getCollection().get(i).toString());
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
	public void quit(){ System.exit(0); }
}
