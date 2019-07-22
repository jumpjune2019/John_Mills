package gridlayoutchallenge;

import javax.swing.*;

public class Driver {

	
	public static void main(String[] args) {
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MyGrid grid = new MyGrid();  
			    grid.showGui();
			}
		});   
		
	}//end main
	
}//end Driver class