package server.command;

import java.sql.ResultSet;

public class ListSensor extends Command
{
	@Override
	public String command(CommandManager commandManager, String[] params)	{
		String respuesta = "";
		if (commandManager.getState()==2){
			try{
				respuesta = "112 OK Lista de sensores." + CRLF;
				ResultSet rs = commandManager.getDbm().executeSelect("SELECT * FROM sensor");			
				while(rs.next()){
					respuesta += rs.getString("id") + ";" + rs.getString("nombre") + ";"+ rs.getString("estado") + CRLF;
				}
				rs.close();
				respuesta += "212 OK Lista Finalizada.";
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			respuesta = "450 ERR Comando no válido" + CRLF;
		}
		return respuesta;
	}
}
