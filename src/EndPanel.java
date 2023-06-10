import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.Border;

public class EndPanel extends JPanel implements ActionListener {
	// paneļi no kā sastāvēs EndPanel
	public static JPanel topPanel = new JPanel(), botPanel = new JPanel();
	//toppanel
	public static JLabel t1 = new JLabel("Testa rezultāti"), t2 = new JLabel("procenti% pareizi"), t3 = new JLabel("laiks");
	//mid
	public static JTextArea midPanel = new JTextArea(14, 22);
	
	//bot panel
	public static JButton btn1 = new JButton("iziet"), btn2 = new JButton("atkārtot");
	//EndPanel
	public EndPanel() {
		FlowLayout layout = (FlowLayout)getLayout();
		layout.setVgap(0);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		topPanel.setPreferredSize(new Dimension(580,70));
        topPanel.setBackground(Color.gray);
        topPanel.setBorder(blackline);
        topPanel.setLayout(new BorderLayout(40, 0));
        addCompTop();
        add(topPanel);
        addCompMid();
        
        JScrollPane scrollBar = new JScrollPane(midPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        add(scrollBar);
        botPanel.setPreferredSize(new Dimension(580,60));
        botPanel.setBackground(Color.gray);
        botPanel.setBorder(blackline);
        addCompBot();
        add(botPanel);

	}
	// pievieno komponentes top panelim
	private void addCompTop() {
		topPanel.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		topPanel.add(t1, BorderLayout.WEST);
		t2.setHorizontalAlignment(JLabel.CENTER);
		// aprēķina testa procentus 
		int pareizie=0;		
		for (Object element : Main.taskArray) {
			Test el = (Test) element;
			if(el.correct) {
				pareizie++;
			}
		}
		double procenti = (double) Main.getNumberOfTests();
		procenti = (pareizie/procenti)*100;
		int score = (int) procenti;
		//pievieno datus
		t2.setText(score+"% izpildīts pareizi");
		topPanel.add(t2, BorderLayout.CENTER);
		//aprēķina testa laiku
		long elapsed = ((Main.finish - Main.start) / 1000);
		long h = 0;
		long min = elapsed/60;
		if (min>=60) {
			h = min/60;
			min = min%60;
		}
		long sec = elapsed%60;
		t3.setText(h+"."+min+"."+sec+" laiks");
		topPanel.add(t3, BorderLayout.EAST);
	}
	
	// pievieno komponentes ar testa rezultātiem midPanelim
	private void addCompMid() {
		
		
		String virkne="";
		for(Object element : Main.taskArray) {
			Test el = (Test) element;
			if(el.correct) {
				virkne += (el.virsraksts+"\t"+el.id+".udz"+"\tpareizi\n");								
			}
			else {
				virkne += (el.virsraksts+"\t"+el.id+".udz"+"\tnepareizi\n");				
			}
			midPanel.setText("Nosaukums\tUzdevums\tizpildīts\n\n"+virkne);
		}
	}
	
	// pievono komponentes bot panelim
	private void addCompBot() {
		botPanel.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		botPanel.setLayout(new BorderLayout());
		btn1.addActionListener(this);
		botPanel.add(btn1, BorderLayout.WEST);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== btn1) {
			// beidz programmas darbību
			System.exit(0);
		}
		
			
	}
}
