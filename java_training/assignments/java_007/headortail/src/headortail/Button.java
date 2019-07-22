package headortail;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.*;


import java.awt.event.*;

public class Button  implements ActionListener {
	JLabel jlab;
	String first;
	String second;
	String firstMsg;
	String secondMsg;
	
	public void setButtons(JPanel frm, String f, String s, String sMsg) {
		first = f;
		second = s;
		secondMsg = sMsg;
				
		JButton jbtnUp = new JButton(first);
		JButton jbtnDown = new JButton(second);
		// Add action listeners.
		jbtnUp.addActionListener(this);
		jbtnDown.addActionListener(this);
		// Add the buttons to the content pane.
		frm.add(jbtnUp);
		frm.add(jbtnDown);
		// Create a label.
		jlab = new JLabel("Waiting...");
		// Add the label to the frame.
		frm.add(jlab);
	}
	
	// Handle button events.

	public void actionPerformed(ActionEvent ae) {
		
		Random rand = new Random();
		Flip myFlip = () -> ((rand.nextInt(2) + 1) == 1) ? "Heads" : "Tails";
		firstMsg = myFlip.flip();
		
		if(ae.getActionCommand().equals(first)) {
			jlab.setText(firstMsg);
		} else if(ae.getActionCommand().equals(second)){
			jlab.setText(secondMsg);
		}
	}//end actionPerformed
	

}//end Button class
