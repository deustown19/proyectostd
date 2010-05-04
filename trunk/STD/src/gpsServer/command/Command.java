package gpsServer.command;

import gpsServer.ClientRequest;


public abstract class Command
{

	protected final static String CRLF = "\r\n";

	public abstract String command(ClientRequest clientRequest, String[] params);
}
