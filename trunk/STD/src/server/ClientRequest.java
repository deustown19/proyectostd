package server;

import java.io.IOException;

import util.SocketManager;

public class ClientRequest implements Runnable
{

	private final static String CRLF = "\r\n";
	private String usuario;
	private SocketManager sockManager;

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
				comando = commandParser(sockManager.leer());

				switch (estado)
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
						// TODO
					case 3:
						// TODO
					default:
						estado = 4;
				}
			}
			sockManager.escribir("208 OK Salir" + CRLF);
			System.out.println("Cliente fuera");
			sockManager.cerrarSocket();
			sockManager.cerrarStreams();
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
