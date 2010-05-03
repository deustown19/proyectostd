package server.command;

public class Salir extends Command
{
	@Override
	public String command(CommandManager commandManager, String[] params)	{
			commandManager.setState(4);
		return "208 OK Adiós.";
	}
}
