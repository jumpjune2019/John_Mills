package matrixinput;

import java.awt.Dimension;

import javax.swing.*;

/*
 * this class creates the cells with the persons name
 * and the button to book/unbook
 */
@SuppressWarnings("serial")
public class MyCell extends JPanel{

	
	JLabel label;
	JButton button;
	int i;
	int j;
	
	public MyCell(int i, int j) {
		this.i = i;
		this.j = j;
		prepareGui();
	}
	
	
	private void prepareGui() {
		
		String seatName = getCharForNumber(i+1) + "-" + Integer.toString(j+1);
		
		//panel = new JPanel(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		label = new JLabel(seatName);
		button = new JButton("   Book  ");
		
		//had to put spaces in between some strings to keep the
		//button from resizing once pressed
		button.addActionListener((ae) ->{
			
			if(button.getText().equals("   Book  ")) {
				label.setText("Seat Taken");
				button.setText("Unbook");
			}else {
				label.setText(seatName);
				button.setText("   Book  ");
			}
			
		});
		
		this.add(label);
		this.add(button);
		
	}//end prepareGui
	
	private static String getCharForNumber(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}
	
}//end MyGrid class