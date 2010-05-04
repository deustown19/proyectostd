package server.command;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
						DecimalFormat dec = new DecimalFormat("###.######");
						double longitud = (Math.random() * 180);
						double latitud = (Math.random() * 180);
						String sLongitud = dec.format(longitud)+"N";
						String sLatitud = dec.format(latitud)+"N";	
						int valor = (int) Math.random()*100;
						Calendar calendario = new GregorianCalendar();
						String fecha =Integer.toString(calendario.get(Calendar.DAY_OF_MONTH)) + "/" + Integer.toString(calendario.get(Calendar.MONTH)) +"/"+Integer.toString(calendario.get(Calendar.YEAR));
						String hora= Integer.toString(calendario.get(Calendar.HOUR)) + ":"+Integer.toString(calendario.get(Calendar.MINUTE))+":"+Integer.toString(calendario.get(Calendar.SECOND));
						respuesta = "114 OK "+ fecha +";"+ hora +";"+sLongitud +"-"+sLatitud+";"+valor +CRLF;
						try {
							cr.getDbm().executeInsert("INSERT INTO historico (sensor_id,fecha,hora,latitud,longitud,valor) VALUES('"+params[0]+"','"+fecha+"','"+hora+"','"+latitud+"','"+longitud+"',"+valor+")");
						} catch (SQLException e) {
							e.printStackTrace();
						}
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
