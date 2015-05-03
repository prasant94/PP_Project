package client.gui;

public class ErrorWindow extends PopUpWindow {
	public static String ERROR_MESSAGE = "Oops! ";
	/**
	 *
	 * @param err
	 */
	public ErrorWindow(String err) {
		super(ERROR_MESSAGE.concat(err));
		
		
	}
}
