package gpsServer.command;

import java.text.DecimalFormat;

import gpsServer.ClientRequest;

public class GetCoor extends Command {

	@Override
	public String command(ClientRequest cr, String[] params) {
		String respuesta = "";
		if (cr.getState()==2){
			if (params.length == 0) {
				respuesta =  "418 ERR Falta parámetro cell_id." + CRLF;
			}else if(params[0]=="3053"){
				DecimalFormat dec = new DecimalFormat("###.######");
				double longitud = (Math.random() * 180);
				double latitud = (Math.random() * 180);
				respuesta = "114 OK "+dec.format(longitud) + "N-" +  dec.format(latitud) + "E" + CRLF;
			}else
				respuesta = "417 ERR Celda desconocida." + CRLF;
		}else respuesta = "450 ERR Comando no válido." + CRLF;	
		return respuesta;
	}

}
