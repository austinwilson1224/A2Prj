package com.mycompany.a2;


import java.util.Vector;

//AKA Game Object Collection
public class GameObjectCollection implements ICollection {
    private Vector collection;
    public GameObjectCollection(){
        collection = new Vector();
    }


    public Vector getCollection() { return collection; }
    public int size() {
        return collection.size();
    }


    public void add(Object newObject){collection.add(newObject);}
    public void add(GameObject object) { collection.add(object); }
    public void remove(Object object) { collection.remove(object); }
    public void clear() { collection.clear(); }

    public IIterator getIterator(){
        return new SpaceVectorIterator();
    }



    //this is the nested private class
    private  class SpaceVectorIterator implements IIterator{

        //two private fields for access
        private int index = 0;

        public boolean hasNext(){
            return this.index < GameObjectCollection.this.collection.size();
        }

        public Object getNext() {
            return (collection.elementAt(index++));
        }
    }


}
