package logger;

public class Logger {
	public Logger(String initialLogMessage)
	{
		System.out.println(initialLogMessage);
	}
	public void logMessage(String messageToLog, Object varArgs)
	{
        	System.out.println(String.format(fmt, varArgs);
		//System.out.println(messageToLog);
	}
}
