package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listenToClient() throws IOException {
		byte[] buf = new byte[500];
		System.out.println("Entering listenToClient" );
		while(true) {
			if (socket.isClosed()) {
				System.out.println("socket closed at CC40");
				return;
			}
			System.out.println("socket open at CC40");
			//BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			InputStream is = socket.getInputStream();
			//String s = new String()
//			String line = br.readLine();
			int readBytes = is.read(buf, 0,500);
			String line = new String(buf);
			//String line = Arrays.toString(buf);
			System.out.println("line: " + line);
			socket.close();
			return;
//			if (line != null && line.length() > 0) {
//				StringTokenizer tok = new StringTokenizer(line, ":");
//				String command = tok.nextToken();
//
////				if (command.equals("DownloadRequest")) {
//					String fileName = tok.nextToken().trim();
//					System.out.println("Initiating request to send file : " + fileName);
//					sendFile(fileName);
//					System.out.println("returned from send file");
////				} else {
////					System.err.println("Unknown command : " + command);
////				}
//			is.close();
//			//socket.close();
//			}
		}

	}

	private void sendFile(String fileName) {
		System.out.println("socket open : " + socket.isConnected());
		System.out.println("sending file : " + fileName);
//		ServerSocket welcomeSocket = null;
//        Socket connectionSocket = null;
        BufferedOutputStream outToClient = null;

        try {
//            welcomeSocket = new ServerSocket(3248);
//            connectionSocket = welcomeSocket.accept();
            outToClient = new BufferedOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            // Do exception handling
            ex.printStackTrace();
        }
        System.out.println("outToClient null : " + (outToClient != null));
        if (outToClient != null) {
            File myFile = new File(fileName);
            System.out.println("FileName Received over network is : "+fileName);
            //fileName = new StringBuilder(fileName).toString();
            fileName = "/Users/prasant/Desktop/empty.txt";
            if(fileName.equalsIgnoreCase("/Users/prasant/Desktop/empty.txt")){
            	System.out.println("filename equal");
            }
            else{
            	System.out.println("filename not equal");

            }
            //byte[] mybytearray = new byte[(int) myFile.length()];
            byte[] mybytearray = new byte[1024];

            FileInputStream fis = null;

            try {
                fis = new FileInputStream(fileName);
            } catch (FileNotFoundException ex) {
                // Do exception handlingsss
            	ex.printStackTrace();
            }
            BufferedInputStream bis = new BufferedInputStream(fis);

            try {
            	System.out.println("bytearray length " + mybytearray.length);
                bis.read(mybytearray, 0, mybytearray.length);
                System.out.println("file" + new String(mybytearray));
                outToClient.write(mybytearray, 0, mybytearray.length);
                outToClient.flush();
                outToClient.close();
//                connectionSocket.close();
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
