package client;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ClientGUI extends JFrame implements ActionListener
{
	private static final long serialVersionUID = -8877474517268367965L;
	
	private JPanel authPanel;
	private JLabel userLabel;
	private JTextField userField;
	private JLabel jLabel2;
	private JPanel jPanel5;
	private JPanel sensorPanel;
	private JButton loginButton;
	private JPanel contentPanel;
	private JButton exitButton;
	private JPanel bottomPanel;
	private JPanel loginPanel;
	private JPanel serverPanel;
	private JLabel ipLabel;
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
				contentPanel = new JPanel();
				getContentPane().add(contentPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				BoxLayout contentPanelLayout = new BoxLayout(contentPanel, javax.swing.BoxLayout.Y_AXIS);
				contentPanel.setLayout(contentPanelLayout);
				contentPanel.setBounds(5, 5, 625, 450);
				{
					loginPanel = new JPanel();
					contentPanel.add(loginPanel);
					BoxLayout loginPanelLayout = new BoxLayout(loginPanel, javax.swing.BoxLayout.X_AXIS);
					loginPanel.setLayout(loginPanelLayout);
					{
						authPanel = new JPanel();
						loginPanel.add(authPanel);
						GridBagLayout authPanelLayout = new GridBagLayout();
						authPanel.setLayout(authPanelLayout);
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
							loginButton = new JButton("Login");
							authPanel.add(loginButton, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
						}
					}
					{
						serverPanel = new JPanel();
						loginPanel.add(serverPanel);
						GridBagLayout serverPanelLayout = new GridBagLayout();
						serverPanel.setLayout(serverPanelLayout);
						serverPanel.setBorder(BorderFactory.createTitledBorder("Servidor"));
						{
							ipLabel = new JLabel("IP: -");
							serverPanel.add(ipLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
						}
					}
				}
				{
					sensorPanel = new JPanel();
					BoxLayout sensorPanelLayout = new BoxLayout(sensorPanel, javax.swing.BoxLayout.X_AXIS);
					sensorPanel.setLayout(sensorPanelLayout);
					contentPanel.add(sensorPanel);
					{
						jPanel5 = new JPanel();
						GridBagLayout jPanel5Layout = new GridBagLayout();
						sensorPanel.add(jPanel5);
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
					bottomPanel = new JPanel();
					contentPanel.add(bottomPanel);
					{
						exitButton = new JButton();
						bottomPanel.add(exitButton);
						exitButton.setText("Salir");
						exitButton.addActionListener(this);
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource().equals(exitButton))
		{
			dispose();
		}
	}
}
