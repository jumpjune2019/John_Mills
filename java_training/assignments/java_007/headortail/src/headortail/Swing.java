package headortail;

//A simple Swing Class
import javax.swing.*;

class Swing{
	private JFrame jfrm;
	Swing(String title) {
		// Create a new JFrame container.
		jfrm = new JFrame(title);
		jfrm.setLayout(new BoxLayout(jfrm.getContentPane(), BoxLayout.Y_AXIS));
	}
	public JFrame getFrame() {
		return jfrm;
	}
}