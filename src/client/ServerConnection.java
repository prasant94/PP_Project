package client;

public class ServerConnection {
	private String serverIp;
	private int serverPort;

	/**
	 *
	 */
	public ServerConnection() {
		// TODO
	}

	/**
	 *
	 * @return
	 */
	public String getServerIp() {
		return serverIp;
	}

	/**
	 *
	 * @param serverIp
	 */
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

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
}
