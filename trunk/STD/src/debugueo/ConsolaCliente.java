package debugueo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public final class ConsolaCliente
{
	public static void main(String[] args)
	{
		int port;

		if (args.length > 1)
		{// Comprobación de que el puerto es un número válido. 3000 por defecto.
			try
			{
				port = Integer.parseInt(args[1]);
				if ((port < 1024) || (port > 49152))
				{
					System.out.println("Número de puerto incorrecto. Debe estar entre 1024 y 49152. Elegido el puerto 3000 en su lugar.");
					port = 3000;
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("El puerto debe ser un número. Elegido el puerto 3000 en su lugar.");
				port = 3000;
			}
		}
		else
		{
			port = 3000;
		}

		String ip = (args.length > 0) ? args[0] : "127.0.0.1";

		try
		{
			Socket s = new Socket(ip, port);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			String comando = "";
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			char[] cbuf = new char[400];
			do
			{
				System.out.println("Prueba un comando: ");
				comando = teclado.readLine() + "\r\n";
				dos.writeBytes(comando);
				//br.read(cbuf);
				//System.out.println(cbuf);
				System.out.println(br.readLine());
			}
			while (!"SALIR\r\n".equals(comando.toUpperCase()));
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
