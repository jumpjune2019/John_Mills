import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class DriverGui {

	JFrame frm;
	JPanel parentPanel;
	JPanel firstPanel;
	JPanel secondPanel;
	JLabel firstLabel;
	JLabel secondLabel;
	JButton firstButton;
	JButton secondButton;
	JLayeredPane layeredPane;
	
	public DriverGui() {
		
		prepareGui();
		
		
	}//end DriverGui
	
	
	private void prepareGui() {
		
		frm = new JFrame("Superimposed Panels");
		frm.setSize(200, 200);
		
		parentPanel = new JPanel();
		firstPanel = new JPanel();
		secondPanel = new JPanel();
		layeredPane = new JLayeredPane();
		
		firstLabel = new JLabel("First Label");
		secondLabel = new JLabel("Second Label");
		
		firstButton = new JButton("First Button");
		secondButton = new JButton("Second Button");
		
		
		firstPanel.add(firstLabel);
		firstPanel.add(firstButton);
		
		secondPanel.add(secondLabel);
		secondPanel.add(secondButton);
		
		firstPanel.setBounds(100, 50, 150, 100);
		secondPanel.setBounds(100, 50, 150, 100);
		secondPanel.setVisible(false);
		
		
		firstButton.addActionListener((ae) -> {
			secondPanel.setVisible(true);
		});
		
		secondButton.addActionListener((ae) -> {
			secondPanel.setVisible(false);
		});
		
		
		layeredPane.add(firstPanel, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(secondPanel, JLayeredPane.POPUP_LAYER);
//		frm.add(firstPanel);
//		frm.add(secondPanel);
		frm.add(layeredPane);
		frm.setVisible(true);
		
		
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
	}//end prepareGui
	
	
}//end DriverGui