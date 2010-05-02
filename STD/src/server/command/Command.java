package server.command;

import util.DataBaseManager;
import util.DataBaseManager.DBType;

public abstract class Command
{
	protected final static String CRLF = "\r\n";
	protected static boolean init = false;
	
	protected static DataBaseManager dbm;
	protected static int state;
	protected static String user;
	protected static boolean gps;
	
	public Command()
	{
		if (!init)
		{
			dbm = new DataBaseManager(DBType.SQLITE, "db/database.db");
			state = 0;
			user = null;
			gps = false;
			init = true;
		}
	}
	
	public abstract String command(String[] params);
}
