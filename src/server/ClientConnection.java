package server;

import common.User;

public class ClientConnection {
	private int serverPort;
	private int clientPort;
	private String clientIp;
	private User user;

	/**
	 *
	 * @return
	 */
	public int getServerPort() {
		return serverPort;
	}

	/**
	 *
	 * @param serverPort
	 */
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	/**
	 *
	 * @return
	 */
	public int getClientPort() {
		return clientPort;
	}

	/**
	 *
	 * @param clientPort
	 */
	public void setClientPort(int clientPort) {
		this.clientPort = clientPort;
	}

	/**
	 *
	 * @return
	 */
	public String getClientIp() {
		return clientIp;
	}

	/**
	 *
	 * @param clientIp
	 */
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	/**
	 *
	 * @return
	 */
	public User getUser() {
		return user;
	}

	/**
	 *
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
