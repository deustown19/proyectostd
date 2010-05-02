package server;

import java.io.IOException;
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
import util.SocketManager;

public class ClientRequest implements Runnable
{
	private SocketManager sockManager;
	private TreeMap<String, Command> comandos;

	public ClientRequest(SocketManager sm)
	{
		this.sockManager = sm;
		
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
	
	@Override
	public void run()
	{
		boolean terminar = false;
		SimpleEntry<String, String[]> entry;
		
		try
		{
			while (!terminar)
			{
				entry = commandParser(sockManager.leer().toUpperCase());
				sockManager.escribir(comandos.get(entry.getKey()).command(entry.getValue()));
				if ("SALIR".equals(entry.getKey()))
					terminar = true;
				/*switch (Integer.valueOf(comando[0]))
				{
					case 0:
						if (comando[0].toUpperCase().equals("USER"))
						{
							try
							{
								usuario = comando[1];
								sockManager.escribir("201 OK Bienvenido " + usuario + CRLF);
								estado = 1;
							}
							catch (ArrayIndexOutOfBoundsException e)
							{// No ha introducido el nombre de usuario.
								sockManager.escribir("401 ERR Falta el nombre de usuario" + CRLF);
							}
						}
						else if (comando[0].toUpperCase().equals("SALIR"))
						{
							estado = 4;
						}
						else
						{
							sockManager.escribir("450 ERR Comando no válido" + CRLF);
						}
						break;

					case 1:
						if (comando[0].toUpperCase().equals("PASS"))
						{
							try
							{
								if (usuario.equals("user") && comando[1].equals("pass"))
								{
									sockManager.escribir("202 OK Bienvenido al sistema" + CRLF);
									estado = 2;
								}
								else
								{
									sockManager.escribir("402 ERR La clave es incorrecta. Introduzca usuario" + CRLF);
									estado = 0;
								}

							}
							catch (ArrayIndexOutOfBoundsException e)
							{// No ha introducido la clave
								sockManager.escribir("403 ERR Falta la clave" + CRLF);
							}
						}
						else if (comando[0].toUpperCase().equals("SALIR"))
						{
							estado = 4;
						}
						else
						{
							sockManager.escribir("450 ERR Comando no válido" + CRLF);
						}
						break;

					case 2:
						// TO//DO
					case 3:
						// TO//DO
					default:
						estado = 4;
				}*/
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
		return new SimpleEntry<String, String[]>(comando[0], params);
	}
}
