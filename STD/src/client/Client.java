package client;

import javax.swing.UIManager;

public class Client
{
	private ClientGUI gui;
	
	public Client(String serverIP, String serverPort, String serverName)
	{
		gui = new ClientGUI(serverIP, serverPort, serverName);
		gui.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Client(args[0], args[1], args[2]);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
