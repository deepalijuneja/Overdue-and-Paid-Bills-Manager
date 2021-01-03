import java.util.Arrays;

/**
 * The Array List class is from the homeworks done before and is changed according to this homework.
 * 
 * @author Deepali Juneja
 * @version 25 May 2020
 */
public class ArrayList<T> {

    private Object[] arrayList;
    private int numOfElements;

    /**
     * This is the first, empty constructor. arrayList is set to zero
     * 
     */
    public ArrayList() {
        this.arrayList = new Object[1];
        this.numOfElements = 0;
    }

    /**
     * The number of elements is set to zero below.
     */
    public ArrayList(int size){
        this.arrayList = new Object[size];
        this.numOfElements = 0;
    }

    /**
     * Below is the full constructor.
     * 
     * @param array
     */
    public ArrayList(Object[] array) {
        if (array.length > 0) {
            this.arrayList = new Object[array.length];
            this.numOfElements = this.arrayList.length;
            System.arraycopy(array, 0, this.arrayList, 0, this.numOfElements);
        } else {
            throw new IllegalArgumentException("Invalid arraylist length");
        }
    }

    /**  check
     * Below is the insert method that checks for index
     * 
     * @param obj   
     * @param indexPos
     */
    public void insert(T obj, int indexPos) {
           if (obj != null && indexPos >= 0 && indexPos < this.size()) {
            
            if (this.numOfElements == this.size()) {
                this.arrayList = Arrays.copyOf(this.arrayList, this.size() + 1);
            }
            System.arraycopy(this.arrayList, indexPos, this.arrayList, indexPos + 1, (this.size() - 1) - indexPos);
            this.arrayList[indexPos] = obj;
        } else {
            throw new IllegalArgumentException("Null!");
        }
    }

    /**
     * Below method removes the object.
     * 
     * @param indexPos
     * @return the removed object
     */
    public Object remove(int indexPos) {
        T removedObject = null;
        if (indexPos >= 0 && indexPos < this.size()) {
            removedObject = (T) this.arrayList[indexPos];
            this.numOfElements--;
            System.arraycopy(this.arrayList, indexPos + 1, this.arrayList, indexPos, this.numOfElements - indexPos);
                                                                                                           
                                                                                                           
        } else {
            throw new IllegalArgumentException("Index is out of bounds, please try again...");
        }
        return removedObject;
    }

    /**
     * Below method returns size
     * 
     * @return
     */
    public int size() {
        return this.arrayList.length;
    }

    /**
     * Below method returns the object at index positions.
     * 
     * @param indexPos 
     * @return object 
     */
    public Object get(int indexPos) {
        T output = null;
        if (indexPos >= 0 && indexPos < this.size()) {
            output = (T) this.arrayList[indexPos];
        }
        return output;
    }

    /**
     * Below method checks for emptiness
     * 
     * @return T/F
     */
    public boolean isEmpty() {
        boolean output = false;
        if (this.size() > 0) {
            for (Object object : arrayList) {
                if (object == null) {
                    output = true;
                    break;
                } else {
                    output = false;
                }
            }
        } else {
            output = false;
        }
        return output;
    }

    /**
     * Below method returns object's index.
     * 
     * @param obj 
     */
    public int indexOf(T obj) {
        int indexPos = -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.arrayList[i] == obj) {
                indexPos = i;
                break;
            }
        }
        return indexPos;
    }

    /**
     * Below method compares the array lists.
     * 
     * @param anotherArrayList the one being compares
     * @return equal/not equal 
     */
    public boolean equals(ArrayList<T> anotherArrayList) {
         boolean output= false;
          if(anotherArrayList == null){
            throw new NullPointerException();
        } else {
            
        if (this.size() == anotherArrayList.size()) {
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i) == anotherArrayList.get(i)) {
                    output= true;
                } else {
                    output = false;
                }
            }
        } else {
            output= false;
        }
        return output;
    }
}

    /**
     * Below is the toString method to print.
     */
    @Override
     public String toString() {
       String output = "[ ";
        for (int i = 0; i < this.numOfElements; i++) {
            if (this.arrayList[i] != null) {
                output += this.arrayList[i] + " ";
            }
        }
        output += "]";
        return output;
    }
}