package server.command;

import java.sql.ResultSet;

public class Historico extends Command
{
	@Override
	public String command(CommandManager commandManager, String[] params)	{
		String respuesta = "";
		if (commandManager.getState()==2){
			if (params.length == 0) 
				return "415 ERR Falta el parámetro id_sensor" + CRLF;
			else{
				try{

					ResultSet rs = commandManager.getDbm().executeSelect("SELECT * FROM historico WHERE sensor_id='" + params[0]+"'");
					respuesta = "113 OK Lista de medidas." + CRLF;
					while(rs.next()){
						respuesta += rs.getString("id") + ";" + rs.getString("nombre") + ";"+ rs.getString("estado") + CRLF;
					}
					rs.close();
					respuesta += "212 OK Lista Finalizada.";
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}else{
			respuesta = "450 ERR Comando no válido" + CRLF;
		}
		return respuesta;
	}
}
