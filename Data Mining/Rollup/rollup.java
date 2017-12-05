import java.io.*;
import java.util.*;
class rollup
{
	public static void main(String [] args)
	{	
		 String csvFile = "temp.csv";	//give address of csv file here
		 String line = "";
       		 String cvsSplitBy = ",";
		 int hotdays=0,milddays=0,colddays=0; 
       		 try (BufferedReader br = new BufferedReader(new FileReader(csvFile)))
		 {
			int week=1;
			while ((line = br.readLine()) != null)
			{
				hotdays=0;
				milddays=0;
				colddays=0;				
				 String[] temp = line.split(cvsSplitBy);
				 for(int i=0;i<7;i++)
				{
					int a=Integer.parseInt(temp[i]);
					if(a>=30)
					  hotdays++;
					if(a>=20&&a<30)
					{
						milddays++;
					}
					if(a<20)
						colddays++;
				}
				System.out.println("Output for Week "+week+":");
				System.out.println("Hot Days  :"+hotdays);
				System.out.println("Mild Days :"+milddays);
				System.out.println("Cold Days :"+colddays);
				week++;
				System.out.println();

			} 
		 }
		catch (IOException e)
		 {
 		           e.printStackTrace();
 	       }
 

	}


}
