package bankersimplementation;

import java.util.Scanner;

public class BankersAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numProcess, numResources;
		int [][]max,need, allocated;
		int []available,request,work;
		boolean []finish;
		String []safeSequence;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of process:");
		numProcess= sc.nextInt();
		System.out.println("Enter the number of resources:");
		numResources=sc.nextInt();
		need=new int[numProcess][numResources];
		max=new int[numProcess][numResources];
		allocated=new int[numProcess][numResources];;
		available=new int[numResources];
		finish=new boolean[numProcess];
		
		// input for allocation matrix
		System.out.println("Allocation Matrix");
		System.out.println();
		for(int i=0;i<numProcess;i++)
		{
			System.out.println("Enter resources for process P"+i);
			for (int j = 0; j < numResources; j++) {
				
				allocated[i][j]=sc.nextInt();
			}
		}
		// input for max matrix
		System.out.println("Enter resources for Max");
		for(int i=0;i<numProcess;i++)
		{
			System.out.println("Enter resources for process P"+i);
			for (int j = 0; j < numResources; j++) {
				
				max[i][j]=sc.nextInt();
			}
		}
		
		System.out.println("Enter resources for Available");
		for(int i=0;i<numResources;i++)
		{	
				
				available[i]=sc.nextInt();
			
		}
		
		//Computing need matrix
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

		
		work=available;
		
		
		for (int i = 0; i < numProcess; i++) {
			finish[i]=false;
		}
		
		
		// logic for safety sequence
		int SafeSeqVar=0,c=0;
		boolean safe=true;
		safeSequence=new String[numProcess];
		label1:
		while(SafeSeqVar!=numProcess){
			c++;
		for (int i = 0; i < numProcess; i++) {
				
			if(finish[i]==false){
				int numResCount=0;
				for (int j = 0; j < numResources; j++) {
					
					
					if(need[i][j]<=work[j]){
						numResCount++;
						
						}
					else break;				
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
		
		
		if(c==numProcess)
		{
			
				
				
					for (int i = 0; i < numProcess; i++) {
						
					if(finish[i]==false){
					for (int j = 0; j < numResources; j++) {
						
						
						if(need[i][j]>=work[j]){
							System.out.println("Unsafe");
							safe=false;
							break label1;
							}
										
					}
					}
					
				
					}
			
			
		}
		}
		System.out.println("The safe sequence is ");
		if(safe)
		for (int i = 0; i < safeSequence.length; i++) {
			System.out.print(safeSequence[i]);
			if((i+1) < safeSequence.length)
				System.out.print(" --> ");
		}
		else
			System.out.println("Not Possible");
		
	}
	
	

}
