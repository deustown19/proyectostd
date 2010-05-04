package client;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
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
	private JButton exitButton;
	private JButton fotoButton;
	private JPanel fotoButtonPanel;
	private JPanel gpsToggleButtonPanel;
	private JLabel posLabel;
	private Canvas canvas;
	private JPanel canvasPanel;
	private JPanel gpsButtonPanel;
	private JButton valActButton;
	private JButton userButton;
	private JButton ipButton;
	private JTextField ipField;
	private JLabel ipLabel;
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
	private JButton closeButton;
	private JPanel bottomPanel;
	private JPanel loginPanel;
	private JPanel serverPanel;
	private JLabel serverLabel;
	private JLabel passLabel;
	private JPasswordField passField;
	
	private Client client;
	private String serverIP;
	private String serverPort;
	private String serverName;
	private Image canvasImage;

	public ClientGUI(Client client, String serverPort, String serverName)
	{
		super();
		this.client = client;
		this.serverPort = serverPort;
		this.serverName = serverName;
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			setTitle("STD");
			setSize(new Dimension(640, 580));
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			this.addWindowListener(new WindowAdapter()
			{
				@Override
				public void windowClosing(WindowEvent e)
				{
					client.exit();
				}
			});
			setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			setResizable(false);
			{
				contentPanel = new JPanel();
				getContentPane().add(contentPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				BoxLayout contentPanelLayout = new BoxLayout(contentPanel, javax.swing.BoxLayout.Y_AXIS);
				contentPanel.setLayout(contentPanelLayout);
				contentPanel.setBounds(5, 5, 625, 550);
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
						authPanel.setBorder(BorderFactory.createTitledBorder("Autenticacion"));
						{
							ipLabel = new JLabel();
							authPanel.add(ipLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
							ipLabel.setText("IP del servidor");
						}
						{
							ipField = new JTextField();
							authPanel.add(ipField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
							ipField.setPreferredSize(new Dimension(100, 20));
						}
						{
							ipButton = new JButton();
							authPanel.add(ipButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
							ipButton.setText("Conectar");
						}
						{
							userLabel = new JLabel("Usuario");
							authPanel.add(userLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
						}
						{
							userField = new JTextField();
							authPanel.add(userField, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
							userField.setPreferredSize(new Dimension(100, 20));
							userField.setEnabled(false);
						}
						{
							userButton = new JButton();
							authPanel.add(userButton, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
							userButton.setText("Enviar");
							userButton.setEnabled(false);
						}
						{
							passLabel = new JLabel("Contrasenya");
							authPanel.add(passLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
						}
						{
							passField = new JPasswordField();
							authPanel.add(passField, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
							passField.setPreferredSize(new Dimension(100, 20));
							passField.setEnabled(false);
							passField.addKeyListener(this);
						}
						{
							loginButton = new JButton("Login");
							authPanel.add(loginButton, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
							loginButton.setEnabled(false);
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
							serverLabel = new JLabel(" ");
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
								commandListScrollPanel.setPreferredSize(new Dimension(280, 80));
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
								sensorTable.setDragEnabled(false);
								sensorTable.setColumnSelectionAllowed(false);
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
							{
								valActButton = new JButton();
								switchOnOffPanel.add(valActButton);
								valActButton.setText("Actualizar valor");
								valActButton.setEnabled(false);
							}
						}
					}
					{
						historicPanel = new JPanel();
						GridBagLayout jPanel2Layout = new GridBagLayout();
						sensorPanel.add(historicPanel);
						historicPanel.setLayout(jPanel2Layout);
						historicPanel.setBorder(BorderFactory.createTitledBorder("Historico"));
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
					BoxLayout jPanel1Layout = new BoxLayout(gpsPanel, javax.swing.BoxLayout.X_AXIS);
					gpsPanel.setLayout(jPanel1Layout);
					{
						gpsButtonPanel = new JPanel();
						gpsPanel.add(gpsButtonPanel);
						BoxLayout jPanel1Layout1 = new BoxLayout(gpsButtonPanel, javax.swing.BoxLayout.Y_AXIS);
						gpsButtonPanel.setLayout(jPanel1Layout1);
						{
							gpsToggleButtonPanel = new JPanel();
							GridBagLayout jPanel2Layout1 = new GridBagLayout();
							gpsButtonPanel.add(gpsToggleButtonPanel);
							gpsToggleButtonPanel.setLayout(jPanel2Layout1);
							gpsToggleButtonPanel.setBorder(BorderFactory.createTitledBorder("GPS"));
							{
								gpsButton = new JToggleButton();
								gpsToggleButtonPanel.add(gpsButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								gpsButton.setText("GPS");
								gpsButton.setEnabled(false);
								gpsButton.addActionListener(this);
							}
						}
						{
							fotoButtonPanel = new JPanel();
							GridBagLayout fotoButtonPanelLayout = new GridBagLayout();
							gpsButtonPanel.add(fotoButtonPanel);
							fotoButtonPanel.setLayout(fotoButtonPanelLayout);
							{
								fotoButton = new JButton();
								fotoButtonPanel.add(fotoButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
								fotoButton.setText("Tomar foto");
								fotoButton.setEnabled(false);
							}
						}
					}
					{
						canvasPanel = new JPanel();
						GridBagLayout jPanel1Layout2 = new GridBagLayout();
						gpsPanel.add(canvasPanel);
						canvasPanel.setLayout(jPanel1Layout2);
						canvasPanel.setEnabled(false);
						{
							canvas = new Canvas()
							{
								private static final long serialVersionUID = -1368486486482651348L;

								@Override
								public void paint(Graphics g)
								{
									super.paint(g);
									if (canvasImage != null)
										g.drawImage(canvasImage, 0, 0, this.getWidth(), this.getHeight(), this);
								}
							};
							canvasPanel.add(canvas, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
							canvas.setPreferredSize(new Dimension(320, 160));
						}
						{
							posLabel = new JLabel();
							canvasPanel.add(posLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 8, 2, 8), 0, 0));
							posLabel.setText(" ");
						}
					}
				}
				{
					bottomPanel = new JPanel();
					contentPanel.add(bottomPanel);
					{
						closeButton = new JButton();
						bottomPanel.add(closeButton);
						closeButton.setText("Cerrar sesion");
						closeButton.setEnabled(false);
						closeButton.addActionListener(this);
					}
					{
						exitButton = new JButton();
						bottomPanel.add(exitButton);
						exitButton.setText("Salir");
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
	
	private void enable(JComponent[] components)
	{
		for (int i=0; i<components.length; i++)
			components[i].setEnabled(true);
	}
	
	private void disable(JComponent[] components)
	{
		for (int i=0; i<components.length; i++)
			components[i].setEnabled(false);
	}
	
	private void connect()
	{
		if (client.connect(ipField.getText()))
		{
			serverIP = ipField.getText();
			serverLabel.setText("//" + serverIP + ":" + serverPort + "/" + serverName);
			disable(new JComponent[]{ipField, ipButton});
			enable(new JComponent[]{userField, userButton, closeButton});
		}
	}
	
	public void update(String message)
	{
		((DefaultListModel)commandList.getModel()).addElement(message);
		statusLabel.setText(" ");
	}
	
	public void error(String message)
	{
		statusLabel.setText(message);
	}

	private void user(String user)
	{
		if (client.user(user))
		{
			disable(new JComponent[]{userLabel, userButton});
			enable(new JComponent[]{passLabel, loginButton});
		}
	}
	
	private void pass(String pass)
	{
		if (client.pass(pass))
		{
			disable(new JComponent[]{passLabel, loginButton});
			enable(new JComponent[]{listSensorButton, gpsButton, fotoButton});
		}
	}

	private void listSensor()
	{
		Vector<Vector<String>> data = client.listSensor();
		if (data != null)
		{
			DefaultTableModel dtm = (DefaultTableModel) sensorTable.getModel();
			for (Vector<String> row: data)
				dtm.addRow(row);
			
			disable(new JComponent[]{listSensorButton});
			enable(new JComponent[]{sensorTable, historicTable, onButton, offButton, valActButton});
		}
	}
	
	private void historico(String id)
	{
		Vector<Vector<String>> data = client.historico(id);
		if (data != null)
		{
			DefaultTableModel dtm = (DefaultTableModel) historicTable.getModel();
			for (Vector<String> row: data)
				dtm.addRow(row);
		}
	}
	
	private void on(int row)
	{
		if (client.on((String) sensorTable.getModel().getValueAt(row, 0)))
		{
			sensorTable.getModel().setValueAt("ON", row, 2);
		}
	}
	
	private void off(int row)
	{
		if (client.off((String) sensorTable.getModel().getValueAt(row, 0)))
		{
			sensorTable.getModel().setValueAt("OFF", row, 2);
		}
	}
	
	private void toggleGPS(boolean pressed)
	{
		if (pressed && client.onGPS())
		{
			gpsButton.setBackground(Color.GREEN);
		}
		else if (!pressed && client.offGPS())
		{
			gpsButton.setBackground(null);
		}
	}
	
	private void getValAct(String id)
	{
		Vector<String> data = client.getValAct(id);
		
		if (data != null)
		{
			((DefaultTableModel)historicTable.getModel()).addRow(data);
		}
	}
	
	private void getFoto()
	{
		canvasImage = client.getFoto();
		
		if (canvasImage != null)
		{
			canvas.repaint();
		}
	}
	
	private void getLoc()
	{
		String data = client.getLoc();
		
		if (data != null)
		{
			posLabel.setText(" ");
			canvasImage = null;
			canvas.repaint();
		}
	}
	
	private void close()
	{
		if (client.close())
		{
			serverLabel.setText(" ");
			userField.setText("");
			passField.setText("");
			
			DefaultTableModel dtm = (DefaultTableModel) sensorTable.getModel();
			for (int i=0; i<dtm.getRowCount(); i++)
				dtm.removeRow(i);
			
			dtm = (DefaultTableModel) historicTable.getModel();
			for (int i=0; i<dtm.getRowCount(); i++)
				dtm.removeRow(i);
			
			((DefaultListModel) commandList.getModel()).removeAllElements();
			
			canvasImage = null;
			canvas.repaint();
			
			disable(new JComponent[]
			{
				userButton, userField, passField, loginButton,
				listSensorButton, sensorTable, historicTable, onButton,
				offButton, gpsButton, fotoButton, closeButton
			});
			enable(new JComponent[]{ipField, ipButton});
		}
	}
	
	private void exit()
	{
		client.exit();
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource().equals(ipButton))
			connect();
		else if (ae.getSource().equals(loginButton))
			user(userField.getText());
		else if (ae.getSource().equals(loginButton))
			pass(String.valueOf(passField.getPassword()));
		else if (ae.getSource().equals(listSensorButton))
			listSensor();
		else if (ae.getSource().equals(onButton))
			on(sensorTable.getSelectedRow());
		else if (ae.getSource().equals(offButton))
			off(sensorTable.getSelectedRow());
		else if (ae.getSource().equals(gpsButton))
			toggleGPS(gpsButton.getModel().isSelected());
		else if (ae.getSource().equals(valActButton))
			getValAct((String) sensorTable.getModel().getValueAt(sensorTable.getSelectedRow(), 0));
		else if (ae.getSource().equals(fotoButton))
		{
			getFoto();
			getLoc();
		}
		else if (ae.getSource().equals(closeButton))
			close();
		else if (ae.getSource().equals(exitButton))
			exit();
	}

	@Override
	public void keyPressed(KeyEvent ke)
	{
		if (ke.getSource().equals(ipField) && (ke.getKeyCode() == KeyEvent.VK_ENTER))
			connect();
		else if (ke.getSource().equals(userField) && (ke.getKeyCode() == KeyEvent.VK_ENTER))
			user(userField.getText());
		else if (ke.getSource().equals(passField) && (ke.getKeyCode() == KeyEvent.VK_ENTER))
			pass(String.valueOf(passField.getPassword()));
		else if (ke.getSource().equals(sensorTable))
		{
			int delta = 0;
			if (ke.getKeyCode() == KeyEvent.VK_UP)
				delta = -1;
			else if (ke.getKeyCode() == KeyEvent.VK_DOWN)
				delta = 1;
			try
			{
				historico((String) sensorTable.getModel().getValueAt(sensorTable.getSelectedRow() + delta, 0));
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
