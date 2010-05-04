package server.command;


import java.text.DecimalFormat;

import server.ClientRequest;

public class GetLoc extends Command
{
	@Override
	public String command(ClientRequest cr, String[] params){
		String respuesta = "";
		if (cr.getState()==3){
			respuesta = "" + CRLF;
			DecimalFormat dec = new DecimalFormat("###.######");
			double longitud = (Math.random() * 180);
			double latitud = (Math.random() * 180);
			respuesta = "114 OK "+dec.format(longitud) + "N-" +  dec.format(latitud) + "E" + CRLF;
			cr.setState(2);
		}else{
			respuesta = "450 ERR Comando no válido" + CRLF;
		}
		return respuesta;
	}
	

}
