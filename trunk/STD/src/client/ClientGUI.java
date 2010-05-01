package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

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
public class ClientGUI extends JFrame implements ActionListener, KeyListener, MouseListener
{
	private static final long serialVersionUID = -8877474517268367965L;

	/* Componentes GUI */
	private JPanel authPanel;
	private JLabel userLabel;
	private JTextField userField;
	private JScrollPane sensorTableScrollPanel;
	private JPanel switchOnOffPanel;
	private JButton offButton;
	private JButton onButton;
	private JScrollPane commandListScrollPanel;
	private JList commandList;
	private JScrollPane historicTableScrollPanel;
	private JToggleButton gpsButton;
	private JPanel gpsPanel;
	private JTable historicTable;
	private JButton listSensorButton;
	private JPanel historicPanel;
	private JTable sensorTable;
	private JLabel statusLabel;
	private JPanel statusPanel;
	private JPanel listSensorPanel;
	private JPanel sensorPanel;
	private JButton loginButton;
	private JPanel contentPanel;
	private JButton exitButton;
	private JPanel bottomPanel;
	private JPanel loginPanel;
	private JPanel serverPanel;
	private JLabel serverLabel;
	private JLabel passLabel;
	private JPasswordField passField;
	
	private String serverIP;
	private String serverPort;
	private String serverName;

	public ClientGUI(String serverIP, String serverPort, String serverName)
	{
		super();
		this.serverIP = serverIP;
		this.serverPort = serverPort;
		this.serverName = serverName;
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
			setResizable(false);
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
							passField.addKeyListener(this);
						}
						{
							loginButton = new JButton("Login");
							authPanel.add(loginButton, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
							loginButton.addActionListener(this);
						}
					}
					{
						serverPanel = new JPanel();
						loginPanel.add(serverPanel);
						GridBagLayout serverPanelLayout = new GridBagLayout();
						serverPanel.setLayout(serverPanelLayout);
						serverPanel.setBorder(BorderFactory.createTitledBorder("Servidor"));
						{
							serverLabel = new JLabel("//" + serverIP + ":" + serverPort + "/" + serverName);
							serverPanel.add(serverLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
						}
						{
							commandListScrollPanel = new JScrollPane();
							serverPanel.add(commandListScrollPanel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 5, 0, 5), 0, 0));
							{
								ListModel jList1Model = new DefaultListModel();
								commandList = new JList();
								commandListScrollPanel.setViewportView(commandList);
								commandList.setModel(jList1Model);
								commandList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								commandListScrollPanel.setPreferredSize(new Dimension(310, 80));
							}
						}
					}
				}
				{
					sensorPanel = new JPanel();
					contentPanel.add(sensorPanel);
					BoxLayout sensorPanelLayout = new BoxLayout(sensorPanel, javax.swing.BoxLayout.X_AXIS);
					sensorPanel.setLayout(sensorPanelLayout);
					sensorPanel.setBounds(5, 225, 625, 229);
					{
						listSensorPanel = new JPanel();
						GridBagLayout jPanel5Layout = new GridBagLayout();
						sensorPanel.add(listSensorPanel);
						listSensorPanel.setBorder(BorderFactory.createTitledBorder("Sensores"));
						listSensorPanel.setLayout(jPanel5Layout);
						{
							listSensorButton = new JButton();
							listSensorPanel.add(listSensorButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
							listSensorButton.setText("Listar sensores");
							listSensorButton.setEnabled(false);
							listSensorButton.addActionListener(this);
						}
						{
							sensorTableScrollPanel = new JScrollPane();
							listSensorPanel.add(sensorTableScrollPanel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 5, 0, 5), 0, 0));
							sensorTableScrollPanel.setPreferredSize(new Dimension(280, 100));
							{
								DefaultTableModel jTable1Model = new DefaultTableModel(new String[][] {{"01", "ejemplo", "OFF"}}, new String[] { "ID", "Nombre", "Estado" })
								{
									private static final long serialVersionUID = -5355929655231575361L;
									
									@Override
									public boolean isCellEditable(int row, int column)
									{
										return false;
									}
								};
								sensorTable = new JTable();
								sensorTableScrollPanel.setViewportView(sensorTable);
								sensorTable.setRowSelectionAllowed(true);
								sensorTable.setModel(jTable1Model);
								sensorTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								sensorTable.setEnabled(false);
								sensorTable.addMouseListener(this);
								sensorTable.addKeyListener(this);
							}
						}
						{
							switchOnOffPanel = new JPanel();
							listSensorPanel.add(switchOnOffPanel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							{
								onButton = new JButton();
								switchOnOffPanel.add(onButton);
								onButton.setText("ON");
								onButton.setEnabled(false);
								onButton.addActionListener(this);
							}
							{
								offButton = new JButton();
								switchOnOffPanel.add(offButton);
								offButton.setText("OFF");
								offButton.setEnabled(false);
								offButton.addActionListener(this);
							}
						}
					}
					{
						historicPanel = new JPanel();
						GridBagLayout jPanel2Layout = new GridBagLayout();
						sensorPanel.add(historicPanel);
						historicPanel.setLayout(jPanel2Layout);
						historicPanel.setBorder(BorderFactory.createTitledBorder("Histórico"));
						{
							historicTableScrollPanel = new JScrollPane();
							historicPanel.add(historicTableScrollPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 5, 0, 5), 0, 0));
							historicTableScrollPanel.setPreferredSize(new Dimension(280, 145));
							{
								DefaultTableModel jTable2Model = new DefaultTableModel(new String[][] {}, new String[] { "Fecha", "Hora", "Coordenadas", "Valor" })
								{
									private static final long serialVersionUID = 2485255026323832169L;
									
									@Override
									public boolean isCellEditable(int row, int column)
									{
										return false;
									}
								};
								historicTable = new JTable();
								historicTableScrollPanel.setViewportView(historicTable);
								historicTable.setModel(jTable2Model);
								historicTable.setEnabled(false);
							}
						}
					}
				}
				{
					gpsPanel = new JPanel();
					contentPanel.add(gpsPanel);
					GridBagLayout jPanel1Layout = new GridBagLayout();
					gpsPanel.setLayout(jPanel1Layout);
					gpsPanel.setBorder(BorderFactory.createTitledBorder("GPS"));
					{
						gpsButton = new JToggleButton();
						gpsPanel.add(gpsButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						gpsButton.setText("GPS");
						gpsButton.setEnabled(false);
						gpsButton.addActionListener(this);
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
				{
					statusPanel = new JPanel();
					contentPanel.add(statusPanel);
					FlowLayout jPanel1Layout = new FlowLayout();
					jPanel1Layout.setHgap(2);
					jPanel1Layout.setVgap(2);
					statusPanel.setLayout(jPanel1Layout);
					statusPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(128, 128, 128)));
					{
						statusLabel = new JLabel();
						statusPanel.add(statusLabel);
						statusLabel.setText(" ");
						statusPanel.setPreferredSize(new Dimension(100, 20));
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void update(String code, String message)
	{
		((DefaultListModel)commandList.getModel()).addElement(code + ": " + message);
	}

	private void login()
	{
	}

	private void listSensor()
	{
	}
	
	private void getHistoric(String id)
	{
	}
	
	private void on(int row)
	{
	}
	
	private void off(int row)
	{
	}
	
	private void toggleGPS(boolean pressed)
	{
		if (pressed)
		{
			gpsButton.setBackground(Color.GREEN);
		}
		else
		{
			gpsButton.setBackground(null);
		}
	}
	
	private void salir()
	{
		dispose();
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource().equals(loginButton))
			login();
		else if (ae.getSource().equals(listSensorButton))
			listSensor();
		else if (ae.getSource().equals(onButton))
			on(sensorTable.getSelectedRow());
		else if (ae.getSource().equals(offButton))
			off(sensorTable.getSelectedRow());
		else if (ae.getSource().equals(gpsButton))
			toggleGPS(gpsButton.getModel().isSelected());
		else if (ae.getSource().equals(exitButton))
			salir();
	}

	@Override
	public void keyPressed(KeyEvent ke)
	{
		if (ke.getSource().equals(passField) && (ke.getKeyCode() == KeyEvent.VK_ENTER))
			login();
		else if (ke.getSource().equals(sensorTable))
		{
			int delta = 0;
			if (ke.getKeyCode() == KeyEvent.VK_UP)
				delta = -1;
			else if (ke.getKeyCode() == KeyEvent.VK_DOWN)
				delta = 1;
			try
			{
				getHistoric((String) sensorTable.getModel().getValueAt(sensorTable.getSelectedRow() + delta, 0));
			}
			catch (Exception e)
			{
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent ke)
	{
	}

	@Override
	public void keyTyped(KeyEvent ke)
	{
	}

	@Override
	public void mouseClicked(MouseEvent me)
	{
		System.out.println(me.getSource().toString());
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
	}
}
