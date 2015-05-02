package client.gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;

public class SignUpPanel extends JPanel {
	private JTextField emailTextField;
	private JTextField userNameTextField;
	private JTextField textField;
	public SignUpPanel() {
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
		
		JLabel signUpWindow = new JLabel("Sign Up");
		signUpWindow.setFont(new Font("Dialog", Font.BOLD, 30));
		signUpWindow.setForeground(Color.RED);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		emailLabel.setForeground(Color.BLACK);
		
		JLabel userNameLabel = new JLabel("User Name");
		userNameLabel.setForeground(Color.BLACK);
		userNameLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.BLACK);
		passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		
		JLabel confirmPasswordLabel = new JLabel("Confirm Password");
		confirmPasswordLabel.setForeground(Color.BLACK);
		confirmPasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		
		JButton signUpButton = new JButton("Sign Up");
		signUpButton.setBackground(Color.LIGHT_GRAY);
		signUpButton.setForeground(Color.BLACK);
		
		emailTextField = new JTextField();
		emailTextField.setForeground(Color.BLACK);
		emailTextField.setColumns(25);
		
		userNameTextField = new JTextField();
		userNameTextField.setForeground(Color.BLACK);
		userNameTextField.setColumns(15);
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(160)
							.addComponent(signUpWindow))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(userNameLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
												.addGap(33)))
										.addComponent(emailLabel))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGap(124))
								.addComponent(confirmPasswordLabel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(323, Short.MAX_VALUE)
					.addComponent(signUpButton)
					.addGap(136))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(signUpWindow)
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(emailLabel))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(userNameLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(confirmPasswordLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(signUpButton)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		// TODO
	}

	/**
	 *
	 * @param username
	 * @return
	 */
	private boolean isValidUsername(String username) {
		// TODO
		return false;
	}

	/**
	 *
	 * @param passsword
	 * @return
	 */
	private boolean isValidPassword(String passsword) {
		// TODO
		return false;
	}
}
