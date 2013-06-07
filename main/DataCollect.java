import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Hashtable;

public class DataCollect {
	
    LocalQ answers = new LocalQ();
    JTextField teamNameQ = new JTextField(30);
    	
	public DataCollect()
	{
	
	JFrame collectFrame = new JFrame("Enter survey data");
	collectFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    collectFrame.setLocation(400, 400);
    
	//team name
	
	JPanel namePanel = new JPanel();
	
	JLabel teamNameLabel = new JLabel("Team name: ");
	
	namePanel.add(teamNameLabel);
	namePanel.add(teamNameQ);
	
	// sliders
	
	final JSlider service = new JSlider(JSlider.HORIZONTAL, 1, 5, answers.serviceA);
	service.setMajorTickSpacing(1);
	service.setPaintTicks(true);
	service.setPreferredSize( new Dimension( 400, 80 ) ); 
	
	//Create the label table
	Hashtable<Integer, JLabel> labelTable = 
            new Hashtable<Integer, JLabel>();
	labelTable.put( new Integer( 1 ), new JLabel("Very poor") );
	labelTable.put( new Integer( 2 ), new JLabel("Poor") );
	labelTable.put( new Integer( 3 ), new JLabel("Fair") );
	labelTable.put( new Integer( 4 ), new JLabel("Very good") );
	labelTable.put( new Integer( 5 ), new JLabel("Excellent") );
	service.setLabelTable( labelTable );
	service.setPaintLabels(true);
	
	final JSlider listening = new JSlider(JSlider.HORIZONTAL, 1, 5, answers.listeningA);
	listening.setMajorTickSpacing(1);
	listening.setPaintTicks(true);
	listening.setPreferredSize( new Dimension( 400, 80 ) ); 
	listening.setLabelTable( labelTable );
	listening.setPaintLabels(true);
	
	// add labels
	
	JLabel serviceLabel = new JLabel("Service quality");
	JLabel listenLabel = new JLabel("Communication");
	
	// service quality
	
	JPanel serviceCont = new JPanel(  ); 
	
	serviceCont.add(service);
	serviceCont.add(serviceLabel);
	
	serviceCont.setBorder(BorderFactory.createEtchedBorder());
	
	// communication
	
	JPanel listenCont = new JPanel(  );
	
	listenCont.add(listening);
	listenCont.add(listenLabel);
	
	listenCont.setBorder(BorderFactory.createEtchedBorder());

	// setup and display frame
	
	collectFrame.setLayout(new GridLayout(0, 1));
	collectFrame.add(namePanel);
	collectFrame.add(serviceCont);
	collectFrame.add(listenCont);
	collectFrame.pack();
    collectFrame.setVisible(true);
	
	// wire up the event handlers

	service.addChangeListener(new ChangeListener(  ) {
	  public void stateChanged(ChangeEvent e) {
		System.out.println("Service's current value = "
							+ service.getValue(  ));
		}
	});
	
	listening.addChangeListener(new ChangeListener(  ) {
	  public void stateChanged(ChangeEvent e) {
		System.out.println("Listenings's current value = "
							+ listening.getValue(  ));
		}
	});
	
	// create method to get the JTextField
	
	teamNameQ.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent ae){
	   System.out.println("Team name = "
							+ teamNameQ.getText());
      }
	});
	
	}
	
	public class LocalQ
	{
    
    public String teamName = "Unknown";
    public int serviceA = 3;
    public int listeningA = 3;
    public int communicationA = 3;
    public int respectA = 3;
    public int invCareA = 3;
    public int invMedA = 3;
    

}

}
