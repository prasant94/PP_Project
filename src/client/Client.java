package client;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		System.out.println("running client");
		Client c = new Client();
		c.downloadMedia(args[0], args[1]);
	}

	private String ip;
	private int port;
	private ClientConnection serverConenction;

	/**
	 *
	 */
	protected Client(){
		this.serverConenction = new ClientConnection();
	}

	/**
	 *
	 * @return
	 */
	protected ArrayList<String> browseMedia(){
		ArrayList<String> fileNames = new ArrayList<String>();
		return fileNames;
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
	protected void downloadMedia(String fileName, String saveAs){
		serverConenction.downloadFile(fileName, saveAs);
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
	public ClientConnection getServerConenction() {
		return serverConenction;
	}

	/**
	 *
	 * @param serverConenction
	 */
	public void setServerConenction(ClientConnection serverConenction) {
		this.serverConenction = serverConenction;
	}
}
