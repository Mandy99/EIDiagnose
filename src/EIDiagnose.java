import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;

import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.TextField;

import javax.swing.JLabel;

import com.hp.ei.diagnose.util.Global_Parameter;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.MouseMotionAdapter;
import java.awt.Label;


public class EIDiagnose {

	private JFrame frmEidiagnose;
	private JOptionPane jOptionPane;
	//public static Global_Parameter globalpara;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//globalpara = new Global_Parameter();
					
					EIDiagnose window = new EIDiagnose();
					window.frmEidiagnose.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EIDiagnose() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEidiagnose = new JFrame();
		frmEidiagnose.setTitle("EIDiagnose");
		frmEidiagnose.setBounds(100, 100, 544, 394);
		frmEidiagnose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jOptionPane = new JOptionPane();
		frmEidiagnose.getContentPane().add(jOptionPane);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSize(544, 394);
		frmEidiagnose.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.setBounds(5, 6, 880, 830);
		JPanel DBConnectPane = new JPanel();
		JPanel DBStatusPane = new JPanel();
		JPanel CertificatePane = new JPanel();
		JPanel LogPane = new JPanel();
		JPanel SettingsPane = new JPanel();
		DBConnectPane.setLayout(null);
		tabbedPane.addTab("DB Connect",DBConnectPane);
		DBStatusPane.setLayout(null);
		tabbedPane.addTab("DB Status",DBStatusPane);
		CertificatePane.setLayout(null);
		LogPane.setLayout(null);
		SettingsPane.setLayout(null);
		JPanel FileCheckPane = new JPanel();
		tabbedPane.addTab("File Check", null, FileCheckPane, null);
		FileCheckPane.setLayout(null);
		JDialog jDialog =new JDialog();
		JLabel lblJettyssl = new JLabel("jetty-ssl.xml");
		lblJettyssl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					java.awt.Desktop.getDesktop().edit(new File(Global_Parameter.jettySSLPath));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frmEidiagnose, e1.getMessage(),"Message",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblJettyssl.setForeground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblJettyssl.setForeground(Color.BLACK);
			}
		});
		lblJettyssl.setBounds(25, 22, 85, 14);
		FileCheckPane.add(lblJettyssl);
		
		JLabel lblStartini = new JLabel("start.ini");
		lblStartini.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					java.awt.Desktop.getDesktop().edit(new File(Global_Parameter.startiniPath));
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frmEidiagnose, e1.getMessage(),"Message",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblStartini.setForeground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblStartini.setForeground(Color.BLACK);
			}
			
		});
		lblStartini.setBounds(25, 52, 59, 14);
		FileCheckPane.add(lblStartini);
		
		Label WSDLStatus = new Label("WSDL status:");
		WSDLStatus.setBounds(22, 72, 80, 22);
		FileCheckPane.add(WSDLStatus);
		
		Label WSDLStatusLable = new Label("");
		WSDLStatusLable.setBounds(126, 72, 62, 22);
		WSDLStatusLable.setText(Global_Parameter.WSDL_STATUS);
		FileCheckPane.add(WSDLStatusLable);
		tabbedPane.addTab("Certificate",CertificatePane);
		tabbedPane.addTab("Log Check",LogPane);
		tabbedPane.addTab("Settings",SettingsPane);
		
		TextField InstallPathField = new TextField();
		InstallPathField.setText(Global_Parameter.installationPath);
		InstallPathField.setBounds(111, 10, 232, 22);
		SettingsPane.add(InstallPathField);
		
		JLabel lblNewLabel = new JLabel("Install Path:");
		lblNewLabel.setBounds(10, 10, 67, 14);
		SettingsPane.add(lblNewLabel);
		
		JButton btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(446, 10, 55, 23);
		SettingsPane.add(btnSave);
		
		TextField ServerConfPathField = new TextField();
		ServerConfPathField.setText(Global_Parameter.installationPath+Global_Parameter.serverConfPath);
		ServerConfPathField.setBounds(111, 53, 295, 22);
		SettingsPane.add(ServerConfPathField);
		
		JLabel lblJettysslpath = new JLabel("ServerConf Path:");
		lblJettysslpath.setBounds(10, 50, 95, 14);
		SettingsPane.add(lblJettysslpath);
		
	}
}
