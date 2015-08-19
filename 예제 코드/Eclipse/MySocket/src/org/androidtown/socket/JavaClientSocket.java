package org.androidtown.socket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class JavaClientSocket {
	
	public static void main(String[] args) {

		try {

			Socket aSocket = new Socket("localhost", 11001);
			
			ObjectOutputStream outstream = new ObjectOutputStream(aSocket.getOutputStream());
			outstream.writeObject("Hello.");
			outstream.flush();

			ObjectInputStream instream = new ObjectInputStream(aSocket.getInputStream());
			Object obj = instream.readObject();
			System.out.println(obj);
			
			aSocket.close();

		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
