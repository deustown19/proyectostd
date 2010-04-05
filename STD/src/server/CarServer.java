package server;

import java.net.ServerSocket;

import util.SocketManager;

public class CarServer
{
	public static void main(String[] args) throws Exception
	{
		{// Set the port number.
			int port;
			if (args.length > 0)
			{// Comprobación de que el puerto es un número válido. 3000 por defecto.
				try
				{
					port = Integer.parseInt(args[0]);
					if (port < 1024 || port > 49152)
					{
						System.out.println("Número de puerto incorrecto. Debe estar entre 1024 y 49152. Elegido el puerto 3000 en su lugar.");
						port = 3000;
					}
				}
				catch (NumberFormatException e)
				{
					System.out.println("Formato de puerto incorrecto. Elegido el puerto 3000 en su lugar.");
					port = 3000;
				}
			}
			else
			{
				port = 3000;
			}

			ServerSocket wellcomeSocket = new ServerSocket(port);

			while (true)
			{
				System.out.println("Esperando peticiones en el puerto " + port + ".");
				// Aceptamos la nueva petición y creamos el SocketManager para
				// gestionar el Socket obtenido
				SocketManager sm = new SocketManager(wellcomeSocket.accept());

				// Creamos un objeto ClientRequest para gestionar las peticiones
				// del cliente
				ClientRequest request = new ClientRequest(sm);
				// Creamos un Thread para el objeto ClientRequest
				Thread hilo = new Thread(request);

				// Arrancar el Thread
				hilo.start();
			}
		}

	}

}
