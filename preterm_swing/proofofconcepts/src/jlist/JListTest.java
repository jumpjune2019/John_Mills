package jlist;

import javax.swing.SwingUtilities;

public class JListTest {

	
	public static void main(String args[]) {
		
		Client list[];
		ClientStore myStore = new ClientStore("clients_list.csv");
		list = myStore.getClientStore();
				
				
				
				
		// Create the frame on the event dispatching thread.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DriverGui(list);
			}
		});
	}//end main
	
	
}//end JListTest