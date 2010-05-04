package server.command;

import java.util.TreeMap;

import server.ClientRequest;
import server.Sensor;

public class On extends Command
{
	@Override
	public String command(ClientRequest cr, String[] params){
		String respuesta = "";
		if (cr.getState()==2){
			String sensorID = params[0];
			TreeMap<String, Sensor> sensoresTree = cr.getSensores();
			if(sensoresTree.containsKey(sensorID)){
				Sensor sensor = sensoresTree.get(sensorID);
				if(sensor.getEstado().equals("OFF")){
					sensor.setEstado("ON");
					respuesta = "203 OK Sensor activo." + CRLF;
				}else
					respuesta = "418 ERR Sensor en estado ON." + CRLF;
			}else
				respuesta = "417 ERR Sensor no existe." + CRLF;
		}else{
			respuesta = "450 ERR Comando no válido" + CRLF;
		}
		return respuesta;
	}
}
