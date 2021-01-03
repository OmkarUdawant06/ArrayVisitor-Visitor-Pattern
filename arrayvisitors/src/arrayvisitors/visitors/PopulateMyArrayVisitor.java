package arrayvisitors.visitors;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.exception.ArrayVisitors;
import arrayvisitors.util.FileProcessor;
import java.io.IOException;
import java.util.Arrays;

public class PopulateMyArrayVisitor implements Visitor{
    private final String fileName;
    private int fileNum = 0;
    int currentSize = 10;

    /**
     * Constructor to accept filename and object of MyArrayList
     * @param fileName name of file to fetch input from
     *                    instance of MyArray
     */
    public PopulateMyArrayVisitor(String fileName){
        this.fileName = fileName;
    }

    /**
     * Read input from file and store in myArray's Integer[]
     * @param myArray object of MyArray
     */
    private void ReadArrayList(MyArray myArray){
        String pattern = "[0-9]+";
        String pattern2 = "[0-9][0-9]";
        String words;
        myArray.myIntArray = myArray.getMyIntArray();
        int size = 0, i = 0;
        try{
            FileProcessor input = new FileProcessor(fileName);

            /*
             * Checks if file is empty */
            if (input.poll() == null) {
                throw new ArrayVisitors("INPUT FILE IS EMPTY!");
            }

            input = new FileProcessor(fileName);
            while ((words = input.poll()) != null) {
                if (words.isEmpty()) {
                    throw new ArrayVisitors("PARSED LINE IS EMPTY!");
                }

                if (words.matches(pattern)) {
                    if (words.matches(pattern2)) {
                        fileNum = Integer.parseInt(words);
                    } else {
                        throw new ArrayVisitors("INTEGER HAS TO BE BETWEEN 00-99");
                    }
                } else {
                    throw new ArrayVisitors("STRING HAS TO BE IN NUMBER FORMAT AND POSITIVE INTEGER!");
                }

                if (!contains(myArray.myIntArray,fileNum) && (size <= (currentSize + 1))) {
                    if (size >= currentSize) {
                        currentSize = myArray.ValidateSize(myArray.myIntArray, currentSize);
                        myArray.myIntArray = myArray.UpdateSetSize(myArray.myIntArray, currentSize);
                    }
                    myArray.AddElement(myArray.myIntArray,fileNum,i);
                    size ++;
                    i ++;
                }
            }

            myArray.myIntArray = myArray.UpdateSetSize(myArray.myIntArray, size);
            myArray.setMyIntArray(myArray.myIntArray);

            input.close();
        }catch(RuntimeException | IOException | ArrayVisitors e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * visit method from Visitor call read function
     * @param myArray object of MyArray
     */
    @Override
    public void visit(MyArray myArray) {
        ReadArrayList(myArray);
    }

    /**
     * visit method from Visitor throws custom exception
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

    /**
     * check if array contains element
     * to avoid duplicate elements
     * @return boolean true if contains element
     *         false if no element found
     */
    public static boolean contains(final Integer[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }
}
