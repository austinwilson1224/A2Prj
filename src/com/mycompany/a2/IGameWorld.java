package com.mycompany.a2;

public interface IGameWorld {

    int getNumberOfLives();
    int getPlayerScore();
    int getNumMissiles();
    int getTimeElapsed();
    boolean soundOn();
    GameObjectCollection getCollection();
    IIterator getIterator();
    void init();
    void increasePSSpeed();
    void decreasePSSpeed();
    void turnPSRight();
    void turnPSLeft();
    void loadNewAsteroid();
    void addPlayerShip();
    void addNonPlayerShip();
    void addSpaceStation();
    void fireMissilePS();
    void fireMissileNPS();
    void jump();
    void turnPSMLRight();
    void turnPSMLLeft();
    void reloadPS();
    void killAsteroid();
    void eliminateNPS();
    void eliminatePS();
    void crashAsteroid();
    void crashNPS();
    void asteroidCrash();
    void asteroidCrashNPS();
    void tick();
    Asteroid findAsteroid();
    int asteroidCount();
    NonPlayerShip findNonPlayerShip();
    void printMap();
    void print();
    void quit();


}
