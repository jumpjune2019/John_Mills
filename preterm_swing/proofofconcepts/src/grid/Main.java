package grid;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new DriverGui();
			}
		});
		
	}//end main
	
}//end Main class