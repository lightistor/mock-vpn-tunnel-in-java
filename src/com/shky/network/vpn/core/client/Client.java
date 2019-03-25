package com.shky.network.vpn.core.client;

public interface Client {

	//boolean return type signifies if call succeeded in performing expected work.
	boolean startClient(String host, int port, String sharedKey); //Start client and do handshake. Expected call TunnelTestGUI.connectionReady()
	void endConnection(); //End connection
	boolean sendMessage(String s); //sends a message
	void receiveMessages(); //infinite blocking loop for receiving messages
}
