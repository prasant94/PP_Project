package client;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientConnection {
	private static final String SERVER_IP = "127.0.0.1";
	private int SERVER_PORT = 4501;

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

	public void sendMessage(String message) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(message);
        writer.flush();
        writer.close();
    }

	public void downloadFile(String fileName, String saveAs) throws IOException {
		/// ----------- send file name to server ------------
		sendMessage(fileName);

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

//        try {
//            clientSocket = new Socket("127.0.0.1", 3248);
//            is = clientSocket.getInputStream();
//        } catch (IOException ex) {
//            // Do exception handling
//        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

//		Scanner s = new Scanner(System.in);
//		s.next();
        if (is != null) {
        	System.out.println("Inupt stream is not null");

            FileOutputStream fos = null;
            BufferedOutputStream bos = null;
            try {
            	System.out.println("entered try, saving as : " + saveAs);
                fos = new FileOutputStream(saveAs);
            	System.out.println("got for");
                bos = new BufferedOutputStream(fos);
            	System.out.println("got bos");
                bytesRead = is.read(aByte, 0, aByte.length);

                do {
                        baos.write(aByte);
                        bytesRead = is.read(aByte);
                } while (bytesRead != -1);

                bos.write(baos.toByteArray());
                bos.flush();
                bos.close();
//                clientSocket.close();
            } catch (IOException ex) {
            	ex.printStackTrace();
                // Do exception handling
            }
        }
	}
}
