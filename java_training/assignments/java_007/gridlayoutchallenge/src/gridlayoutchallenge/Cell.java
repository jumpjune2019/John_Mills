package gridlayoutchallenge;

import javax.swing.*;

public class Cell extends JPanel{

	JButton button;
	JLabel label;
	int rows, columns;
	

	//this looks like absolute garbage, but it works
	//I will refactor code later when I can
	//It is too late to do this now and I need sleep
	public Cell(JLabel bottomLabel, int rows, int columns) {
		
		this.rows = rows;
		this.columns = columns;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		String input = getCharForNumber(rows) + "-" + Integer.toString(columns);
		button = new JButton(input);
		label = new JLabel(input);
		
		button.addActionListener((ae) ->{
			bottomLabel.setText(label.getText());
		});

		this.add(label);
		this.add(button);
		
	}
	
	
	public static String getCharForNumber(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}
	
	
}//end Cell class