package jlist;


import java.awt.*;
import javax.swing.*;

/*
 * 
 * Clicking the button in AddOrRemove class will return a true or false value
 * saying if the seat is taken. If vacant, JList in its class will delete that
 * value from the list and send it to the AddOrRemove class, in which it will be displayed there.
 * I will need a Client reference inside AddOrRemove. Can check for no client in the seat
 * by checking if null. If seat is take, the AddOrRemove class will return the current
 * reference to the Client in the seat. That client will then be added back to the list.
 * AddOrRemove will then change the labels and buttons to say it is vacant
 * 
 * Need to set a check if nothing is selected that the list will
 * not remove the item since Java sets unitialized ints to 0
 * 
 */


public class DriverGui{
	
	JLabel jlab;
	JPanel listPanel;
	Client[] myList;
	AddOrRemovePanel bottom;
	JScrollPane scroller;
	MyList jlstHolder;

	DriverGui(Client[] clientArr) {
		// Create a new JFrame container.
		JFrame jfrm = new JFrame("JList Demo");
		jfrm.setLayout(new BorderLayout());
		jfrm.setSize(400, 500);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//setting list up for component
		jlstHolder = new MyList(clientArr);
		scroller = new JScrollPane(jlstHolder.getJList());
		scroller.setPreferredSize(new Dimension(120, 90));

		
		// Make a label that displays the selection.
		jlab = new JLabel("Please choose a name");
		//button = new JButton("Delete");
		bottom = new AddOrRemovePanel(jlstHolder);

		

		jfrm.add(scroller, BorderLayout.WEST);
		jfrm.add(jlab, BorderLayout.CENTER);
		jfrm.add(bottom, BorderLayout.SOUTH);

		jfrm.setVisible(true);
		
	}

	
}//end class DriverGui