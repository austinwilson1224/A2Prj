package com.mycompany.a2;

import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld {
    private GameWorld gw;

    public GameWorldProxy(GameWorld gw){ this.gw = gw; }

    public int getNumberOfLives() { return this.gw.getNumberOfLives(); }
    public int getPlayerScore() { return this.gw.getPlayerScore(); }
    public int getNumMissiles() { return this.gw.getNumMissiles(); }
    public int getTimeElapsed() { return this.gw.getTimeElapsed(); }
    public GameObjectCollection getCollection() { return this.gw.getCollection(); }
    public IIterator getIterator() { return this.gw.getIterator(); }
    public void init() { this.gw.init(); }
    public void increasePSSpeed() { this.gw.increasePSSpeed(); }
    public void decreasePSSpeed() { this.gw.decreasePSSpeed(); }
    public void turnPSRight() { this.gw. turnPSRight(); }
    public void turnPSLeft() { this.gw.turnPSLeft(); }
    public void loadNewAsteroid() { this.gw.loadNewAsteroid(); }
    public void addPlayerShip() { this.gw.addPlayerShip(); }
    public void addNonPlayerShip() { this.gw.addNonPlayerShip(); }
    public void addSpaceStation() { this.gw.addSpaceStation(); }
    public void fireMissilePS() { this.gw.fireMissileNPS(); }
    public void fireMissileNPS() { this.gw.fireMissileNPS(); }
    public void jump() { this.gw.jump(); }
    public void revolvePSML() { this.gw.revolvePSML(); }
    public void reloadPS() { this.gw.reloadPS(); }
    public void killAsteroid() { this.gw.killAsteroid(); }
    public void eliminateNPS() { this.gw.eliminateNPS(); }
    public void eliminatePS() { this.gw.eliminatePS(); }
    public void crashAsteroid() { this.gw.crashAsteroid(); }
    public void crashNPS() { this.gw.crashNPS(); }
    public void asteroidCrash() { this.gw.asteroidCrash(); }
    public void asteroidCrashNPS() { this.gw.asteroidCrashNPS(); }
    public void tick() { this.gw.tick(); }
    public Asteroid findAsteroid() { return this.gw.findAsteroid(); }
    public int asteroidCount() { return this.gw.asteroidCount(); }
    public NonPlayerShip findNonPlayerShip() { return this.gw.findNonPlayerShip(); }
    public void printMap() { this.gw.printMap(); }
    public void print() { this.gw.print(); }
    public void quit() { this.gw.quit(); }
}
