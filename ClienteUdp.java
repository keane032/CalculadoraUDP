package com.br.sd.Cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class ClienteUdp {

	 public static void main(String args[]){ 
			// args give message contents and destination hostname
		 Scanner scanner = new Scanner(System.in);
		 DatagramSocket aSocket = null;
			try {
				
				System.out.println("intercale ';' a cada operaçao ou numero");
				System.out.println("ex: 3;+;2");
				System.out.println("OU intercale ';' a cada numero em uma mensagen comencando con '$' para calcular a idade");
				System.out.println("ex: $;2;0;1;8");
				
				String mng = scanner.nextLine();
				aSocket = new DatagramSocket();    
				byte [] m = mng.getBytes();
				InetAddress aHost = InetAddress.getByName("127.0.0.1");
				int serverPort = 6789;		                                                 
				DatagramPacket request =
				 	new DatagramPacket(m,  mng.length(), aHost, serverPort);
				aSocket.send(request);			                        
				byte[] buffer = new byte[1000];
				DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
				aSocket.receive(reply);
				System.out.println("Reply: " + new String(reply.getData()));	
			}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
			}catch (IOException e){System.out.println("IO: " + e.getMessage());
			}finally {if(aSocket != null) aSocket.close();}
		}	
	
}
