package server.command;

import server.ClientRequest;

public class GetValAct extends Command
{
	@Override
	public String command(ClientRequest cr, String[] params){
		String respuesta = "";
		if (cr.getState()==2){
			if (params.length>0){				
				if(cr.getSensores().containsKey(params[0])){
					if(cr.getSensores().get(params[0]).isOn()){
						
						respuesta = "" +CRLF;
					}else
						respuesta = "416 ERR Sensor en OFF" + CRLF;
				}else
					respuesta = "414 Sensor desconocido." + CRLF;
			}else
				respuesta = "415 Falta parámetro id_sensor" + CRLF;
		}else{
			respuesta = "450 ERR Comando no válido" + CRLF;
		}
		return respuesta;
	}
}
