package client;

import javax.swing.UIManager;

public abstract class ClientMain
{
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new ClientGUI(args[0], args[1], args[2]).setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
