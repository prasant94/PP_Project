package client.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import client.Client;

public class MainWindow extends JFrame {

	private static final String DOWNLOAD_DIR = "/Users/prasant/Desktop/";

	private static final long serialVersionUID = 1L;

	final static String WELCOME_PANEL = "Welcome Panel";
	final static String SIGN_IN_PANEL = "Sign In Panel";
	final static String SIGN_UP_PANEL = "Sign Up Panel";
	final static String DASHBOARD_PANEL = "Dashboard Panel";

	static final String BROWSE_FILE_PANEL = "Browse File Panel";
	private JTextField usernameSignInTextField;
	private JTextField usernameSignUpTextField;
	private JTextField emailSignUpTextField;

	JPanel browseFilePanel;
	JPanel fileList;
	private JPasswordField passwordSignInTextField;
	private JPasswordField passwordSignUpTextField;
	private JPasswordField confirmPasswordSignUpTextField;

	public Client client;
	private boolean signedIn;

	public MainWindow() {
		client = new Client();
		signedIn = false;
		getContentPane().setLayout(new CardLayout(0, 0));

		JPanel welcomeWindowPanel = new JPanel();
		getContentPane().add(welcomeWindowPanel, WELCOME_PANEL);
		createWelcomePanel(welcomeWindowPanel);

		JPanel signInWindowPanel = new JPanel();
		getContentPane().add(signInWindowPanel, SIGN_IN_PANEL);
		createSignInPanel(signInWindowPanel);

		JPanel dashboardWindowPanel = new JPanel();
		getContentPane().add(dashboardWindowPanel, DASHBOARD_PANEL);
		createDashboardPanel(dashboardWindowPanel);

		JPanel signUpWindowPanel = new JPanel();
		getContentPane().add(signUpWindowPanel, SIGN_UP_PANEL);
		createSignUpPanel(signUpWindowPanel);

		browseFilePanel = new JPanel();
		getContentPane().add(browseFilePanel, BROWSE_FILE_PANEL);
		fileList = createBrowseFilePanel(browseFilePanel);


	}

	private JPanel createBrowseFilePanel(JPanel browseFilePanel) {
		browseFilePanel.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel informationInBrowsePanel = new JPanel();
		browseFilePanel.add(informationInBrowsePanel);

		JLabel fileChooseLabel = new JLabel("Choose the file you want to download...");

		JButton fileToDownloadChosenButton = new JButton("Download");
		fileToDownloadChosenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fileToBeDownloaded==null){
					displayErrorMessage("Select a file");
				}
				else{
					client.downloadMedia(fileToBeDownloaded, DOWNLOAD_DIR + fileToBeDownloaded);
				}
			}
		});

		JButton streamFileButton = new JButton("Stream");
		streamFileButton.setEnabled(false);
		GroupLayout gl_informationInBrowsePanel = new GroupLayout(informationInBrowsePanel);
		gl_informationInBrowsePanel.setHorizontalGroup(
			gl_informationInBrowsePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_informationInBrowsePanel.createSequentialGroup()
					.addGap(147)
					.addComponent(fileToDownloadChosenButton)
					.addGap(18)
					.addComponent(streamFileButton)
					.addContainerGap(95, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_informationInBrowsePanel.createSequentialGroup()
					.addContainerGap(98, Short.MAX_VALUE)
					.addComponent(fileChooseLabel)
					.addGap(67))
		);
		gl_informationInBrowsePanel.setVerticalGroup(
			gl_informationInBrowsePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_informationInBrowsePanel.createSequentialGroup()
					.addContainerGap(46, Short.MAX_VALUE)
					.addComponent(fileChooseLabel)
					.addGroup(gl_informationInBrowsePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_informationInBrowsePanel.createSequentialGroup()
							.addGap(12)
							.addComponent(fileToDownloadChosenButton))
						.addGroup(gl_informationInBrowsePanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(streamFileButton)))
					.addGap(51))
		);
		informationInBrowsePanel.setLayout(gl_informationInBrowsePanel);

		JPanel fileList = new JPanel();
		browseFilePanel.add(fileList);
		return fileList;
	}

	public static void main(String[] args){

		 MainWindow main = new MainWindow();

		 main.setSize(500, 500);
		 main.setVisible(true);
	}

	private void goToPanel(String panelName) {
       CardLayout cl = (CardLayout)(getContentPane().getLayout());
       cl.show(getContentPane(), panelName);
	}

	private void displayErrorMessage(String string) {
		ErrorWindow err = new ErrorWindow(string);
	}

	String fileToBeDownloaded=null;
	private void browseFiles() {
		List<String> filesOnServer = client.browseMedia();

		fileList.setLayout(new GridLayout(filesOnServer.size(), 1));
		ButtonGroup radioButtonGroup = new ButtonGroup();
		for(String s : filesOnServer){
			JRadioButton file = new JRadioButton(s);
			file.addActionListener(new java.awt.event.ActionListener() {
                @Override
				public void actionPerformed(java.awt.event.ActionEvent e) {
                    fileToBeDownloaded = ((JRadioButton)(e.getSource())).getText().trim();
                    System.out.println(fileToBeDownloaded);
                }
            });
			fileList.add(file);
			radioButtonGroup.add(file);
		}
	}
	private void uploadFile() throws IOException {

		//Create a file chooser
		final JFileChooser fc = new JFileChooser();

		int option = fc.showOpenDialog(null);
		if (option == JFileChooser.CANCEL_OPTION || option == JFileChooser.CANCEL_OPTION) {
			System.out.println("error in choosing file");
			return;
		}
		String fileToUpload = fc.getSelectedFile().toString();
		String fileName = getFileNameFromPath(fileToUpload);
		client.uploadMedia(fileToUpload, fileName);
	}

	private String getFileNameFromPath(String fileToUpload) {
		String[] tokens = fileToUpload.split("/");
		return tokens[tokens.length-1];
	}

	private void createSignUpPanel(JPanel signUpWindowPanel) {
		JLabel signUpPanelLabel = new JLabel("Sign Up");
		JLabel usernameSignUpLabel = new JLabel("Username");
		JLabel emailSignUpLabel = new JLabel("Email");
		JLabel passwordSignUpLabel = new JLabel("Password");
		JLabel confirmPasswordSignUpLabel = new JLabel("Confirm Password");

		usernameSignUpTextField = new JTextField();
		usernameSignUpTextField.setColumns(10);

		emailSignUpTextField = new JTextField();
		emailSignUpTextField.setColumns(10);

		JButton signUpButton = new JButton("Sign Up");
		signUpButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// client = new Client();
				signedIn = client.addUser(usernameSignUpTextField.getText(), emailSignUpTextField.getText(), passwordSignUpTextField.getText());
				System.out.println("signed in : " + signedIn);
				if (!signedIn) {
					return;
				}
				goToPanel(DASHBOARD_PANEL);
			}
		});

		passwordSignUpTextField = new JPasswordField();
		passwordSignUpTextField.setColumns(10);

		confirmPasswordSignUpTextField = new JPasswordField();
		confirmPasswordSignUpTextField.setColumns(10);

		JButton backSignUpButton = new JButton("Back");
		backSignUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goToPanel(WELCOME_PANEL);
			}
		});

		GroupLayout gl_signUpWindowPanel = new GroupLayout(signUpWindowPanel);
		gl_signUpWindowPanel.setHorizontalGroup(
			gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_signUpWindowPanel.createSequentialGroup()
					.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_signUpWindowPanel.createSequentialGroup()
							.addGap(153)
							.addComponent(signUpPanelLabel))
						.addGroup(gl_signUpWindowPanel.createSequentialGroup()
							.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_signUpWindowPanel.createSequentialGroup()
									.addContainerGap()
									.addComponent(passwordSignUpLabel))
								.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_signUpWindowPanel.createSequentialGroup()
										.addContainerGap()
										.addComponent(emailSignUpLabel))
									.addGroup(gl_signUpWindowPanel.createSequentialGroup()
										.addGap(115)
										.addComponent(usernameSignUpLabel)))
								.addGroup(gl_signUpWindowPanel.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(backSignUpButton)
										.addComponent(confirmPasswordSignUpLabel))))
							.addGap(35)
							.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(signUpButton)
								.addComponent(usernameSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(emailSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_signUpWindowPanel.createSequentialGroup()
									.addGap(12)
									.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(confirmPasswordSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_signUpWindowPanel.setVerticalGroup(
			gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_signUpWindowPanel.createSequentialGroup()
					.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_signUpWindowPanel.createSequentialGroup()
									.addGap(116)
									.addComponent(emailSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_signUpWindowPanel.createSequentialGroup()
									.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_signUpWindowPanel.createSequentialGroup()
											.addGap(85)
											.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(usernameSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(usernameSignUpLabel)))
										.addGroup(gl_signUpWindowPanel.createSequentialGroup()
											.addGap(20)
											.addComponent(signUpPanelLabel)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(emailSignUpLabel)))
							.addGroup(gl_signUpWindowPanel.createSequentialGroup()
								.addGap(149)
								.addComponent(passwordSignUpLabel)))
						.addGroup(gl_signUpWindowPanel.createSequentialGroup()
							.addGap(147)
							.addComponent(passwordSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_signUpWindowPanel.createSequentialGroup()
							.addGap(28)
							.addComponent(confirmPasswordSignUpLabel))
						.addGroup(gl_signUpWindowPanel.createSequentialGroup()
							.addGap(18)
							.addComponent(confirmPasswordSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(backSignUpButton)
						.addComponent(signUpButton))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		signUpWindowPanel.setLayout(gl_signUpWindowPanel);
	}

	private void createDashboardPanel(JPanel dashboardWindowPanel) {

		JButton uploadFileButton = new JButton("Upload File");
		uploadFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					uploadFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton browseFilesButton = new JButton("Browse Files");

		JLabel dashboardLabel = new JLabel("Dashboard");

		GroupLayout gl_dashboardWIndowPanel = new GroupLayout(dashboardWindowPanel);
		gl_dashboardWIndowPanel.setHorizontalGroup(
			gl_dashboardWIndowPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dashboardWIndowPanel.createSequentialGroup()
					.addGroup(gl_dashboardWIndowPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dashboardWIndowPanel.createSequentialGroup()
							.addGap(63)
							.addComponent(browseFilesButton)
							.addGap(46)
							.addComponent(uploadFileButton))
						.addGroup(gl_dashboardWIndowPanel.createSequentialGroup()
							.addGap(151)
							.addComponent(dashboardLabel)))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		gl_dashboardWIndowPanel.setVerticalGroup(
			gl_dashboardWIndowPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_dashboardWIndowPanel.createSequentialGroup()
					.addGroup(gl_dashboardWIndowPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dashboardWIndowPanel.createSequentialGroup()
							.addComponent(dashboardLabel)
							.addGap(65)
							.addComponent(browseFilesButton))
						.addGroup(gl_dashboardWIndowPanel.createSequentialGroup()
							.addGap(69)
							.addComponent(uploadFileButton)))
					.addContainerGap(167, Short.MAX_VALUE))
		);

		dashboardWindowPanel.setLayout(gl_dashboardWIndowPanel);
		browseFilesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				browseFiles();
				goToPanel(BROWSE_FILE_PANEL);
			}
		});
	}

	private void addCurrentFilesToPanel(JPanel panel) {
		// TODO Auto-generated method stub

	}

	private void createSignInPanel(JPanel signInWindowPanel) {
		JLabel usernameSignInLabel = new JLabel("Username - ");
		JLabel passwordSignInLabel = new JLabel("Password -");

		usernameSignInTextField = new JTextField();
		usernameSignInTextField.setColumns(20);

		JLabel signInWindowLabel = new JLabel("Sign In");
		signInWindowLabel.setForeground(Color.BLACK);

		JButton signInButton = new JButton("Sign In");

		signInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// client = new Client();
				StringBuilder userInformation = new StringBuilder();
				userInformation.append(usernameSignInTextField.getText()+","+ passwordSignInTextField.getText());
				if(client.isValidUser(userInformation.toString())){
					goToPanel(DASHBOARD_PANEL);
				}
				else{
					displayErrorMessage("Username or Password Incorrect");
				}
			}});

		passwordSignInTextField = new JPasswordField();
		passwordSignInTextField.setColumns(20);

		JButton backSignInButton = new JButton("Back");
		backSignInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goToPanel(WELCOME_PANEL);
			}
		});

		GroupLayout gl_signInWindowPanel = new GroupLayout(signInWindowPanel);
		gl_signInWindowPanel.setHorizontalGroup(
			gl_signInWindowPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_signInWindowPanel.createSequentialGroup()
					.addGroup(gl_signInWindowPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_signInWindowPanel.createSequentialGroup()
							.addGap(70)
							.addGroup(gl_signInWindowPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_signInWindowPanel.createSequentialGroup()
									.addComponent(usernameSignInLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(usernameSignInTextField, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_signInWindowPanel.createSequentialGroup()
									.addGap(6)
									.addComponent(passwordSignInLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_signInWindowPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_signInWindowPanel.createSequentialGroup()
											.addComponent(signInButton)
											.addGap(18)
											.addComponent(backSignInButton))
										.addComponent(passwordSignInTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_signInWindowPanel.createSequentialGroup()
							.addGap(162)
							.addComponent(signInWindowLabel)))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_signInWindowPanel.setVerticalGroup(
			gl_signInWindowPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_signInWindowPanel.createSequentialGroup()
					.addGap(34)
					.addComponent(signInWindowLabel)
					.addGap(44)
					.addGroup(gl_signInWindowPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameSignInLabel)
						.addComponent(usernameSignInTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_signInWindowPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordSignInLabel)
						.addComponent(passwordSignInTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_signInWindowPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(backSignInButton)
						.addComponent(signInButton))
					.addGap(31))
		);

		signInWindowPanel.setLayout(gl_signInWindowPanel);
	}

	private void createWelcomePanel(JPanel welcomeWindowPanel) {
		JLabel fileSharingLabel = new JLabel("Media Sharing");
		fileSharingLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		fileSharingLabel.setForeground(Color.BLACK);

		JButton signInWelcomeButton = new JButton("Sign In");
		signInWelcomeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goToPanel(SIGN_IN_PANEL);
			}
		});

		JButton signUpWelcomeButton = new JButton("Sign Up");
		signUpWelcomeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goToPanel(SIGN_UP_PANEL);
			}
		});

		JLabel newUserLabel = new JLabel("New User?");
		GroupLayout gl_welcomeWindowPanel = new GroupLayout(welcomeWindowPanel);
		gl_welcomeWindowPanel.setHorizontalGroup(
			gl_welcomeWindowPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_welcomeWindowPanel.createSequentialGroup()
					.addGap(183)
					.addGroup(gl_welcomeWindowPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(fileSharingLabel)
						.addGroup(gl_welcomeWindowPanel.createParallelGroup(Alignment.TRAILING)
							.addComponent(signUpWelcomeButton)
							.addGroup(gl_welcomeWindowPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(signInWelcomeButton)
								.addComponent(newUserLabel))))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		gl_welcomeWindowPanel.setVerticalGroup(
			gl_welcomeWindowPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_welcomeWindowPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(fileSharingLabel)
					.addGap(44)
					.addComponent(signInWelcomeButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(newUserLabel)
					.addGap(12)
					.addComponent(signUpWelcomeButton)
					.addGap(126))
		);
		welcomeWindowPanel.setLayout(gl_welcomeWindowPanel);
	}
}
