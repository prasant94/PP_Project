package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.StringTokenizer;

import common.User;

public class ServerConnection extends Thread {
	private int serverPort;
	private int clientPort;
	private String clientIp;
	private User user;
	private Socket socket;

	public ServerConnection(Socket socket) {
		if (socket.isClosed()) System.out.println("socket closed at CC25");
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			if (socket.isClosed()) System.out.println("socket closed at CC32");
			listenToClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void listenToClient() throws IOException {
		byte[] buf = new byte[500];
		if (socket.isClosed()) {
			return;
		}
		InputStream is = socket.getInputStream();

		int readBytes = is.read(buf, 0, 500);
		if (readBytes == -1) {
			System.out.println("No bytes read");
		}

		String line = new String(buf, "UTF8");

		if (line != null && line.length() > 0) {
			StringTokenizer tok = new StringTokenizer(line, ":");
			String command = tok.nextToken();

			if (command.equals("DownloadRequest")) {
				String fileName = tok.nextToken().trim();
				System.out.println("Initiating request to send file : '" + fileName+"'");
				sendFile(fileName);
			} else {
				System.err.println("Unknown command : " + command);
			}
			is.close();
		}

	}

	private void sendFile(String fileName) {
		BufferedOutputStream outToClient = null;

		try {
			outToClient = new BufferedOutputStream(socket.getOutputStream());
		} catch (IOException ex) {
			// Do exception handling
			ex.printStackTrace();
		}
		if (outToClient != null) {
			byte[] mybytearray = new byte[4096];
			fileName = new String(fileName.toCharArray());
			File file = new File(fileName);
			FileInputStream fis = null;

			try {
				fis = new FileInputStream(fileName.trim());
			} catch (FileNotFoundException ex) {
				// Do exception handling
				ex.printStackTrace();
			}
			BufferedInputStream bis = new BufferedInputStream(fis);

			try {
				int sizeLeft = (int) file.length();
				while (bis.read(mybytearray) != -1) {
					int sendSize = Math.min(4096, sizeLeft);
					outToClient.write(mybytearray, 0, sendSize);
					sizeLeft -= sendSize;
				}
				outToClient.flush();
				outToClient.close();
				fis.close();
				socket.close();

				// File sent, exit the main method
				return;
			} catch (IOException ex) {
				// Do exception handling
			}
		}
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
