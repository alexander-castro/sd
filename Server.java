package server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;

public class Server {
	
	public Server() {
		System.out.println("Server started at " + LocalDateTime.now());
		try {
			ServerSocket serverSocket = new ServerSocket(15555);
			System.out.println("Server on port 15555...");
			boolean serverOn = true;
			while (serverOn) {
				Socket connection = serverSocket.accept();
				System.out.println("Accepted connection");
				InputStream inputStream = connection.getInputStream();
				int age = inputStream.read();
				System.out.println("Input request data->" + age);
			}
		} catch (IOException e) {
			System.out.println("Error" + e.getMessage() + "in Server at " + LocalDateTime.now());
		}
		System.out.println("Server finished at " + LocalDateTime.now());
	}

	
	public static void main(String[] args) {
		new Server();
	}

}
