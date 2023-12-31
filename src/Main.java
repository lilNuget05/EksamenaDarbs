import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class Main {
	
	// Masīvs kurā tiks uzglabāti testa jautājumi
	public static LinkedList<Object> taskArray = new LinkedList<Object>();
	//GUI kompnenetes
	public static Frame f;
	public static StartPanel pane1;
	public static TestPanel pane2;
	public static EndPanel pane3;
	
	//Testa tagadējais id
	public static int currentId;
	// Testa uzsākšanas un beigšanas laiki
	public static long start, finish;
	
	//Metode kas palaiž testa datu ieguvi
	public static void getTestData() {
			// Sākumā ir jāuzina cik ir teksta failā rindu lai uzinātu cik bus testu.
			int testCount = getNumberOfTests();
			// Iegūst Datus no faila

			   try {
				     int numAtbilde = 0;
				     String apraksts=null;
				     String textAtbilde = null;
				     String teksts = null;
				     String[] atbilzuMasivs = null;
				     
					 FileReader myObj = new FileReader("Tasks.txt");
				     BufferedReader myReader = new BufferedReader(myObj);				  
					 String line=null;
				     for (int i=0;i<testCount;i++) {
				    	 
				    	 //Iegūst pirmaja līnijā testa nosaukumu, id, tipu.
				    	 line = myReader.readLine();
				    	 String[] splitData = line.split("/");
				    	 String virsraksts = splitData[0];
				    	 int id = Integer.parseInt(splitData[1]);
				    	 int tips = Integer.parseInt(splitData[2]);
				    	 

				    	 //Iegūst otrās līnijas testa aprakstu un atbildes veidu.			    	 
				    	 if (tips == 3) {
				    		 line = myReader.readLine();
				    		 splitData = line.split("/"); 
				    		 apraksts = splitData[0];
				    		 textAtbilde = splitData[1];			    		 
				    	 }
				    	 else {
				    		 line = myReader.readLine();
				    		 splitData = line.split("/");
				    		 apraksts = splitData[0];
				    		 numAtbilde = Integer.parseInt(splitData[1]);			    		 			    		 
				    	 }			    	 			    	 
				    	 //Iegūst trešās līnijas testa atbildes vai tekstu
				    	 if (tips == 3) {
				    		 line = myReader.readLine();
				    		 teksts = line;
				    	 }
				    	 else {
				    		 line = myReader.readLine();
				    		 splitData = line.split("/");
				    		 atbilzuMasivs = splitData;
				    	 }
				    	 //Atkarībā no testa tipa, tiek izveidots tam klases objekts
				    	 switch(tips) {
				     		case 1:
				     			TestType1 test1 = new TestType1(virsraksts, id, tips, numAtbilde, atbilzuMasivs, apraksts);
				     			taskArray.add(test1);
				     			break;
				     		case 2:
				     			TestType2 test2 = new TestType2(virsraksts, id, tips, numAtbilde, atbilzuMasivs, apraksts);
				     			taskArray.add(test2);
				     			break;
				     		case 3:
				     			TestType3 test3 = new TestType3(virsraksts, id, tips, textAtbilde, teksts, apraksts);
				     			taskArray.add(test3);
				     			break;
				    	 }
				     }
				     myReader.close();
				} catch (Exception e) {
					System.out.println("Error2:");
				}
		   
		}
		
	//Metode kur iegust testu daudzumu
	public static int getNumberOfTests() {
		// no faila nolasa rindu daudzumu un dala to ar 3    
		try {
			FileReader myObj = new FileReader("Tasks.txt");
			BufferedReader myReader = new BufferedReader(myObj);
			@SuppressWarnings("unused")
			String line=null;
			int index=0;
			//Kamer line nav null tiek skaitīts
			while((line=myReader.readLine()) != null) {
				index++;
			}
			myReader.close();
			//index dala ar 3 jo tests sastāv failā no 3 rindām.
			return index/3;
			} catch (Exception e) {
				System.out.println("Error1: Problem with reading data from a file ");
			}
			return 0;
		}
		
	//izveido visus paneļus un gui
	public static void StartGUI(){
			f = new Frame();
			pane1 = new StartPanel();
			pane2 = new TestPanel();
			currentId = 1;
			f.add(pane1);
		    f.setVisible(true); 
		}
	
	//parada framā testa paneli
	public static void showTest() {
			removePane();
			TestPanel.setTestById(taskArray);
			f.add(pane2);
			f.validate();
			f.repaint();
		}
	//Noņem visus komonentus no frame
	public static void removePane() {
			f.getContentPane().removeAll();
		}
		
	//parāda rezultāta un beidzamo paneli
	public static void showEndResult() {
			removePane();
			//Salīdzina atbildes
			Test.result(taskArray);
			//pievieno pēdējo rezultātu paneli
			pane3 = new EndPanel();
			f.add(pane3);
			f.validate();
			f.repaint();
			
		}
		
	
	
	public static void main(String[] args) {
		// iegūst un saglabā katra testa datus masīvā
		getTestData();
		// Uztaisa Sākuma paneli, no kura tiks veiktas tālākās darbības.
		StartGUI();
	}

}
