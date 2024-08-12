
package demo;

public class Logger {
	
	private static Logger instance;

    private Logger() {
    }
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    public void log(String message) {
        System.out.println("Logging message: " + message);
    }

	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
        logger.log("This is a log message.");

        Logger anotherLogger = Logger.getInstance();
        anotherLogger.log("This is another log message.");

        System.out.println("Are both loggers the same instance? " + (logger == anotherLogger));
	}

}

