package logger;

public class Logger {
	public Logger(String initialLogMessage)
	{
		System.out.println(initialLogMessage);
	}
	public void logFormattedMessage(String formatString, Object... varArgs)
	{
        	System.out.println(String.format(formatString, varArgs));
	}
	public void logMessage(String messageToLog) {
		System.out.println(messageToLog);
	}
	
}
