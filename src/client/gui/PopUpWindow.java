package client.gui;

import java.awt.PopupMenu;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PopUpWindow extends JFrame {
	/**
	 * @param string 
	 *
	 */
	public PopUpWindow(String string) {
		this.setVisible(true);
		this.setSize(300, 100);
		JLabel message = new JLabel(string);
		this.add(message);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 *
	 */
	public void close() {
		// TODO
	}
}
