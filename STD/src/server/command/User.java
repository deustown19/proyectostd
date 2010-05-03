package server.command;

public class User extends Command
{
	@Override
	public String command(CommandManager commandManager, String[] params)	{
		String respuesta = "";
		if (commandManager.getState()==0)
		{	
			if (params.length == 0) 
				respuesta = "403 ERR Falta el usuario" + CRLF;
			else{
				commandManager.setUser(params[0]);
				commandManager.setState(1);
				respuesta =  "201 OK Bienvenido " + commandManager.getUser() + CRLF;
			}
		} else{
			respuesta = "450 ERR Comando no válido" + CRLF;
		}
		return respuesta;
	}
}
