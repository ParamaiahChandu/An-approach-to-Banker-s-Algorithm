
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;

public class BankersUI extends JFrame implements ActionListener {
	int numProcess,numResources;
	 JFrame f=new JFrame("Banker's Algorithm");
	 NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);

		 NumberFormat format1 = NumberFormat.getInstance();
		    NumberFormatter formatter1 = new NumberFormatter(format1);
	    
	    
	    
	    JTextField [][] need;
	    JFormattedTextField[][] alloc=null,max=null;
	    JTextField []available;
	   
	    JFormattedTextField tf1=null;
	    JFormattedTextField tf2=null;
	    JLabel JProcess;
	    JLabel JResources;
	    JLabel JButtonLabel;
	    JLabel Heading;
	    final JLabel safeSeqLabel=new JLabel("The Safe Sequence is:");
	  public BankersUI() {
		// TODO Auto-generated constructor stub
		  
		  formatter1.setValueClass(Integer.class) ;
		    formatter1.setMinimum(1);
		    formatter1.setMaximum(Integer.MAX_VALUE);
		    formatter1.setAllowsInvalid(false);
		    // If you want the value to be committed on each keystroke instead of focus lost
		    formatter1.setCommitsOnValidEdit(true);
		   tf1= new JFormattedTextField(formatter1);
		   tf2=new JFormattedTextField(formatter1);
		   Heading=new JLabel("Banker's Algorithm");
		   Heading.setForeground(Color.RED.darker());
		   Heading.setFont(new Font("Serif",Font.ITALIC,40));
		   Border border = BorderFactory.createLineBorder(Color.BLACK);
		  // Heading.setBorder(border);
		  JProcess =new JLabel("No of Process");
		  JProcess.setForeground(Color.BLUE.darker());
		  JProcess.setFont(new Font("Times New Roman",Font.BOLD,20));
		  
		  
		  JResources=new JLabel("No of Resource Types");
		  JResources.setForeground(Color.BLUE.darker());
		  JResources.setFont(new Font("Times New Roman",Font.BOLD,20));
		  JButtonLabel=new JLabel("Please Click here to enter the values");
		  JButtonLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
		  JButtonLabel.setForeground(Color.BLUE.darker());
		  
		  //JButtonLabel.setFont(new Font("", Font.ITALIC, 40)); 
		  Heading.setBounds(250, 20, 320, 50);
		  JProcess.setBounds(20, 100, 300 , 40);
		  tf1.setBounds(400,100, 50,30);
		  JResources.setBounds(20,150, 300, 40);
		  tf2.setBounds(400,150, 50,30);
		  f.add(Heading);
		  f.add(JProcess);
		  f.add(tf1);
		  f.add(JResources);
		  f.add(tf2);
		  JButtonLabel.setBounds(20, 200, 350,40);
		  JButtonLabel.setBackground(Color.GREEN);
		  f.add(JButtonLabel);
		  JButton b=new JButton("Click Here");
		  b.setBounds(400,200,95,30);  
		    b.addActionListener(this);  
		    f.add(b); 
		    f.setSize(800,800);  
		    f.setLayout(null);  
		    f.setVisible(true); 
		    f.getContentPane().setBackground(Color.orange.darker());
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    }
	
	  
	    //tf1.setBounds(50,50, 20,20);
	   // tf2.setBounds(80,50, 20,20);
	
	
	
	public void actionPerformed(ActionEvent e){
		
		try{
		
		
		
		numProcess=	Integer.parseInt(tf1.getText());
		System.out.println("no of process:"+numProcess);
		numResources=Integer.parseInt(tf2.getText());
		System.out.println("no of resources:"+numResources);
		f.setVisible(false);
		JFrame f2=new JFrame("Banker's Algorithm");
													//setting the dynamic size of the frame
		int dimh=4*(numResources)*150;
		int dimv=4*(numProcess)*150;
		JPanel panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(dimh, dimv);
            };
        };  
		
		
	    panel.setLayout(null);
	    panel.setBackground(Color.ORANGE.darker());
	    JButton backButton=new JButton("Back");
	    backButton.setBounds(10, 10,100, 20);
	    		backButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						safeSeqLabel.setText("");
						f.setVisible(true);
						f2.setVisible(false);
						
					}
				});
	    		panel.add(backButton);
	    
	    JLabel allocLabel=new JLabel("Allocation");
	    allocLabel.setBounds(60, 50, 100, 20);
	    panel.add(allocLabel);
	    
	    int p[]=new int[numProcess];
	    int processLabel=0;
	    for (int j = 0; j < numProcess; j++) {
    		
    		JLabel jl=new JLabel("P"+j);
    		jl.setBounds(20, 120+processLabel, 40, 20);
    		p[j]=120+processLabel;
    		processLabel=processLabel+50;
    		panel.add(jl);
    		
		}
	    
	    for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}
	    
	    int resourceLabel=0;
	    for (int j = 0; j < numResources; j++) {
    		
    		JLabel jl=new JLabel("R"+j);
    		jl.setBounds(50+resourceLabel, 80, 40, 20);
    		resourceLabel=resourceLabel+45;
    		panel.add(jl);
    		
		}
	  
	    
	    // allocation matrix
	    
	   
	    	alloc=new JFormattedTextField[numProcess][numResources];
	        int allocYLength=0,TotXLength=0,TotYlength=0,allocXLength=0;
	        
	    	    for (int i = 0; i < numProcess; i++) {
	    	    	allocXLength=0;
	    			for (int j = 0; j < numResources; j++) {
	    				formatter.setValueClass(Integer.class) ;
	    			    formatter.setMinimum(0);
	    			    formatter.setMaximum(Integer.MAX_VALUE);
	    			    formatter.setAllowsInvalid(false);
	    			    formatter.setCommitsOnValidEdit(true);
	    				alloc[i][j]=new JFormattedTextField(formatter);
	    				alloc[i][j].setBounds(50+allocXLength, p[i], 40, 20);
	    				panel.add(alloc[i][j]);
	    				allocXLength=allocXLength+45;
	    			}
	    			
	    			TotXLength=allocXLength;
	    		}
	    	    
	    	    TotYlength=allocYLength;
	    	    
	    	    max=new JFormattedTextField[numProcess][numResources];
		        int maxYLength=0,maxXLength=TotXLength+20;
		        
		        //Max Matrix
		        
		        JLabel maxLabel=new JLabel("Max Matrix");
		        maxLabel.setBounds(TotXLength+70, 50, 100, 20);
		        panel.add(maxLabel);
		        resourceLabel=TotXLength+20;
		        for (int j = 0; j < numResources; j++) {
		    		
		    		JLabel jl=new JLabel("R"+j);
		    		jl.setBounds(50+resourceLabel, 80, 40, 20);
		    		resourceLabel=resourceLabel+45;
		    		panel.add(jl);
		    		
				}
		        
		    	    for (int i = 0; i < numProcess; i++) {
		    	    	 maxXLength=TotXLength+20;
		    			for (int j = 0; j < numResources; j++) {
		    				max[i][j]=new JFormattedTextField(formatter);
		    				max[i][j].setBounds(50+ maxXLength, 120+maxYLength, 40, 20);
		    				panel.add(max[i][j]);
		    				maxXLength=maxXLength+45;
		    			}
		    			maxYLength=maxYLength+50;
		    			
		    		}
		    	    TotXLength=maxXLength;
		    	    
		    	    
		    	    //Available Matrix
		    	    JLabel availableLabel=new JLabel("Available");
		    	    availableLabel.setBounds(TotXLength+70, 50, 100, 20);
			        panel.add(availableLabel);
		    	   
		    	    resourceLabel=TotXLength+20;
		    	    for (int j = 0; j < numResources; j++) {
		        		
		        		JLabel jl=new JLabel("R"+j);
		        		jl.setBounds(50+resourceLabel, 80, 40, 20);
		        		resourceLabel=resourceLabel+45;
		        		panel.add(jl);
		        		
		    		}
		    	    
		    	    available=new JTextField[numResources];
		    	    int availXLength=TotXLength+20;
		    	    for (int j = 0; j < numResources; j++) {
		        		
		    	    	available[j]=new JTextField();
		    	    	available[j].setBounds(50+ availXLength, 120, 40, 20);
	    				panel.add(available[j]);
	    				availXLength=availXLength+45;
		        		
		    		}
		    	    
		    	    
		    	    
	    	JButton gss=new JButton("Generate Safe Sequence");
	    	gss.setBounds(100, p[p.length-1]+100, 200, 20);
	    	final int finalY=TotYlength+100+50;
	    	final int finalX=availXLength+60;
	    	
	    	JLabel needLabel[][]=new JLabel[numProcess][numResources];
	    	JLabel needText=new JLabel("");
	    	JLabel needRes[]=new JLabel[numResources];
	    	JLabel Symbol[]=new JLabel[numProcess];
	    	
	    	for (int i = 0; i < numProcess; i++) {
	    		Symbol[i]=new JLabel("");
			}
	    	
	    	
	    	JLabel SymbolFal[][]=new JLabel[numProcess][numProcess];
	    	
	    	for (int i = 0; i < numProcess; i++) {
	    		for (int j = 0; j < numProcess; j++) {
	    		SymbolFal[i][j]=new JLabel("");
	    		}
			}
	    	for (int i = 0; i < numProcess; i++) {
	    		for (int j = 0; j < numResources; j++) {
	    			needLabel[i][j]=new JLabel("");
				}
				
			}
	    	for (int i = 0; i < numResources; i++) {
	    		needRes[i]=new JLabel("");
			}
	    	
	    	JLabel newAvailLable[][][]=new JLabel[numProcess][numProcess][numResources];
	    	JLabel newAvailText=new JLabel("");
	    	JLabel newAvailRes[]=new JLabel[numResources];
	    	
	    	

	    	for (int i = 0; i < numProcess; i++) {
	    		for (int j = 0; j < numProcess; j++) {
	    		for (int k = 0; k < numResources; k++) {
	    			newAvailLable[i][j][k]=new JLabel("");
				}
	    		}
			}
	    	
	    	JLabel newAvailLableFail[][][]=new JLabel[numProcess][numProcess][numResources];
	    	
	    	
	    	

	    	for (int i = 0; i < numProcess; i++) {
	    		for (int j = 0; j < numProcess; j++) {
	    			for (int k = 0; k < numResources; k++) {
	    				newAvailLableFail[i][j][k]=new JLabel("");
					}
	    			
				}
				
			}
	    	
	    	
	    	for (int i = 0; i < numResources; i++) {
	    		newAvailRes[i]=new JLabel("");
			}
	    	
	    	
	    		gss.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					try{
					int [][] allocation= new int[numProcess][numResources];
					try{
					for (int i = 0; i < numProcess; i++) {
						for (int j = 0; j < numResources; j++) {
							allocation[i][j]=Integer.parseInt(alloc[i][j].getText());
						}
					}
					}
					catch (Exception allocExcep) {
						// TODO: handle exception
						throw new Exception("Please Enter All The Values For Allocation Matrix ");
					}
					
					int [][] maxMat= new int[numProcess][numResources];
					try{
					for (int i = 0; i < numProcess; i++) {
						for (int j = 0; j < numResources; j++) {
							
							maxMat[i][j]=Integer.parseInt(max[i][j].getText());
						}
					}
					}
					catch (Exception maxExcep) {
						// TODO: handle exception
						throw new Exception("Please Enter All The Values for Max Matrix ");
					}
					boolean maxPass=true;
					for (int i = 0; i < numProcess; i++) {
						for (int j = 0; j < numResources; j++) {
							if(maxMat[i][j]<allocation[i][j]){
								maxPass=false;
								JOptionPane.showMessageDialog(null,"Max matrix Values cannot be less than Allocation Values", "InfoBox: " +"error" , JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
					
					
					if(maxPass){
					int [] availMat= new int[numResources];
						try{
						for (int j = 0; j < numResources; j++) {
							availMat[j]=Integer.parseInt(available[j].getText());
						}
						}
						catch (Exception availExcep) {
							// TODO: handle exception
							throw new Exception("Please Enter All The Values For Available Matrix");
						}
						
						// Calculating need only when Max is greater than or equal to Allocation
						int need[][]=new int[numProcess][numResources];
						int needXLength=finalX;
						int needYlength=0;
						needText.setText("Need Matrix");
						needText.setBounds(finalX+160, 50, 200, 30);
						
						
						int resourceL=finalX+60;
						 for (int j = 0; j < numResources; j++) {
				        		
				        		needRes[j].setText("R"+j);
				        		needRes[j].setBounds(100+resourceL, 80, 40, 20);
				        		resourceL=resourceL+45;
				        		
				        		
				    		}
						
						for(int i=0;i<numProcess;i++)
						{
							needXLength=finalX+60;
							
							for (int j = 0; j < numResources; j++) {
								
								need[i][j]=maxMat[i][j]-allocation[i][j];
								
								needLabel[i][j].setText(need[i][j]+"");
								needLabel[i][j].setBounds(100+needXLength, 120+needYlength, 40, 30);
								needXLength=needXLength+45;
							}
							needYlength=needYlength+50;
						}				
				    	resourceL=resourceL+60;
						for (int j = 0; j < numResources; j++) {
			        		
			        		newAvailRes[j].setText("R"+j);
			        		newAvailRes[j].setBounds(100+resourceL, 80, 40, 20);
			        		resourceL=resourceL+45;	
			    		}
										
						int newAvailXLength=needXLength;
						int newAvailYLength=0;
						newAvailText.setText("New Available");
						newAvailText.setBounds(needXLength+160, 50, 200, 30);
						
						int work[]=new int[numResources];
						boolean []finish=new boolean[numProcess];
						String []safeSequence;
						
				        work=availMat;
						
						
						for (int i = 0; i < numProcess; i++) {
							finish[i]=false;
						}	
						int SafeSeqVar=0;
						safeSequence=new String[numProcess];
						int c=0;
						int []availNew=new int[numResources];
						newAvailXLength	=needXLength+60;
						
						boolean safe=true;
						//int failProcess[]=new int[numProcess];
						int failProcessPrev=0,failProcessNext=0;
						
						
						String valid=";";
						
						needXLength=needXLength+100;
						
						
						// Logic for Safe Sequence
						
						 //if(valid!="OK"){
						while(c<numProcess ){
							
						System.out.println("failProcessPrev "+failProcessPrev);
						System.out.println("failProcessNext "+failProcessNext);
						if((c>1 && failProcessPrev==failProcessNext && failProcessPrev!=0 ) || failProcessPrev==numProcess){
							safe=false;
							System.out.println("safe "+safe);
							break;
						}
						else{
							if(c>1){
							failProcessPrev=failProcessNext;
							failProcessNext=0;}
						for (int i = 0; i < numProcess; i++) {
							newAvailXLength	=needXLength+60;
						
							if(finish[i]==false){
								int numResCount=0;
								int displayVar=0;
								for (int j = 0; j < numResources; j++) {				
									if(need[i][j]<=work[j]){
										numResCount++;						
										newAvailLable[c][i][j].setText(work[j]+"");	
										
										newAvailLable[c][i][j].setBounds(newAvailXLength, p[i], 40, 30);
										
										newAvailXLength=newAvailXLength+45;
										displayVar++;
									
										}
									else{
										
										if(c==0)
										failProcessPrev++;
										else 
										failProcessNext++;
										
										
										
										newAvailXLength	=needXLength+60;
										displayVar=0;
										for (int k = 0; k < numResources; k++) {
										newAvailLableFail[c][i][k].setText(work[k]+"");

										newAvailLableFail[c][i][k].setBounds(newAvailXLength, p[i], 40, 30);
										newAvailXLength=newAvailXLength+45;
										}
										
										SymbolFal[c][i].setText("FALSE");
										
										SymbolFal[c][i].setBounds(newAvailXLength, p[i], 40, 30);
										
										System.out.println("false:"+newAvailXLength);
										break;
										
									}	
									
									
									
									
								}
								
								if(numResCount==numResources){
									safeSequence[SafeSeqVar]="P"+i;
									
									finish[i]=true;
									for (int k = 0; k < numResources; k++)
									work[k]=work[k]+allocation[i][k];
									SafeSeqVar++;
									Symbol[i].setText("TRUE");
									Symbol[i].setBounds(newAvailXLength, p[i], 40, 30);
								}
							}
							if(i==numProcess-1 && finish[i]==true && c>=1){
								
								newAvailXLength=newAvailXLength +  45*numResources;
							}
							
							
						}
						
						needXLength=newAvailXLength;
						
						
						c++;
						}
						}
						
				//}
						System.out.println("The safe sequence is:");
						String safeSeq=new String("The safe sequence is ");
						if(safe )
						for (int i = 0; i < safeSequence.length; i++) {
							System.out.print(safeSequence[i]);
							safeSeq=safeSeq+safeSequence[i];
							if((i+1) < safeSequence.length){
								System.out.print(" --> ");
							safeSeq=safeSeq+"-->";}
						}
						else
							safeSeq="The Safe Sequence is Not Possible";
							
						System.out.println(safeSeq);
						safeSeqLabel.setText(safeSeq);
						safeSeqLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
						safeSeqLabel.setForeground(Color.BLUE.darker());
						safeSeqLabel.setBounds(200,p[p.length-1]+200, 300+ numProcess*200, 60);
						

				}	

					}
					catch (Exception exec) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null,exec.getMessage(),"Warning:"+" Error Message " , JOptionPane.INFORMATION_MESSAGE);
						
					}
				
				}
			});
	    	
	    	panel.add(gss);
	    	panel.add(needText);
	    	panel.add(newAvailText);
	    	for (int i = 0; i < numResources; i++) {
				panel.add(needRes[i]);
				panel.add(newAvailRes[i]);
			}
	    	
	    	
	    	for (int i = 0; i < numProcess; i++) {
				panel.add(Symbol[i]);
				
			}
	    	
	    	
	    	for (int i = 0; i < numProcess; i++) {
	    		for (int j = 0; j < numProcess; j++) {
				panel.add(SymbolFal[i][j]);
	    		}
				
			}
	    	for(int i=0;i<numProcess;i++)
	    	{
	    		for(int j=0;j<numResources;j++){
	    			panel.add(needLabel[i][j]);
	    		}
	    	}
	    	
	    	
	    	for(int i=0;i<numProcess;i++)
	    	{
	    		for(int j=0;j<numProcess;j++)
		    	{
	    		for(int k=0;k<numResources;k++){
	    			panel.add(newAvailLable[i][j][k]);
	    		}
		    	}
	    	}
	    	
	    	for(int i=0;i<numProcess;i++)
	    	{
	    		for(int j=0;j<numProcess;j++){
	    		for (int k = 0; k < numResources; k++) {
	    			panel.add(newAvailLableFail[i][j][k]);
				}
	    			
	    		}
	    	}
	    	panel.add(safeSeqLabel);
	    	
	    	
	    	
	    	
	    	
		/*tf=new JTextField[numProcess][numResources];
    int row=0;
	    for (int i = 0; i < numProcess; i++) {
	    	int column=0;
			for (int j = 0; j < numResources; j++) {
				tf[i][j].setBounds(150+row, 200+column, 20, 20);
				column=column+30;
			}
			row=row+40;
		}
	    
	    for (int i = 0; i < numProcess; i++) {
	    	
			for (int j = 0; j < numResources; j++) {
				f.add(tf[i][j]);
			}
			
		}*/
	    	
	    	//
	    	JScrollPane jScrollPane = new JScrollPane(panel);
			// only a configuration to the jScrollPane...
			jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			//JScrollBar sb = jScrollPane.getVerticalScrollBar();
	    	//sb.setValue( sb.getMaximum() );
	    f2.getContentPane().add(jScrollPane).setBackground(Color.ORANGE.darker());;
	    //jScrollPane.setMinimumSize(new Dimension());
	    f2.setSize(800,800);  
		//f2.setContentPane(panel);
	   
	    f2.setVisible(true); 
	    
	    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	    jScrollPane.setPreferredSize( new Dimension( 400, 400));
		//f2.add(jScrollPane);
			    
	   // f2.setVisible(true); 
	    
	    
	}
catch (Exception exception) {
	// TODO: handle exception
	
	JOptionPane.showMessageDialog(null,"Please enter all the values to proceed ", "InfoBox: " +"error" , JOptionPane.INFORMATION_MESSAGE);
}	        } 
	
	
	public String safeSequence(int [][] max,int [][]allocated,int []available){
		int need[][]=new int[numProcess][numResources];
		for(int i=0;i<numProcess;i++)
		{
			//System.out.println("Process P"+i);
			for (int j = 0; j < numResources; j++) {
				//System.out.println("Resource R"+j);
				need[i][j]=max[i][j]-allocated[i][j];
			}
		}
		
		for(int i=0;i<numProcess;i++)
		{
			System.out.println("Process P"+i);
			for (int j = 0; j < numResources; j++) {
				
				System.out.print(need[i][j]+" ");
			}
			System.out.println();
		}
		int work[]=new int[numResources];
		boolean []finish=new boolean[numProcess];
		String []safeSequence;
		
work=available;
		
		
		for (int i = 0; i < numProcess; i++) {
			finish[i]=false;
		}
		
		int SafeSeqVar=0;
		boolean safe=true;
		safeSequence=new String[numProcess];
		int c=0,failProcessNext=0,failProcessPrev=0;
		while(SafeSeqVar!=numProcess){
			c++;
			if(c>2 && failProcessPrev==failProcessNext){
				safe=false;
				break;
			}
			else{
				if(c>2){
				failProcessPrev=failProcessNext;
				failProcessNext=0;}	
		for (int i = 0; i < numProcess; i++) {
				
			if(finish[i]==false){
				int numResCount=0;
				for (int j = 0; j < numResources; j++) {
					
					
					if(need[i][j]<=work[j]){
						numResCount++;
						
						}
					else{
						if(c==1)
							failProcessPrev++;
							else 
							failProcessNext++;
						break;}				
				}
				if(numResCount==numResources){
					safeSequence[SafeSeqVar]="P"+i;
					//System.out.println(safeSequence[SafeSeqVar]);
					finish[i]=true;
					for (int k = 0; k < numResources; k++)
					work[k]=work[k]+allocated[i][k];
					SafeSeqVar++;
				}
			}
		}
			}
		}
		System.out.println("The safe sequence is:");
		String safeSeq=new String();
		if(safe){
		for (int i = 0; i < safeSequence.length; i++) {
			System.out.print(safeSequence[i]);
			safeSeq=safeSeq+safeSequence[i];
			if((i+1) < safeSequence.length){
				System.out.print(" --> ");
			safeSeq=safeSeq+"-->";}
		}
		}else
		{
			safeSeq="OK";
		}
		return safeSeq;
	}
	
	public static void main(String[] args) {
		BankersUI bankersUI=new BankersUI();
	
		
	}
	    
	}
