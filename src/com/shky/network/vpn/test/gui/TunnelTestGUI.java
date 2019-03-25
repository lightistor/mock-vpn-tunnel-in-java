package com.shky.network.vpn.test.gui;



public interface TunnelTestGUI
{
   void printf(String s); //Prints to screen
   void connectionReady(); //Connection is ready for messages
   void connectionClosed(); //Connection is terminated
}