package arrayvisitors.visitors;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.exception.ArrayVisitors;
import arrayvisitors.util.Results;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class MissingIntsVisitor implements Visitor{
    public static StringBuilder stringBuilder = new StringBuilder();
    public static StringBuilder stringBuilderSTDOut = new StringBuilder();
    public static int fileNumber = 1;
    private static Results missingintsout1;
    private static Results missingintsout2;

    /**
     * Print all missing integers from 00-99
     * @param set1 integer array
     * @param myArray MyArray object
     * @return array with all missing integers
     */
    private static Integer[] MissingInts(Integer[] set1, MyArray myArray) {
        stringBuilder = new StringBuilder();
        stringBuilderSTDOut = new StringBuilder();
        StringBuilder format = new StringBuilder();
        Set<Integer> setNew = new LinkedHashSet<>(Arrays.asList(set1));
        Integer[] outputArray = new Integer[99];
        Set<Integer> outputSet = new LinkedHashSet<>();

        for (int i = 0; i <= 99; i ++) {
            if (!setNew.contains(i)){
                outputSet.add(i);
            }
        }
        outputSet.toArray(outputArray);
        outputArray = myArray.UpdateSetSize(outputArray, outputSet.size());

        for (int value : outputArray){
            if (value == 0 || value == 1 || value == 2 || value == 3 || value == 4 || value == 5 || value == 6 || value == 7 || value == 8 || value == 9) {
                stringBuilder.append("0").append(value).append("\n");
                stringBuilderSTDOut.append("0").append(value).append(" ");
            } else {
                stringBuilder.append(value).append("\n");
                stringBuilderSTDOut.append(value).append(" ");
            }
        }

        int flag = getOutputStatus();

        if (flag == 1) {
            missingintsout1.addOutputToFile(getOutput());
            missingintsout1.printToConsole(format.append("Missing Ints File1: [ ").append(getOutputStdOut()).append(" ]"));
        } else {
            missingintsout2.addOutputToFile(getOutput());
            missingintsout2.printToConsole(format.append("Missing Ints File2: [ ").append(getOutputStdOut()).append(" ]"));
        }

        return outputArray;
    }

    /**
     * Set Results object for redirecting output
     * @param missingintsout1 output file 1
     * @param missingintsout2 output file 2
     */
    public static void setResults(Results missingintsout1, Results missingintsout2) {
        MissingIntsVisitor.missingintsout1 = missingintsout1;
        MissingIntsVisitor.missingintsout2 = missingintsout2;
    }

    /**
     * Display output
     * @return StringBuilder output
     */
    public static StringBuilder getOutput(){
        return stringBuilder;
    }

    /**
     * Display output to console
     * @return StringBuilder output
     */
    public static StringBuilder getOutputStdOut(){
        return stringBuilderSTDOut;
    }

    /**
     * Gets which file to write result to
     * @return file number;
     *          1 for output file1
     *          2 for output file2
     */
    public static int getOutputStatus(){
        return fileNumber++;
    }

    /**
     * visit method from Visitor call read function
     * @param myArray object of MyArray
     */
    @Override
    public void visit(MyArray myArray) {
        MissingInts(myArray.myIntArray, myArray);
    }

    /**
     * visit method from Visitor call read function
     * @param myArrayList object of MyArrayList
     */
    @Override
    public void visit(MyArrayList myArrayList) {
        try {
            throw new ArrayVisitors("UNDEFINED BEHAVIOUR!");
        } catch (ArrayVisitors e){
            e.printStackTrace();
            System.exit(0);
        }
    }
}
