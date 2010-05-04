package server.command;

import java.util.TreeMap;

import server.ClientRequest;
import server.Sensor;

public class ListSensor extends Command
{
	@Override
	public String command(ClientRequest cr, String[] params){
		String respuesta = "";
		if (cr.getState()==2){
			try{
				respuesta = "112 OK Lista de sensores." + CRLF;
				/*ResultSet rs = cr.getDbm().executeSelect("SELECT * FROM sensor");			
				while(rs.next()){
					respuesta += rs.getString("id") + ";" + rs.getString("nombre") + ";"+ rs.getString("estado") + CRLF;
				}
				rs.close();*/
				TreeMap<String, Sensor> sensoresTree = cr.getSensores();
				Sensor[] sensores = new Sensor[sensoresTree.size()];
				sensoresTree.values().toArray(sensores);
				for(int i=0;i<sensores.length;i++)
				{
					respuesta += sensores[i].getId() + ";" + sensores[i].getDescripcion() + ";"+ sensores[i].getEstado() + CRLF;
				}
				respuesta += "212 OK Lista Finalizada.";
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			respuesta = "450 ERR Comando no válido" + CRLF;
		}
		return respuesta;
	}
}
