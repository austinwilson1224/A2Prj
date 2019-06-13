package com.mycompany.a2;


/**
 * Fixed Game Objects and such
 *
 *
 * Austin Wilson & Elianna Sanchez
 */
public abstract class FixedGameObject extends GameObject{
    //fields
    private static int id;

    //methods

    public int getNextID(){
        return this.id;
    }
}
