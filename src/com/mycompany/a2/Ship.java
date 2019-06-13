package com.mycompany.a2;

/**
 *
 *
 * Austin Wilson & Elianna Sanchez
 */
public abstract class Ship extends MovableGameObject{
    private int missileCount;

    public void setMissileCount(int missileCount){
        this.missileCount = missileCount;
    }
    public int getMissileCount(){
        return this.missileCount;
    }
    public void decrementMissileCount(){
        this.missileCount--;
    }

}
