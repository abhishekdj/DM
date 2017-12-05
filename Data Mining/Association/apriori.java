import java.io.*;
import java.util.*;
class apriori
{
	int transaction_count, item_count;
	double min_support;
	String []items;
	int []include_item;
	int [][]item_transactions;
	Scanner sc;

	public void input()
	{
		sc=new Scanner(System.in);
		System.out.println("Enter the number of transactions");
		transaction_count=sc.nextInt();
		System.out.println("Enter the of Distinct items");
		item_count=sc.nextInt();
		items=new String[item_count];
		System.out.println("Enter the items");
		String str=sc.nextLine();
		for(int i=0;i<item_count;i++)
		{
			items[i]=sc.nextLine();
		}
		System.out.println("Enter the minimum support");
		min_support=sc.nextDouble();
		item_transactions=new int[transaction_count][item_count];
		include_item=new int[item_count];
		System.out.println("\n\nEnter the transactions\nEnter 1 if present and 0 otherwise\n\n");

		
		for(int i=0;i<transaction_count;i++)
		{
			System.out.println("\nEntering the items for transaction "+(i+1)+": ");
			for(int j=0;j<item_count;j++)
			{
				System.out.println(" "+items[j]+" ");
				item_transactions[i][j]=sc.nextInt();
				if(item_transactions[i][j]!=1)
					item_transactions[i][j]=0;	
			}
		}
		int count_arr[]=new int[item_count];
		for(int i=0;i<transaction_count;i++)
		{
			for(int j=0;j<item_count;j++)
			{
				if(item_transactions[i][j]==1)
					count_arr[j]+=1;	
			}
		}
		
		System.out.println("\n\nItem count after all Transactions ");
		for(int i=0;i<item_count;i++)
			System.out.println(items[i]+":"+count_arr[i]+" times");

		
	}
	
	public void first_pass()
	{
		int count_arr[]=new int[item_count];
		int itemset_number=0;
		for(int i=0;i<transaction_count;i++)
		{
			for(int j=0;j<item_count;j++)
			{
				if(item_transactions[i][j]==1)
					count_arr[j]+=1;	
			}
		}
		System.out.println("\n\nFrequent Itemsets generated after pass one:");
		for(int i=0;i<item_count;i++)
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
		int count_arr[][]=new int[item_count][item_count];
		int itemset_number=0;
		for(int i=0;i<item_count;i++)
		{
			for(int j=i+1;j<item_count;j++)
			{
				for(int k=0;k<transaction_count;k++)
				{
					if(item_transactions[k][j]==1 && item_transactions[k][i]==1)
						count_arr[i][j]+=1;	
				}
			}
		}
		System.out.println("\n\nFrequent Itemsets after the pass two:");
		for(int i=0;i<item_count;i++)
		{
			for(int j=i+1;j<item_count;j++)
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
		int count_arr[][][]=new int[item_count][item_count][item_count];
		int itemset_number=0;
		for(int i=0;i<item_count;i++)
		{
			for(int j=i+1;j<item_count;j++)
			{
			   for(int r=j+1;r<item_count;r++)
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
			for(int j=i+1;j<item_count;j++)
			{
				for(int r=j+1;r<item_count;r++)
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


