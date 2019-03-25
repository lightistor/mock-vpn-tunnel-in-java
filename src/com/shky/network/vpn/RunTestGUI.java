package com.shky.network.vpn;

import com.shky.network.vpn.test.gui.TunnelTestGUIClient;
import com.shky.network.vpn.test.gui.TunnelTestGUIServer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class RunTestGUI extends JFrame implements ActionListener {

	private JButton	m_btnClient;
	private JButton m_btnServer;
	
	public RunTestGUI()
	{
		super("Title");
		this.setSize(450,450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setVisible(true);

		m_btnClient = new JButton("ClientImpl");
		m_btnServer = new JButton("ServerImpl");
		
		m_btnClient.addActionListener(this);
		m_btnServer.addActionListener(this);
		
		this.add(m_btnClient);
		this.add(m_btnServer);
		//displayClient();
	}
	
	public void actionPerformed( ActionEvent e )
	{
		if(e.getSource() == m_btnClient) displayClient();
		if(e.getSource() == m_btnServer) displayServer();
	}
	
	private void displayClient()
	{
		SwingUtilities.invokeLater( new Runnable(){
			public void run() {
				new TunnelTestGUIClient();
			}
		});
	}
	
	private void displayServer()
	{
		SwingUtilities.invokeLater( new Runnable(){
			public void run() {
				new TunnelTestGUIServer();
			}
			
		});
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		SwingUtilities.invokeLater( new Runnable(){
			public void run() {
				new RunTestGUI();
			}
			
		});
	}
}