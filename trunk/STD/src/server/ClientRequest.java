package server;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.TreeMap;
import java.util.AbstractMap.SimpleEntry;

import server.command.Command;
import server.command.GetFoto;
import server.command.GetLoc;
import server.command.GetValAct;
import server.command.Historico;
import server.command.ListSensor;
import server.command.Off;
import server.command.OffGPS;
import server.command.On;
import server.command.OnGPS;
import server.command.Pass;
import server.command.Salir;
import server.command.User;
import util.DataBaseManager;
import util.SocketManager;
import util.DataBaseManager.DBType;

public class ClientRequest implements Runnable
{
	private SocketManager sockManager;
	
	public SocketManager getSockManager() {
		return sockManager;
	}

	private  int state;
	private  String user;
	private  boolean gps;
	private DataBaseManager dbm = null;


	private TreeMap<String, Command> comandos;
	private TreeMap<String, Sensor> sensores;

	public ClientRequest(SocketManager sm)
	{
		this.sockManager = sm;		
		state = 0;
		user = null;
		gps = false;	

		dbm = new DataBaseManager(DBType.SQLITE, "db/database.db");

		comandos = new TreeMap<String, Command>();
		comandos.put("USER", new User());
		comandos.put("PASS", new Pass());
		comandos.put("LISTSENSOR", new ListSensor());
		comandos.put("HISTORICO", new Historico());
		comandos.put("ON", new On());
		comandos.put("OFF", new Off());
		comandos.put("ONGPS", new OnGPS());
		comandos.put("OFFGPS", new OffGPS());
		comandos.put("GET_VALACT", new GetValAct());
		comandos.put("GET_FOTO", new GetFoto());
		comandos.put("GET_LOC", new GetLoc());
		comandos.put("SALIR", new Salir());
		
		cargarSensores();
	}
	
	
	private void cargarSensores(){
		sensores = new TreeMap<String, Sensor>();
		try{
			ResultSet rs = dbm.executeSelect("SELECT * FROM sensor");			
			while(rs.next()){
				sensores.put(rs.getString("id") , new Sensor(rs.getString("id") ,rs.getString("nombre"),rs.getString("estado")));
			}
			rs.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	public TreeMap<String, Sensor> getSensores() {
		return sensores;
	}


	public void setSensores(TreeMap<String, Sensor> sensores) {
		this.sensores = sensores;
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

	public boolean isGps() {
		return gps;
	}

	public void setGps(boolean gps) {
		this.gps = gps;
	}
}
