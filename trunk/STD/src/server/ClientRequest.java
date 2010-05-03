package server;

import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;

import server.command.CommandManager;
import util.SocketManager;

public class ClientRequest implements Runnable
{
	private SocketManager sockManager;
	private CommandManager commandManager;

	public ClientRequest(SocketManager sm)
	{
		this.sockManager = sm;		
		commandManager = new CommandManager();
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
				sockManager.escribir(commandManager.command(entry));
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
}
