package Sjf;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
		
		//get total process from user
		System.out.print("Enter process:");
		int process = input.nextInt(); //total process
		
		int burstTime[] = new int[process]; //burst time
		int ta[] = new int[process];     // turn around times
		int wt[] = new int[process];     // waiting times
		int processId [] = new int[100];
		
		//get bust time from user
		int totalTA = 0;
		float wtAv = 0;
		for(int i = 0;i<process;i++)
		{
			System.out.print("Enter burst time for process "+(i+1)+":");
			burstTime[i] = input.nextInt();
			processId[burstTime[i]] = i;
		}
		
		//sorting
		sort(burstTime);
		
		for(int i = 0; i<burstTime.length; i++) {
			totalTA += burstTime[i];
			ta[i] = totalTA-0;
			
			wt[i] = totalTA-burstTime[i];
			wtAv+= wt[i];
		}
		
		
		float taT = 0;
        for(int i = 0;i<process;i++)
        {
        	taT += ta[i];
        }
		
		System.out.println("\n");
		System.out.println("---------------------------");
		System.out.println("P.Id\tB.T\tT.A\tW.T");
		System.out.println("---------------------------");
		for(int i = 0; i<process;i++)
		{
			System.out.println((processId[burstTime[i]]+1)+"\t"+burstTime[i]+"\t"+ta[i]+"\t"+wt[i]);
		}
		
		System.out.println("---------------------------");
		System.out.println("   Avarage process time");
		System.out.println("---------------------------");
		
		System.out.println("Avrg.T.A.T:"+(taT/process));
		System.out.println("Avrg.W.T:"+(wtAv/process));
		System.out.println("---------------------------");
		
		System.out.println("\n\n-----------------------------------------------------------------");
		for(int i = 0; i<process; i++)
		{
			System.out.print("|\tp"+(processId[burstTime[i]]+1)+"\t");
			if(i+1 == process)
				System.out.print("|");
				
		}
		System.out.println("\n-----------------------------------------------------------------");
		
		for(int i = 0;i<process;i++)
		{
			if(i == 0)
			{
				System.out.print(0+"\t  \t"+ta[i]);
			}else {
				System.out.print("\t  \t"+ta[i]);
			}
		}
		
		input.close();
	}
	
	
	//insertion sort
	public static void sort(int arr[])
	{
		for(int i = 1; i<arr.length; i++)
		{
			int temp = arr[i];
			int j = i - 1;
			
			//if j getter then -1 and arr[j] getter then temp then swap.
			while(j>-1 && temp<arr[j])
			{
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = temp;
		}
	}

}
