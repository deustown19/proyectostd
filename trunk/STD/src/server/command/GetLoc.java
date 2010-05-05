package server.command;


import java.text.DecimalFormat;

import server.ClientRequest;
import server.GpsAccess;

public class GetLoc extends Command
{
	@Override
	public String command(ClientRequest cr, String[] params){
		String respuesta = "";
		String sLongitud = "";
		String sLatitud = "";
		if (cr.getState()==3){
			if (cr.isGps()){
				respuesta = "" + CRLF;
				DecimalFormat dec = new DecimalFormat("###.######");
				double longitud = (Math.random() * 180);
				double latitud = (Math.random() * 180);
				sLongitud = dec.format(longitud) + "N";
				sLatitud = dec.format(latitud) + "E";
			}else{
				String coordenadas;
				GpsAccess gps = new GpsAccess();
				gps.connect("127.0.0.1");
				gps.user();
				gps.pass();
				coordenadas = gps.getCoor("3053");
				sLongitud = coordenadas.split("-")[0];
				sLatitud = coordenadas.split("-")[1];
			}
			respuesta = "114 OK "+sLongitud + "-" + sLatitud + CRLF;
			cr.setState(2);
		}else{
			respuesta = "450 ERR Comando no válido" + CRLF;
		}
		return respuesta;
	}
	

}
