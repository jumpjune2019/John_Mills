import javax.swing.*;

/*
 * creates an object that holds the JList and DefaultListModel
 * that allows easy access to pass between classes and mutable
 * by all classes it is passed to
 */
public class MyList{
	
	JList<Client> jlst;
	DefaultListModel<Client> defaultList;
	JLabel jlab;
	JScrollPane jscrlp;
	Client[] myList;
	JButton button;
	int index;
	
	MyList(Client[] myList) {
		
		//starts at -1 since DefaultListModel grabs the first
		//position if nothing is selected
		index = -1;
		this.myList = myList;

		//creates a list model that mutates the JList
		defaultList = new DefaultListModel<Client>();
		jlst = new JList<Client>(defaultList);
		for(Client myClient : myList) {
			defaultList.addElement(myClient);
		}
		
		jlst.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jlab = new JLabel("Please choose a name");
		
		jlst.addListSelectionListener((le) -> {
			
			index = jlst.getSelectedIndex(); 
			
		}); //end addlistener		
		
	}//end MyList constructor
	
	
	public JList<Client> getJList() {
		return jlst;
	}
	
	public DefaultListModel<Client> getDefaultList() {
		return defaultList;
	}
	
	public int getIndex() {
		return index;
	}

	
}//end MyList class