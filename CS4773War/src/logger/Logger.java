package logger;

/**
 * The logging utility of the game that prints to console
 */
public class Logger {
	/**
	 * Creates a logger object and prints the variation being played
	 * @param initialLogMessage			The variation of war
	 */
	public Logger(String initialLogMessage)
	{
		System.out.println(initialLogMessage);
	}

	/**
	 * 
	 * @param formatString			A string containing formats i.e "%s" or "%d"
	 * @param varArgs				A variable number of arguments containing the format variables			
	 */
	public void logFormattedMessage(String formatString, Object... varArgs)
	{
		System.out.println(String.format(formatString, varArgs));
	}


	/**
	 * Prints a simple string to console that does not need formatting
	 * @param messageToLog			The message needing to be printed
	 */
	public void logMessage(String messageToLog) {
		System.out.println(messageToLog);
	}

}
