package arrayvisitors.adt;

import arrayvisitors.util.MyLogger;
import arrayvisitors.visitors.Element;
import arrayvisitors.visitors.Visitor;

import java.util.Arrays;

public class MyArray implements MyArrayI, Element {
    public Integer[] myIntArray = new Integer[10];
    MyLogger myLogger;

    /**
     * Empty Constructor
     */
    public MyArray(){}

    /**
     * Constructor for debugging purpose
     * @param myLogger MyLogger level
     */
    public MyArray(MyLogger myLogger){
        this.myLogger = myLogger;
    }

    /**
     * For debugging
     * @return message showing successful call to MyArray
     */
    public MyLogger getMyLogger() {
        myLogger.writeMessage("CALL TO MyArray", MyLogger.DebugLevel.MYARRAY);
        return myLogger;
    }

    public void setMyLogger(MyLogger myLogger) {
        this.myLogger = myLogger;
    }

    /**
     * Get integer array
     * @return integer array
     */
    public Integer[] getMyIntArray() {
        Arrays.fill(myIntArray, -1);
        return myIntArray;
    }

    /**
     * Set integer array
     * @param myIntArray array to store
     */
    public void setMyIntArray(Integer[] myIntArray) {
        this.myIntArray = myIntArray;
    }

    /**
     * Finalize method for ADT Design norms
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable
    {
        System.out.println("From Finalize Method");
    }

    /**
     * Checks for need to update size
     * @param mySet integer array to update size of
     * @param currentSize its current size
     * @return new size
     */
    @Override
    public int ValidateSize(Integer[] mySet, int currentSize) {
        if (mySet.length >= currentSize){
            currentSize = currentSize + (currentSize / 2);
        }
        return currentSize;
    }

    /**
     * Set updated size to integer array
     * @param mySet integer array to update size of
     * @param currentSize new current size
     * @return updated array size
     */
    @Override
    public Integer[] UpdateSetSize(Integer[] mySet, int currentSize) {
        Integer[] myArray = new Integer[currentSize];
        Arrays.fill(myArray, -1);
        for (int i = 0; i < mySet.length; i++){
            if (i >= currentSize){
                break;
            }
            myArray[i] = mySet[i];
        }

        return myArray;
    }

    /**
     * Add input from file to array
     * @param mySet integer array
     * @param element input to insert
     * @param location position at which element
     *                 is to be insert
     */
    @Override
    public void AddElement(Integer[] mySet, int element, int location) {
        mySet[location] = element;
    }

    /**
     * To access instance of this class using Visitor
     * @param visitor this visitor instance
     */
    @Override
    public void Accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * For Debugging purpose
     * @return String format
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * For Object cloning
     * @return Return clone of this object
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        MyArray myArray = new MyArray();
        myArray.setMyIntArray(this.myIntArray);
        return myArray;
    }

}