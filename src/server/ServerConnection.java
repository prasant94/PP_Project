package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.StringTokenizer;

import common.User;

public class ServerConnection extends Thread {
	private static final String ROOT_DIR = "/Users/prasant/Desktop/server/";
	private static final int REQUEST_HEADER_SIZE = 5;
	private static final String ENCODING_FORMAT = "ASCII";
	private static final int REQUEST_BODY_BUFFER_SIZE = 500;
	private static final String RESPONSE_HEADER_SIZE_FORMAT = "%010d";
	private static final int RESPONSE_HEADER_SIZE = 10;
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
		byte[] buf = new byte[REQUEST_BODY_BUFFER_SIZE];
		if (socket.isClosed()) {
			System.err.println("Socket closed");
			return;
		}
		InputStream is = socket.getInputStream();

		is.read(buf, 0, REQUEST_HEADER_SIZE);
		String requestLengthString = new String(buf, ENCODING_FORMAT);
		requestLengthString = requestLengthString.trim();
		int requestLength = Integer.parseInt(requestLengthString);

		assert requestLength <= REQUEST_BODY_BUFFER_SIZE;

		int readBytes = is.read(buf, 0, requestLength);
		if (readBytes == -1) {
			System.out.println("No bytes read");
		}

		String line = new String(buf, ENCODING_FORMAT);

		if (line != null && line.length() > 0) {
			StringTokenizer tok = new StringTokenizer(line, ":");
			String request = tok.nextToken();

			if (request.equals("DownloadRequest")) {
				String fileName = tok.nextToken().trim();
				System.out.println("Initiating request to send file : '" + fileName+"'");
				sendFile(ROOT_DIR + fileName);
			} else if (request.equals("UploadRequest")) {
				String fileName = tok.nextToken().trim();
				System.out.println("Initiating download for file : '" + fileName+"'");
				receiveFile(ROOT_DIR + fileName);
			} else if (request.equals("BrowseFiles")) {
				String option = tok.nextToken().trim();
				sendListOfFiles(option);
			}
			else if(request.equals("NewUser")){
				String details = tok.nextToken().trim();
				System.out.println("Adding new user to database");
				addUser(details);
			}
			else {
				System.err.println("Unknown command : " + request);
			}
			is.close();
		}

	}

	private void addUser(String details) throws IOException
	{
	    File file = new File(ROOT_DIR+"database.txt");
		BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
		output.write(details+"\n");
		output.close();
		System.out.println("User added");
	}



	private void sendListOfFiles(String option) {
		// open a file for the root directory
		File root = new File(ROOT_DIR);

		// Root file should obviously be an assertion
		assert root.isDirectory();

		// Initialize StringBuilder
		StringBuilder sb = new StringBuilder();
		// Append all file names to String Builder
		for (File file : root.listFiles()) {
			sb.append(file.getName()).append(',');
		}
		// remove the last comma
		sb.replace(sb.length()-1, sb.length(), "");
		// add response header at the beginning
		sb.insert(0, String.format(RESPONSE_HEADER_SIZE_FORMAT, sb.length() + RESPONSE_HEADER_SIZE));

		String response = sb.toString();

		/// ----------- send response string -----------
	}

	/**
	 *
	 * @param saveAs Path where file is saved
	 */
	private void receiveFile(String saveAs) {
		byte[] aByte = new byte[1];
		int bytesRead;

		InputStream is = null;
		try {
			is = socket.getInputStream();
		} catch (IOException e) {
			System.err.println("the socket is closed, the socket is not connected, "
					+ "or the socket input has been shutdown using shutdownInput()");
			e.printStackTrace();
		}

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream(saveAs);
			bos = new BufferedOutputStream(fos);
			bytesRead = is.read(aByte, 0, aByte.length);

			do {
				baos.write(aByte);
				bytesRead = is.read(aByte);
			} while (bytesRead != -1);

			bos.write(baos.toByteArray());
			bos.flush();
			bos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			// Do exception handling
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
//
//	/**
//	 *
//	 * @param user
//	 */
	public void setUser(User user) {
		this.user = user;
	}

}
