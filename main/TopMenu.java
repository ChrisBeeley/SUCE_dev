import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Hashtable;

public class TopMenu {
  public static void main(String[] args) 
  {
	JFrame frame = new JFrame("Nottinghamshire Healthcare NHS Trust survey");
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setLocation(200, 200);
	
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(2, 2));
	
	// create buttons
	
	JButton collectButton = new JButton("Collect data");
	JButton uploadButton = new JButton("Upload");
	JButton downloadButton = new JButton("Download");
	JButton exploreButton = new JButton("Explore data");
	
	panel.add(collectButton);
	panel.add(uploadButton);
	panel.add(downloadButton);
	panel.add(exploreButton);
	
	frame.add(panel);
	
	frame.pack();
    frame.setVisible(true);
	
	// wire up the event handlers
	
	collectButton.addActionListener(new ActionListener(  ) {
	  public void actionPerformed(ActionEvent e) {
			new DataCollect();
			}
	});


  }
}

