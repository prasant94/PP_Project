package client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class ClientConnection {
	private static final String SERVER_IP = "192.168.55.240";
	private static final String REQUEST_HEADER_SIZE_FORMAT = "%05d";
	private int SERVER_PORT = 4501;
	private static final String ENCODING_FORMAT = "ASCII";
	private static final int RESPONSE_HEADER_SIZE = 5;
	private static final int RESPONSE_BODY_BUFFER_SIZE = 10240;


	private Socket socket;

	/**
	 * @throws IOException
	 * @throws UnknownHostException
	 *
	 */
	public ClientConnection() {
		try {
			this.socket = new Socket(SERVER_IP, SERVER_PORT);
		} catch (UnknownHostException e) {
			System.err.println("Failed to establish a connection with the server.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Failed to create a socket.");
			e.printStackTrace();
		}
	}

	public void uploadFile(String filePath, String fileName) {
		DataOutputStream outToServer = null;

		/// ----------- send file name to server ------------
		try {
			outToServer = new DataOutputStream(socket.getOutputStream());
			String request = "UploadRequest:" + fileName;
			byte[] bytes = (String.format(REQUEST_HEADER_SIZE_FORMAT, request.length()) + request).getBytes(ENCODING_FORMAT );
			outToServer.write(bytes);
			outToServer.flush();
		} catch (IOException e1) {
			System.err.println("error occurs when creating the output stream or if the socket is not connected.");
			e1.printStackTrace();
		}

		/// ----------- send file to server ------------
		if (outToServer != null) {
			byte[] mybytearray = new byte[4096];
			filePath = new String(filePath.toCharArray());
			File file = new File(filePath);
			FileInputStream fis = null;

			try {
				fis = new FileInputStream(filePath.trim());
			} catch (FileNotFoundException ex) {
				// Do exception handling
				ex.printStackTrace();
			}
			BufferedInputStream bis = new BufferedInputStream(fis);

			try {
				int sizeLeft = (int) file.length();
				while (bis.read(mybytearray) != -1) {
					int sendSize = Math.min(4096, sizeLeft);
					outToServer.write(mybytearray, 0, sendSize);
					sizeLeft -= sendSize;
				}
				outToServer.flush();
				outToServer.close();
				fis.close();
				socket.close();

				// File sent, exit the main method
				return;
			} catch (IOException ex) {
				// Do exception handling
			}
		}
	}

	public List<String> getAvailableFileList() {
		/// ----------- send file name to server ------------
		try {
			DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
			String request = "BrowseRequest:AllFiles";
			// format request.length into a ServerConnection.COMMAND_HEADER_SIZE sized zero padded string
			// and append the request to it
			byte[] bytes = (String.format(REQUEST_HEADER_SIZE_FORMAT, request.length()) + request).getBytes(ENCODING_FORMAT );
			outToServer.write(bytes);
			outToServer.flush();
		} catch (IOException e1) {
			System.err.println("error occurs when creating the output stream or if the socket is not connected.");
			e1.printStackTrace();
		}

		/// ----------- Read list of files -------------
		byte[] buf = new byte[RESPONSE_BODY_BUFFER_SIZE];

		InputStream is = null;
		try {
			is = socket.getInputStream();
		} catch (IOException e) {
			System.err.println("Input Stream Creation Failed");
			e.printStackTrace();
		}

		try {
			is.read(buf, 0, RESPONSE_HEADER_SIZE);
			String responseLengthString = null;
			responseLengthString = new String(buf, ENCODING_FORMAT);
			responseLengthString = responseLengthString.trim();
			System.out.println("response Length string " + responseLengthString);
			int responseLength = Integer.parseInt(responseLengthString);
			System.out.println("response length "  + responseLength);

			StringBuilder sb = new StringBuilder();
			int bytesLeft = responseLength;
			do {
				int bytesToRead = Math.min(RESPONSE_BODY_BUFFER_SIZE, bytesLeft);
				int readBytes = is.read(buf, 0, bytesToRead);
				sb.append(new String(buf, ENCODING_FORMAT));
				System.out.println(sb);
				bytesLeft -= readBytes;
			} while (bytesLeft > 0);

			System.out.println("list of files : " + sb.toString());
			return Arrays.asList(sb.toString().split(","));

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			System.err.println("read failed");
			e.printStackTrace();
		}
		return null;
	}

	public void downloadFile(String fileName, String saveAs) {
		/// ----------- send file name to server ------------
		try {
			DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
			String request = "DownloadRequest:" + fileName;
			// format request.length into a ServerConnection.COMMAND_HEADER_SIZE sized zero padded string
			// and append the request to it
			byte[] bytes = (String.format(REQUEST_HEADER_SIZE_FORMAT, request.length() + request)).getBytes(ENCODING_FORMAT );
			outToServer.write(bytes);
			outToServer.flush();
		} catch (IOException e1) {
			System.err.println("error occurs when creating the output stream or if the socket is not connected.");
			e1.printStackTrace();
		}

		/// ----------- accept file -----------
		byte[] aByte = new byte[1];
		int bytesRead;

		//        Socket clientSocket = null;
		InputStream is = null;
		try {
			is = socket.getInputStream();
			System.out.println("got input stream");
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


	public boolean addUser(String name, String email, String password) {
		/// ----------- send user details to server ------------
		String userDetails = name.concat(";").concat(email).concat(";").concat(password);
		try {
			DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
			String request = "NewUser:" + userDetails;
			// format request.length into a ServerConnection.COMMAND_HEADER_SIZE sized zero padded string
			// and append the request to it
			byte[] bytes = (String.format(REQUEST_HEADER_SIZE_FORMAT, request.length()) + request).getBytes(ENCODING_FORMAT );
			outToServer.write(bytes);
			outToServer.flush();
		} catch (IOException e1) {
			System.err.println("error occurs when creating the output stream or if the socket is not connected.");
			e1.printStackTrace();
		}
		// receive response
		byte[] buf = new byte[RESPONSE_BODY_BUFFER_SIZE];
		if (socket.isClosed()) {
			System.err.println("Socket closed");
			return false;
		}
		try {
			InputStream is = socket.getInputStream();

			is.read(buf, 0, RESPONSE_HEADER_SIZE);
			String responseLengthString = new String(buf, ENCODING_FORMAT);
			System.out.println("responseLengthString : " + responseLengthString);
			responseLengthString = responseLengthString.trim();
			int responseLength = Integer.parseInt(responseLengthString);

			int readBytes = is.read(buf, 0, responseLength);
			if (readBytes == -1) {
				System.out.println("No bytes read");
			}

			String line = new String(buf, ENCODING_FORMAT);
			System.out.println("adding user : resopnse from server : " + line);
			if (line.equals("SignUp Successful")) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException | IOException e) {
			System.err.println("reception failed");
			e.printStackTrace();
		}
		return false;
	}
}
