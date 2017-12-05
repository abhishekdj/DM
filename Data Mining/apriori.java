import java.io.*;
import java.util.*;
class apriori
{
	int transaction_count, item_count=4;
	double min_support;
	String []items;
	int []include_item;
	int [][]item_transactions;
	Scanner sc;
        String line = "";
	public void input() 
	{
		
			
		try
		{

			int row=0;
			FileReader file = new FileReader("apr.csv");
			BufferedReader br = new BufferedReader(file);
			item_count = (line.split(",")).length;
			items=new String[4];
			//System.out.print(item_count);
			 while((line = br.readLine())!=null)
			{
				String[] person = line.split(",");
				row++;
			}
			file = new FileReader("apr.csv");
			br = new BufferedReader(file);
			 while((line = br.readLine())!=null)
			{
				String[] person = line.split(",");
				for(int i=0; i<4;i++)
				{
					//System.out.println(person[i]);					
					items[i]=person[i];

				}
				break;
			}
			System.out.println(row);
			line="";
			sc=new Scanner(System.in);
			transaction_count=row;
			
		
		
			System.out.println("Enter the minimum support");
			min_support=sc.nextDouble();
			item_transactions=new int[transaction_count][4];
			include_item=new int[4];
			

			file = new FileReader("apr.csv");
			br = new BufferedReader(file);
			int tra=0;		
			while((line = br.readLine())!=null)
			{
				String[] person = line.split(",");				
				//for(int i=0;i<transaction_count;i++)
				//{
				 // for(int j=0;j<4;j++)
				//	{
						
						
						if(person[0].equals(items[0]))
							item_transactions[tra][0]=1;
						else
							item_transactions[tra][0]=0;
						if(person[1].equals(items[1]))
							item_transactions[tra][1]=1;
						else
							item_transactions[tra][1]=0;
						if(person[2].equals(items[2]))
							item_transactions[tra][2]=1;
						else
							item_transactions[tra][2]=0;
						if(person[3].equals(items[3]))
							item_transactions[tra][3]=1;
						else
							item_transactions[tra][3]=0;
				
				//	}
					System.out.println();


										
					 for(int j=0;j<4;j++)
						System.out.print(person[j]);
					System.out.println();
					tra++;
				//}
			}
		
			int count_arr[]=new int[4];
			for(int i=0;i<transaction_count;i++)
			{
				for(int j=0;j<4;j++)
				{
					if(item_transactions[i][j]==1)
						count_arr[j]+=1;	
				}
			}
		
			System.out.println("\n\nItem count after all Transactions ");
			for(int i=0;i<4;i++)
				System.out.println(items[i]+":"+count_arr[i]+" times");
		}catch (IOException e) {
            e.printStackTrace();
        }
			

	 }
	
	public void first_pass()
	{
		int count_arr[]=new int[4];
		int itemset_number=0;
		for(int i=0;i<transaction_count;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(item_transactions[i][j]==1)
					count_arr[j]+=1;	
			}
		}
		System.out.println("\n\nFrequent Itemsets generated after pass one:");
		for(int i=0;i<4;i++)
		{
			if(((count_arr[i]/(float)transaction_count)*100)>=min_support)
				include_item[i]=1;
			else
				include_item[i]=0;
			if(include_item[i]==1)
				System.out.println("{"+items[i]+"}");
		}
			
	}
	public void second_pass()
	{
		int count_arr[][]=new int[4][4];
		int itemset_number=0;
		for(int i=0;i<4;i++)
		{
			for(int j=i+1;j<4;j++)
			{
				for(int k=0;k<transaction_count;k++)
				{
					if(item_transactions[k][j]==1 && item_transactions[k][i]==1)
						count_arr[i][j]+=1;	
				}
			}
		}
		System.out.println("\n\nFrequent Itemsets after the pass two:");
		for(int i=0;i<4;i++)
		{
			for(int j=i+1;j<4;j++)
			{
				if(((count_arr[i][j]/(float)transaction_count)*100)>=min_support)
					include_item[i]=1;
				else
					include_item[i]=0;
				if(include_item[i]==1)
				{
					System.out.println("{"+items[i]+", "+items[j]+"}");
				}	
			}
		}
		
		
	}
	public void third_pass()
	{
		int count_arr[][][]=new int[4][4][4];
		int itemset_number=0;
		for(int i=0;i<item_count;i++)
		{
			for(int j=i+1;j<4;j++)
			{
			   for(int r=j+1;r<4;r++)
			    {				
				for(int k=0;k<transaction_count;k++)
				{
					if(item_transactions[k][j]==1 && item_transactions[k][i]==1 && item_transactions[k][r]==1)
						count_arr[i][j][r]+=1;	
				}
			    }
			}
		}
		System.out.println("\n\nFrequent Itemsets after the pass three:");
		for(int i=0;i<item_count;i++)
		{
			for(int j=i+1;j<4;j++)
			{
				for(int r=j+1;r<4;r++)
				{
					if(((count_arr[i][j][r]/(float)transaction_count)*100)>=min_support)
					include_item[i]=1;
					else
					include_item[i]=0;
					if(include_item[i]==1)
					{
						System.out.println("{"+items[i]+", "+items[j]+","+items[r]+"}");
					}
				}	
			}
		}
		
		
	}
	public static void main(String []args)throws IOException
	{
		apriori a=new apriori();
		
		a.input();
		a.first_pass();
		a.second_pass();
		a.third_pass();
	}
}


