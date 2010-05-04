package server.command;

import server.ClientRequest;

public class OnGPS extends Command
{
	@Override
	public String command(ClientRequest cr, String[] params){
		String respuesta = "";
		if (cr.getState()==2){
			if(cr.isGps())
				respuesta = "419 ERR GPS en estado ON." + CRLF;
			else{
				cr.setGps(true);
				respuesta = "205 OK GPS activado." + CRLF;
			}				
		}else{
			respuesta = "450 ERR Comando no válido" + CRLF;
		}
		return respuesta;
	}
}
