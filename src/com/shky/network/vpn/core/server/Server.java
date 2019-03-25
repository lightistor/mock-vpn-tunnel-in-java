package com.shky.network.vpn.core.server;

public interface Server {

	//boolean return type signifies if call succeeded in performing expected work.
	boolean startServer(int port, String sharedKey); //Start server and wait for client connections
	void endConnection(); //End connection
	void closeServer(); //shutdown server
	boolean sendMessage(String s); //sends a message
	void acceptConnection(); //blocking call to accept connections to server.
	void receiveMessages(); //infinite blocking loop for receiving messages.
}
