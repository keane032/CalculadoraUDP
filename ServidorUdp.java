package com.br.sd.Servidor;

import java.awt.datatransfer.SystemFlavorMap;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import com.br.sd.funcao.Calculadora;

public class ServidorUdp {

	 public static void main(String args[]){ 
	    	
		 Calculadora calculadora = new Calculadora();
		 DatagramSocket aSocket = null;
		 double result;
			
			try{
		    	aSocket = new DatagramSocket(6789);
						// create socket at agreed port
				byte[] buffer = new byte[1000];
	 			while(true){
	 				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
	  				aSocket.receive(request);     
	  				
	  				System.out.println(new String(request.getData()));
	  				 String msg =new String(request.getData());
	  				
	  					
	
	  				String array[];
	  				array = msg.split(";");
	  				
	  				
	  				
	  				calculadora.servico(array);
	  				
	  				System.out.println(calculadora.getTotal());
	  				
	  				byte[] mens = Double.toString(calculadora.getTotal()).getBytes(); 
	  				
	  				DatagramPacket req = new DatagramPacket(mens, mens.length);
	  				
	    			DatagramPacket reply = new DatagramPacket(req.getData(), req.getLength(), 
	    				request.getAddress(), request.getPort());		
	    			
	    			aSocket.send(reply);
	    			
	    		}
			}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
			}catch (IOException e) {System.out.println("IO: " + e.getMessage());
			}finally {if(aSocket != null) aSocket.close();}
	    }
	
}
