package server.command;

import server.ClientRequest;

public class OffGPS extends Command
{
	@Override
	public String command(ClientRequest cr, String[] params){
		String respuesta = "";
		if (cr.getState()==2){
			if(cr.isGps()){
				cr.setGps(true);
				respuesta = "206 OK GPS desactivado." + CRLF;
			}
			else
				respuesta = "420 ERR GPS en estado OFF" + CRLF;
		}else{
			respuesta = "450 ERR Comando no válido" + CRLF;
		}
		return respuesta;
	}
}
