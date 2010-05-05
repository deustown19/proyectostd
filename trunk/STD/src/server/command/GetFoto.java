package server.command;

import java.io.File;
import java.io.FileInputStream;

import server.ClientRequest;
import util.SocketManager;

public class GetFoto extends Command
{
	@Override
	public String command(ClientRequest cr, String[] params)
	{
		String respuesta = "";
		if (cr.getState() == 2)
		{
			if (cr.isGps())
			{
				String fileName = "img/imagen.jpg";
				FileInputStream fis = null;
				
				try
				{
					fis = new FileInputStream(fileName);
					//File file = new File(fileName);
					//BufferedImage bi = ImageIO.read(file);
					cr.getSockManager().escribir("206 OK " + new File(fileName).length() + " bytes transmitiendo." + CRLF);
					sendBytes(fis, cr.getSockManager());
					fis.close();
					cr.getSockManager().escribir(CRLF + "fin"+ CRLF);
					//ImageIO.write(bi, "jpg", cr.getSockManager().getDOS());
					cr.setState(3);
				}
				catch (Exception e)
				{
					System.out.println("No abre fichero");
				}
			}
			else
				respuesta = "420 ERR GPS en estado OFF." + CRLF;
		}
		else
		{
			respuesta = "450 ERR Comando no válido" + CRLF;
		}
		return respuesta;
	}

	private void sendBytes(FileInputStream fis, SocketManager sm) throws Exception
	{
		// Construct a 1K buffer to hold bytes on their way to the socket.
		byte[] buffer = new byte[1024];
		int bytes = 0;

		// Copy requested file into the socket's output stream.
		while ((bytes = fis.read(buffer)) != -1)
		{
			sm.escribir(buffer, bytes);
		}
	}
}
