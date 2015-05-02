package client.gui;

import java.awt.CardLayout;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.Client;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class MainWindow extends JFrame {
	final static String WELCOME_PANEL = "Welcome Panel";
	final static String SIGN_IN_PANEL = "Sign In Panel";
	final static String SIGN_UP_PANEL = "Sign Up Panel";
	final static String DASHBOARD_PANEL = "Dashboard Panel";
	private JTextField passwordSignInTextField;
	private JTextField usernameSignInTextField;
	private JTextField usernameSignUpTextField;
	private JTextField emailSignUpTextField;
	private JTextField passwordSignUpTextField;
	private JTextField textField;
	
	public MainWindow() {
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel welcomePanel = new JPanel();
		getContentPane().add(welcomePanel, "name_25468806608141");
		
		JLabel fileSharingLabel = new JLabel("File Sharing");
		fileSharingLabel.setForeground(Color.BLACK);
		
		JButton signInWelcomeButton = new JButton("Sign In");
		
		JButton signUpWelcomeButton = new JButton("Sign Up");
		
		JLabel newUserLabel = new JLabel("New User?");
		GroupLayout gl_welcomePanel = new GroupLayout(welcomePanel);
		gl_welcomePanel.setHorizontalGroup(
			gl_welcomePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_welcomePanel.createSequentialGroup()
					.addGap(183)
					.addGroup(gl_welcomePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(newUserLabel)
						.addComponent(signUpWelcomeButton)
						.addComponent(signInWelcomeButton)
						.addComponent(fileSharingLabel))
					.addGap(179))
		);
		gl_welcomePanel.setVerticalGroup(
			gl_welcomePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_welcomePanel.createSequentialGroup()
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
		welcomePanel.setLayout(gl_welcomePanel);
		
		JPanel signInPanel = new JPanel();
		getContentPane().add(signInPanel, "name_25468806608141");
		
		JLabel usernameSignInLabel = new JLabel("Username - ");
		
		JLabel passwordSignInLabel = new JLabel("Password -");
		
		passwordSignInTextField = new JTextField();
		passwordSignInTextField.setColumns(20);
		
		usernameSignInTextField = new JTextField();
		usernameSignInTextField.setColumns(20);
		
		JLabel signInWindowLabel = new JLabel("Sign In");
		signInWindowLabel.setForeground(Color.BLACK);
		
		JButton signInButton = new JButton("Sign In");
		GroupLayout gl_signInPanel = new GroupLayout(signInPanel);
		gl_signInPanel.setHorizontalGroup(
			gl_signInPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_signInPanel.createSequentialGroup()
					.addGroup(gl_signInPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_signInPanel.createSequentialGroup()
							.addGap(70)
							.addGroup(gl_signInPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_signInPanel.createSequentialGroup()
									.addComponent(usernameSignInLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(usernameSignInTextField, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_signInPanel.createSequentialGroup()
									.addGap(6)
									.addComponent(passwordSignInLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_signInPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(signInButton)
										.addComponent(passwordSignInTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_signInPanel.createSequentialGroup()
							.addGap(162)
							.addComponent(signInWindowLabel)))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_signInPanel.setVerticalGroup(
			gl_signInPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_signInPanel.createSequentialGroup()
					.addGap(34)
					.addComponent(signInWindowLabel)
					.addGap(44)
					.addGroup(gl_signInPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameSignInLabel)
						.addComponent(usernameSignInTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_signInPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordSignInTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordSignInLabel))
					.addGap(31)
					.addComponent(signInButton)
					.addContainerGap(67, Short.MAX_VALUE))
		);
		signInPanel.setLayout(gl_signInPanel);
		
		JPanel confirmPasswordSignUpTextField = new JPanel();
		getContentPane().add(confirmPasswordSignUpTextField, "name_25468806608141");
		
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
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton signUpButton = new JButton("Sign Up");
		GroupLayout gl_confirmPasswordSignUpTextField = new GroupLayout(confirmPasswordSignUpTextField);
		gl_confirmPasswordSignUpTextField.setHorizontalGroup(
			gl_confirmPasswordSignUpTextField.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_confirmPasswordSignUpTextField.createSequentialGroup()
					.addGroup(gl_confirmPasswordSignUpTextField.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_confirmPasswordSignUpTextField.createSequentialGroup()
							.addGap(153)
							.addComponent(signUpPanelLabel))
						.addGroup(gl_confirmPasswordSignUpTextField.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_confirmPasswordSignUpTextField.createParallelGroup(Alignment.TRAILING)
								.addComponent(usernameSignUpLabel)
								.addGroup(gl_confirmPasswordSignUpTextField.createSequentialGroup()
									.addGap(12)
									.addComponent(confirmPasswordSignUpLabel))
								.addComponent(emailSignUpLabel)
								.addComponent(passwordSignUpLabel))
							.addGroup(gl_confirmPasswordSignUpTextField.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_confirmPasswordSignUpTextField.createSequentialGroup()
									.addGap(44)
									.addGroup(gl_confirmPasswordSignUpTextField.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(emailSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_confirmPasswordSignUpTextField.createSequentialGroup()
									.addGap(35)
									.addComponent(usernameSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_confirmPasswordSignUpTextField.createSequentialGroup()
							.addGap(168)
							.addComponent(signUpButton)))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		gl_confirmPasswordSignUpTextField.setVerticalGroup(
			gl_confirmPasswordSignUpTextField.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_confirmPasswordSignUpTextField.createSequentialGroup()
					.addGroup(gl_confirmPasswordSignUpTextField.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_confirmPasswordSignUpTextField.createSequentialGroup()
							.addGap(85)
							.addGroup(gl_confirmPasswordSignUpTextField.createParallelGroup(Alignment.BASELINE)
								.addComponent(usernameSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(usernameSignUpLabel)))
						.addGroup(gl_confirmPasswordSignUpTextField.createSequentialGroup()
							.addGap(20)
							.addComponent(signUpPanelLabel)))
					.addGap(18)
					.addGroup(gl_confirmPasswordSignUpTextField.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_confirmPasswordSignUpTextField.createSequentialGroup()
							.addComponent(emailSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_confirmPasswordSignUpTextField.createParallelGroup(Alignment.BASELINE)
								.addComponent(passwordSignUpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordSignUpLabel))
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_confirmPasswordSignUpTextField.createSequentialGroup()
							.addComponent(emailSignUpLabel)
							.addGap(64)
							.addComponent(confirmPasswordSignUpLabel)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(signUpButton)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		confirmPasswordSignUpTextField.setLayout(gl_confirmPasswordSignUpTextField);
		
		JPanel dashboardPanel = new JPanel();
		getContentPane().add(dashboardPanel, "name_25468806608141");
		
		JButton uploadFileButton = new JButton("Upload File");
		
		JPanel panel = new JPanel();
		
		JButton DownloadButton = new JButton("Download");
		DownloadButton.setEnabled(false);
		
		JButton browseFilesButton = new JButton("Browse Files");
		
		JButton StreamButton = new JButton("Stream");
		StreamButton.setEnabled(false);
		
		JLabel dashboardLabel = new JLabel("Dashboard");
		GroupLayout gl_dashboardPanel = new GroupLayout(dashboardPanel);
		gl_dashboardPanel.setHorizontalGroup(
			gl_dashboardPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dashboardPanel.createSequentialGroup()
					.addGroup(gl_dashboardPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dashboardPanel.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_dashboardPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dashboardPanel.createSequentialGroup()
									.addComponent(DownloadButton)
									.addGap(18)
									.addComponent(StreamButton))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_dashboardPanel.createSequentialGroup()
									.addComponent(browseFilesButton)
									.addGap(18)
									.addComponent(uploadFileButton))))
						.addGroup(gl_dashboardPanel.createSequentialGroup()
							.addGap(151)
							.addComponent(dashboardLabel)))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		gl_dashboardPanel.setVerticalGroup(
			gl_dashboardPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dashboardPanel.createSequentialGroup()
					.addComponent(dashboardLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(gl_dashboardPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(browseFilesButton)
						.addComponent(uploadFileButton))
					.addGap(20)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_dashboardPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(DownloadButton)
						.addComponent(StreamButton))
					.addGap(34))
		);
		dashboardPanel.setLayout(gl_dashboardPanel);
	
	}
	
//	private void createPanelsAndAddToCards() {
//		welcomePanel = new WelcomePanel();
//		signInPanel = new SignInPanel();
//		signUpPanel = new SignUpPanel();
//		dashboardPanel = new DashboardPanel();
//		
//		cards.add(welcomePanel,WELCOME_PANEL);
//		cards.add(signInPanel,SIGN_IN_PANEL);
//		cards.add(signUpPanel,SIGN_UP_PANEL);
//		cards.add(dashboardPanel,DASHBOARD_PANEL);
//		
//	}

	public static void main(String[] args){
		
		MainWindow main = new MainWindow();
	}
}
