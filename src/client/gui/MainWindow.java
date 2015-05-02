package client.gui;

import java.awt.CardLayout;
import java.awt.Frame;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField confirmPasswordSignUpTextField;
	
	public Client client;
	
	public MainWindow() {
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel welcomeWindowPanel = new JPanel();
		JPanel signInWindowPanel = new JPanel();
		JPanel dashboardWIndowPanel = new JPanel();
		JPanel signUpWindowPanel = new JPanel();
		
		getContentPane().add(welcomeWindowPanel, WELCOME_PANEL);
		getContentPane().add(signInWindowPanel, SIGN_IN_PANEL);
		getContentPane().add(dashboardWIndowPanel, SIGN_UP_PANEL);
		getContentPane().add(signUpWindowPanel, DASHBOARD_PANEL);
		
		JLabel fileSharingLabel = new JLabel("File Sharing");
		fileSharingLabel.setForeground(Color.BLACK);
		
		JButton signInWelcomeButton = new JButton("Sign In");
		signInWelcomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToPanel(SIGN_IN_PANEL);
			}
		});
		
		JButton signUpWelcomeButton = new JButton("Sign Up");
		signUpWelcomeButton.addActionListener(new ActionListener() {
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
		
		
		
		
		JLabel usernameSignInLabel = new JLabel("Username - ");
		
		JLabel passwordSignInLabel = new JLabel("Password -");
		
		passwordSignInTextField = new JTextField();
		passwordSignInTextField.setColumns(20);
		
		usernameSignInTextField = new JTextField();
		usernameSignInTextField.setColumns(20);
		
		JLabel signInWindowLabel = new JLabel("Sign In");
		signInWindowLabel.setForeground(Color.BLACK);
		
		JButton signInButton = new JButton("Sign In");
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignInPanel.validateCredentials(usernameSignInTextField.getText(), passwordSignInTextField.getText());
				client.
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
										.addComponent(signInButton)
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
					.addGap(18)
					.addGroup(gl_signInWindowPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordSignInTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordSignInLabel))
					.addGap(31)
					.addComponent(signInButton)
					.addContainerGap(67, Short.MAX_VALUE))
		);
		signInWindowPanel.setLayout(gl_signInWindowPanel);
		
		
		
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
		
		
		
		JButton uploadFileButton = new JButton("Upload File");
		
		JPanel panel = new JPanel();
		
		JButton DownloadButton = new JButton("Download");
		DownloadButton.setEnabled(false);
		
		JButton browseFilesButton = new JButton("Browse Files");
		
		JButton StreamButton = new JButton("Stream");
		StreamButton.setEnabled(false);
		
		JLabel dashboardLabel = new JLabel("Dashboard");
		GroupLayout gl_dashboardWIndowPanel = new GroupLayout(dashboardWIndowPanel);
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
		dashboardWIndowPanel.setLayout(gl_dashboardWIndowPanel);
	
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
//	}

	public static void main(String[] args){
		
		 MainWindow main = new MainWindow();
		 
		 main.setSize(500, 500);
		 main.setVisible(true);
	}
	
	
	private void goToNextPanel() {
        CardLayout cl = (CardLayout)(getContentPane().getLayout());
        cl.next(getContentPane());
    }
//
    private void goToPrevPanel() {
        CardLayout cl = (CardLayout)(getContentPane().getLayout());
        cl.previous(getContentPane());
    }

    private void goToPanel(String panelName) {
        CardLayout cl = (CardLayout)(getContentPane().getLayout());
        cl.show(getContentPane(), panelName);
    }
}
