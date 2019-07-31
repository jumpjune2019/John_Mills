package jlist;

import java.awt.event.*;

import javax.swing.*;

/*
 * TODO
 * The buttons need different functionality in the end
 * these are just for testing for the frid layout
 * 
 */

@SuppressWarnings("serial")
public class AddOrRemovePanel extends JPanel implements ActionListener {

	JButton addBtn;
	JButton rmvBtn;
	MyList myList;
	
	public AddOrRemovePanel(MyList myList){
		
		this.myList = myList;
		addBtn = new JButton("Add Client");
		rmvBtn = new JButton("Remove Client");
		addBtn.addActionListener(this);
		rmvBtn.addActionListener(this);
		this.add(addBtn);
		this.add(rmvBtn);
		
	}
	
	/*
	 * TODO
	 * currently testing the functionality of it
	 * go back and print off correct stuff when
	 * the time comes
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		//just for ease of reading when working with the objects
		DefaultListModel<Client> temp = myList.getDefaultList();
		int index = myList.getIndex();
		
		
		if(ae.getActionCommand().equals("Add Client")) {
			System.out.println("Added");
		}else {
				temp.removeElementAt(index);
		}
		
	}//end actionPerformed

	
}//end class AddOrRemove