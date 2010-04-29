package server;

import java.io.IOException;

import util.SocketManager;

public class ClientRequest implements Runnable
{

	final static String CRLF = "\r\n";
	String usuario;
	SocketManager sockManager;

	public ClientRequest(SocketManager sm)
	{
		this.sockManager = sm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		try
		{
			String[] comando;
			int estado = 0;
			while (estado < 4)
			{
				comando = commandParser(sockManager.Leer());

				switch (estado)
				{
					case 0:
						if (comando[0].toUpperCase().equals("USER"))
						{
							try
							{
								usuario = comando[1];
								sockManager.Escribir("201 OK Bienvenido " + usuario + CRLF);
								estado = 1;
							}
							catch (ArrayIndexOutOfBoundsException e)
							{// No ha introducido el nombre de usuario.
								sockManager.Escribir("401 ERR Falta el nombre de usuario" + CRLF);
							}
						}
						else if (comando[0].toUpperCase().equals("SALIR"))
						{
							estado = 4;
						}
						else
						{
							sockManager.Escribir("450 ERR Comando no válido" + CRLF);
						}
						break;

					case 1:
						if (comando[0].toUpperCase().equals("PASS"))
						{
							try
							{
								if (usuario.equals("user") && comando[1].equals("pass"))
								{
									sockManager.Escribir("202 OK Bienvenido al sistema" + CRLF);
									estado = 2;
								}
								else
								{
									sockManager.Escribir("402 ERR La clave es incorrecta. Introduzca usuario" + CRLF);
									estado = 0;
								}

							}
							catch (ArrayIndexOutOfBoundsException e)
							{// No ha introducido la clave
								sockManager.Escribir("403 ERR Falta la clave" + CRLF);
							}
						}
						else if (comando[0].toUpperCase().equals("SALIR"))
						{
							estado = 4;
						}
						else
						{
							sockManager.Escribir("450 ERR Comando no válido" + CRLF);
						}
						break;

					case 2:
						// TODO
					case 3:
						// TODO
					default:
						estado = 4;
				}
			}
			sockManager.Escribir("208 OK Salir" + CRLF);
			System.out.println("Cliente fuera");
			sockManager.CerrarSocket();
			sockManager.CerrarStreams();
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
	}

	/**
	 * @param s
	 *            String comando recibido
	 * @return String[] comando y parámetros separados
	 */
	private String[] commandParser(String s)
	{
		String[] comando = s.split(" ");
		return comando;
	}

}
