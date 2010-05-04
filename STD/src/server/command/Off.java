package server.command;

import java.util.TreeMap;

import server.ClientRequest;
import server.Sensor;

public class Off extends Command
{
	@Override
	public String command(ClientRequest cr, String[] params){
		String respuesta = "";
		if (cr.getState()==2){
			String sensorID = params[0];
			TreeMap<String, Sensor> sensoresTree = cr.getSensores();
			if(sensoresTree.containsKey(sensorID)){
				Sensor sensor = sensoresTree.get(sensorID);
				if(sensor.getEstado().equals("ON")){
					sensor.setEstado("OFF");
					respuesta = "204 OK Sensor desactivado." + CRLF;
				}else
					respuesta = "419 ERR Sensor en estado OFF." + CRLF;
			}else
				respuesta = "417 ERR Sensor no existe." + CRLF;
		}else{
			respuesta = "450 ERR Comando no válido" + CRLF;
		}
		return respuesta;
	}
}
