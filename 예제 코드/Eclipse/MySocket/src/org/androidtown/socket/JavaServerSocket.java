package org.androidtown.socket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServerSocket {
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(11001);
			System.out.println("?œë²„ ?Œì¼“??ë§Œë“¤?´ì¡Œ?µë‹ˆ??");
			
			while(true) {
				Socket aSocket = server.accept();
				
				ObjectInputStream instream = new ObjectInputStream(aSocket.getInputStream());
				Object obj = instream.readObject();
				System.out.println("Input : " + obj);

				ObjectOutputStream outstream = new ObjectOutputStream(aSocket.getOutputStream());
				outstream.writeObject(obj + " from Server.");
				outstream.flush();
				aSocket.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
