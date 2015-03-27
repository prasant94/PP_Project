package server;

import java.util.ArrayList;

public class Server {
	private int listeningPort;
	private String ipAddress;
	ArrayList<ClientConnection> connections;

	public void listenForRequests(int port) {
		// TODO
	}

	public ClientConnection openConnection(String ipAddress, int port) {
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
