package grid;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyCell extends JPanel{

	
	JLabel label;
	JButton button;
	
	public MyCell() {
		prepareGui();
	}
	
	
	private void prepareGui() {
		
		//panel = new JPanel(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		label = new JLabel("I am a label");
		button = new JButton("Press me!");
		
		
		this.add(label);
		this.add(button);
		
		
	}
	
	
}//end MyGrid class