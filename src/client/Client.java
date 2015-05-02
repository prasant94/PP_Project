package client;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		System.out.println("running client");
		Client c = new Client();
		c.uploadMedia(args[0], args[1]);
	}

	private String ip;
	private int port;
	private ClientConnection serverConnection;

	/**
	 *
	 */
	protected Client(){
		this.serverConnection = new ClientConnection();
	}

	/**
	 *
	 * @return
	 */
	public ArrayList<String> browseMedia(){
		ArrayList<String> fileNames = new ArrayList<String>();
		fileNames.add("file1");
		fileNames.add("file2");
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
		serverConnection.downloadFile(fileName, saveAs);
	}

	/**
	 *
	 * @param fileName
	 * @return
	 */
	protected void uploadMedia(String filePath, String fileName){
		serverConnection.uploadFile(filePath, fileName);
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
		return serverConnection;
	}

	/**
	 *
	 * @param serverConenction
	 */
	public void setServerConenction(ClientConnection serverConenction) {
		this.serverConnection = serverConenction;
	}


	public boolean isValidUser(String userInformation) {
		// TODO Auto-generated method stub
		String messageToServer = "validate user,";
		messageToServer = messageToServer.concat(userInformation);
		return true;
	}

}
