package client;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private String userName;
	private String password;

//	public static void main(String[] args) {
//		System.out.println("running client");
//		Client c = new Client();
////		c.uploadMedia(args[0], args[1]);
//		c.addUser("abcde", "email", "password");
////		c.browseMedia();
//	}

	private String ip;
	private int port;
	private ClientConnection clientConnection;

	/**
	 *
	 */
	public Client(){
		this.clientConnection = new ClientConnection();
	}

	/**
	 *
	 * @return
	 */
	public List<String> browseMedia(){
		return clientConnection.getAvailableFileList();
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
	public void downloadMedia(String fileName, String saveAs){
		clientConnection.downloadFile(fileName, saveAs);
	}

	/**
	 *
	 * @param fileName
	 * @return
	 */
	public void uploadMedia(String filePath, String fileName){
		clientConnection.uploadFile(filePath, fileName);
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
		return clientConnection;
	}

	/**
	 *
	 * @param serverConenction
	 */
	public void setServerConenction(ClientConnection serverConenction) {
		this.clientConnection = serverConenction;
	}


	public boolean isValidUser(String userInformation) {
		String messageToServer = "validate user,";
		messageToServer = messageToServer.concat(userInformation);
		return true;
	}
	

	public void addUser(String name, String email, String password){
		System.out.println("add client");
		clientConnection.addUser(name, email, password);
	}

}
