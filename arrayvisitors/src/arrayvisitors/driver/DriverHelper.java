package arrayvisitors.driver;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.Results;
import arrayvisitors.visitors.CommonIntsVisitor;
import arrayvisitors.visitors.MissingIntsVisitor;
import arrayvisitors.visitors.PopulateMyArrayVisitor;
import arrayvisitors.visitors.Visitor;
import java.io.IOException;

public class DriverHelper {

    /**
     * Gets input from Driver and makes required call to
     * Visitor pattern
     * @param commonintsout Output file for storing Common Ints
     * @param missingintsout1 Output file for storing Missing Ints
     * @param missingintsout2 Output file for storing Missing Ints
     * @param args String commandline arguments
     */
    public void processInput(Results commonintsout, Results missingintsout1, Results missingintsout2, String[] args) {

        MyLogger myLogger = MyLogger.getInstance();
        Visitor populateMyArrayVisitor;
        Visitor commonIntsVisitor = new CommonIntsVisitor();
        Visitor missingIntsVisitor = new MissingIntsVisitor();
        try {
            myLogger.setDebugValue(Integer.parseInt(args[5]));

            myLogger.writeMessage("CALL TO MYARRAY CONSTRUCTOR\n", MyLogger.DebugLevel.CONSTRUCTOR);
            MyArray myArray = new MyArray();
            myLogger.writeMessage("CALL TO MYARRAY CONSTRUCTOR\n", MyLogger.DebugLevel.CONSTRUCTOR);
            MyArray myArray1 = new MyArray();
            myLogger.writeMessage("CALL TO MYARRAYLIST CONSTRUCTOR\n", MyLogger.DebugLevel.CONSTRUCTOR);
            MyArrayList myArrayList = new MyArrayList();

            myLogger.writeMessage("READING INPUT FILE 1...\n", MyLogger.DebugLevel.FILE_PROCESSOR);
            myLogger.writeMessage("PROCESSING INPUT FILE 1...\n", MyLogger.DebugLevel.POPULATEMYARRAYVISITOR);
            populateMyArrayVisitor = new PopulateMyArrayVisitor(args[0]);

            myLogger.writeMessage("STORING DATA FROM INPUT FILE 1!\n", MyLogger.DebugLevel.MYARRAY);

            populateMyArrayVisitor.visit(myArray);
            MissingIntsVisitor.setResults(missingintsout1,missingintsout2);

            myLogger.writeMessage("PROCESSING MISSING INTS ARRAY...\n", MyLogger.DebugLevel.VISITOR);
            myArray.Accept(missingIntsVisitor);

            myLogger.writeMessage("ADDING MyArray OBJECT TO MyArrayList...\n", MyLogger.DebugLevel.MYARRAYLIST);
            myArrayList.add(myArray);

            myLogger.writeMessage("READING INPUT FILE 1...\n", MyLogger.DebugLevel.FILE_PROCESSOR);
            myLogger.writeMessage("PROCESSING INPUT FILE 2...\n", MyLogger.DebugLevel.POPULATEMYARRAYVISITOR);
            populateMyArrayVisitor = new PopulateMyArrayVisitor(args[1]);

            myLogger.writeMessage("STORING DATA FROM INPUT FILE 2!\n", MyLogger.DebugLevel.MYARRAY);
            populateMyArrayVisitor.visit(myArray1);

            myLogger.writeMessage("PROCESSING MISSING INTS ARRAY...\n", MyLogger.DebugLevel.VISITOR);
            myArray1.Accept(missingIntsVisitor);

            myLogger.writeMessage("ADDING MyArray OBJECT TO MyArrayList...\n", MyLogger.DebugLevel.MYARRAYLIST);
            myArrayList.add(myArray1);

            myLogger.writeMessage("PROCESSING COMMON INTS ARRAY...\n", MyLogger.DebugLevel.VISITOR);
            myArrayList.Accept(commonIntsVisitor);

            commonintsout.addOutputToFile(CommonIntsVisitor.getOutput());
            commonintsout.printToConsole(CommonIntsVisitor.getOutputStdOut());

            myLogger.writeMessage("PROGRAM TERMINATED SUCCESSFULLY!\n", MyLogger.DebugLevel.SUCCESS);

        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            commonintsout.closeFile();
            missingintsout1.closeFile();
            missingintsout2.closeFile();
        }
    }
}