package client;

import javax.swing.UIManager;

public abstract class Client
{
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new ClientGUI("127.0.0.1", "8080").setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
