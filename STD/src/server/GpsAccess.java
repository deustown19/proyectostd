package server;

import java.util.Vector;

import util.SocketManager;

public class GpsAccess {
	private final static String CRLF = "\r\n";
	public SocketManager sm;
	
	public boolean connect(String ip)
	{
		try
		{
			sm = new SocketManager(ip, 4000);
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean user()
	{
		try
		{
			sm.escribir("USER gps" + CRLF);
			String response = sm.leer().trim();
			if (response.charAt(0) != '4')
				return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean pass()
	{
		try
		{
			sm.escribir("PASS gps" + CRLF);
			String response = sm.leer().trim();
			if (response.charAt(0) != '4')
				return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public String getCoor(String cell_id)
	{
		String coor = "fallo";
		String response;
		try
		{
			sm.escribir("GET_COOR " + cell_id + CRLF);
			response = sm.leer().trim();
			if (response.charAt(0) != '4')
				coor = tokenize(response, " ").get(2);
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return coor;
	}
	
	private static Vector<String> tokenize(String str, String delimiter)
	{
		Vector<String> vector = new Vector<String>();
		String[] tokens = str.split(delimiter);
		for (String token: tokens)
			vector.add(token.trim());
		return vector;
	}
}
