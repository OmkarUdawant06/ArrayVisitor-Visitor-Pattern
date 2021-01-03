package arrayvisitors.visitors;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.exception.ArrayVisitors;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class CommonIntsVisitor implements Visitor{
    public static StringBuilder stringBuilder = new StringBuilder();
    public static StringBuilder stringBuilderStdOut = new StringBuilder();

    /**
     * Returns only common Integers from array 1 & array 2
     * @param set1 array from input file1
     * @param set2 array from input file2
     * @return new array with common Integers
     */
    private static Integer[] CommonInts(Integer[] set1, Integer[] set2) {
        stringBuilder = new StringBuilder();
        stringBuilderStdOut = new StringBuilder();

        MyArray myArray = new MyArray();
        Set<Integer> setNew = new LinkedHashSet<>();
        Set<Integer> setNew1 = new LinkedHashSet<>(Arrays.asList(set1));
        Set<Integer> setNew2 = new LinkedHashSet<>(Arrays.asList(set2));
        Integer[] outputArray = new Integer[set1.length];

        for (Integer itr : setNew1) {
            if(setNew2.contains(itr)) {
                setNew.add(itr);
            }
        }
        setNew.toArray(outputArray);
        outputArray = myArray.UpdateSetSize(outputArray,setNew.size());

        stringBuilderStdOut.append("Common Ints: [ ");
        for (int value : outputArray){
            if (value == 0 || value == 1 || value == 2 || value == 3 || value == 4 || value == 5 || value == 6 || value == 7 || value == 8 || value == 9) {
                stringBuilder.append("0").append(value).append("\n");
                stringBuilderStdOut.append("0").append(value).append(" ");
            } else {
                stringBuilder.append(value).append("\n");
                stringBuilderStdOut.append(value).append(" ");
            }
        }
        stringBuilderStdOut.append(" ]");
        return outputArray;
    }

    /**
     * Display output
     * @return StringBuilder output
     */
    public static StringBuilder getOutput(){
        return stringBuilder;
    }

    /**
     * Display output
     * @return StringBuilder output
     */
    public static StringBuilder getOutputStdOut(){
        return stringBuilderStdOut;
    }

    /**
     * visit method from Visitor call read function
     * @param myArray object of MyArray
     */
    @Override
    public void visit(MyArray myArray) {
        try {
            throw new ArrayVisitors("UNDEFINED BEHAVIOUR!");
        } catch (ArrayVisitors e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * visit method from Visitor call read function
     * @param myArrayList object of MyArrayList
     */
    @Override
    public void visit(MyArrayList myArrayList) {
        MyArray myArray, myArray1;
        myArray = myArrayList.mainSet.get(0);
        myArray1 = myArrayList.mainSet.get(1);
        CommonInts(myArray.myIntArray,myArray1.myIntArray);
    }
}
