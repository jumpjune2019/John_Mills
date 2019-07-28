package gridlayoutchallenge;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.*;

public class MyGrid{

	private JFrame frm;
	private JPanel panel;
	private JLabel topLabel;
	private JLabel bottomLabel;
	
	
	public MyGrid() {
		prepareGui();
	}
	

	private void prepareGui() {
		
		int rows = getRandomNum();
		int columns = getRandomNum();
		
		frm = new JFrame("Column and Rows Example");
		frm.setSize((rows*50), (rows*50) + 80);
		frm.setLocationRelativeTo(null);
		frm.setLayout(new BorderLayout());
		
		topLabel = new JLabel("Basic Matrix Demo", JLabel.CENTER);
		bottomLabel = new JLabel("No Seat Selected", JLabel.CENTER);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(rows, columns));		
		
		for(int i=0; i < rows; i++) {
			for(int j=0; j < columns; j++) {
				panel.add(new Cell(bottomLabel, i+1, j+1));
			}
		}

		frm.add(topLabel, BorderLayout.NORTH);
		frm.add(panel, BorderLayout.CENTER);
		frm.add(bottomLabel, BorderLayout.SOUTH);
		frm.setVisible(true);
		
		// old school way to close a window
		frm.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	             // this is the way to force a java application to gracefully exit
	        	 // when not going to end via the main method entry point
	        	 System.exit(0);
	         }        
	    }); 
		
	}//end prepareGui
	
	

	public static int getRandomNum() {
		
		Random rand = new Random();
		int myRandom = rand.nextInt(4) + 2;
		
		return myRandom;
		
	}//end getRandomNum
	
	
}//end MyGrid class