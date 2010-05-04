package server.command;

import server.ClientRequest;


public abstract class Command
{

	protected final static String CRLF = "\r\n";

	public abstract String command(ClientRequest cr, String[] params);
}
