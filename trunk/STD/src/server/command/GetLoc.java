package server.command;

public class GetLoc extends Command
{
	@Override
	public String command(CommandManager commandManager, String[] params)	{
		String respuesta = "";
		if (commandManager.getState()==3){
		
		}else{
			respuesta = "450 ERR Comando no válido" + CRLF;
		}
		return respuesta;
	}
}
