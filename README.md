# CSX42: Assignment 3
## Name: Omkar Udawant

Redeem 1 slack days
-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.


Note: build.xml is present in [arrayvisitors/src](arrayvisitors/src/) folder.

## Instruction to clean:

```commandline
ant -buildfile arrayvisitors/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

## Instructions to compile:

```commandline
ant -buildfile arrayvisitors/src/build.xml all
```
The above command compiles your code and generates .class files inside the BUILD folder.

## Instructions to run:

```commandline
ant -buildfile arrayvisitors/src/build.xml run -Darg1="input1.txt" -Darg2="input2.txt" -Darg3="commonInts.txt" -Darg4="missingInts1.txt" -Darg5="missingInts2.txt" -Darg6=<Int value(between 0-7)>
```
Note: Arguments accept the absolute path of the files.


## Description:
Integer array is implemented as internal array. Initial size is set to 10. As elements added reach max size, size is increased by 50% of its current capacity.
Visitor is an interface which contains overloaded methods visit. One accepts MyArray object whereas other method accepts object of MyArrayList.
Element contains Accept method which takes a visitor as argument. 
MyArrayList stores object of MyArray which holds reference to integer arrays and its methods.
MissingInts visitor takes input array from one file at a time. It searches for missing numbers from 00-99 in current integer array. Then the output of each array is redirected to console as well as output file.
CommonInts visitor takes object stored in MyArrayList. It compares both arrays and stores common integers in new array.
Driver class accepts 6 commandline arguments. PopulateMyArrayVisitor creates necessary FileProcessor object to access two input files.
Apart from Driver class, DriverHelper class is simple concise code which makes call to visitors using MyArray and MyArrayList objects.
Results class object created to write the results of Missing Integers and Common Integers to respective output files.

MyLogger class used to debug the program: 
`Case 0: NONE`
`Case 1: CONSTRUCTOR (To check if Constructors are called appropriately)`
`Case 2: FILE_PROCESSOR (To check if FileProcessor is executing)`
`Case 3: VISITOR (To check if Visitor MissingInts and CommonInts are working)`
`Case 4: POPULATEMYARRAYVISITOR (To check if Visitor Populate array fucntions as intended)`
`Case 5: MYARRAY (To check if MyArray is executing)`
`Case 6: MYARRAYLIST (To check if MyArray object are added to MyArrayList)`
`Case 7: SUCCESS (To check if program executes Successfully)`

Exception handling done to trace appropriate errors. Code is well commented for better understanding of function's purpose.
Created class for custom Exception handling called ArrayVisitors.

Data Structure used:    `ArrayList to store objects of MyArray.`
                        `Integer array with initial capacity of 10. It store numbers from 00-99.`

MyArray: Integer[] is used. Its time complexity for insertion is O(1). When size increased by 50%, time complexity changes by O(n).
MyArrayList: ArrayList's time Complexity for insertion is O(1).

## Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 07/23/2020