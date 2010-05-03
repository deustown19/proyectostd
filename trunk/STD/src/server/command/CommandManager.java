package server.command;

import java.util.TreeMap;
import java.util.AbstractMap.SimpleEntry;

import util.DataBaseManager;
import util.DataBaseManager.DBType;

public class CommandManager {
	protected  int state;
	protected  String user;
	protected  boolean gps;
	protected DataBaseManager dbm = null;


	private TreeMap<String, Command> comandos;
	
	public CommandManager(){
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
	}
	
	
	public DataBaseManager getDbm() {
		return dbm;
	}

	public void setDbm(DataBaseManager dbm) {
		this.dbm = dbm;
	}
	
	public String command( SimpleEntry<String, String[]> comando){
		String respuesta;
		if (comandos.containsKey(comando.getKey()))
			respuesta = comandos.get(comando.getKey()).command(this, comando.getValue());
		else respuesta = "450 ERR Comando no válido \r\n";
		return respuesta;
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
