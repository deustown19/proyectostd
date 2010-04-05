package client;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ClientUI extends JFrame
{
	private static final long serialVersionUID = 408900111876949823L;
	private JButton jButton1;

	public ClientUI()
	{
		super();
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1, BorderLayout.CENTER);
				jButton1.setText("jButton1");
			}
			pack();
			setSize(400, 300);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				ClientUI inst = new ClientUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
}
