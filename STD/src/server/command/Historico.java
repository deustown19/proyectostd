package server.command;

import java.sql.ResultSet;

import server.ClientRequest;

public class Historico extends Command
{
	@Override
	public String command(ClientRequest cr, String[] params){
		String respuesta = "";
		if (cr.getState()==2){
			if (params.length == 0) 
				respuesta = "415 ERR Falta el parámetro id_sensor" + CRLF;
			else if(cr.getSensores().containsKey(params[0])){
				try{

					ResultSet rs = cr.getDbm().executeSelect("SELECT * FROM historico WHERE sensor_id='" + params[0]+"'");
					respuesta = "113 OK Lista de medidas." + CRLF;
					while(rs.next()){
						respuesta += rs.getString("fecha") + ";" + rs.getString("hora") + ";"+ rs.getString("latitud") + "-" + rs.getString("longitud") + ";" + rs.getInt("valor")+  CRLF;
					}
					rs.close();
					respuesta += "212 OK Lista Finalizada.";
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			else
				respuesta = "414 ERR Sensor desconocido." + CRLF;
		}else{
			respuesta = "450 ERR Comando no válido." + CRLF;
		}
		return respuesta;
	}
}
