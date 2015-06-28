package keyboard;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
	/** The array of booleans determining whether or not the given key is pressed **/
	private static boolean keysPressed[] = new boolean[128];

	/** The array of booleans determining if the key was pressed last cycle **/
	private static boolean newPressed[] = new boolean[128];

	/**
	 * Returns the pressed state of the given key
	 */
	public static boolean isKeyPressed(char key) {
		newPressed[(int) key] = false;
		return keysPressed[(int) key];
	}

	/**
	 * Returns true on the initial press of a key
	 * (Pressed for the first time and not on the last)
	 */
	public static boolean isKeyNewPressed(char key) {
		boolean value = newPressed[(int) key];
		newPressed[(int) key] = false;
		return value;
	}

	public void keyPressed(KeyEvent e) {
		int index = (int) e.getKeyChar();
		if(!keysPressed[index]) {
			newPressed[index] = true;
		}
		keysPressed[index] = true;
	}

	public void keyReleased(KeyEvent e) {
		int index = (int) e.getKeyChar();
		keysPressed[index] = false;
	}

	public void keyTyped(KeyEvent e) {
	}
}