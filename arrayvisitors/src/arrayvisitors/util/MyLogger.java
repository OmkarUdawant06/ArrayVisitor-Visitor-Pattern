package arrayvisitors.util;

public class MyLogger {

    private static MyLogger myLogger = new MyLogger();

    private MyLogger(){}

    public static MyLogger getInstance(){
        return myLogger;
    }

    /**
     * Enum stores Debug point required for assignment
     */
    public static enum DebugLevel {
        CONSTRUCTOR,
        FILE_PROCESSOR,
        MYARRAYLIST,
        VISITOR,
        POPULATEMYARRAYVISITOR,
        MYARRAY,
        SUCCESS,
        NONE;
    };

    private DebugLevel debugLevel;

    /**
     * Set Debug value
     * @param levelIn value of DebugLevel to set
     */
    public void setDebugValue (int levelIn) {
        switch (levelIn) {
            case 1: debugLevel = DebugLevel.CONSTRUCTOR;
                    break;
            case 2: debugLevel = DebugLevel.FILE_PROCESSOR;
                    break;
            case 3: debugLevel = DebugLevel.VISITOR;
                    break;
            case 4: debugLevel = DebugLevel.POPULATEMYARRAYVISITOR;
                    break;
            case 5: debugLevel = DebugLevel.MYARRAY;
                    break;
            case 6: debugLevel = DebugLevel.MYARRAYLIST;
                break;
            case 7: debugLevel = DebugLevel.SUCCESS;
                break;
            default: debugLevel = DebugLevel.NONE;
                    break;
        }
    }

    /**
     * Set the Debug level
     * @param levelIn Debug level value
     */
    public DebugLevel setDebugValue (DebugLevel levelIn) {
        debugLevel = levelIn;
        return debugLevel;
    }

    /**
     * Prints the message
     * @param message Message to be printed
     * @param levelIn Debug level
     */
    public void writeMessage (String message  , DebugLevel levelIn ) {
        if (levelIn == debugLevel)
            System.out.println(message);
    }

    /**
     * Print for debugging
     * @return The debugging level set to
     */
    public String toString() {
        return "The debug level has been set to the following " + debugLevel;
    }
}
