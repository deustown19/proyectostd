package server.command;


public abstract class Command
{

	protected final static String CRLF = "\r\n";

	public abstract String command(CommandManager commandManager, String[] params);
}
