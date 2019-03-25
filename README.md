Mock-VPN-Tunnel-in-Java
========================

This is a demo implementation of a simple VPN to send data from one computer to another over a protected channel.
This is an implementation for establishing a secure channel between a client and server endpoints.
This implementation establishes the baseline for Virtual Private Network Tunnel.
The secure transfer is based on an encryption where the key exchange is through Diffie Hellman method.
Using a shared secret key the information is exchanged securely.
For the sake of simplicity, the encryption is password-based where DES is with MD5 hash.
The resulting communication through the public network is the foundation for a protected channel found in tunnels for VPN connections 


**DISCLAIMER**: The test GUI (Java AWT and Swing) incorporates a point-to-point client-server model with no reconnection.
Java security and crypto libraries to implement the protocol and key exchange.
Incorporating the use of this source-code for any real operation is discouraged and beyond the purpose of this implementation.