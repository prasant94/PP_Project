package client.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomePanel extends JPanel {
	public WelcomePanel() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(192, 192, 192));
		
		JButton signIn = new JButton("Sign In");
		signIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpPanel signUp = new SignUpPanel();
				
			}
		});
		signIn.setFont(new Font("Dialog", Font.PLAIN, 20));
		signIn.setForeground(new Color(255, 0, 0));
		signIn.setBackground(new Color(192, 192, 192));
		
		JLabel ApplicationName = new JLabel("File Sharing");
		ApplicationName.setForeground(new Color(255, 0, 0));
		ApplicationName.setFont(new Font("Dialog", Font.BOLD, 35));
		ApplicationName.setBackground(new Color(255, 0, 0));
		
		JButton SignUp = new JButton("Sign Up");
		SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Sign Up Clicked");
			}
		});
		SignUp.setForeground(Color.RED);
		SignUp.setFont(new Font("Dialog", Font.PLAIN, 20));
		SignUp.setBackground(new Color(192, 192, 192));
		
		JLabel newUser = new JLabel("New User?");
		newUser.setForeground(Color.RED);
		newUser.setBackground(Color.BLACK);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(83)
					.addComponent(ApplicationName)
					.addContainerGap(90, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(130)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(newUser)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(SignUp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addComponent(signIn, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
							.addGap(123))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(ApplicationName)
					.addGap(52)
					.addComponent(signIn)
					.addGap(18)
					.addComponent(newUser)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(SignUp, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(81, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		// TODO`1`
	}
}
