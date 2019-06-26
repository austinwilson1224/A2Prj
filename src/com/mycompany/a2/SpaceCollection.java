package com.mycompany.a2;


import java.util.Vector;

//AKA Game Object Collection
public class SpaceCollection implements ICollection {

    private Vector theCollection;

    public SpaceCollection(){
        theCollection = new Vector();
    }

    public void add(Object newObject){
        theCollection.add(newObject);
    }

    public IIterator getIterator(){
        return new SpaceVectorIterator();
    }


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
    }


}
