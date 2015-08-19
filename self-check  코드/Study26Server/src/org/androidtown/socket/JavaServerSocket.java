package org.androidtown.socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.androidtown.study21.SongItem;

public class JavaServerSocket {
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(11001);
			System.out.println("11001 포트에서 서버가 시작되었습니다.");
			
			while(true) {
				Socket socket = server.accept();
				
				ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
				
				Object obj = instream.readObject();
				System.out.println("Command : " + obj);
				
				if (obj.equals("WRITE")) {
					Integer countObj = (Integer) instream.readObject();
					int count = countObj.intValue();
					
					ObjectOutputStream fileout = new ObjectOutputStream(new FileOutputStream(new File("list.txt")));
					fileout.writeObject(countObj);
					for (int i = 0; i < count; i++) {
						Object itemObj = instream.readObject();
						SongItem item = (SongItem) itemObj;
						fileout.writeObject(item);
					}
					
					fileout.flush();
					fileout.close();
					
					System.out.println("파일 list.txt에 데이터 쓰기 완료.");
					
					sendResponse(outstream, "200", "OK");
					
				} else if (obj.equals("READ")) {
					outstream.writeObject("200");
					
					ObjectInputStream filein = new ObjectInputStream(new FileInputStream(new File("list.txt")));
					Integer countObj = (Integer) filein.readObject();
					outstream.writeObject(countObj);
					
					int count = countObj.intValue();
					for (int i = 0; i < count; i++) {
						Object itemObj = filein.readObject();
						outstream.writeObject(itemObj);
					}
					
					outstream.flush();
					filein.close();
					
					System.out.println("파일 list.txt에서 데이터 읽기 완료.");
					
				} else {
					System.out.println("Unknown command.");
					sendResponse(outstream, "400", "Unknown command.");
				}
				
				instream.close();
				outstream.close();
				socket.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void sendResponse(ObjectOutputStream outstream, String code, String message)
		throws Exception
	{
		outstream.writeObject(code);
		outstream.writeObject(message);
		outstream.flush();
	}
	
}
