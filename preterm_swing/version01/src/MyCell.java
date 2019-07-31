import javax.swing.*;

/*
 * this class creates the cells with the persons name
 * and the button to book/unbook
 */
@SuppressWarnings("serial")
public class MyCell extends JPanel{

	
	JLabel label;
	JButton button;
	int i;
	int j;
	MyList myList;
	Client myClient;
	
	public MyCell(MyList myList, int i, int j) {
		this.myList = myList;
		this.i = i;
		this.j = j;
		prepareGui();
	}
	
	
	private void prepareGui() {
				
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		label = new JLabel("Vacant");
		button = new JButton("   Book  ");
		
		//had to put spaces in between some strings to keep the
		//button from resizing once pressed
		button.addActionListener((ae) ->{
			
			DefaultListModel<Client> temp = myList.getDefaultList();
			int index = myList.getIndex();
			
			if(button.getText().equals("   Book  ")) {
				
				if(index != -1) {
					myClient = temp.get(index);
				}
				if(myClient != null) {
					button.setText("Unbook");
					temp.remove(index);
					label.setText(myClient.getClientIdandInit());
				}
			}else {
				temp.addElement(myClient);
				myClient = null;
				label.setText("Vacant");
				button.setText("   Book  ");
			}
			
		});
		
		this.add(label);
		this.add(button);
		
	}//end prepareGui
	
	
}//end MyGrid class