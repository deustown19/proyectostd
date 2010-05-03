package client;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.UIManager;

public class Client
{
	private ClientGUI gui;
	//TODO atributos para el socket
	
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
		try
		{
			//TODO
			gui.update("");
			return true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return false;
		}
	}
	
	public boolean pass(String pass)
	{
		try
		{
			//TODO
			gui.update("");
			return true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return false;
		}
	}
	
	public Vector<Vector<String>> listSensor()
	{
		try
		{
			//TODO
			gui.update("");
			return null;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return null;
		}
	}
	
	public Vector<Vector<String>> historico(String id)
	{
		try
		{
			//TODO
			gui.update("");
			return null;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return null;
		}
	}
	
	public boolean on(String id)
	{
		try
		{
			//TODO
			gui.update("");
			return true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return false;
		}
	}
	
	public boolean off(String id)
	{
		try
		{
			//TODO
			gui.update("");
			return true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return false;
		}
	}
	
	public boolean onGPS()
	{
		try
		{
			//TODO
			gui.update("");
			return true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return false;
		}
	}
	
	public boolean offGPS()
	{
		try
		{
			//TODO
			gui.update("");
			return true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return false;
		}
	}
	
	public Vector<String> getValAct(String id)
	{
		try
		{
			//TODO
			gui.update("");
			return null;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return null;
		}
	}
	
	public Image getFoto()
	{
		try
		{
			//TODO
			BufferedImage image = ImageIO.read((InputStream) null); //TODO
			gui.update("");
			return image;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return null;
		}
	}
	
	public String getLoc()
	{
		try
		{
			//TODO
			gui.update("");
			return null;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return null;
		}
	}
	
	public boolean close()
	{
		try
		{
			//TODO
			gui.update("");
			return true;
		}
		catch (Exception e)
		{
			gui.error("Error connecting to server");
			return false;
		}
	}
	
	public void exit()
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
