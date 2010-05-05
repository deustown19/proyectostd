package gpsServer;

import gpsServer.command.Command;
import gpsServer.command.GetCoor;
import gpsServer.command.Pass;
import gpsServer.command.Salir;
import gpsServer.command.User;

import java.io.IOException;
import java.util.TreeMap;
import java.util.AbstractMap.SimpleEntry;


import util.DataBaseManager;
import util.SocketManager;
import util.DataBaseManager.DBType;

public class ClientRequest implements Runnable
{
	private SocketManager sockManager;
	
	public SocketManager getSockManager() {
		return sockManager;
	}
	
	private  String user;
	private DataBaseManager dbm = null;
	private int state = 0;

	private TreeMap<String, Command> comandos;

	public ClientRequest(SocketManager sm)
	{
		this.sockManager = sm;
		state = 0;
		user = null;
	

		dbm = new DataBaseManager(DBType.SQLITE, "db/database.db");

		comandos = new TreeMap<String, Command>();
		comandos.put("USER", new User());
		comandos.put("PASS", new Pass());
		comandos.put("GET_COOR", new GetCoor());
		comandos.put("SALIR", new Salir());
		
	}
	
	

	


	@Override
	public void run()
	{
		boolean terminar = false;
		SimpleEntry<String, String[]> entry;
		
		try
		{
			while (!terminar)
			{
				entry = commandParser(sockManager.leer());
				sockManager.escribir(command(entry));
				if ("SALIR".equals(entry.getKey()))
					terminar = true;
			}
			
			System.out.println("Cliente fuera");
			sockManager.cerrarSocket();
			sockManager.cerrarStreams();
		}
		catch (IOException ioe)
		{
			System.err.println(ioe);
		}
	}

	/**
	 * @param s
	 *            String comando recibido
	 * @return SimpleEntry<String, String[]> comando y parámetros separados
	 */
	private SimpleEntry<String, String[]> commandParser(String s)
	{
		String[] comando = s.trim().split(" ");
		String[] params = new String[comando.length - 1];
		for (int i=1; i<comando.length; i++)
			params[i-1] = comando[i];
		return new SimpleEntry<String, String[]>(comando[0].toUpperCase(), params);
	}
	
	public String command( SimpleEntry<String, String[]> comando){
		String respuesta;
		if (comandos.containsKey(comando.getKey()))
			respuesta = comandos.get(comando.getKey()).command(this, comando.getValue());
		else respuesta = "450 ERR Comando no válido \r\n";
		return respuesta;
	}
	
	public DataBaseManager getDbm() {
		return dbm;
	}

	public void setDbm(DataBaseManager dbm) {
		this.dbm = dbm;
	}
	


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
