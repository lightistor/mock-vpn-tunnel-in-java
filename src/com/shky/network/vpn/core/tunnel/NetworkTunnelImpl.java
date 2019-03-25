package com.shky.network.vpn.core.tunnel;


import com.shky.network.vpn.test.gui.TunnelTestGUI;

public class NetworkTunnelImpl implements NetworkTunnel {

	private static NetworkTunnelImpl s_server;
	private static NetworkTunnelImpl s_client;
	
	private TunnelTestGUI m_gui;
	public NetworkTunnelImpl(TunnelTestGUI gui)
	{
		m_gui = gui;
	}
	@Override
	public void receiveMessages(){}
	@Override
	public void acceptConnection(){}
	@Override
	public void closeServer()
	{
		if( this != s_server) return;
		NetworkTunnelImpl server = s_server;
		s_server = null;
		server.endConnection();
		if( s_client != null )s_client.endConnection();
		
	}
	@Override
	public void endConnection() {
		
		if( this == s_server)
		{
			if(s_client != null )s_client.endConnection();
		}
		else if( this == s_client)
		{
			s_client = null;
			if( s_server != null )s_server.endConnection();
		}
		m_gui.connectionClosed();
	}
	protected void receiveMessage(String s)
	{
		m_gui.printf(s);
	}

	@Override
	public boolean sendMessage(String s) {
		
		if( this == s_server && s_client != null )
		{
			s_client.receiveMessage(s);
			return true;
		}
		else if( this == s_client && s_server != null )
		{
			s_server.receiveMessage(s);
			return true;
		}
		return false;
	}

	@Override
	public boolean startClient(String host, int port, String sharedKey) {
		
		if( s_server == null ) return false;
		
		s_server.startConnection();
		s_client = this;
		startConnection();
		return true;
	}
	
	protected void startConnection()
	{
		m_gui.connectionReady();
	}

	@Override
	public boolean startServer(int port, String sharedKey) {
		s_server = this;
		return true;
	}

}
