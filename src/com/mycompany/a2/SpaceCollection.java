package com.mycompany.a2;


import java.util.Vector;

//AKA Game Object Collection
public class SpaceCollection implements ICollection {

    private Vector theCollection;


    public Vector getTheCollection() {
        return theCollection;
    }

    public int size() {
        return theCollection.size();
    }

    public SpaceCollection(){
        theCollection = new Vector();
    }

    public void add(Object newObject){
        theCollection.add(newObject);
    }
    public void remove(Object object) { theCollection.remove(object); }

    public IIterator getIterator(){
        return new SpaceVectorIterator();
    }



    //this is the nested private class
    private  class SpaceVectorIterator implements IIterator{

        //two private fields for access
        private int index;

        public SpaceVectorIterator(){
            index = -1;
        }

        public boolean hasNext(){
            if(theCollection.size() <= 0)
                return false;
            if(index == theCollection.size() - 1)
                return false;
            return true;
        }

        public Object getNext() {
            index++;
            return (theCollection.elementAt(index));
        }
        public Object getCurrentObject() {
            if(index >= 0) {
                return (theCollection.elementAt(index));
            }
            return null;
        }
    }


}
