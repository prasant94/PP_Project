package client;

import java.util.ArrayList;

public class Client {

	private String ip;
	private int port;
	private ServerConnection serverConenction;

	/**
	 *
	 */
	protected Client(){
		// TODO
	}

	/**
	 *
	 * @return
	 */
	protected String browseMedia(){
		// TODO
		return null;
	}

	/**
	 *
	 * @param filename
	 * @return
	 */
	protected boolean streamMedia(String filename){
		// TODO
		return false;
	}

	/**
	 *
	 * @param filename
	 * @return
	 */
	protected boolean downloadMedia(String filename){
		// TODO
		return false;
	}

	/**
	 *
	 * @param filename
	 * @return
	 */
	protected boolean uploadMedia(String filename){
		// TODO
		return false;
	}

	/**
	 *
	 * @param query
	 * @return
	 */
	protected ArrayList<String> searchMedia(String query){
		// TODO
		return null;
	}

	/**
	 *
	 * @return
	 */
	public String getIp() {
		return ip;
	}

	/**
	 *
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 *
	 * @return
	 */
	public int getPort() {
		return port;
	}

	/**
	 *
	 * @param port
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 *
	 * @return
	 */
	public ServerConnection getServerConenction() {
		return serverConenction;
	}

	/**
	 *
	 * @param serverConenction
	 */
	public void setServerConenction(ServerConnection serverConenction) {
		this.serverConenction = serverConenction;
	}
}
