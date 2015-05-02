package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static void main(String[] args) throws IOException {
		System.out.println("running server");
		Server s = new Server();
		s.listenForRequests();
	}

	private Socket socket;
	private ServerSocket serverSocket;
	private int LISTENING_PORT = 4501;
	private String ipAddress;
	ArrayList<ServerConnection> connections;

	public Server () {
		connections = new ArrayList<ServerConnection>();
		try {
			serverSocket = new ServerSocket(LISTENING_PORT);
		} catch (IOException e) {
			System.err.println("Could not initialize port");
			e.printStackTrace();
		}
	}

	public void listenForRequests() throws IOException {
		while (true) {
			socket = serverSocket.accept();
			System.out.println("New Connection established with : " + socket.getInetAddress());
			ServerConnection newConnection = new ServerConnection(socket);
			if (socket.isClosed()) System.out.println("socket closed at S37");
			connections.add(newConnection);
			newConnection.start();
		}
	}

	public ServerConnection openConnection(String ipAddress, int port) {
		// TODO
		return null;
	}

	private int getNewPort() {
		// TODO
		return 0;
	}

	/**
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	private boolean validateCredentials(String username, String password) {
		// TODO
		return false;
	}
}
