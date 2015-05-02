package client.gui;

import java.awt.CardLayout;
import java.awt.Color;
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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import client.Client;
import javax.swing.JPasswordField;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	final static String WELCOME_PANEL = "Welcome Panel";
	final static String SIGN_IN_PANEL = "Sign In Panel";
	final static String SIGN_UP_PANEL = "Sign Up Panel";
	final static String DASHBOARD_PANEL = "Dashboard Panel";

	static final String BROWSE_FILE_PANEL = "Browse File Panel";
	private JTextField usernameSignInTextField;
	private JTextField usernameSignUpTextField;
	private JTextField emailSignUpTextField;
	private JTextField passwordSignUpTextField;
	private JTextField confirmPasswordSignUpTextField;

	public Client client;
	JPanel browseFilePanel;
	JPanel fileList;
	private JPasswordField passwordSignInTextField;
	public MainWindow() {
//		client = new Client();
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

		JButton fileToDownloadChosenButton = new JButton("Done");
		GroupLayout gl_informationInBrowsePanel = new GroupLayout(informationInBrowsePanel);
		gl_informationInBrowsePanel.setHorizontalGroup(
			gl_informationInBrowsePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_informationInBrowsePanel.createSequentialGroup()
					.addContainerGap(97, Short.MAX_VALUE)
					.addComponent(fileChooseLabel)
					.addGap(68))
				.addGroup(gl_informationInBrowsePanel.createSequentialGroup()
					.addGap(152)
					.addComponent(fileToDownloadChosenButton)
					.addContainerGap(181, Short.MAX_VALUE))
		);
		gl_informationInBrowsePanel.setVerticalGroup(
			gl_informationInBrowsePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_informationInBrowsePanel.createSequentialGroup()
					.addGap(21)
					.addComponent(fileChooseLabel)
					.addGap(27)
					.addComponent(fileToDownloadChosenButton)
					.addContainerGap(48, Short.MAX_VALUE))
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
		// TODO Auto-generated method stub
	}

	private void browseFiles() {
		List<String> filesOnServer = client.browseMedia();
		fileList.setLayout(new GridLayout(filesOnServer.size(), 1));
		ButtonGroup radioButtonGroup = new ButtonGroup();
		for(String s : filesOnServer){
			JRadioButton file = new JRadioButton(s);
			fileList.add(file);
			radioButtonGroup.add(file);
		}
	}
	private void uploadFile() throws IOException {

		//Create a file chooser
		final JFileChooser fc = new JFileChooser();

		fc.showOpenDialog(null);
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

		passwordSignUpTextField = new JTextField();
		passwordSignUpTextField.setColumns(10);

		confirmPasswordSignUpTextField = new JTextField();
		confirmPasswordSignUpTextField.setColumns(10);

		JButton signUpButton = new JButton("Sign Up");
		signUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				client = new Client();
				client.addUser(usernameSignUpTextField.getText(), emailSignUpTextField.getText(), passwordSignUpTextField.getText());
				goToPanel(DASHBOARD_PANEL);
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
							.addGap(47)
							.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(usernameSignUpLabel)
								.addGroup(gl_signUpWindowPanel.createSequentialGroup()
									.addGap(12)
									.addComponent(confirmPasswordSignUpLabel))
								.addComponent(emailSignUpLabel)
								.addComponent(passwordSignUpLabel))
							.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_signUpWindowPanel.createSequentialGroup()
									.addGap(44)
									.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(confirmPasswordSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(emailSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_signUpWindowPanel.createSequentialGroup()
									.addGap(35)
									.addComponent(usernameSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_signUpWindowPanel.createSequentialGroup()
							.addGap(168)
							.addComponent(signUpButton)))
					.addContainerGap(105, Short.MAX_VALUE))
		);

		gl_signUpWindowPanel.setVerticalGroup(
			gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
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
					.addGap(18)
					.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_signUpWindowPanel.createSequentialGroup()
							.addComponent(emailSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_signUpWindowPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(passwordSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordSignUpLabel))
							.addGap(18)
							.addComponent(confirmPasswordSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_signUpWindowPanel.createSequentialGroup()
							.addComponent(emailSignUpLabel)
							.addGap(64)
							.addComponent(confirmPasswordSignUpLabel)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(signUpButton)
					.addContainerGap(20, Short.MAX_VALUE))
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
		final JPanel panel = new JPanel();

		JButton DownloadButton = new JButton("Download");
		DownloadButton.setEnabled(false);

		JButton browseFilesButton = new JButton("Browse Files");

		JButton StreamButton = new JButton("Stream");
		StreamButton.setEnabled(false);

		JLabel dashboardLabel = new JLabel("Dashboard");

		GroupLayout gl_dashboardWIndowPanel = new GroupLayout(dashboardWindowPanel);
		gl_dashboardWIndowPanel.setHorizontalGroup(
			gl_dashboardWIndowPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dashboardWIndowPanel.createSequentialGroup()
					.addGroup(gl_dashboardWIndowPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dashboardWIndowPanel.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_dashboardWIndowPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dashboardWIndowPanel.createSequentialGroup()
									.addComponent(DownloadButton)
									.addGap(18)
									.addComponent(StreamButton))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_dashboardWIndowPanel.createSequentialGroup()
									.addComponent(browseFilesButton)
									.addGap(18)
									.addComponent(uploadFileButton))))
						.addGroup(gl_dashboardWIndowPanel.createSequentialGroup()
							.addGap(151)
							.addComponent(dashboardLabel)))
					.addContainerGap(99, Short.MAX_VALUE))
		);

		gl_dashboardWIndowPanel.setVerticalGroup(
				gl_dashboardWIndowPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_dashboardWIndowPanel.createSequentialGroup()
						.addComponent(dashboardLabel)
						.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
						.addGroup(gl_dashboardWIndowPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(browseFilesButton)
							.addComponent(uploadFileButton))
						.addGap(20)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_dashboardWIndowPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(DownloadButton)
							.addComponent(StreamButton))
						.addGap(34))
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
				client = new Client();
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
										.addComponent(signInButton)
										.addComponent(passwordSignInTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(6))
						.addGroup(gl_signInWindowPanel.createSequentialGroup()
							.addGap(162)
							.addComponent(signInWindowLabel)))
					.addContainerGap(53, Short.MAX_VALUE))
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
					.addGap(43)
					.addComponent(signInButton)
					.addContainerGap(42, Short.MAX_VALUE))
		);

		signInWindowPanel.setLayout(gl_signInWindowPanel);
	}

	private void createWelcomePanel(JPanel welcomeWindowPanel) {
		JLabel fileSharingLabel = new JLabel("File Sharing");
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
						.addComponent(newUserLabel)
						.addComponent(signUpWelcomeButton)
						.addComponent(signInWelcomeButton)
						.addComponent(fileSharingLabel))
					.addGap(179))
		);
		gl_welcomeWindowPanel.setVerticalGroup(
			gl_welcomeWindowPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_welcomeWindowPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(fileSharingLabel)
					.addGap(65)
					.addComponent(signInWelcomeButton)
					.addGap(12)
					.addComponent(newUserLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(signUpWelcomeButton)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		welcomeWindowPanel.setLayout(gl_welcomeWindowPanel);
	}
}
