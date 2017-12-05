import java.io.*;
import java.util.*;
class Tweight
{
		public static void main(String [] args)
		{
			int n;
			int sum=0;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter no of Depts");	
			n=sc.nextInt();
			int Dept[]=new int[n];
			int placed[]=new int[n];
			double tweight[]=new double[n];
			double dweight[]=new double[n];
			System.out.println("Enter no of students in each dept respectively");
			for(int i=0;i<n;i++)	
			{
				Dept[i]=sc.nextInt();
			}
			System.out.println("Enter no of placed students in each dept respectively");
			for(int i=0;i<n;i++)	
			{
				placed[i]=sc.nextInt();
			}
			for(int i=0;i<n;i++)
			{
				tweight[i]=(double)placed[i]/Dept[i];	
				tweight[i]=tweight[i]*100.0;
			}
			/*	for(int i=0;i<n;i++)
			{
				System.out.println(Dept[i]);	
				System.out.println(placed[i]);				
			}
			System.out.println(sum);*/	
			for(int i=0;i<n;i++)	
			{
				sum=sum+placed[i];
			}			
			//System.out.println(sum);
			for(int i=0;i<n;i++)
			{
				dweight[i]=(double)placed[i]/sum;	
				dweight[i]=dweight[i]*100.0;
			}				
			System.out.println("The t-weights of Departments are:");
			for(int i=0;i<n;i++)
			{
				System.out.println("Department "+i+": "+tweight[i]);	
			
			}
			System.out.println("The d-weights of Departments are:");
			for(int i=0;i<n;i++)
			{
				System.out.println("Department "+i+": "+dweight[i]);	
			
			
			}
	}
}
