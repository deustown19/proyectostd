package gpsServer.command;

import gpsServer.ClientRequest;

public class Salir extends Command
{
	@Override
	public String command(ClientRequest cr, String[] params){
			cr.setState(4);
		return "208 OK Adiós.";
	}
}
