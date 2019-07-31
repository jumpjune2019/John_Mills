import java.awt.Component;
import java.awt.Container;
import java.awt.event.*;

import javax.swing.*;

/*
 * Extended JPanel that holds a flowlayout for 2 separate buttons
 * and resets the entire matrix or prints the list of currently
 * seated people to the console
 */

@SuppressWarnings("serial")
public class ResetPrintPanel extends JPanel implements ActionListener {

	JButton resetMatrix;
	JButton printToConsole;
	MyList myList;
	RowColumnLayout rowAndColumn;
	
	public ResetPrintPanel(MyList myList, RowColumnLayout rowAndColumn){
		
		this.rowAndColumn = rowAndColumn;
		this.myList = myList;
		resetMatrix = new JButton("Reset Entire Matrix");
		printToConsole = new JButton("Print Assigned Seats in Console");
		resetMatrix.addActionListener(this);
		printToConsole.addActionListener(this);
		this.add(resetMatrix);
		this.add(printToConsole);
		
	}
	
	/*
	 * formats and prints the current people
	 * booked to the console
	 */
	private void printSeatsToConsole() {
		
		//grabs the components that are on screen, index 2 is MyCell object
		//which also holds the reference to the client
		Component myPanel = rowAndColumn.getComponent(2);
		Component iter;
		MyCell myCell;
		Client myClient;
		
		System.out.format("%-30s", "Client");
		System.out.format("%-10s", "ID");
		System.out.format("%-5s", "Seat Number");
		System.out.println();
		
		for(int i=0; i < 100; i++) {
			iter = ((Container) myPanel).getComponent(i);
			myCell = (MyCell) iter;
			
			if(myCell.myClient != null) {
				
				myClient = myCell.myClient;
				System.out.format("%-30s", myClient.getClientName());
				System.out.format("%-10s", myClient.getClientId());
				System.out.format("%-10s", getCharForNumber((myCell.i)+1) + "-" + (myCell.j+1)%11);
				System.out.println();
			}
			
		}//end for		
		
		
	}//end printSeatsToConsole
	
	
	/*
	 * resets the entire room back to vacant and throws people
	 * currently booked back into JList
	 */
	private void deleteRoom() {
		
		DefaultListModel<Client> tempList = myList.getDefaultList();
		Component myPanel = rowAndColumn.getComponent(2);
		Component iter;
		MyCell myCell;
		
		for(int i=0; i < 100; i++) {
			iter = ((Container) myPanel).getComponent(i);
			myCell = (MyCell) iter;
			if(myCell.myClient != null) {
				tempList.addElement(myCell.myClient);
				myCell.button.setText("   Book  ");
				myCell.label.setText("Vacant");
				myCell.myClient = null;
			}
		}//end for
		
	}//end deleteRoom
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getActionCommand().equals("Reset Entire Matrix")) {
			//System.out.println("Added");
				deleteRoom();
		}else {
			printSeatsToConsole();		
		}
		
	}//end actionPerformed

	public static String getCharForNumber(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}
	
}//end class AddOrRemove