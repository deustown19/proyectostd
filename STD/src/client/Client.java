package client;

import java.awt.Image;
import java.util.Vector;

import javax.swing.UIManager;

public class Client
{
	private ClientGUI gui;
	
	public Client(String serverPort, String serverName)
	{
		gui = new ClientGUI(this, serverPort, serverName);
		gui.setVisible(true);
	}

	public boolean connect(String IP)
	{
		try
		{
			//TODO
			return true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return false;
		}
	}
	
	public boolean user(String user)
	{
		boolean isCorrect = false;
		
		try
		{
			//TODO
			isCorrect = true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return false;
		}
		
		gui.update("");
		return isCorrect;
	}
	
	public boolean pass(String pass)
	{
		boolean isCorrect = false;
		
		try
		{
			//TODO
			isCorrect = true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return false;
		}
		
		gui.update("");
		return isCorrect;
	}
	
	public Vector<Vector<String>> listSensor()
	{
		try
		{
			//TODO
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return null;
		}
		
		gui.update("");
		return null;
	}
	
	public Vector<Vector<String>> historico(String id)
	{
		try
		{
			//TODO
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return null;
		}
		
		gui.update("");
		return null;
	}
	
	public boolean on(String id)
	{
		boolean isCorrect = false;
		
		try
		{
			//TODO
			isCorrect = true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return false;
		}
		
		gui.update("");
		return isCorrect;
	}
	
	public boolean off(String id)
	{
		boolean isCorrect = false;
		
		try
		{
			//TODO
			isCorrect = true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return false;
		}
		
		gui.update("");
		return isCorrect;
	}
	
	public boolean onGPS()
	{
		boolean isCorrect = false;
		
		try
		{
			//TODO
			isCorrect = true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return false;
		}
		
		gui.update("");
		return isCorrect;
	}
	
	public boolean offGPS()
	{
		boolean isCorrect = false;
		
		try
		{
			//TODO
			isCorrect = true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return false;
		}
		
		gui.update("");
		return isCorrect;
	}
	
	public Vector<String> getValAct(String id)
	{
		try
		{
			//TODO
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return null;
		}
		
		gui.update("");
		return null;
	}
	
	public Image getFoto()
	{
		try
		{
			//TODO
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return null;
		}
		
		gui.update("");
		return null;
	}
	
	public String getLoc()
	{
		try
		{
			//TODO
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return null;
		}
		
		gui.update("");
		return null;
	}
	
	public boolean cerrar()
	{
		boolean isCorrect = false;
		
		try
		{
			//TODO
			isCorrect = true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return false;
		}
		
		gui.update("");
		return isCorrect;
	}
	
	public void salir()
	{
		//TODO Cerrar socket
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
