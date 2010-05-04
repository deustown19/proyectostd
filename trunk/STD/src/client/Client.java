package client;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStreamImpl;
import javax.swing.UIManager;

import util.SocketManager;

public class Client
{
	private final static String CRLF = "\r\n";
	private ClientGUI gui;
	private SocketManager sm;
	private String serverPort;
	
	public Client(String serverPort, String serverName)
	{
		this.serverPort = serverPort;
		gui = new ClientGUI(this, serverPort, serverName);
		gui.setVisible(true);
	}
	
	private static Vector<String> tokenize(String str, String delimiter)
	{
		Vector<String> vector = new Vector<String>();
		String[] tokens = str.split(delimiter);
		for (String token: tokens)
			vector.add(token.trim());
		return vector;
	}

	public boolean connect(String ip)
	{
		try
		{
			sm = new SocketManager(ip, Integer.valueOf(serverPort));
			return true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean user(String user)
	{
		try
		{
			sm.escribir("USER " + user + CRLF);
			String response = sm.leer().trim();
			gui.update(response);
			if (response.charAt(0) != '4')
				return true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean pass(String pass)
	{
		try
		{
			sm.escribir("PASS " + pass + CRLF);
			String response = sm.leer().trim();
			gui.update(response);
			if (response.charAt(0) != '4')
				return true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			e.printStackTrace();
		}
		return false;
	}
	
	public Vector<Vector<String>> listSensor()
	{
		String response;
		Vector<Vector<String>> data;
		try
		{
			sm.escribir("LISTSENSOR" + CRLF);
			response = sm.leer().trim();
			gui.update(response);
			if (response.substring(0, 3).equals("112"))
			{
				data = new Vector<Vector<String>>();
				response = sm.leer().trim();
				while (!(response.substring(0, 3).equals("212")))
				{
					data.add(tokenize(response, ";"));
					gui.update(response);
					response = sm.leer().trim();
				}
				gui.update(response);
				return data;
			}
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			e.printStackTrace();
		}
		return null;
	}
	
	public Vector<Vector<String>> historico(String id)
	{
		String response;
		Vector<Vector<String>> data;
		try
		{
			sm.escribir("HISTORICO " + id + CRLF);
			response = sm.leer().trim();
			gui.update(response);
			if (response.substring(0, 3).equals("113"))
			{
				data = new Vector<Vector<String>>();
				response = sm.leer().trim();
				while (!(response.substring(0, 3).equals("212")))
				{
					data.add(tokenize(response, ";"));
					gui.update(response);
					response = sm.leer().trim();
				}
				gui.update(response);
				return data;
			}
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean on(String id)
	{
		try
		{
			sm.escribir("ON " + id + CRLF);
			String response = sm.leer().trim();
			gui.update(response);
			if (response.charAt(0) != '4')
				return true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean off(String id)
	{
		try
		{
			sm.escribir("OFF " + id + CRLF);
			String response = sm.leer().trim();
			gui.update(response);
			if (response.charAt(0) != '4')
				return true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean onGPS()
	{
		try
		{
			sm.escribir("ONGPS" + CRLF);
			String response = sm.leer().trim();
			gui.update(response);
			if (response.charAt(0) != '4')
				return true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean offGPS()
	{
		try
		{
			sm.escribir("OFFGPS" + CRLF);
			String response = sm.leer().trim();
			gui.update(response);
			if (response.charAt(0) != '4')
				return true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			e.printStackTrace();
		}
		return false;
	}
	
	public Vector<String> getValAct(String id)
	{
		try
		{
			sm.escribir("GET_VALACT " + id + CRLF);
			String response = sm.leer().trim();
			gui.update(response);
			if (response.charAt(0) != '4')
				return tokenize(tokenize(response, " ").get(2), ";");
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			e.printStackTrace();
		}
		return null;
	}
	
	public Image getFoto()
	{
		try
		{
			sm.escribir("GET_FOTO" + CRLF);
			String response = sm.leer().trim();
			gui.update(response);
			if (response.charAt(0) != '4')
			{
				BufferedImage image = ImageIO.read(new ByteArrayInputStream(sm.leer().getBytes()));
				return image;
			}
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			e.printStackTrace();
		}
		return null;
	}
	
	public String getLoc()
	{
		try
		{
			sm.escribir("GET_LOC" + CRLF);
			String response = sm.leer().trim();
			gui.update(response);
			if (response.charAt(0) != '4')
				return tokenize(response, " ").get(2);
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean close()
	{
		try
		{
			sm.escribir("SALIR" + CRLF);
			String response = sm.leer().trim();
			gui.update(response);
			if (response.charAt(0) != '4')
			{
				sm.cerrarStreams();
				sm.cerrarSocket();
				sm = null;
				return true;
			}
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			e.printStackTrace();
		}
		return false;
	}
	
	public void exit()
	{
		try
		{
			sm.cerrarStreams();
			sm.cerrarSocket();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Client(args[0], args[1]);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
