import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.border.Border;

public class TestPanel extends JPanel implements ActionListener {
	
	public static JPanel topPanel = new JPanel(), desriptionPanel = new JPanel(), taskPanel = new JPanel(),enterPanel = new JPanel(), botPanel = new JPanel();
	//top panel components
	public static JLabel virsrakstsLabel = new JLabel("Virsraksts"), uzdLabel = new JLabel("0. uzdevums"), pointsLabel = new JLabel("1 Point ");
	//desription panel components
	public static JLabel descriptionLabel = new JLabel("Description about the the task you have to complete.");
	//submit panel components
	public JButton submitButton = new JButton("Atbildēt");
	//bot panel components
	public static JButton backButton = new JButton("   iepriekšējais   "), nextButton = new JButton("   nākamais   ");
	
	//type1
	public static JRadioButton[] radioArray;
	//type2
	public static JCheckBox[] boxArray;
	//type3
	public static JTextField field = new JTextField("");
	public static JLabel taskLabel = new JLabel("");
	
	// Testa panelis
	public TestPanel() {
		//setBackground(Color.green);
		FlowLayout layout = (FlowLayout)getLayout();
		layout.setVgap(0);
		setLayout(layout);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		topPanel.setPreferredSize(new Dimension(580,50));
        topPanel.setBackground(Color.gray);
        topPanel.setBorder(blackline);
        addCompTop();
        add(topPanel);
        
        desriptionPanel.setPreferredSize(new Dimension(580,100));
        addCompDesription();
        add(desriptionPanel);
        
        taskPanel.setPreferredSize(new Dimension(580,110));
        //taskPanel.setBackground(Color.blue);
        add(taskPanel);
        
        enterPanel.setPreferredSize(new Dimension(580,50));
        enterPanel.setBackground(Color.lightGray);
        addCompSubmit();
        add(enterPanel);
        
        botPanel.setPreferredSize(new Dimension(580,50));
        botPanel.setBackground(Color.gray);
        botPanel.setBorder(blackline);
        addCompBot();
        add(botPanel);
        
        
	}
	
	public void addCompTop() {
		topPanel.setLayout(new BorderLayout(20, 5));
		topPanel.add(virsrakstsLabel, BorderLayout.WEST);
		uzdLabel.setHorizontalAlignment(JLabel.CENTER);
		topPanel.add(uzdLabel, BorderLayout.CENTER);
		topPanel.add(pointsLabel, BorderLayout.EAST);
	}
	public void addCompDesription() {
		desriptionPanel.setLayout(new BorderLayout());
		desriptionPanel.add(descriptionLabel, BorderLayout.NORTH);
	}
	public void addCompSubmit() {
		enterPanel.setLayout(new BorderLayout());
		enterPanel.setBorder(BorderFactory.createEmptyBorder(5, 100, 5, 100));
		submitButton.addActionListener(this);
		enterPanel.add(submitButton, BorderLayout.CENTER);
		
	}	
	public void addCompBot() {
		botPanel.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		botPanel.setLayout(new BorderLayout());
		backButton.addActionListener(this);
		nextButton.addActionListener(this);
		botPanel.add(backButton, BorderLayout.WEST);
		botPanel.add(nextButton, BorderLayout.EAST);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {
			
		}
		else if(e.getSource() == backButton) {
			
		}
		else if(e.getSource() == nextButton) {
			
		}
	}
}
