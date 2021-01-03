package arrayvisitors.adt;

import arrayvisitors.visitors.Element;
import arrayvisitors.visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList implements MyArrayListI, Element {
    public List<MyArray> mainSet = new ArrayList<MyArray>();

    /**
     * To access instance of this class using Visitor
     * @param visitor this visitor instance
     */
    @Override
    public void Accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * Add MyArray objects to List
     * @param myArray myArray object
     */
    @Override
    public void add(MyArray myArray) {
        mainSet.add(myArray);
    }
}
