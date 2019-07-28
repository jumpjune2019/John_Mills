package gridlayoutchallenge;

import javax.swing.*;

public class Driver {

	
	public static void main(String[] args) {
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MyGrid();  
			}
		});   
		
	}//end main
	
}//end Driver class