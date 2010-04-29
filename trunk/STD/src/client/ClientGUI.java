package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ClientGUI extends javax.swing.JFrame
{
	private static final long serialVersionUID = -8877474517268367965L;
	private JPanel authPanel;
	private JLabel userLabel;
	private JTextField userField;
	private JLabel jLabel2;
	private JPanel jPanel5;
	private JPanel jPanel3;
	private JButton jButton1;
	private JPanel jPanel2;
	private JButton jButton2;
	private JPanel elResto;
	private JPanel jPanel1;
	private JPanel jPanel4;
	private JLabel jLabel1;
	private JLabel passLabel;
	private JPasswordField passField;

	public ClientGUI()
	{
		super();
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			setTitle("STD");
			setSize(new Dimension(640, 480));
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			this.setResizable(false);
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				BoxLayout jPanel2Layout = new BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS);
				jPanel2.setLayout(jPanel2Layout);
				jPanel2.setBounds(5, 5, 625, 450);
				{
					jPanel1 = new JPanel();
					jPanel2.add(jPanel1);
					BoxLayout jPanel1Layout = new BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS);
					jPanel1.setLayout(jPanel1Layout);
					{
						authPanel = new JPanel();
						jPanel1.add(authPanel);
						GridBagLayout jPanel1Layouto = new GridBagLayout();
						authPanel.setLayout(jPanel1Layouto);
						authPanel.setBorder(BorderFactory.createTitledBorder("Autenticación"));
						{
							userLabel = new JLabel("Usuario");
							authPanel.add(userLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 8, 2, 8), 0, 0));	
						}
						{
							userField = new JTextField();
							authPanel.add(userField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
							userField.setPreferredSize(new Dimension(100, 20));
						}
						{
							passLabel = new JLabel("Contraseña");
							authPanel.add(passLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
						}
						{
							passField = new JPasswordField();
							authPanel.add(passField, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
							passField.setPreferredSize(new Dimension(100, 20));
						}
						{
							jButton1 = new JButton("Login");
							authPanel.add(jButton1, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
						}
					}
					{
						jPanel4 = new JPanel();
						jPanel1.add(jPanel4);
						GridBagLayout jPanel4Layout = new GridBagLayout();
						jPanel4.setLayout(jPanel4Layout);
						jPanel4.setBorder(BorderFactory.createTitledBorder("Servidor"));
						{
							jLabel1 = new JLabel("IP: -");
							jPanel4.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
							BorderLayout jLabel1Layout = new BorderLayout();
							jLabel1.setLayout(jLabel1Layout);
						}
					}
				}
				{
					jPanel3 = new JPanel();
					BoxLayout jPanel3Layout = new BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS);
					jPanel3.setLayout(jPanel3Layout);
					jPanel2.add(jPanel3);
					{
						jPanel5 = new JPanel();
						GridBagLayout jPanel5Layout = new GridBagLayout();
						jPanel3.add(jPanel5);
						jPanel5.setBorder(BorderFactory.createTitledBorder("Sensor"));
						jPanel5.setLayout(jPanel5Layout);
						{
							jLabel2 = new JLabel();
							jPanel5.add(jLabel2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
							jLabel2.setText("jLabel2");
						}
					}
				}
				{
					elResto = new JPanel();
					jPanel2.add(elResto);
					{
						jButton2 = new JButton();
						elResto.add(jButton2);
						jButton2.setText("Salir");
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
