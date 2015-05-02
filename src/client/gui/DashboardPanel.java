package client.gui;

import java.awt.Panel;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class DashboardPanel extends Panel {
	
	private String fileToUpload() throws IOException {

		//Create a file chooser
		final JFileChooser fc = new JFileChooser();
		
		fc.showOpenDialog(null);
		String uploadFile = fc.getSelectedFile().toString();
		
		return uploadFile;
	}
	public DashboardPanel() {
		
		JLabel welcomeLabel = new JLabel("User-");
		welcomeLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		welcomeLabel.setForeground(Color.BLACK);
		
		JLabel userNameDashboardLabel = new JLabel("");
		userNameDashboardLabel.setForeground(Color.BLACK);
		userNameDashboardLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		
		JButton browseFileButton = new JButton("Browse Files");
				
		JButton uploadFileButton = new JButton("UploadFile");
		uploadFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						fileToUpload();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});

		
		JPanel panel = new JPanel();
		
		JButton downloadButton = new JButton("Download");
		
		JButton streamButton = new JButton("Stream");
		streamButton.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(89)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(welcomeLabel)
								.addComponent(browseFileButton))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(61)
									.addComponent(uploadFileButton, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(170)
									.addComponent(userNameDashboardLabel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(downloadButton)
									.addGap(30)
									.addComponent(streamButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(userNameDashboardLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(welcomeLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(uploadFileButton)
						.addComponent(browseFileButton))
					.addGap(57)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(downloadButton)
						.addComponent(streamButton))
					.addContainerGap(234, Short.MAX_VALUE))
		);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Video 2");
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Video 1");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Video 3");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Video 4");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnNewRadioButton_2)
						.addComponent(rdbtnNewRadioButton_3)
						.addComponent(rdbtnNewRadioButton_1)
						.addComponent(rdbtnNewRadioButton))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(rdbtnNewRadioButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnNewRadioButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}
	
	
}
